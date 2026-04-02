import java.io.*;
import java.util.*;

public class entry_12296331 {
    static List<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;
    static int start = -1, end = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && dfs(i, -1)) {
                break;
            }
        }

        if (start == -1) {
            out.println("IMPOSSIBLE");
        } else {
            List<Integer> cycle = new ArrayList<>();
            cycle.add(start);
            for (int v = end; v != start; v = parent[v]) {
                cycle.add(v);
            }
            cycle.add(start);
            out.println(cycle.size());
            for (int city : cycle) {
                out.print(city + " ");
            }
            out.println();
        }
        out.close();
    }

    private static boolean dfs(int node, int par) {
        visited[node] = true;
        parent[node] = par;

        for (int neighbor : graph[node]) {
            if (neighbor == par) continue;
            if (visited[neighbor]) {
                start = neighbor;
                end = node;
                return true;
            }
            parent[neighbor] = node;
            if (dfs(neighbor, node)) {
                return true;
            }
        }
        return false;
    }
}