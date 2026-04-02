//package CSES.Graph;

import java.util.*;
import java.io.*;

public class entry_11601320 {
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] vis;
    static int[] par;
    static int s = 0, f = 0;
    static boolean dfs (int n, int p) {
        vis[n] = true;
        par[n] = p;

        for (int i : adj.get(n)) {
            if (i == p) continue;
            if (vis[i]) {
                s = n;
                f = i;
                return true;
            }
            else if (dfs(i, n)) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        vis = new boolean[n + 1];
        par = new int[n + 1];

        for (int i = 1; i <= n; i++) if (!vis[i] && dfs(i, -1)) break;

        if (s == 0) out.println("IMPOSSIBLE");
        else {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(f);
            int x = s;

            while (x != f) {
                res.add(x);
                x = par[x];
            }
            res.add(f);
            Collections.reverse(res);

            out.println(res.size());
            for (int i : res) out.print(i + " ");
        }
        out.close();
    }
}