// package Vanilla.Week2;
import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class entry_4624118 {
    public static void main(String[] args) throws Exception {
        new entry_4624118().run();
    }

    public static int n,m,q;
    public static long[][] city;
    public static final long INF = (long) 1e18;

    public void run() throws Exception {
        FastScanner f = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        n = f.nextInt();
        m = f.nextInt();
        q = f.nextInt();
        city = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(city[i], INF);
            city[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = f.nextInt() - 1;
            int b = f.nextInt() - 1;
            long c = f.nextLong();
            long min = Math.min(city[a][b], c);

            city[a][b] = min;
            city[b][a] = min;
        }

        fw();

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int a = f.nextInt() - 1;
            int b = f.nextInt() - 1;
            long dist = city[a][b];
            s.append( dist == INF ? -1 : dist);
            s.append("\n");
        }


        out.println(s);
        out.flush();
    }

    public void fw() {
        for(int k = 0; k < n; k++) {
            for (int v = 0; v < n; v++) {
                for (int w = 0; w <= v; w++) {
                    long vw = dist(v,w);
                    long vk = dist(v,k);
                    long kw = dist(k,w);
                    if (vw > vk + kw) {
                        city[v][w] = vk + kw;
                        city[w][v] = vk + kw;
                    }
                }
            }
        }
    }

    public long dist(int v1, int v2) {
        return city[v1][v2];
    }

    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}