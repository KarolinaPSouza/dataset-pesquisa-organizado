import java.io.*;
import java.util.*;

public class entry_15309095 {

    static class Result {
        int node;
        int distance;

        Result(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static Result bfs(int startNode, List<List<Integer>> graph) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        dist[startNode] = 0;
        queue.add(startNode);

        int farthestNode = startNode;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : graph.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.add(v);

                    if (dist[v] > dist[farthestNode]) {
                        farthestNode = v;
                    }
                }
            }
        }

        return new Result(farthestNode, dist[farthestNode]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> graph = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // First BFS
        Result first = bfs(1, graph);
        // Second BFS from farthest node
        Result second = bfs(first.node, graph);

        System.out.println(second.distance);
    }
}