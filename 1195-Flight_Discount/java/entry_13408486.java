import java.io.*;
import java.util.*;

public class entry_13408486 {

    // Edge class for storing destination city and flight cost.
    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    // State class to store the current city, coupon-used flag, and accumulated
    // distance.
    static class State implements Comparable<State> {
        int node, used; // used=0 if coupon not yet used, 1 if already used.
        long dist;

        State(int node, int used, long dist) {
            this.node = node;
            this.used = used;
            this.dist = dist;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        // Input using BufferedReader for fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Build the graph: using an array of lists (1-indexed)
        List<Edge>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, c));
        }

        // Prepare the distance table with two states for each city.
        // INF is set as a value high enough to avoid overflow.
        long INF = Long.MAX_VALUE / 2;
        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }
        // Start at city 1 (Syrjälä) with coupon unused.
        dist[1][0] = 0;

        // Priority Queue to process states by minimum current distance.
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0, 0));

        // Modified Dijkstra
        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int node = cur.node;
            int used = cur.used;
            long d = cur.dist;

            // If this state is outdated, skip it.
            if (d != dist[node][used])
                continue;

            // Relax the edges
            for (Edge e : adj[node]) {
                // Option 1: Do not use the coupon for this flight.
                if (d + e.cost < dist[e.to][used]) {
                    dist[e.to][used] = d + e.cost;
                    pq.add(new State(e.to, used, dist[e.to][used]));
                }
                // Option 2: Use the coupon if it hasn't been used yet.
                if (used == 0) {
                    long newCost = d + (e.cost / 2);
                    if (newCost < dist[e.to][1]) {
                        dist[e.to][1] = newCost;
                        pq.add(new State(e.to, 1, newCost));
                    }
                }
            }
        }

        // The result is the minimum cost to reach city n (Metsälä)
        long answer = Math.min(dist[n][0], dist[n][1]);
        out.println(answer);
        out.close();
    }
}