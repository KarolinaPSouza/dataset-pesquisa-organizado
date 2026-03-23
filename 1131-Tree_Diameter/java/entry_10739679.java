import java.io.*;
import java.util.*;

public class entry_10739679 {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] dp = new int[n];
        iterativeDFS(graph, 0, dp);
        System.out.println(ans - 1); // Subtract 1 to match the original output
    }

    private static void iterativeDFS(List<Integer>[] graph, int root, int[] dp) {
        Stack<int[]> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        Stack<int[]> postOrder = new Stack<>();

        stack.push(new int[]{root, -1}); // Node and its parent

        // Step 1: Traverse the graph using DFS and store post-order nodes
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int node = current[0];
            int parent = current[1];

            if (!visited[node]) {
                visited[node] = true;
                postOrder.push(current); // Store for post-order processing

                // Add all unvisited children to the stack
                for (int neighbor : graph[node]) {
                    if (!visited[neighbor]) {
                        stack.push(new int[]{neighbor, node});
                    }
                }
            }
        }

        // Step 2: Process nodes in reverse post-order
        while (!postOrder.isEmpty()) {
            int[] current = postOrder.pop();
            int node = current[0];
            int parent = current[1];

            int max = 0;
            int secMax = 0;

            // Calculate the maximum and second maximum dp values for the node's children
            for (int neighbor : graph[node]) {
                if (neighbor == parent) continue;

                if (dp[neighbor] > max) {
                    secMax = max;
                    max = dp[neighbor];
                } else if (dp[neighbor] > secMax) {
                    secMax = dp[neighbor];
                }
            }

            ans = Math.max(ans, max + secMax + 1); // Update the global max answer
            dp[node] = 1 + max; // Store the maximum dp value for this node
        }
    }
}