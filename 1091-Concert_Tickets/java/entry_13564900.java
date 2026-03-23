import sun.misc.Unsafe;
import java.io.*;
import java.lang.reflect.Field;

public class entry_13564900 {
    // ─── Unsafe I/O setup ──────────────────────────────────────────────────────
    static final Unsafe unsafe;
    static final long byteBaseOffset;
    static final int  byteIndexScale;
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe)f.get(null);
            byteBaseOffset = unsafe.arrayBaseOffset(byte[].class);
            byteIndexScale  = unsafe.arrayIndexScale (byte[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class UnsafeInput {
        private final byte[] buf;
        private int ptr, buflen;
        private final InputStream in;
        UnsafeInput(InputStream in, int sz) throws IOException {
            this.in = in;
            buf = new byte[sz];
            buflen = in.read(buf);
            ptr = 0;
        }
        private int fill() throws IOException {
            buflen = in.read(buf);
            ptr = 0;
            return buflen;
        }
        private byte read() throws IOException {
            if (ptr >= buflen && fill() == -1) return -1;
            return unsafe.getByte(buf, byteBaseOffset + ptr++);
        }
        private byte peek() throws IOException {
            if (ptr >= buflen && fill() == -1) return -1;
            return unsafe.getByte(buf, byteBaseOffset + ptr);
        }
        private boolean isWS(byte c) {
            return c==' '||c=='\n'||c=='\r'||c=='\t'||c=='\f';
        }
        private void skipWS() throws IOException {
            byte c;
            while ((c = peek()) != -1 && isWS(c)) ptr++;
        }
        int nextInt() throws IOException {
            skipWS();
            byte c = read();
            boolean neg = false;
            if (c=='-') { neg=true; c=read(); }
            int r = 0;
            while (c>='0' && c<='9') {
                r = r*10 + (c - '0');
                c = peek();
                if (c==-1 || isWS(c)) break;
                c = read();
            }
            return neg ? -r : r;
        }
    }

    // ─── 4-pass, 8-bit LSD radix sort ───────────────────────────────────────────
    static void radixSort(int[] a, int[] aux, int n) {
        final int MASK = 0xFF;
        final int W = 256;
        int[] cnt = new int[W];

        // 4 passes: shift = 0, 8, 16, 24
        for (int shift = 0; shift < 32; shift += 8) {
            // count
            for (int i = 0; i < W; i++) cnt[i] = 0;
            for (int i = 0; i < n; i++) {
                cnt[(a[i] >>> shift) & MASK]++;
            }
            // prefix sum
            int sum = 0;
            for (int i = 0; i < W; i++) {
                int t = cnt[i];
                cnt[i] = sum;
                sum += t;
            }
            // reorder
            for (int i = 0; i < n; i++) {
                int v = a[i];
                int b = (v >>> shift) & MASK;
                aux[cnt[b]++] = v;
            }
            // swap buffers
            int[] tmp = a; a = aux; aux = tmp;
        }
        // after 4 passes, 'a' holds sorted data if even passes; if odd, need copy
        // our loop does 4 swaps -> ends up in 'a'
    }

    // ─── iterative path-compressed DSU on plain int[] ─────────────────────────
    static int findAvail(int[] parent, int x) {
        int root = x;
        while (parent[root] != root) {
            root = parent[root];
        }
        // path compress
        while (parent[x] != root) {
            int nxt = parent[x];
            parent[x] = root;
            x = nxt;
        }
        return root;
    }

    // ─── main solve ────────────────────────────────────────────────────────────
    public static void main(String[] args) throws IOException {
        UnsafeInput in = new UnsafeInput(System.in, 1<<20);
        StringBuilder out = new StringBuilder();

        int n = in.nextInt(), m = in.nextInt();
        int[] tickets = new int[n];
        // read + detect uniform
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

        // general: radix sort
        int[] aux = new int[n];
        radixSort(tickets, aux, n);

        // DSU parent init (1-based)
        int[] parent = new int[n+1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        // queries: binary search + DSU
        for (int i = 0; i < m; i++) {
            int q = in.nextInt() << 1;
            // floor index
            int lo = 0, hi = n-1, idx = -1;
            while (lo <= hi) {
                int mid = (lo + hi) >>> 1;
                if (tickets[mid] <= q) {
                    idx = mid; lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (idx < 0) {
                out.append(-1).append('\n');
            } else {
                int av = findAvail(parent, idx+1);
                if (av > 0) {
                    int sold = tickets[av-1] >>> 1;
                    out.append(sold).append('\n');
                    parent[av] = av - 1;
                } else {
                    out.append(-1).append('\n');
                }
            }
        }

        System.out.print(out);
    }
}