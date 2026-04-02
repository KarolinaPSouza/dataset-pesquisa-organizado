import java.io.*;
import java.util.*;

public class entry_2497550 {
    static final long INF = (long) (10e11);

    public static void main(String[] args) {
        int N = io.nextInt();
        int M = io.nextInt();
        int Q = io.nextInt();

        long[][] dist = new long[N][N];
        for (long[] i : dist) Arrays.fill(i, INF);

        while (M-- > 0) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            long c = io.nextLong();

            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
        }

        for (int i = 0; i < N; i++) dist[i][i] = 0;
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        while (Q-- > 0) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            io.println(dist[a][b] >= INF ? -1 : dist[a][b]);
        }
        io.close();
    }

    static FastIO io = new FastIO();

    static class FastIO extends PrintWriter {
        BufferedReader br;
        StringTokenizer st;

        public FastIO() {
            super(System.out);
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
                return null;
            }
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

        public void close() {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            super.close();
        }
    }
}