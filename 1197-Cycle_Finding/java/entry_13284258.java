import java.io.*;
import java.util.*;

public class entry_13284258 {
    static final long INF = (long) 1e18;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Read directed edges
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new int[]{u, v, w};
        }

        // Build undirected adjacency to find weakly-connected components
        List<Integer>[] undirectedAdj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            undirectedAdj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            undirectedAdj[u].add(v);
            undirectedAdj[v].add(u);
        }

        boolean[] compVisited = new boolean[n + 1];
        // For breaking out when a negative cycle is found:
        boolean foundNegCycle = false;

        // Iterate over all nodes to discover components
        for (int i = 1; i <= n && !foundNegCycle; i++) {
            if (compVisited[i]) continue;

            // BFS to collect this component's nodes
            List<Integer> compNodes = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            compVisited[i] = true;
            q.add(i);
            while (!q.isEmpty()) {
                int u = q.poll();
                compNodes.add(u);
                for (int v : undirectedAdj[u]) {
                    if (!compVisited[v]) {
                        compVisited[v] = true;
                        q.add(v);
                    }
                }
            }

            // For each node in this component, run Bellman-Ford with that node as source
            for (int src : compNodes) {
                // dist and parent arrays
                long[] dist = new long[n + 1];
                int[] parent = new int[n + 1];
                Arrays.fill(dist, INF);
                Arrays.fill(parent, -1);

                dist[src] = 0;

                // Relax edges (n-1) times
                for (int iter = 0; iter < n - 1; iter++) {
                    boolean anyRelax = false;
                    for (int[] e : edges) {
                        int u = e[0], v = e[1], w = e[2];
                        if (dist[u] != INF && dist[u] + w < dist[v]) {
                            dist[v] = dist[u] + w;
                            parent[v] = u;
                            anyRelax = true;
                        }
                    }
                    if (!anyRelax) break;
                }

                // One more pass to detect negative cycle reachable from src
                int x = -1;
                for (int[] e : edges) {
                    int u = e[0], v = e[1], w = e[2];
                    if (dist[u] != INF && dist[u] + w < dist[v]) {
                        x = v;
                        parent[v] = u;
                        break;
                    }
                }
                if (x != -1) {
                    // Negative cycle found reachable from src
                    System.out.println("YES");
                    // To ensure x is inside the cycle, walk back n steps
                    for (int k = 0; k < n; k++) {
                        x = parent[x];
                    }
                    // Collect the cycle
                    List<Integer> cycle = new ArrayList<>();
                    int curr = x;
                    do {
                        cycle.add(curr);
                        curr = parent[curr];
                    } while (curr != x && curr != -1);
                    cycle.add(x);
                    // Reverse to print in correct order
                    Collections.reverse(cycle);
                    // Print cycle nodes
                    StringBuilder sb = new StringBuilder();
                    for (int node : cycle) {
                        sb.append(node).append(" ");
                    }
                    System.out.println(sb.toString().trim());
                    foundNegCycle = true;
                    break;
                }
                // else: no negative cycle reachable from this src; continue with next src
            }
            // continue to next component if none found in this component
        }

        if (!foundNegCycle) {
            System.out.println("NO");
        }
    }
}