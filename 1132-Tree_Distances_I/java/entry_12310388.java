import java.io.*;
import java.util.*;

public class entry_12310388 {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader for fast input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // Create an adjacency list for the tree (1-indexed)
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Read the edges and construct the tree
        for (int i = 1; i < n; i++) {
            String[] parts = br.readLine().trim().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        // Step 1: Perform BFS from node 1 to find the farthest node A.
        int[] distanceFromStart = new int[n + 1];
        Arrays.fill(distanceFromStart, -1);
        int A = bfs(1, graph, distanceFromStart);

        // Step 2: Perform BFS from node A to get distances from A and find farthest node B.
        int[] distanceFromA = new int[n + 1];
        Arrays.fill(distanceFromA, -1);
        int B = bfs(A, graph, distanceFromA);

        // Step 3: Perform BFS from node B to get distances from B.
        int[] distanceFromB = new int[n + 1];
        Arrays.fill(distanceFromB, -1);
        bfs(B, graph, distanceFromB);

        // For each node, the answer is the maximum distance from either A or B.
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int maxDistance = Math.max(distanceFromA[i], distanceFromB[i]);
            sb.append(maxDistance).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    /**
     * This method performs a breadth-first search (BFS) starting from the given start node.
     * It fills the 'dist' array with distances from the start node and returns the farthest node found.
     *
     * @param start The starting node for BFS.
     * @param graph The tree represented as an adjacency list.
     * @param dist  The array to hold distances from the start node.
     * @return The farthest node from the start node.
     */
    static int bfs(int start, ArrayList<Integer>[] graph, int[] dist) {
        Queue<Integer> queue = new ArrayDeque<>();
        dist[start] = 0;
        queue.offer(start);
        int farthestNode = start;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Update the farthest node if necessary
            if (dist[current] > dist[farthestNode]) {
                farthestNode = current;
            }

            // Visit all adjacent nodes that have not been visited yet
            for (int neighbor : graph[current]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        return farthestNode;
    }
}