import java.io.*;
import java.util.*;

public class entry_9978534 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        float nextFloat() {
            return Float.parseFloat(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void readArr(int[] ar, int n) {
            for (int i = 0; i < n; i++) {
                ar[i] = nextInt();
            }
        }

        void readArr(long[] ar, int n) {
            for (int i = 0; i < n; i++) {
                ar[i] = nextLong();
            }
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
        long d;

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

    public static int[] dfs(ArrayList<ArrayList<Integer>> g, boolean[] vis, int[] par, int st, int p) {
        vis[st] = true;
        int t = par[st];
        par[st] = p;
        for (Integer v : g.get(st)) {
            if (!vis[v]) {
                int[] temp = dfs(g, vis, par, v, st);
                if (temp.length > 0) {
                    return temp;
                }
            } else {
                if (v != p) {
                    int[] temp = { st, v };
                    return temp;
                }
            }
        }
        return new int[0];
    }

    public static void solve(Reader fs, FastReader sc, PrintWriter w, StringBuilder sb) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            g.get(a).add(b);
            g.get(b).add(a);
        }
        boolean[] vis = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (vis[i] || g.get(i).size() == 0)
                continue;
            int[] par = new int[n];
            Arrays.fill(par, -1);
            int arr[] = dfs(g, vis, par, i, -1);
            if (arr.length == 0)
                continue;
            int tst = arr[0];
            int ten = arr[1];
            // System.out.println(":> " + tst + " " + ten + " " + i);
            // for (Integer t : par) {
            // System.out.print(t + " ");
            // }
            // System.out.println();
            while (tst != ten) {
                ans.add(tst + 1);
                tst = par[tst];
            }
            ans.add(ten + 1);
            break;
        }

        if (ans.size() == 0) {
            sb.append("IMPOSSIBLE\n");
            return;
        }
        ans.add(ans.get(0));
        sb.append(ans.size() + "\n");
        for (int i = 0; i < ans.size(); i++) {
            sb.append((ans.get(i)) + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        Reader sc = new Reader();
        FastReader fs = new FastReader();
        PrintWriter w = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        // long o = fs.nextLong();
        // while (o > 0) {
        solve(sc, fs, w, sb);
        // o--;
        // }
        System.out.print(sb.toString());
        w.close();
    }
}
