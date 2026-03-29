import java.util.*;

public class entry_12103629 {

    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nOriginal = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int weight = sc.nextInt();
            edges.add(new Edge(from, to, weight));
        }
        int dummyNode = nOriginal;
        for (int i = 0; i < nOriginal; i++) {
            edges.add(new Edge(dummyNode, i, 0));
        }

        int totalNodes = nOriginal + 1;
        long[] dist = new long[totalNodes];
        int[] parent = new int[totalNodes];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[dummyNode] = 0;

        int lastUpdatedNode = -1;
        for (int i = 0; i < totalNodes; i++) {
            lastUpdatedNode = -1;
            for (Edge edge : edges) {
                if (dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    parent[edge.to] = edge.from;
                    lastUpdatedNode = edge.to;
                }
            }
        }

        if (lastUpdatedNode != -1) {
            int x = lastUpdatedNode;
            for (int i = 0; i < totalNodes; i++) {
                x = parent[x];
            }

            List<Integer> cycle = new ArrayList<>();
            int cur = x;
            while (true) {
                cycle.add(cur);
                cur = parent[cur];
                if (cur == x) {
                    cycle.add(cur);
                    break;
                }
            }
            Collections.reverse(cycle);
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            for (int node : cycle) {
                if (node != dummyNode) {
                    sb.append((node + 1)).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println("NO");
        }
    }
}