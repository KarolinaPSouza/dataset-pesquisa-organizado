import java.util.*;

public class entry_13240688 {
    static class Edge {
        int from, to, cost;
        Edge(int u, int v, int w) {
            from = u;
            to = v;
            cost = w;
        }
    }

    static final long INF = Long.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of nodes
        int m = sc.nextInt(); // number of edges

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            edges.add(new Edge(a, b, c));
        }

        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, 0); 

        int lastUpdated = -1;

        // Run Bellman-Ford for n rounds
        for (int i = 1; i <= n; i++) {
            lastUpdated = -1;
            for (Edge e : edges) {
                if (dist[e.from] + e.cost < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.cost;
                    parent[e.to] = e.from;
                    lastUpdated = e.to;
                }
            }
        }

        if (lastUpdated == -1) {
            System.out.println("NO");
        } else {
            // Recover cycle
            int x = lastUpdated;
            for (int i = 0; i < n; i++) {
                x = parent[x]; // get a node inside the cycle
            }

            List<Integer> cycle = new ArrayList<>();
            int current = x;
            do {
                cycle.add(current);
                current = parent[current];
            } while (current != x && !cycle.contains(current));
            cycle.add(x);
            Collections.reverse(cycle);

            System.out.println("YES");
            for (int v : cycle) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}