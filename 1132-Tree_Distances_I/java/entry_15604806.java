import java.io.*;
import java.util.*;

public class entry_15604806 {
    static final int NO_PARENT = -1;

    static int[] parent, dp, up, ans;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        parent = new int[n];
        Arrays.fill(parent, NO_PARENT);
        dp = new int[n];
        up = new int[n];
        ans = new int[n];

        // -------- BFS 1: build parent + order --------
        int[] order = new int[n];
        int idx = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : adj.get(u)) {
                if (v == parent[u]) continue;
                parent[v] = u;
                q.add(v);
            }
        }

        // -------- DP bottom-up (reverse order) --------
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            for (int v : adj.get(u)) {
                if (v == parent[u]) continue;
                dp[u] = Math.max(dp[u], 1 + dp[v]);
            }
        }

        // -------- BFS 2: rerooting --------
        q.clear();
        q.add(0);
        up[0] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            ans[u] = Math.max(dp[u], up[u]);

            int max = -1, secondMax = -1;
            for (int v : adj.get(u)) {
                if (v == parent[u]) continue;
                int d = dp[v];
                if (d > max) {
                    secondMax = max;
                    max = d;
                } else if (d > secondMax) {
                    secondMax = d;
                }
            }

            for (int v : adj.get(u)) {
                if (v == parent[u]) continue;
                int use = (dp[v] == max) ? secondMax : max;
                up[v] = Math.max(up[u] + 1, 2 + use);
                q.add(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(ans[i]).append(' ');
        System.out.print(sb);
    }

    // ---------- FAST INPUT ----------
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = System.in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do c = read(); while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}