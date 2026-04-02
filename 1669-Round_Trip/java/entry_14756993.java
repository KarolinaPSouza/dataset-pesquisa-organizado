import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class entry_14756993 {
    private static final class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }

    private static final class FastWriter {
        private final BufferedWriter bw;
        FastWriter() { bw = new BufferedWriter(new OutputStreamWriter(System.out)); }
        void print(Object o) throws IOException { bw.write(o.toString()); }
        void println(Object o) throws IOException { bw.write(o.toString()); bw.newLine(); }
        void flush() throws IOException { bw.flush(); }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        FastWriter fw = new FastWriter();
        int n = fs.nextInt();
        int m = fs.nextInt();
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        int[] parent = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        java.util.List<Integer> cycle = null;

        outer:
        for (int start = 1; start <= n; start++) {
            if (vis[start]) continue;
            // BFS from start
            q.clear();
            q.add(start);
            parent[start] = -1;
            vis[start] = true;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (v == parent[u]) continue; // skip the edge leading back to parent
                    if (!vis[v]) {
                        vis[v] = true;
                        parent[v] = u;
                        q.add(v);
                    } else {
                        // Found a cycle between u and v
                        cycle = buildCycle(u, v, parent);
                        break outer;
                    }
                }
            }
        }

        if (cycle == null) {
            fw.println("IMPOSSIBLE");
        } else {
            fw.println(cycle.size());
            StringBuilder sb = new StringBuilder();
            for (int node : cycle) sb.append(node).append(' ');
            fw.println(sb.toString().trim());
        }
        fw.flush();
    }

    // Reconstruct cycle given two endpoints u and v where v was already visited (and not parent[u])
    private static List<Integer> buildCycle(int u, int v, int[] parent) {
        java.util.List<Integer> pathU = new java.util.ArrayList<>();
        java.util.List<Integer> pathV = new java.util.ArrayList<>();
        int x = u;
        while (x != -1) { pathU.add(x); x = parent[x]; }
        int y = v;
        while (y != -1) { pathV.add(y); y = parent[y]; }
        // Reverse to root-first order
        Collections.reverse(pathU);
        Collections.reverse(pathV);
        int i = 0, lim = Math.min(pathU.size(), pathV.size());
        while (i < lim && pathU.get(i).equals(pathV.get(i))) i++;
        List<Integer> cycle = createRoundTrip(i, pathU, pathV);
        return cycle;
    }

    private static List<Integer> createRoundTrip(int i, List<Integer> pathU, List<Integer> pathV) {
        int lcaIndex = i - 1; // index of LCA in both lists
        int lca = pathU.get(lcaIndex);
        // Build cycle: u up to LCA, then LCA down to v, then back to u
        List<Integer> cycle = new ArrayList<>();
        // u to LCA
        for (int a = pathU.size() - 1; a >= lcaIndex; a--) cycle.add(pathU.get(a));
        // LCA to v (excluding LCA)
        for (int b = lcaIndex + 1; b < pathV.size(); b++) cycle.add(pathV.get(b));
        // close cycle by adding starting node again
        cycle.add(cycle.get(0));
        return cycle;
    }
}