import java.io.*;
import java.util.*;

public class entry_13407736 {
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
        boolean usedCoupon;

        State(int node, long dist, boolean usedCoupon) {
            this.node = node;
            this.dist = dist;
            this.usedCoupon = usedCoupon;
        }

        public int compareTo(State o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        // FAST INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
        }


        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) Arrays.fill(dist[i], Long.MAX_VALUE);
        dist[1][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0, false));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            long d = cur.dist;
            int used = cur.usedCoupon ? 1 : 0;

            if (d > dist[u][used]) continue;

            for (Edge e : graph[u]) {

                if (dist[e.to][used] > d + e.cost) {
                    dist[e.to][used] = d + e.cost;
                    pq.add(new State(e.to, dist[e.to][used], cur.usedCoupon));
                }

                if (!cur.usedCoupon) {
                    long discounted = d + e.cost / 2;
                    if (dist[e.to][1] > discounted) {
                        dist[e.to][1] = discounted;
                        pq.add(new State(e.to, discounted, true));
                    }
                }
            }
        }

        System.out.println(Math.min(dist[n][0], dist[n][1]));
    }
}