import java.util.*;
import java.io.*;

public class entry_15572877 {

    static ArrayList<Integer>[] g;
    static int[] parent;
    static int[] vis;
    static int start = -1, end = -1;

    static boolean dfs(int u, int p) {
        vis[u] = 1;
        for (int v : g[u]) {
            if (v == p) continue;

            if (vis[v] == 1) {
                start = v;
                end = u;
                return true;
            }

            parent[v] = u;
            if (vis[v] == 0 && dfs(v, u)) return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();

        int n = in.nextInt();
        int m = in.nextInt();

        g = (ArrayList<Integer>[]) new ArrayList[n + 1];
        parent = new int[n + 1];
        vis = new int[n + 1];

        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        while (m-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0 && dfs(i, -1)) break;
        }

        if (start == -1) {
            out.println("IMPOSSIBLE");
            out.close();
            return;
        }

        // reconstruct cycle
        ArrayList<Integer> cycle = new ArrayList<>();
        cycle.add(start);

        for (int v = end; v != start; v = parent[v])
            cycle.add(v);

        cycle.add(start);

        out.println(cycle.size());
        for (int x : cycle) out.print(x + " ");

        out.close();
    }

    // Fast IO
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) {}
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }

    static class FastWriter {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        void print(Object o) throws IOException { bw.append(String.valueOf(o)); }
        void println(Object o) throws IOException { bw.append(String.valueOf(o)).append("\n"); }
        void close() throws IOException { bw.close(); }
    }
}