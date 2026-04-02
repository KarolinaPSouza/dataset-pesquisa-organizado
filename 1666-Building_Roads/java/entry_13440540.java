import java.io.*;
import java.util.*;

public class entry_13440540 {
    static class F {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String n() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String l = br.readLine();
                if (l == null) return null;
                st = new StringTokenizer(l);
            }
            return st.nextToken();
        }

        int ni() throws IOException {
            return Integer.parseInt(n());
        }
    }

    public static void main(String[] args) throws IOException {
        F f = new F();
        int n = f.ni();
        int m = f.ni();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = f.ni();
            edges[i][1] = f.ni();
        }

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {  // Fix: make size n+1
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        ArrayList<int[]> ans = new ArrayList<>();

        dfs(1, visited, list);
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, visited, list);
                ans.add(new int[]{1, i});  // Connecting node i to root (1)
            }
        }

        System.out.println(ans.size());
        for (int[] edge : ans) {
            System.out.println(edge[0] + " " + edge[1]);  // Fix: new line for each edge
        }
    }

    public static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> list) {
        if (visited[node]) return;
        visited[node] = true;
        for (int neighbor : list.get(node)) {
            dfs(neighbor, visited, list);
        }
    }
}