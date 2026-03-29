import java.io.*;
import java.util.*;

class Edge {
    int to;
    int from;
    int weight;

    Edge(int to, int from, int weight) {
        this.to = to;
        this.from = from;
        this.weight = weight;
    }
}

public class entry_15941732 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(to, from, weight));
        }

        long[] distances = new long[n + 1];
        Integer[] parent = new Integer[n + 1];

        Arrays.fill(distances, 0L);

        // Bellman–Ford relaxations
        for (int i = 1; i <= n - 1; i++) {
            for (Edge e : edges) {
                if (distances[e.to] != Long.MAX_VALUE &&
                    distances[e.to] + e.weight < distances[e.from]) {

                    distances[e.from] = distances[e.to] + e.weight;
                    parent[e.from] = e.to;
                }
            }
        }

        // Detect negative cycle
        Integer cyclicNode = null;
        for (Edge e : edges) {
            if (distances[e.to] != Long.MAX_VALUE &&
                distances[e.to] + e.weight < distances[e.from]) {

                distances[e.from] = distances[e.to] + e.weight;
                parent[e.from] = e.to;   // 🔥 FIX
                cyclicNode = e.from;
            }
        }

        if (cyclicNode == null) {
            System.out.println("NO");
            return;
        }

        // 🔥 Force node inside the cycle
        for (int i = 0; i < n; i++) {
            cyclicNode = parent[cyclicNode];
        }

        // Extract cycle
        List<Integer> cycle = new ArrayList<>();
        Integer start = cyclicNode;
        do {
            cycle.add(start);
            start = parent[start];
        } while (!start.equals(cyclicNode));   // 🔥 FIX

        cycle.add(cyclicNode);
        Collections.reverse(cycle);

        System.out.println("YES");
        for (Integer x : cycle) {
            System.out.print(x + " ");
        }
    }
}