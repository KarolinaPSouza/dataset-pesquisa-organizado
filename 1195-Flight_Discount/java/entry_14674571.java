import java.io.*;
import java.util.*;

public class entry_14674571 {
    static ArrayList<int[]>[] adj;

    // dist[i][0] = shortest distance to node i without using discount
    // dist[i][1] = shortest distance to node i after using discount
    static long[][] dist;
    static final long INF = (long)1e18;

    static class State implements Comparable<State> {
        int node;   // current node
        int used;   // whether discount has been used (0 = no, 1 = yes)
        long cost;  // total cost to reach this state

        State(int node, long cost, int used) {
            this.node = node;
            this.cost = cost;
            this.used = used;
        }

        @Override
        public int compareTo(State o) {
            return Long.compare(this.cost, o.cost); // min-heap based on cost
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = fr.nextInt();
        int m = fr.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            int w = fr.nextInt();
            adj[u].add(new int[] {v, w});
        }

        dist = new long[n + 1][2];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dist[i], INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[1][0] = 0; // Start at node 1, discount not used
        pq.offer(new State(1, 0, 0));

        while (!pq.isEmpty()) {
            State s = pq.poll();
            int u = s.node;
            int used = s.used;
            long d = s.cost;

            // Skip outdated state
            if (d > dist[u][used])
                continue;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];

                // Case 1: move without using discount
                if (dist[v][used] > d + w) {
                    dist[v][used] = d + w;
                    pq.offer(new State(v, dist[v][used], used));
                }

                // Case 2: use discount if not yet used
                if (used == 0) {
                    long newCost = d + (w >> 1);
                    if (dist[v][1] > newCost) {
                        dist[v][1] = newCost;
                        pq.offer(new State(v, newCost, 1));
                    }
                }
            }
        }
        out.println(Math.min(dist[n][0], dist[n][1]));
        out.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null)
                    return null;
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}