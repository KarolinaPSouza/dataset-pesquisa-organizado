import java.io.*;
import java.util.*;

class Codechef {
    public static void main(String[] args) throws IOException {
        // fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // build adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        // 1) BFS from node 0 → find farthest node A
        int[] dist0 = new int[n];
        int a = bfs(0, adj, dist0);

        // 2) BFS from A → record distA[], find farthest node B
        int[] distA = new int[n];
        int b = bfs(a, adj, distA);

        // 3) BFS from B → record distB[]
        int[] distB = new int[n];
        bfs(b, adj, distB);

        // 4) answer[i] = max(distA[i], distB[i])
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    /**
     * Runs a BFS from `src` over the tree in `adj`.
     * Fills `dist[]` with distances from src, and returns
     * the index of a farthest node (one of the ends of the diameter).
     */
    private static int bfs(int src, List<Integer>[] adj, int[] dist) {
        Arrays.fill(dist, -1);
        Deque<Integer> q = new ArrayDeque<>();
        dist[src] = 0;
        q.add(src);
        int farthest = src;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > dist[farthest]) {
                        farthest = v;
                    }
                }
            }
        }
        return farthest;
    }
}