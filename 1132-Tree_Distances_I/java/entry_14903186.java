import java.util.*;
import java.io.*;

public class entry_14903186 {
    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() {
            if (ptr >= len) {
                try { len = in.read(buffer); ptr = 0; } catch (IOException e) { return -1; }
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() {
            int entry_14903186, sign = 1, val = 0;
            do { entry_14903186 = readByte(); } while (entry_14903186 <= ' ');
            if (entry_14903186 == '-') { sign = -1; entry_14903186 = readByte(); }
            while (entry_14903186 > ' ') { val = val * 10 + (entry_14903186 - '0'); entry_14903186 = readByte(); }
            return val * sign;
        }
    }

    static List<List<Integer>> adj;
    static int dp[][];  // [maxDepth, secondMax, maxChild]
    static int ans[];

    static class Node {
        int u, par, stage;
        Node(int u, int par, int stage) { this.u = u; this.par = par; this.stage = stage; }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        solve(fr, out);
        out.flush();
    }

    static void solve(FastReader fr, PrintWriter out) {
        int n = fr.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dp = new int[n][3];
        ans = new int[n];

        // Iterative dfs1
        Stack<Node> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        int[] ret = new int[n];
        stack.push(new Node(0, -1, 0));

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int u = node.u;
            int par = node.par;
            int stage = node.stage;

            if (stage == 0) {
                stack.push(new Node(u, par, 1));
                for (int v : adj.get(u)) if (v != par) stack.push(new Node(v, u, 0));
            } else {
                // compute dp[u]
                int maxi = -1, sec = -1, maxnode = -1;
                for (int v : adj.get(u)) {
                    if (v == par) continue;
                    int temp = ret[v];
                    if (temp > maxi) { sec = maxi; maxi = temp; maxnode = v; }
                    else if (temp > sec) sec = temp;
                }
                dp[u][0] = maxi; dp[u][1] = sec; dp[u][2] = maxnode;
                ret[u] = maxi + 1;
            }
        }

        // Iterative dfs2
        stack.push(new Node(0, -1, -1));  // stage stores parAns
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int u = node.u, par = node.par, parAns = node.stage;
            ans[u] = Math.max(parAns, dp[u][0]);
            for (int v : adj.get(u)) {
                if (v == par) continue;
                if (v == dp[u][2]) stack.push(new Node(v, u, Math.max(dp[u][1], parAns) + 1));
                else stack.push(new Node(v, u, ans[u] + 1));
            }
        }

        StringBuilder res = new StringBuilder();
        for (int x : ans) res.append(x + 1).append(' ');
        out.println(res.toString());
    }
}