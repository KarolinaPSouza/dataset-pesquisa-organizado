import java.io.*;
import java.util.*;

public class entry_12131011 {
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            graph[a].add(b);
            graph[b].add(a);
        }

        int farthestNode = bfs(1)[1];

        int diameter = bfs(farthestNode)[0];

        System.out.println(diameter);
    }

    private static int[] bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        int[] distance = new int[graph.length];

        queue.add(start);
        visited[start] = true;
        int farthestNode = start, maxDist = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    distance[neighbor] = distance[node] + 1;
                    if (distance[neighbor] > maxDist) {
                        maxDist = distance[neighbor];
                        farthestNode = neighbor;
                    }
                }
            }
        }
        return new int[]{maxDist, farthestNode};
    }
}