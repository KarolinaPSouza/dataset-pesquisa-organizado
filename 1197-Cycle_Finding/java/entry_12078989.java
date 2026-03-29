import java.util.*;

public class entry_12078989 {
    static class Edge {
        int a, b, c;
        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            edges.add(new Edge(a, b, c));
        }

        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, 0);
        Arrays.fill(parent, -1);

        int lastRelaxedNode = -1;

        for (int i = 0; i < n; i++) {
            lastRelaxedNode = -1;
            for (Edge edge : edges) {
                if (dist[edge.a] + edge.c < dist[edge.b]) {
                    dist[edge.b] = dist[edge.a] + edge.c;
                    parent[edge.b] = edge.a;
                    lastRelaxedNode = edge.b;
                }
            }
        }

        if (lastRelaxedNode == -1) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < n; i++) {
            lastRelaxedNode = parent[lastRelaxedNode];
        }

        List<Integer> cycle = new ArrayList<>();
        int current = lastRelaxedNode;
        do {
            cycle.add(current);
            current = parent[current];
        } while (current != lastRelaxedNode);
        cycle.add(lastRelaxedNode);

        Collections.reverse(cycle);
        System.out.println("YES");
        for (int node : cycle) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}