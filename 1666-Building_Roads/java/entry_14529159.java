import java.io.*;
import java.util.*;

public class entry_14529159 {
    public static void dfs_iterative(ArrayList<Integer>[] graph, boolean[] vis, int src, ArrayList<Integer> sub) {
        Stack<Integer> st = new Stack<>();
        st.push(src);
        vis[src] = true;
        while (!st.isEmpty()) {
            int top = st.pop();
            sub.add(top);
            for (int nbr : graph[top]) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    st.push(nbr);
                }
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> dfs(int[][] edges, int N) {
        ArrayList<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] vis = new boolean[N];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                ArrayList<Integer> sub = new ArrayList<>();
                dfs_iterative(graph, vis, i, sub);
                ans.add(sub);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>> ans = dfs(edges, n);
        ArrayList<Integer> list = new ArrayList<>();
        for (ArrayList<Integer> l : ans) list.add(l.get(0) + 1);

        out.println(ans.size() - 1);
        for (int i = 1; i < list.size(); i++) {
            out.println(list.get(i - 1) + " " + list.get(i));
        }
        out.flush();
    }
}