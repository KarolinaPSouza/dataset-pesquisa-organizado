import java.io.*;
import java.util.*;

public class entry_12125002 {

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
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph[u].add(v);
            graph[v].add(u);
        }

        System.out.println(treeDiameter(n));
    }

    public static int treeDiameter(int n) {
        if (n == 1) return 0;
        int[] firstBFS = bfs(1, n);
        int[] secondBFS = bfs(firstBFS[0], n);
        return secondBFS[1];
    }

    public static int[] bfs(int start, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        dist[start] = 0;
        queue.add(start);

        int farthestNode = start;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                    if (dist[neighbor] > dist[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return new int[]{farthestNode, dist[farthestNode]};
    }
}