import java.io.*;
import java.util.*;

public class entry_13805921 {
    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class State implements Comparable<State> {
        int node;
        long dist;

        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            long c = Long.parseLong(line[2]);
            adj.get(a).add(new Edge(b, c));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<State> pq = new PriorityQueue<>();

        dist[1] = 0;
        pq.offer(new State(1, 0));

        while (!pq.isEmpty()) {
            State current = pq.poll();
            int u = current.node;
            long d = current.dist;

            if (d > dist[u]) continue;

            for (Edge edge : adj.get(u)) {
                int v = edge.to;
                long w = edge.weight;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new State(v, dist[v]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]);
            if (i < n) sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}