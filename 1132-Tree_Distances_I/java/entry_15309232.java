import java.io.*;
import java.util.*;

public class entry_15309232 {

    static class BFSResult {
        int farthestNode;
        int[] dist;

        BFSResult(int node, int[] dist) {
            this.farthestNode = node;
            this.dist = dist;
        }
    }

    static BFSResult bfs(int start, List<List<Integer>> graph) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();

        dist[start] = 0;
        q.add(start);

        int farthest = start;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > dist[farthest]) {
                        farthest = v;
                    }
                }
            }
        }

        return new BFSResult(farthest, dist);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // BFS from node 1 to find one endpoint of diameter
        BFSResult first = bfs(1, graph);
        int A = first.farthestNode;

        // BFS from A to find the other endpoint B + distances from A
        BFSResult second = bfs(A, graph);
        int B = second.farthestNode;
        int[] distA = second.dist;

        // BFS from B to get distances from B
        BFSResult third = bfs(B, graph);
        int[] distB = third.dist;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(" ");
        }

        System.out.println(sb.toString());
    }
}