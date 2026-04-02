import java.util.*;
import java.io.*;

public class entry_15661867 {
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i ++) {graph.put(i+1, new ArrayList<>());}

        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        parents = new int[n+1];
        Arrays.fill(parents, -1);
        visited = new boolean[n+1];

        solve(n, m, graph);
    }


    public static void solve(int n, int m, Map<Integer, List<Integer>> graph) {
        boolean isValid = false;
        int[] ans = null;

        for (int i = 1; i <= n; i ++ ) {
            if (visited[i] == true) {
                continue;
            }   
            // System.out.println("debug start : " + i);
            int[] temp = dfs(i, graph);
            if (temp != null) {
                isValid = true;
                ans = temp;
                break;
            }
        }

        if (isValid == false) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        // System.out.println("debug parents : " + Arrays.toString(parents));
        // System.out.println("debug [u, v] : " + Arrays.toString(ans));


        StringBuilder sb = new StringBuilder();
        sb.append(ans[1]).append(' ');
        int count = 1;
        int u = ans[0];
        while (u != ans[1]) {
            // System.out.println("debug u : " + u);
            sb.append(u).append(' ');
            count += 1;
            u = parents[u];
        }
        sb.append(ans[1]);
        count += 1;

        System.out.println(count);
        System.out.println(sb.toString());
        return;
    }


    public static int[] dfs(int cur, Map<Integer, List<Integer>> graph) {
        // System.out.println("debug dfs start cur : " + cur);
        int[] ans = null;
        visited[cur] = true;
        // System.out.println("debug dfs start visited : " + Arrays.toString(visited));
        // System.out.println("debug dfs start parents : " + Arrays.toString(parents));

        for (int neighbor : graph.get(cur)) {
            // System.out.println("debug next current cur : " + cur);
            // System.out.println("debug next neighbor : " + neighbor);
            // 找到
            if (visited[neighbor] == true && neighbor != parents[cur]) {
                // System.out.println("debug cur found : " + cur);
                // System.out.println("debug neighbor found : " + neighbor);
                ans = new int[]{cur, neighbor};
                return ans;
            }   
            if (visited[neighbor] == false) {
                // System.out.println("debug neighbor : " + neighbor);
                parents[neighbor] = cur;
                // System.out.println("debug 往下走 neighbor : " + neighbor);
                // System.out.println("debug =====");
                ans = dfs(neighbor, graph);
                if (ans != null) {
                    return ans;
                }
            }
        }

        return ans;
    }
}