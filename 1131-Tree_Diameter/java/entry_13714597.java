import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_13714597 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] edge = reader.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int farthestFromStart[] = bfs(graph, 1);
        int diameter = bfs(graph, farthestFromStart[0])[1];

        System.out.println(diameter);
    }

    public static int[] bfs(List<List<Integer>> graph, int node) {
        int n = graph.size();
        Queue<Integer> queue = new LinkedList();
        int dist[] = new int[n + 1];
        boolean visited[] = new boolean[n + 1];
        queue.offer(node);
        visited[node] = true;
        int farthestNode = node;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbour : graph.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    dist[neighbour] = dist[current] + 1;
                    queue.offer(neighbour);

                    if (dist[neighbour] > dist[farthestNode]) {
                        farthestNode = neighbour;
                    }
                }
            }
        }

        return new int[] { farthestNode, dist[farthestNode] };
    }
}