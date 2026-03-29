import java.io.*;
import java.util.*;

class Main {

    // Represents a state in the priority queue
    static class State implements Comparable<State> {
        int id;       // Current city
        long cost;    // Total cost so far
        int used;     // 0 if coupon NOT used, 1 if coupon USED

        public State(int id, long cost, int used) {
            this.id = id;
            this.cost = cost;
            this.used = used;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    // Represents a flight connection
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();

        // Adjacency List
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            int w = fs.nextInt();
            adj.get(u).add(new Edge(v, w));
        }

        // dist[node][0] -> Min cost to reach 'node' having NOT used the coupon
        // dist[node][1] -> Min cost to reach 'node' having ALREADY used the coupon
        long[][] dist = new long[n + 1][2];
        for (long[] row : dist) Arrays.fill(row, Long.MAX_VALUE);

        PriorityQueue<State> pq = new PriorityQueue<>();

        // Start at city 1 with cost 0 and coupon not used
        dist[1][0] = 0;
        // dist[1][1] stays MAX_VALUE because we haven't used the coupon yet
        pq.add(new State(1, 0, 0));

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int u = current.id;
            long cost = current.cost;
            int used = current.used;

            // Optimization: If we found a shorter path to this state already, skip
            if (cost > dist[u][used]) continue;

            for (Edge e : adj.get(u)) {
                int v = e.to;
                int w = e.weight;

                // Case 1: We have NOT used the coupon yet (current.used == 0)
                if (used == 0) {
                    // Option A: Continue without using coupon (0 -> 0)
                    if (dist[u][0] + w < dist[v][0]) {
                        dist[v][0] = dist[u][0] + w;
                        pq.add(new State(v, dist[v][0], 0));
                    }

                    // Option B: Use the coupon on this flight (0 -> 1)
                    // Price becomes floor(w / 2)
                    long discountedPrice = w / 2;
                    if (dist[u][0] + discountedPrice < dist[v][1]) {
                        dist[v][1] = dist[u][0] + discountedPrice;
                        pq.add(new State(v, dist[v][1], 1));
                    }
                }

                // Case 2: We have ALREADY used the coupon (current.used == 1)
                if (used == 1) {
                    // We must continue normally with full price (1 -> 1)
                    if (dist[u][1] + w < dist[v][1]) {
                        dist[v][1] = dist[u][1] + w;
                        pq.add(new State(v, dist[v][1], 1));
                    }
                }
            }
        }

        // The answer is the cheapest way to reach node N having used the coupon
        System.out.println(dist[n][1]);
    }

    // Fast I/O helper class
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
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