import java.io.*;
import java.util.*;
public class entry_1330908 {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) {
        int numCities = r.nextInt();
        int numRoads = r.nextInt();
        int numQueries = r.nextInt();
        long[][] distances = new long[numCities][numCities];
        long INF = (long) Math.pow(10, 15);
        for (int i = 0; i < numCities; i++) {
            Arrays.fill(distances[i], INF);
            distances[i][i] = 0;
        }
        for (int i = 0; i < numRoads; i++) {
            int a = r.nextInt() - 1;
            int b = r.nextInt() - 1;
            long length = r.nextLong();
            distances[a][b] = Math.min(distances[a][b], length);
            distances[b][a] = Math.min(distances[b][a], length);
        }
        for (int k = 0; k < numCities; k++) {
            for (int i = 0; i < numCities; i++) {
                for (int j = 0; j < numCities; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }
        for (int i = 0; i < numQueries; i++) {
            int a = r.nextInt() - 1;
            int b = r.nextInt() - 1;
            if (distances[a][b] == INF) {
                pw.println(-1);
            }
            else {
                pw.println(distances[a][b]);
            }
        }
        pw.close();
    }
}