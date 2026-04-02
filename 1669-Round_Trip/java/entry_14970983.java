import java.io.*;
import java.util.*;

public class entry_14970983 {

    // Static variables for global access
    static List<List<Integer>> adjList;
    static int[] visited; // 0=unvisited, 1=in stack, 2=finished
    static int[] parent;
    static PrintWriter out; // Make 'out' static to be accessible for exit

    /**
     * Performs an iterative 3-state DFS to find a cycle.
     */
    public static void iterativeDfs(int startNode) {
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);
        parent[startNode] = -1;
        visited[startNode] = 1; // Mark as "in stack"

        while (!stack.isEmpty()) {
            int node = stack.peek(); // Keep node on stack until fully processed

            boolean hasUnvisitedNeighbor = false;
            for (int v : adjList.get(node)) {
                // Don't go immediately back to the parent
                if (v == parent[node]) {
                    continue;
                }

                // If 'v' is "in stack" (state 1), we found an ancestor. CYCLE!
                if (visited[v] == 1) {
                    List<Integer> cycle = new ArrayList<>();
                    cycle.add(v); // Start from the ancestor 'v'
                    int curr = node; // Backtrack from the current 'node'

                    while (curr != v) {
                        cycle.add(curr);
                        curr = parent[curr];
                    }
                    cycle.add(v); // Close the cycle

                    // Print cycle and exit
                    out.println(cycle.size());
                    Collections.reverse(cycle); // C++ logic prints in this order
                    for (int c : cycle) {
                        out.print((c + 1) + " ");
                    }
                    out.println();

                    out.close();
                    System.exit(0);
                }

                // If 'v' is unvisited (state 0), push it to the stack
                if (visited[v] == 0) {
                    visited[v] = 1; // Mark as "in stack"
                    parent[v] = node;
                    stack.push(v);
                    hasUnvisitedNeighbor = true;
                    // Break and continue from the new node 'v'
                    break; 
                }

                // If visited[v] == 2, it's finished. Do nothing.
            }

            // If we explored all neighbors and found no new ones,
            // this 'node' is finished. Pop it and mark as state 2.
            if (!hasUnvisitedNeighbor) {
                visited[node] = 2; // Mark as "finished"
                stack.pop();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Setup fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out); // Initialize the static writer

        // Read n and m
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // Initialize adjacency list
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Read m edges
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a--; // Adjust to 0-based indexing
            b--;

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        visited = new int[n]; // 0=unvisited (default)
        parent = new int[n];

        // Run DFS from every node to check all disconnected components
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                iterativeDfs(i);
            }
        }

        // If the program hasn't exited by now, no cycle was found
        out.println("IMPOSSIBLE");

        out.close();
    }
}