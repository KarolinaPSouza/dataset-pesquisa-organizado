import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class entry_14483910 {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;
    static int INT_MAX = Integer.MAX_VALUE, INT_MIN = Integer.MIN_VALUE;
    static long LONG_MAX = Long.MAX_VALUE, LONG_MIN = Long.MIN_VALUE;

    void dfs(
            List<Integer>[] g,
            boolean[] vis,
            int node
    ) {
        vis[node] = true;
        for (int neighbor : g[node]) {
            if (!vis[neighbor]) {
                dfs(g, vis, neighbor);
            }
        }
    }

    void solve() throws IOException {
        int N = parseInt(nextToken()), M = parseInt(nextToken());
        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int from = parseInt(nextToken()), to = parseInt(nextToken());
            g[from].add(to);
            g[to].add(from);
        }
        boolean[] vis = new boolean[N + 1];
        int k = 0;
        var components = new ArrayList<Integer>(N);
        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                k++;
                vis[i] = true;
                components.add(i);
                this.dfs(g, vis, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(--k).append("\n");
        for (int i = 0; i + 1 < components.size(); i++) {
            sb.append(components.get(i) + " " + components.get(i + 1)).append("\n");
        }
        out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int TC = 1;
        while (TC-- > 0) new entry_14483910().solve();
        out.flush();
        out.close();
        br.close();
    }

    static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }
}