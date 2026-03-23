import sun.misc.Unsafe;
import java.io.*;
import java.lang.reflect.Field;

public class entry_13564925 {
    // ─── Unsafe setup (only for I/O) ─────────────────────────────────────────
    static final Unsafe unsafe;
    static final long byteBaseOffset;
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe)f.get(null);
            byteBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ─── UnsafeInput for fast I/O ─────────────────────────────────────────────
    static class UnsafeInput {
        private final byte[] buf;
        private int ptr, buflen;
        private final InputStream in;
        UnsafeInput(InputStream in, int size) throws IOException {
            this.in = in;
            buf = new byte[size];
            buflen = in.read(buf);
            ptr = 0;
        }
        private int fill() throws IOException {
            buflen = in.read(buf);
            ptr = 0;
            return buflen;
        }
        private byte peek() throws IOException {
            if (ptr >= buflen && fill() == -1) return -1;
            return unsafe.getByte(buf, byteBaseOffset + ptr);
        }
        private byte read() throws IOException {
            if (ptr >= buflen && fill() == -1) return -1;
            return unsafe.getByte(buf, byteBaseOffset + ptr++);
        }
        private void skipWS() throws IOException {
            byte c;
            while ((c = peek()) != -1 && (c==' '||c=='\n'||c=='\r'||c=='\t'||c=='\f')) {
                ptr++;
            }
        }
        int nextInt() throws IOException {
            skipWS();
            byte c = read();
            boolean neg = false;
            if (c == '-') { neg = true; c = read(); }
            int r = 0;
            while (c >= '0' && c <= '9') {
                r = r * 10 + (c - '0');
                c = peek();
                if (c == -1 || c==' '||c=='\n'||c=='\r'||c=='\t'||c=='\f') break;
                c = read();
            }
            return neg ? -r : r;
        }
    }

    // ─── Iterative merge sort (raw int[] access) ───────────────────────────────
    static void merge(int[] a, int[] aux, int l, int m, int r) {
        int i = l, j = m, k = l;
        while (i < m && j < r) {
            if (a[i] <= a[j]) aux[k++] = a[i++];
            else              aux[k++] = a[j++];
        }
        while (i < m) aux[k++] = a[i++];
        while (j < r) aux[k++] = a[j++];
        System.arraycopy(aux, l, a, l, r - l);
    }
    static void iterativeMergeSort(int[] a, int[] aux, int n) {
        for (int sz = 1; sz < n; sz <<= 1) {
            for (int l = 0; l < n; l += sz << 1) {
                int m = Math.min(l + sz, n);
                int r = Math.min(l + (sz << 1), n);
                merge(a, aux, l, m, r);
            }
        }
    }

    // ─── Binary-search floor (raw int[] access) ────────────────────────────────
    static int floorIndex(int[] tickets, int n, int key) {
        int lo = 0, hi = n - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int v = tickets[mid];
            if (v <= key) { ans = mid; lo = mid + 1; }
            else           { hi = mid - 1; }
        }
        return ans;
    }

    // ─── Iterative DSU-find with path compression (raw int[] access) ─────────
    static int findAvail(int[] parent, int x) {
        int root = x;
        while (parent[root] != root) {
            root = parent[root];
        }
        // path compression
        while (x != root) {
            int nxt = parent[x];
            parent[x] = root;
            x = nxt;
        }
        return root;
    }

    // ─── Main solve ────────────────────────────────────────────────────────────
    public static void main(String[] args) throws IOException {
        UnsafeInput in = new UnsafeInput(System.in, 1 << 20);
        StringBuilder out = new StringBuilder();

        int n = in.nextInt(), m = in.nextInt();

        // Read tickets & detect uniform
        int[] tickets = new int[n];
        int first = in.nextInt() << 1;
        tickets[0] = first;
        boolean uniform = true;
        for (int i = 1; i < n; i++) {
            int p = in.nextInt() << 1;
            tickets[i] = p;
            if (p != first) uniform = false;
        }

        if (uniform) {
            int rem = n;
            for (int i = 0; i < m; i++) {
                int q = in.nextInt() << 1;
                if (q >= first && rem > 0) {
                    out.append(first >>> 1).append('\n');
                    rem--;
                } else {
                    out.append(-1).append('\n');
                }
            }
            System.out.print(out);
            return;
        }

        // General case:
        // 1) sort
        int[] aux = new int[n];
        iterativeMergeSort(tickets, aux, n);

        // 2) DSU parent init (1-based indexing)
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 3) queries
        for (int i = 0; i < m; i++) {
            int q = in.nextInt() << 1;
            int idx = floorIndex(tickets, n, q);
            if (idx >= 0) {
                int av = findAvail(parent, idx + 1);
                if (av > 0) {
                    int sold = tickets[av - 1] >>> 1;
                    out.append(sold).append('\n');
                    parent[av] = av - 1;
                    continue;
                }
            }
            out.append(-1).append('\n');
        }

        System.out.print(out);
    }
}