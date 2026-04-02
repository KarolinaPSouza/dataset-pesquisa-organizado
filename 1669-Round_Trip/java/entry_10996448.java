import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class entry_10996448 {

    static int n;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] parent;
    static boolean[] vis;
    static int sv = -1;
    static int ev = -1;

    static class DisjointUnion {
        int[] parent, rank;

        DisjointUnion(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) return;
            if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    static void visit() {
        for (int i = 0; i <= n; i++) parent[i] = -1;
        for (int i = 0; i <= n; i++) {
            if (!vis[i] && dfs(i, -1)) return;
        }
    }

    static boolean dfs(int v, int p) {
        vis[v] = true;
        parent[v] = p;
        for (int u : adj.get(v)) {
            if (u == p) continue;
            if (vis[u]) {
                sv = u;
                ev = v;
                return true;
            } else {
                if (dfs(u, v)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        vis = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        visit();

        if (sv != -1 && ev != -1) {
            ArrayList<Integer> ans = new ArrayList<>();
            int tv = ev;
            ans.add(sv);
            while (tv != sv) {
                ans.add(tv);
                tv = parent[tv];
            }
            ans.add(sv);

            System.out.println(ans.size());
            for (int node : ans) System.out.print(node + " ");
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}