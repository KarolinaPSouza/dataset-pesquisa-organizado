import java.io.*;
import java.util.*;

public class entry_14089985 {

    public static class Pair {
        int node;
        int dt;

        public Pair(int node, int dt) {
            this.node = node;
            this.dt = dt;
        }
    }

    static void solve(FastReader in) {
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int vis[] = new int[n + 1];
        int par[] = new int[n + 1];
        Arrays.fill(par, -1);
        Arrays.fill(vis, -1);
        dfs(1, vis, adj);
        if (vis[n] == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        Arrays.fill(vis, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1] = 1;

        while (!q.isEmpty()) {
            int node = q.remove();

            if (n == node)
                break;

            for (int it : adj.get(node)) {

                if (vis[it] == -1) {
                    vis[it] = 1;
                    par[it] = node;
                    q.add(it);

                }

            }
        }

        List<Integer> res = new ArrayList<>();
        int node = n;
        while (node != -1) {
            res.add(node);
            node = par[node];
        }
        System.out.println(res.size());
        // Collections.sort(res);
        for (int i=res.size()-1;i>=0;i--)
            System.out.print(res.get(i) + " ");

    }

    public static void dfs(int curr, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[curr] = 1;

        for (int it : adj.get(curr)) {
            if (vis[it] == -1) {
                dfs(it, vis, adj);
            }
        }

    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        solve(in); // single test case
    }

    // FastReader for fast input
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = br.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}