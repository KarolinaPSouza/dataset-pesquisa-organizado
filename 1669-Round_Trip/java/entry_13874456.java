import java.io.*;
import java.util.*;

public class entry_13874456 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    static int start = -1, end = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) break;
            }
        }

        if (start == -1) {
            out.println("IMPOSSIBLE");
        } else {
            List<Integer> path = new ArrayList<>();
            path.add(start);
            for (int v = end; v != start; v = parent[v]) {
                path.add(v);
            }
            path.add(start); // complete the cycle
            Collections.reverse(path);
            out.println(path.size());
            for (int x : path) out.print(x + " ");
            out.println();
        }

        out.flush();
    }

    static boolean dfs(int u, int par) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (v == par) continue;
            if (visited[v]) {
                start = v;
                end = u;
                return true;
            } else {
                parent[v] = u;
                if (dfs(v, u)) return true;
            }
        }
        return false;
    }
}