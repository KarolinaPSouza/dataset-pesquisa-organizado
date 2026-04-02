import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class entry_12640820 {
    private static int n, m;
    private static List<Integer>[] adj;
    private static boolean[] visited;
    private static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        visited = new boolean[n + 1];
        List<Integer> components = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                components.add(i);
                dfs(i);
            }
        }

        int k = components.size() - 1;
        System.out.println(k);
        for (int i = 0; i < k; i++) {
            System.out.println(components.get(i) + " " + components.get(i + 1));
        }
    }

    private static void dfs(int u) {
        visited[u] = true;
        for (int v : adj[u]) {
            if (!visited[v]) {
                dfs(v);
            }
        }
    }
}