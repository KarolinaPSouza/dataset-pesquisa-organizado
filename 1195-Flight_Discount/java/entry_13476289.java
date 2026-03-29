import java.util.*;
import java.io.*;

public class entry_13476289 {
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
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj.get(a).add(new Edge(b, c));
        }

        long[][] dist = new long[n + 1][2]; // [node][0/1] → 0: coupon not used, 1: used
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[1][0] = 0;
        pq.add(new Node(1, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.u;
            int used = cur.used;
            long d = cur.dist;

            if (d > dist[u][used]) continue;

            for (Edge e : adj.get(u)) {
                int v = e.to;
                long cost = e.cost;

                // Normal move (no coupon use)
                if (d + cost < dist[v][used]) {
                    dist[v][used] = d + cost;
                    pq.add(new Node(v, used, dist[v][used]));
                }

                // Use coupon (if not used yet)
                if (used == 0 && d + cost / 2 < dist[v][1]) {
                    dist[v][1] = d + cost / 2;
                    pq.add(new Node(v, 1, dist[v][1]));
                }
            }
        }

        System.out.println(dist[n][1]);
    }
}