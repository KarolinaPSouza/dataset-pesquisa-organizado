import java.io.*;
import java.util.*;

public class entry_12639958 {
    static List<Integer>[] adj;
    static int[] color;
    static boolean isBipartite = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        color = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            color[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!bfs(i)) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(color[i]).append(" ");
        }
        System.out.println(sb);
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        color[start] = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj[u]) {
                if (color[v] == 0) {
                    color[v] = 3 - color[u];
                    queue.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}