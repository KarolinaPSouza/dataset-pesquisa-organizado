import java.io.*;
import java.util.*;

public class entry_13486112 {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;
    static int cycleStart = -1, cycleEnd = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

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
                if (dfs(i)) {
                    break;
                }
            }
        }

        if (cycleStart == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            List<Integer> cycle = new ArrayList<>();
            cycle.add(cycleStart);
            for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
                cycle.add(v);
            }
            cycle.add(cycleStart);
            System.out.println(cycle.size());
            for (int v : cycle) {
                System.out.print(v + " ");
            }
        }
    }

    static boolean dfs(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        parent[start] = -1;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                visited[v] = true;
            }

            for (int u : adj[v]) {
                if (u == parent[v]) continue;
                if (visited[u]) {
                    cycleStart = u;
                    cycleEnd = v;
                    return true;
                } else {
                    parent[u] = v;
                    stack.push(u);
                }
            }
        }
        return false;
    }
}