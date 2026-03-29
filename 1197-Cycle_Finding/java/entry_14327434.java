import java.io.*;
import java.util.*;

public class entry_14327434 {
    static final int INF = Integer.MAX_VALUE / 2;
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        List<long[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long a = in.nextInt(), b = in.nextInt(), c = in.nextLong();
            edges.add(new long[] { a, b, c });
        }

        // we are going to relax the edges n times ans if it happens then there is a
        // negative cycle

        int[] parent = new int[n + 1];
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(parent, -1);

        dist[1] = 0;

        // relaxing the edges for n - 1 times
        for (int i = 0; i < n - 1; i++) {
            for (long[] e : edges) {
                int u = (int) e[0], v = (int) e[1];
                long cost = e[2];
                if (dist[v] > dist[u] + cost) {
                    dist[v] = dist[u] + cost;
                    parent[v] = u;
                }
            }
        }

        // if the relaxation happen for the nth time means there is a cycle
        int startNode = -1;
        for (long[] e : edges) {
            int u = (int) e[0], v = (int) e[1];
            long cost = e[2];
            if (dist[v] > dist[u] + cost) {
                // cycle found
                dist[v] = dist[u] + cost;
                parent[v] = u;
                startNode = v;
            }
        }

        if (startNode == -1) {
            out.println("NO");
            out.flush();
            return;
        }

        for (int i = 0; i < n; i++)
            startNode = parent[startNode];

        List<Integer> cycle = new ArrayList<>();
        int v = startNode;
        do {
            cycle.add(v);
            v = parent[v];
        } while (v != startNode);
        cycle.add(startNode);
        Collections.reverse(cycle);

        out.println("YES");
        for (int node : cycle) {
            out.print(node + " ");
        }
        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
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
    }
}