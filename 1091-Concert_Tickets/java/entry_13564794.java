import sun.misc.Unsafe;
import java.io.*;
import java.lang.reflect.Field;

public class entry_13564794 {
    // ─── Unsafe setup ─────────────────────────────────────────────────────────
    static final Unsafe unsafe;
    static final long byteBaseOffset;
    static final int  byteIndexScale;
    static final long intBaseOffset;
    static final int  intIndexScale;
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe)f.get(null);

            byteBaseOffset = unsafe.arrayBaseOffset(byte[].class);
            byteIndexScale  = unsafe.arrayIndexScale (byte[].class);

            intBaseOffset   = unsafe.arrayBaseOffset(int[].class);
            intIndexScale   = unsafe.arrayIndexScale (int[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // ─── UnsafeInput for fast I/O ─────────────────────────────────────────────
    static class UnsafeInput {
        private final byte[] buf;
        private int ptr, buflen;
        private final InputStream in;
        public UnsafeInput(InputStream in, int size) throws IOException {
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
            int r=0;
            while (c>='0'&&c<='9') {
                r = r*10 + (c - '0');
                c = peek();
                if (c==-1||isWS(c)) break;
                c = read();
            }
            return neg?-r:r;
        }
    }

    // ─── Iterative merge sort (bottom-up) ─────────────────────────────────────
    static void merge(int[] a, int[] aux, int l, int m, int r) {
        int i=l, j=m, k=l;
        while(i<m && j<r) aux[k++] = (a[i]<=a[j]? a[i++] : a[j++]);
        while(i<m) aux[k++]=a[i++];
        while(j<r) aux[k++]=a[j++];
        for(int x=l;x<r;x++) a[x]=aux[x];
    }
    static void iterativeMergeSort(int[] a, int[] aux, int n) {
        for(int sz=1; sz<n; sz<<=1)
            for(int l=0; l<n; l+=sz<<1)
                merge(a,aux,l, Math.min(l+sz,n), Math.min(l+2*sz,n));
    }

    // ─── Binary-search floor (Unsafe) ─────────────────────────────────────────
    static int floorIndex(int[] tickets, int n, int key) {
        int lo=0, hi=n-1, ans=-1;
        while(lo<=hi) {
            int mid=(lo+hi)>>>1;
            int v = unsafe.getInt(tickets, intBaseOffset + mid*intIndexScale);
            if(v<=key) { ans=mid; lo=mid+1; }
            else       { hi=mid-1; }
        }
        return ans;
    }

    // ─── Iterative DSU-find with path compression (Unsafe) ────────────────────
    static int findAvail(int[] parent, int x) {
        int root=x;
        // find root
        while(true) {
            int p=unsafe.getInt(parent, intBaseOffset + root*intIndexScale);
            if(p==root) break;
            root=p;
        }
        // compress path
        while(x!=root) {
            int nxt=unsafe.getInt(parent, intBaseOffset + x*intIndexScale);
            unsafe.putInt(parent, intBaseOffset + x*intIndexScale, root);
            x=nxt;
        }
        return root;
    }

    // ─── Main solve ────────────────────────────────────────────────────────────
    public static void main(String[] args) throws IOException {
        UnsafeInput in = new UnsafeInput(System.in, 1<<20);
        StringBuilder out = new StringBuilder();

        int n = in.nextInt(), m = in.nextInt();

        // Read tickets, detect uniform
        int[] tickets = new int[n];
        int first = in.nextInt()<<1;
        tickets[0] = first;
        boolean uniform = true;
        for(int i=1;i<n;i++){
            int p = in.nextInt()<<1;
            tickets[i] = p;
            if(p!=first) uniform = false;
        }

        if(uniform) {
            // Fast path: all tickets == first
            int remaining = n;
            for(int i=0;i<m;i++){
                int q = in.nextInt()<<1;
                if(q>=first && remaining>0) {
                    out.append(first>>>1).append('\n');
                    remaining--;
                } else {
                    out.append(-1).append('\n');
                }
            }
            System.out.print(out);
            return;
        }

        // General path:
        // 1) sort tickets
        int[] aux = new int[n];
        iterativeMergeSort(tickets, aux, n);

        // 2) DSU parent init
        int[] parent = new int[n+1];
        for(int i=0;i<=n;i++){
            unsafe.putInt(parent, intBaseOffset + i*intIndexScale, i);
        }

        // 3) process queries
        for(int i=0;i<m;i++){
            int q = in.nextInt()<<1;
            int idx = floorIndex(tickets, n, q);
            if(idx>=0){
                int av = findAvail(parent, idx+1);
                if(av>0){
                    int sold = unsafe.getInt(tickets, intBaseOffset + (av-1)*intIndexScale)>>>1;
                    out.append(sold).append('\n');
                    unsafe.putInt(parent, intBaseOffset + av*intIndexScale, av-1);
                    continue;
                }
            }
            out.append(-1).append('\n');
        }

        System.out.print(out);
    }
}