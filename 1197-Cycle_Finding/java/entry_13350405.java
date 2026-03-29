import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_13350405 {

    public static void ansBit(int n, ArrayList<int[]> edges) {
        long INF = (long) 1e18;
        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        Arrays.fill(dist, INF);
        dist[1] = 0; // Assuming node 1 is the source, but this might not catch all cycles

        int lastRelaxedNode = -1;

        // Bellman-Ford algorithm
        for (int i = 0; i < n; i++) {
            lastRelaxedNode = -1;
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int val = edge[2];
                if (dist[u] + val < dist[v]) {
                    dist[v] = dist[u] + val;
                    parent[v] = u;
                    lastRelaxedNode = v;
                }
            }
        }

        if (lastRelaxedNode == -1) {
            System.out.println("NO");
            return;
        }

        // Find a node that's part of the negative cycle
        for (int i = 0; i < n; i++) {
            lastRelaxedNode = parent[lastRelaxedNode];
        }

        // Reconstruct the cycle
        List<Integer> cycle = new ArrayList<>();
        int current = lastRelaxedNode;
        while (true) {
            cycle.add(current);
            if (cycle.size() > 1 && current == lastRelaxedNode) {
                break;
            }
            current = parent[current];
        }
        Collections.reverse(cycle);

        System.out.println("YES");
        for (int node : cycle) {
            System.out.print(node + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, val});
        }
        ansBit(n, edges);
    }
}