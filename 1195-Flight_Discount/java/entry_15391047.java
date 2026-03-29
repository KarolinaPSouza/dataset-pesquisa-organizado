import java.util.*;
import java.io.*;

public class entry_15391047 {
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
        boolean used;
        State(int node, long cost, boolean used) {
            this.node = node;
            this.cost = cost;
            this.used = used;
        }
        public int compareTo(State o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<Edge>[] g = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            long c = Long.parseLong(parts[2]);
            g[a].add(new Edge(b, c));
        }

        long INF = Long.MAX_VALUE / 2;
        long[] distWithout = new long[n+1];
        long[] distWith = new long[n+1];
        Arrays.fill(distWithout, INF);
        Arrays.fill(distWith, INF);

        PriorityQueue<State> pq = new PriorityQueue<>();
        distWithout[1] = 0;
        pq.add(new State(1, 0, false));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            long cost = cur.cost;
            boolean used = cur.used;

            if (used && cost > distWith[u]) continue;
            if (!used && cost > distWithout[u]) continue;

            for (Edge e : g[u]) {
                int v = e.to;
                long c = e.cost;

                if (!used) {
                    // travel normally
                    if (distWithout[v] > distWithout[u] + c) {
                        distWithout[v] = distWithout[u] + c;
                        pq.add(new State(v, distWithout[v], false));
                    }
                    // use coupon
                    long half = c / 2;
                    if (distWith[v] > distWithout[u] + half) {
                        distWith[v] = distWithout[u] + half;
                        pq.add(new State(v, distWith[v], true));
                    }
                } else {
                    // already used coupon
                    if (distWith[v] > distWith[u] + c) {
                        distWith[v] = distWith[u] + c;
                        pq.add(new State(v, distWith[v], true));
                    }
                }
            }
        }

        System.out.println(distWith[n]);
    }
}