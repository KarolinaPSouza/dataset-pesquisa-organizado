// Import required libraries
import java.io.*;
import java.util.*;

public class entry_12473861 {

    // Graph variables
    static List<Integer>[] adj;   // Adjacency list to store the graph
    static boolean[] visited;     // Marks visited nodes
    static int[] parent;          // Stores parent of each node

    // DFS function to find and print a cycle
    static boolean dfs(int start) {
        // Stack for iterative DFS (node, parent)
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, -1});

        // Continue DFS while the stack is not empty
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int node = top[0], par = top[1];

            // Skip if the node is already visited
            if (visited[node]) continue;

            // Mark the node as visited and record its parent
            visited[node] = true;
            parent[node] = par;

            // Check all neighbors of the current node
            for (int neighbor : adj[node]) {
                // Visit unvisited neighbors
                if (!visited[neighbor]) {
                    stack.push(new int[]{neighbor, node});
                }
                // Cycle detected if the neighbor is visited and not the parent
                else if (neighbor != par) {
                    List<Integer> cycle = new ArrayList<>();
                    cycle.add(node);

                    // Backtrack to find the full cycle
                    for (int v = parent[node]; v != neighbor; v = parent[v]) {
                        cycle.add(v);
                    }
                    cycle.add(neighbor);
                    cycle.add(node);

                    // Print cycle length and nodes
                    System.out.println(cycle.size());
                    for (int c : cycle) {
                        System.out.print(c + " ");
                    }
                    System.out.println();

                    // Return true if a cycle is found
                    return true;
                }
            }
        }

        // No cycle found
        return false;
    }

    // Main method to read input and build the graph
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of nodes and edges
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // Number of nodes
        int m = Integer.parseInt(st.nextToken());  // Number of edges

        // Initialize adjacency list and arrays
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        // Read edges and build the graph
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        // Run DFS for all unvisited nodes
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i)) return; // Stop if a cycle is found
            }
        }

        // If no cycle is found, print "IMPOSSIBLE"
        System.out.println("IMPOSSIBLE");
    }
}