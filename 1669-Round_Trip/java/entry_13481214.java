import java.io.*;
import java.util.*;

public class entry_13481214 {
    static int[] parent;
    static boolean[] visited;
    static List<Integer>[] graph;
    static int cycleStart = -1, cycleEnd = -1;

    public static boolean dfs(int node, int par) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (neighbor == par) continue;
            if (visited[neighbor]) {
                cycleEnd = node;
                cycleStart = neighbor;
                return true;
            } else {
                parent[neighbor] = node;
                if (dfs(neighbor, node)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // number of cities
        int m = Integer.parseInt(st.nextToken()); // number of roads

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        // Build graph
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && dfs(i, -1)) {
                List<Integer> path = new ArrayList<>();
                path.add(cycleStart);
                for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
                    path.add(v);
                }
                path.add(cycleStart);
                Collections.reverse(path);

                System.out.println(path.size());
                for (int city : path) System.out.print(city + " ");
                return;
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}