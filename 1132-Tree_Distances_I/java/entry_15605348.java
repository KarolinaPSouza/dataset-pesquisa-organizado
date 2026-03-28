//package contest;

import java.io.*;
import java.util.*;

public class entry_15605348 {
    static final int NO_PARENT = -1;
    static int[] p;
    static int[] parent;
    static int[] dp;
    static int[] ans;
    static List<List<Integer>> adj;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int nodeCount = fs.nextInt();

        adj = new ArrayList<>(nodeCount);
        for (int i = 0; i < nodeCount; i++) adj.add(new ArrayList<>());

        int edgeCount = nodeCount - 1;
        for (int i = 0; i < edgeCount; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        parent = new int[nodeCount];
        Arrays.fill(parent, NO_PARENT);
        dp = new int[nodeCount];
        p = new int[nodeCount];
        ans = new int[nodeCount];

        // -------- BFS 1: build parent[] and list of nodes --------
        List<Integer> nodes = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();
            nodes.add(node);

            for (int adjNode : adj.get(node)) {
                if (adjNode == parent[node]) continue;
                parent[adjNode] = node;
                q.add(adjNode);
            }
        }

        // -------- Bottom-up DP (reverse order) --------
        for (int i = nodeCount - 1; i >= 0; i--) {
            int node = nodes.get(i);
            for (int adjNode : adj.get(node)) {
                if (adjNode == parent[node]) continue;
                dp[node] = Math.max(dp[node], 1 + dp[adjNode]);
            }
        }

        // -------- BFS 2: rerooting --------
        q.clear();
        q.add(0);
        p[0] = 0;
        int[] above = new int[nodeCount];
        int[] parentLine = new int[nodeCount];

        while (!q.isEmpty()) {
            int node = q.poll();
            // for current node we've everything computed
            int down = dp[node];
            ans[node] = Math.max(above[node], down);

            // before adding child to qu, do child computations

            // this cal is based on parent and siblings
            int parentNode = parent[node];

//            if (parentNode != NO_PARENT) {
//                parentLine[node] = 1 + parentLine[parentNode];
//                for (int siblingNode : adj.get(parentNode)) {
//                    if (siblingNode == parent[parentNode] || siblingNode == node) continue;
//                    parentLine[node] = Math.max(parentLine[node], 2 + dp[siblingNode]);
//                }
//            }

            // for sibling max
            int max = -1, secondMax = -1;
            for (int adjNode : adj.get(node)) {
                if (adjNode == parent[node]) continue;
                int v = dp[adjNode];
                if (v > max) {
                    secondMax = max;
                    max = dp[adjNode];
                } else if (v == max) {
                    secondMax = max;
                } else {
                    secondMax = Math.max(secondMax, v);
                }
            }

            // this cal is based on children of node, and is specific for each child
            for (int adjNode : adj.get(node)) {
                if (adjNode == parent[node]) continue;

                int siblingMax = (dp[adjNode] == max) ? secondMax : max;
                above[adjNode] = Math.max(1 + above[node], 2 + siblingMax);

                q.add(adjNode);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append(' ');
        System.out.print(sb);
    }

    // -------- Fast Input --------
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
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}