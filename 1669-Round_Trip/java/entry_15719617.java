import java.io.*;
import java.util.*;

public class entry_15719617 {

    static ArrayList<Integer>[] adj;
    static boolean[] vis;
    static int[] parent;
    static int start = -1, end = -1;

    static void dfs(int u, int p) {
        vis[u] = true;
        parent[u] = p;

        for (int v : adj[u]) {
            if (v == p) continue;

            if (vis[v]) {
                // cycle found
                start = v;
                end = u;
                return;
            }

            if (!vis[v]) {
                dfs(v, u);
                if (start != -1) return;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        vis = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, -1);
                if (start != -1) break;
            }
        }

        if (start == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        // reconstruct cycle
        ArrayList<Integer> cycle = new ArrayList<>();
        cycle.add(start);

        for (int v = end; v != start; v = parent[v]) {
            cycle.add(v);
        }
        cycle.add(start);

        System.out.println(cycle.size());
        for (int x : cycle) {
            System.out.print(x + " ");
        }
    }

    // fast input
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}