import java.io.*;
import java.util.*;

public class entry_9980380 {
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

    public static void bfs(ArrayList<ArrayList<Integer>> g, ArrayList<ArrayList<Long>> c, int st, long[] dist) {
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[st] = 0;
        PriorityQueue<p> pq = new PriorityQueue<>();
        pq.add(new p(0L, st));
        boolean[] vis = new boolean[dist.length];
        while (!pq.isEmpty()) {
            p u = pq.poll();
            if (vis[(int) u.b])
                continue;
            vis[(int) u.b] = true;
            for (int i = 0; i < g.get((int) u.b).size(); i++) {
                int v = g.get((int) u.b).get(i);
                long cst = c.get((int) u.b).get(i);
                if (dist[v] > dist[(int) u.b] + cst) {
                    dist[v] = dist[(int) u.b] + cst;
                    pq.add(new p((long) dist[v], v));
                }
            }
        }
    }

    public static void solve(Reader fs, FastReader sc, PrintWriter w, StringBuilder sb) throws Exception {
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<ArrayList<Long>> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
            c.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            long wt = sc.nextLong();
            g.get(a).add(b);
            c.get(a).add(wt);
        }
        long[] dist = new long[n];
        bfs(g, c, 0, dist);
        for (int i = 0; i < n; i++) {
            sb.append(dist[i] + " ");
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
