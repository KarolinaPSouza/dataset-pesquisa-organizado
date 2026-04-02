import java.io.*;
import java.util.*;

public class entry_9786182 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[BUFFER_SIZE]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    static class p implements Comparable<p> {
        long a;
        long b;
        long c;

        p(long a, long b) {
            this.a = a;
            this.b = b;
        }

        p(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(p other) {
            if (this.a != other.a) {
                return Long.compare(this.a, other.a);
            }
            if (this.b != other.b) {
                return Long.compare(this.b, other.b);
            }
            return Long.compare(this.c, other.c);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            p pair = (p) o;
            return a == pair.a && b == pair.b && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    public static void build(long[] seg, long[] nums, int l, int r, int id) {
        if (l == r) {
            seg[id] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(seg, nums, l, mid, (2 * id) + 1);
        build(seg, nums, mid + 1, r, (2 * id) + 2);
        seg[id] = Math.max(seg[(2 * id) + 1], seg[(2 * id) + 2]);
    }

    public static void pushDown(long[] seg, long[] lazy, int l, int r, int id) {
        if (l != r) {
            lazy[(2 * id) + 1] += lazy[id];
            lazy[(2 * id) + 2] += lazy[id];
        }
        seg[id] += lazy[id];
        lazy[id] = 0;
    }

    public static void update(long[] seg, long[] lazy, int x, int y, long val, int l, int r, int id) {
        pushDown(seg, lazy, l, r, id);
        if (r < x || y < l) {
            return;
        }
        if (l >= x && r <= y) {
            lazy[id] += val;
            pushDown(seg, lazy, l, r, id);
            return;
        }

        int mid = l + (r - l) / 2;
        update(seg, lazy, x, y, val, l, mid, (2 * id) + 1);
        update(seg, lazy, x, y, val, mid + 1, r, (2 * id) + 2);
        seg[id] = Math.max(seg[(2 * id) + 1], seg[(2 * id) + 2]);
    }

    public static long query(long[] seg, long[] lazy, int x, int y, int l, int r, int id) {
        pushDown(seg, lazy, l, r, id);
        if (r < x || y < l) {
            return Long.MIN_VALUE;
        }
        if (l >= x && r <= y) {
            return seg[id];
        }
        int mid = l + (r - l) / 2;
        return Math.max(query(seg, lazy, x, y, l, mid, (2 * id) + 1), query(seg, lazy, x, y, mid + 1, r, (2 * id) + 2));
    }

    public static void solve(Reader sc, FastReader fs, PrintWriter w, StringBuilder sb) throws Exception {
        int n = sc.nextInt();
        int q = sc.nextInt();
        long[] nums = new long[n];
        long[] seg = new long[4 * n];
        long[] lazy = new long[4 * n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        long[] pref = new long[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }
        build(seg, pref, 0, n - 1, 0);
        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();
            if (type == 1) {
                int k = sc.nextInt() - 1;
                long u = sc.nextLong();
                long res = u - nums[k];
                nums[k] = u;
                update(seg, lazy, k, n - 1, res, 0, n - 1, 0);
            } else {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                long temp2 = query(seg, lazy, a, b, 0, n - 1, 0);
                long temp1 = 0;
                if (a != 0) {
                    temp1 = query(seg, lazy, a - 1, a - 1, 0, n - 1, 0);
                }
                sb.append(Math.max(temp2 - temp1, 0) + "\n");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        FastReader fs = new FastReader();
        PrintWriter w = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        // long o = sc.nextLong();
        // while (o > 0) {
        solve(sc, fs, w, sb);
        // o--;
        // }
        System.out.print(sb.toString());
        w.close();
    }
}
