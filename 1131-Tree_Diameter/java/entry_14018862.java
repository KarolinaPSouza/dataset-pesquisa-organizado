import java.io.*;
import java.util.*;

public class entry_14018862 {
    public static void main(String[] args) throws IOException {
        // Fast input with BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Create adjacency list
        List<Integer>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Read edges
        for (int i = 0; i < n - 1; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            adj[a].add(b);
            adj[b].add(a); // Undirected edge
        }

        // First BFS: Find one endpoint of the diameter
        int[] dist = new int[n + 1];
        Arrays.fill(dist, n + 1); // Large enough since max path is n-1
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1); // Start from node 1
        dist[1] = 0;
        int farthestNode = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj[node]) {
                if (dist[neighbor] == n + 1) { // Not visited
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                    if (dist[neighbor] > dist[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }

        // Second BFS: Find diameter from the farthest node
        Arrays.fill(dist, n + 1);
        queue.offer(farthestNode);
        dist[farthestNode] = 0;
        int diameter = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj[node]) {
                if (dist[neighbor] == n + 1) { // Not visited
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                    diameter = Math.max(diameter, dist[neighbor]);
                }
            }
        }

        // Output diameter
        System.out.println(diameter);
    }
}