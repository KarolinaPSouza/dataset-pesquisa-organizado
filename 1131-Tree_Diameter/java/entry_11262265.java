import java.io.*;
import java.util.*;

public class entry_11262265 {
    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Adjacency list representation
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // Perform the first BFS to find the farthest node from node 1
        int farthestNode = bfs(1, n, tree).getKey();

        // Perform the second BFS from the farthest node to find the diameter
        int diameter = bfs(farthestNode, n, tree).getValue();

        // Output the diameter
        System.out.println(diameter);
    }

    // BFS function to find the farthest node and its distance
    private static Map.Entry<Integer, Integer> bfs(int start, int n, List<List<Integer>> tree) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];

        queue.add(start);
        visited[start] = true;

        int farthestNode = start;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);

                    // Track the farthest node
                    if (distance[neighbor] > distance[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new AbstractMap.SimpleEntry<>(farthestNode, distance[farthestNode]);
    }
}