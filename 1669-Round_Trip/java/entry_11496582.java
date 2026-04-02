import java.util.*;
import java.io.*;

public class entry_11496582 {
    private static List<List<Integer>> adj;
    private static boolean[] visited;
    private static int[] parent;
    private static boolean found = false;

    static void findCycle(int v, int p) {
        visited[v] = true;
        parent[v] = p;

        for (int u : adj.get(v)) {
            if (u == p) continue;  // Skip parent

            if (visited[u]) {
                // Found a potential cycle, validate its length
                List<Integer> cycle = new ArrayList<>();
                int curr = v;
                cycle.add(u);  // Add the closing vertex

                // Reconstruct the cycle
                while (curr != u) {
                    cycle.add(curr);
                    curr = parent[curr];
                }
                cycle.add(u);  // Complete the cycle

                // Check if cycle length is at least 3
                if (cycle.size() >= 4) {  // >= 4 because we added closing vertex twice
                    found = true;
                    System.out.println(cycle.size() );  // -1 because we added closing vertex twice
                    for (int i = cycle.size() - 1; i >= 0; i--) {
                        System.out.print(cycle.get(i) + " ");
                    }
                    System.out.println();
                    return;
                }
            } else if (!found) {
                findCycle(u, v);
                if (found) return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // Initialize data structures
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Try to find a cycle starting from each vertex
        if (n >= 3) {  // Only try if we have enough vertices
            for (int i = 1; i <= n && !found; i++) {
                if (!visited[i]) {
                    findCycle(i, 0);
                }
            }
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        }

        br.close();
    }
}