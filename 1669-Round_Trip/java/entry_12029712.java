import java.io.*;
import java.util.*;

public class entry_12029712 {
    static int n, m;
    static List<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;
    static int cycleStart = -1, cycleEnd = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && dfs(i, -1)) {
                printCycle();
                return;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static boolean dfs(int v, int par) {
        visited[v] = true;
        parent[v] = par;

        for (int u : graph[v]) {
            if (u == par) continue;
            if (visited[u]) {
                cycleStart = u;
                cycleEnd = v;
                return true;
            }
            parent[u] = v;
            if (dfs(u, v)) return true;
        }

        return false;
    }

    static void printCycle() {
        List<Integer> cycle = new ArrayList<>();
        cycle.add(cycleStart);
        for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
            cycle.add(v);
        }
        cycle.add(cycleStart);
        Collections.reverse(cycle);

        System.out.println(cycle.size());
        for (int v : cycle) System.out.print(v + " ");
        System.out.println();
    }
}