import java.io.*;
import java.util.*;

public class entry_14020091 {
    static int n, m;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited;
    static int[] parent;
    static int start = -1, end = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];
        Arrays.fill(parent, -1);

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && dfs(i)) {
                break;
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
            path.add(start);
            Collections.reverse(path);
            out.println(path.size());
            for (int city : path) {
                out.print(city + " ");
            }
            out.println();
        }

        out.flush(); // Always flush before exit
    }

    static boolean dfs(int u) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (v == parent[u]) continue;
            if (visited[v]) {
                start = v;
                end = u;
                return true;
            } else {
                parent[v] = u;
                if (dfs(v)) return true;
            }
        }
        return false;
    }
}