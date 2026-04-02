import java.io.*;
import java.util.*;

public class entry_14254568 {
    static List<Integer>[] adj;
    static int n, m;
    static int[] par, dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        par = new int[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);
        Arrays.fill(par, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        List<Integer> ans = bfs(1, n);
        if (ans == null) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans.size());
            StringBuilder sb = new StringBuilder();
            for (int i : ans) sb.append(i).append(" ");
            System.out.println(sb.toString().trim());
        }
    }

    private static List<Integer> bfs(int src, int dest) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n + 1];
        q.add(src);
        vis[src] = true;
        dist[src] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int e : adj[cur]) {
                if (!vis[e]) {
                    vis[e] = true;
                    dist[e] = dist[cur] + 1;
                    par[e] = cur;
                    q.add(e);
                }
            }
        }

        if (!vis[dest]) return null;

        List<Integer> path = new ArrayList<>();
        for (int i = dest; i != -1; i = par[i]) path.add(i);
        Collections.reverse(path);
        return path;
    }
}