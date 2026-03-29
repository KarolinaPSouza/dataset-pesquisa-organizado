import java.io.*;
import java.util.*;

public class entry_10398939 {
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
        long cost;
        int usedCoupon;

        State(int node, long cost, int usedCoupon) {
            this.node = node;
            this.cost = cost;
            this.usedCoupon = usedCoupon;
        }

        @Override
        public int compareTo(State other) {
            return Long.compare(this.cost, other.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
        }

        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(1, 0, 0));
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int u = current.node;
            long cost = current.cost;
            int usedCoupon = current.usedCoupon;

            if (cost > dist[u][usedCoupon])
                continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                long w = edge.cost;

                if (dist[u][usedCoupon] + w < dist[v][usedCoupon]) {
                    dist[v][usedCoupon] = dist[u][usedCoupon] + w;
                    pq.offer(new State(v, dist[v][usedCoupon], usedCoupon));
                }

                if (usedCoupon == 0) {
                    long reducedCost = dist[u][0] + (w / 2);
                    if (reducedCost < dist[v][1]) {
                        dist[v][1] = reducedCost;
                        pq.offer(new State(v, dist[v][1], 1));
                    }
                }
            }
        }

        long result = Math.min(dist[n][0], dist[n][1]);
        System.out.println(result);
    }
}