import java.io.*;
import java.util.*;

public class entry_14457054 {
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        // 1st BFS from node 1
        int farthestFrom1 = bfs(1, n);

        // 2nd BFS from farthest node
        int diameter = bfsDistance(farthestFrom1, n);

        System.out.println(diameter);
    }

    // Returns farthest node from src
    static int bfs(int src, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n + 1];
        q.add(src);
        vis[src] = true;
        int last = src;

        while (!q.isEmpty()) {
            int u = q.poll();
            last = u;
            for (int v : adj[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
        return last;
    }

    // Returns distance to farthest node from src
    static int bfsDistance(int src, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n + 1];
        q.add(new int[]{src, 0});
        vis[src] = true;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int u = cur[0], dist = cur[1];
            maxDist = Math.max(maxDist, dist);

            for (int v : adj[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(new int[]{v, dist + 1});
                }
            }
        }
        return maxDist;
    }
}