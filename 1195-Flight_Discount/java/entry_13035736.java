import java.io.*;
import java.util.*;

public class entry_13035736 {

    static class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class State implements Comparable<State> {
        int node;
        long dist;
        boolean used;

        State(int node, long dist, boolean used) {
            this.node = node;
            this.dist = dist;
            this.used = used;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Edge>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]) - 1;
            int v = Integer.parseInt(edge[1]) - 1;
            long w = Long.parseLong(edge[2]);
            adj[u].add(new Edge(v, w));
        }

        // dist[node][0] = min distance without using discount
        // dist[node][1] = min distance after using discount
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(0, 0, false));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            State curr = pq.poll();
            int u = curr.node;
            long d = curr.dist;
            boolean used = curr.used;

            // Skip if we've already found a better path to this state
            if (d > dist[u][used ? 1 : 0]) continue;

            for (Edge edge : adj[u]) {
                int v = edge.to;
                long w = edge.cost;

                // Option 1: Don't use discount on this edge
                long newDist1 = d + w;
                if (newDist1 < dist[v][used ? 1 : 0]) {
                    dist[v][used ? 1 : 0] = newDist1;
                    pq.offer(new State(v, newDist1, used));
                }

                // Option 2: Use discount on this edge (only if not used before)
                if (!used) {
                    long newDist2 = d + w / 2;
                    if (newDist2 < dist[v][1]) {
                        dist[v][1] = newDist2;
                        pq.offer(new State(v, newDist2, true));
                    }
                }
            }
        }

        System.out.println(Math.min(dist[n-1][0], dist[n-1][1]));
    }
}