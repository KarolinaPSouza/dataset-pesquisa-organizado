import java.io.*;
import java.util.*;

public class entry_15791932 {

    static void bfs(int start, List<Integer>[] adj, int[] dist) {
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {   // 🔴 THIS LINE
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] dist = new int[n + 1];
        bfs(1, adj, dist);

        int a = 1;
        for (int i = 1; i <= n; i++)
            if (dist[i] > dist[a]) a = i;

        int[] dist1 = new int[n + 1];
        bfs(a, adj, dist1);

        int b = a;
        for (int i = 1; i <= n; i++)
            if (dist1[i] > dist1[b]) b = i;

        int[] dist2 = new int[n + 1];
        bfs(b, adj, dist2);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(Math.max(dist1[i], dist2[i])).append(" ");

        System.out.println(sb);
    }
}