import java.util.*;
import java.io.*;

public class entry_12389287 {
    static class Edge {
        int u, v;
        long w;
        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        detectCycle(n, edges, bw);
        bw.flush();  // Ensure all output is written efficiently
    }

    private static void detectCycle(int n, List<Edge> edges, BufferedWriter bw) throws IOException {
        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(parent, -1);

        for (int start = 1; start <= n; start++) {
            if (visited[start]) continue; // Skip already visited components

            Arrays.fill(dist, Long.MAX_VALUE);
            dist[start] = 0;
            int cycleStart = -1;

            // Bellman-Ford Relaxation
            for (int i = 1; i <= n; i++) {
                boolean updated = false;
                cycleStart = -1;
                for (Edge e : edges) {
                    if (dist[e.u] != Long.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                        dist[e.v] = dist[e.u] + e.w;
                        parent[e.v] = e.u;
                        updated = true;
                        if (i == n) cycleStart = e.v;  // Found a cycle
                    }
                }
                if (!updated) break;
            }

            if (cycleStart != -1) {
                for (int i = 0; i < n; i++) {
                    cycleStart = parent[cycleStart];
                }

                List<Integer> cycle = new ArrayList<>();
                for (int v = cycleStart;; v = parent[v]) {
                    cycle.add(v);
                    if (v == cycleStart && cycle.size() > 1) break;
                }
                Collections.reverse(cycle);

                bw.write("YES\n");
                for (int node : cycle) {
                    bw.write(node + " ");
                }
                bw.write("\n");
                return;
            }

            // Mark all reachable nodes as visited
            for (int i = 1; i <= n; i++) {
                if (dist[i] != Long.MAX_VALUE) visited[i] = true;
            }
        }

        bw.write("NO\n");
    }
}