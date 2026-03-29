import java.io.*;
import java.util.*;

public class entry_13409683 {
    static class Edge {
        int to;
        long cost;
        Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int u;
        int used; // 0 = coupon not used, 1 = used
        long dist;
        Node(int u, int used, long dist) {
            this.u = u;
            this.used = used;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    static final long INF = Long.MAX_VALUE;
    static List<List<Edge>> adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj.get(u).add(new Edge(v, c));
        }

        // Dijkstra with state: 0 = no coupon used, 1 = used
        long[][] dist = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1][0] = 0;
        pq.add(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.u;
            int used = curr.used;
            long d = curr.dist;

            if (d > dist[u][used]) continue;

            for (Edge e : adj.get(u)) {
                int v = e.to;
                long w = e.cost;

                // Normal move
                if (d + w < dist[v][used]) {
                    dist[v][used] = d + w;
                    pq.add(new Node(v, used, dist[v][used]));
                }

                // Use coupon if not used yet
                if (used == 0) {
                    long discounted = d + (w / 2);
                    if (discounted < dist[v][1]) {
                        dist[v][1] = discounted;
                        pq.add(new Node(v, 1, discounted));
                    }
                }
            }
        }

        System.out.println(dist[n][1]); // Cheapest route using coupon
    }
}