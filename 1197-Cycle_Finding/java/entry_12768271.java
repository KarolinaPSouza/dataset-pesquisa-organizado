import java.util.*;

public class entry_12768271 {

    private static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            edges.add(new Edge(u, v, weight));
        }

        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, 0);
        Arrays.fill(parent, 0);

        int negativeCycleNode = -1;
        for (int i = 1; i <= n; i++) {
            negativeCycleNode = -1;
            for (Edge edge : edges) {
                int u = edge.from;
                int v = edge.to;
                int weight = edge.weight;
                if (dist[u] != INF && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    negativeCycleNode = v;
                }
            }
            if (negativeCycleNode == -1 && i < n) {
                System.out.println("NO");
                return;
            }
        }

        if (negativeCycleNode == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            int current = negativeCycleNode;
            for (int i = 0; i < n; ++i) {
                current = parent[current];
            }

            List<Integer> cycle = new ArrayList<>();
            int start = current;
            cycle.add(start);
            current = parent[current];
            while (current != start) {
                cycle.add(current);
                current = parent[current];
            }
            cycle.add(start);
            Collections.reverse(cycle);
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print(cycle.get(i) + (i == cycle.size() - 1 ? "" : " "));
            }
            System.out.println();
        }
        scanner.close();
    }

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}