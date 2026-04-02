import java.io.*;
import java.util.StringTokenizer;

public class entry_9052029 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        long INF = (long) 1e12;

        int n = io.nextInt(), m = io.nextInt(), q = io.nextInt();
        long[][] dist = new long[n][n];

        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
            for (int j = i + 1; j < n; j++)
                dist[i][j] = dist[j][i] = INF;
        }


        for (int i = 0; i < m; i++) {
            int a = io.nextInt() - 1, b = io.nextInt() - 1, d = io.nextInt();

            dist[a][b] = dist[b][a] = Math.min(dist[a][b], d);
        }

        for (int i = 0; i < n; i++) {
            for (int a = 0; a < n; a++) {
                if (dist[a][i] != INF) {
                    for (int b = 0; b < n; b++) {
                        if (dist[i][b] != INF) {
                            long tmp = dist[a][i] + dist[i][b];
                            if (dist[a][b] == INF || dist[a][b] > tmp) {
                                dist[a][b] = dist[b][a] = tmp;
                            }
                        }

                    }
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int a = io.nextInt() - 1, b = io.nextInt() - 1;
            if (dist[a][b] >= INF) {
                io.println(-1);
            } else {
                io.println(dist[a][b]);
            }
        }
        io.close();

    }

    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}