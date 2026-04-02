import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_11473239 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader for fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        // Read n and m
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // Initialize arrays for coloring and visited
        int[] color = new int[n + 1];
        Arrays.fill(color, -1); // -1 means unvisited

        // BFS to check bipartiteness and color the graph
        boolean isPossible = true;
        for (int start = 1; start <= n; start++) {
            if (color[start] == -1) {
                // Start BFS for this component
                Queue<Integer> q = new LinkedList<>();
                q.add(start);
                color[start] = 0; // Color the start node with 0

                while (!q.isEmpty() && isPossible) {
                    int curr = q.poll();
                    for (int neighbor : graph.get(curr)) {
                        if (color[neighbor] == -1) {
                            // Assign the opposite color to the neighbor
                            color[neighbor] = 1 - color[curr];
                            q.add(neighbor);
                        } else if (color[neighbor] == color[curr]) {
                            // Found a conflict, not bipartite
                            isPossible = false;
                            break;
                        }
                    }
                }
            }
        }

        // Output the result
        if (!isPossible) {
            out.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= n; i++) {
                out.print((color[i] + 1) + " "); // Convert 0, 1 to 1, 2
            }
        }

        out.flush();
        out.close();
    }
}