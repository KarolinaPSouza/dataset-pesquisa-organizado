import java.io.*;
import java.util.*;

public class entry_13483131 {
    static int n, m;
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;
    static int start = -1, end = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) break;
            }
        }

        if (start == -1) {
            out.write("IMPOSSIBLE\n");
        } else {
            List<Integer> path = new ArrayList<>();
            path.add(start);
            for (int v = end; v != start; v = parent[v]) path.add(v);
            path.add(start);
            Collections.reverse(path);
            out.write(path.size() + "\n");
            for (int x : path) out.write(x + " ");
            out.write("\n");
        }

        out.flush();
    }

    static boolean dfs(int u, int par) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (v == par) continue;
            if (visited[v]) {
                start = v;
                end = u;
                return true;
            }
            parent[v] = u;
            if (dfs(v, u)) return true;
        }
        return false;
    }
}