import java.io.*;
import java.util.*;

public class entry_14971001 {
    static class Edge {
        int from, to;
        long cost;
        Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            long c = Long.parseLong(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        long INF = (long) 1e17;
        long NINF = -INF;

        long[] dist = new long[n];
        Arrays.fill(dist, 0); // initial distances to 0
        int[] relaxant = new int[n];
        Arrays.fill(relaxant, -1);

        int lastRelaxed = -1;

        // Bellman-Ford
        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] + e.cost < dist[e.to]) {
                    dist[e.to] = Math.max(dist[e.from] + e.cost, NINF);
                    relaxant[e.to] = e.from;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.from] + e.cost < dist[e.to]) {
                dist[e.to] = Math.max(dist[e.from] + e.cost, NINF);
                relaxant[e.to] = e.from;
                lastRelaxed = e.to;
            }
        }

        if (lastRelaxed == -1) {
            System.out.println("NO");
            return;
        }

        // Find a node inside the negative cycle
        for (int i = 0; i < n; i++) {
            lastRelaxed = relaxant[lastRelaxed];
        }

        List<Integer> cycle = new ArrayList<>();
        int node = lastRelaxed;
        cycle.add(node);
        while (relaxant[node] != lastRelaxed) {
            node = relaxant[node];
            cycle.add(node);
        }
        cycle.add(relaxant[node]);
        Collections.reverse(cycle);

        System.out.println("YES");
        for (int x : cycle) {
            System.out.print((x + 1) + " ");
        }
        System.out.println();
    }
}