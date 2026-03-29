import java.util.*;
import java.io.*;

public class entry_12079220 {
    static int n, m;
    static List<Edge> edges;
    static long[] dist;
    static int[] parent;

    static class Edge {
        int a, b;
        long c;
        Edge(int a, int b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        int cycleStart = findNegativeCycle();
        if (cycleStart != -1) {
            System.out.println("YES");
            List<Integer> cycle = extractCycle(cycleStart);
            for (int node : cycle) {
                System.out.print(node + " ");
            }
        } else {
            System.out.println("NO");
        }
    }

    static int findNegativeCycle() {
        dist = new long[n + 1];
        parent = new int[n + 1];
        Arrays.fill(dist, 0);

        int x = -1;
        for (int i = 0; i < n; i++) {
            x = -1;
            for (Edge e : edges) {
                if (dist[e.a] + e.c < dist[e.b]) {
                    dist[e.b] = dist[e.a] + e.c;
                    parent[e.b] = e.a;
                    x = e.b;
                }
            }
        }

        if (x == -1) {
            return -1; // No negative cycle found
        } else {
            // Find a node in the cycle
            for (int i = 0; i < n; i++) {
                x = parent[x];
            }
            return x;
        }
    }

    static List<Integer> extractCycle(int start) {
        List<Integer> cycle = new ArrayList<>();
        int v = start;
        while (true) {
            cycle.add(v);
            v = parent[v];
            if (v == start || cycle.contains(v)) {
                cycle.add(v);
                break;
            }
        }
        Collections.reverse(cycle);
        return cycle;
    }
}