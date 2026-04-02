
import java.io.*;
import java.util.*;

public class entry_7163967  {
    static class Path implements Comparable<Path> {
        int dest;
        long cost;

        Path(int dest, long cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Path other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    static class Graph {
        int n;
        long[][] dist;

        Graph(int n) {
            this.n = n;
            dist = new long[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], Long.MAX_VALUE);
                dist[i][i] = 0;
            }
        }

        void addEdge(int a, int b, int cost) {
            dist[a][b] = Math.min(dist[a][b], cost);
            dist[b][a] = Math.min(dist[b][a], cost);
        }

        void findPath() {
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][k] != Long.MAX_VALUE && dist[k][j] != Long.MAX_VALUE) {
                            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        }
                    }
                }
            }
        }

        long getDistance(int src, int dest) {
            return dist[src][dest] != Long.MAX_VALUE ? dist[src][dest] : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        final long INF = (long) 1e12;
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int cost = in.nextInt();
            graph.addEdge(a, b, cost);
        }

        graph.findPath();

        for (int i = 0; i < q; i++) {
            int src = in.nextInt() - 1;
            int dest = in.nextInt() - 1;
            out.println(graph.getDistance(src, dest));
        }

        out.close();
    }

    static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }
}
