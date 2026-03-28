//package contest;

import java.io.*;
import java.util.*;

/*
here path len = number of edges
path will be simple, ie no repeated nodes
 dp[node] = max distance to any leaf from node (leaves give us max distance, hence we consider them)
to fill parent[] we use top to bottom bfs
to fill dp[] we explore the tree node list from bottom to top
 rerooting logic:
 down[node] = dp[node]
above[node] = max path length among all the paths starting from node via its parent node
ie not involving any of its descendants
 for any node, 'N' before calling for the childNode 'C' in bfs, we calculate above[C] for it:
to calculate above[C] for any child C we need two things:
 1) max of all the paths of the form: C -> parent(ie N) -> C1 ..... leaf
(where C1 is some other child of parent, ie sibling of C)
 siblingMax: max of dp values of all the children of 'N' except 'C'
to compute this efficiently, we use max and secondMax logic
 => 2 + siblingMax
 2) max of all the paths starting from C going via N, and ending at nodes other than sibling of C
ie paths of the form: C -> N -> parent of N .....
this is computed with use of above[node]
=> 1 + above[node]
  */

public class entry_15606672 {
    static final int NO_PARENT = -1;
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
        int root = 0;
        parent[root] = NO_PARENT;
        dp = new int[nodeCount];
        ans = new int[nodeCount];

        // -------- BFS top to bottom: build parent[] and list of nodes --------
        List<Integer> nodes = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(root);

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
        q.add(root);
        int[] above = new int[nodeCount];

        while (!q.isEmpty()) {
            int node = q.poll();
            // for current node we've everything computed
            int down = dp[node];
            ans[node] = Math.max(above[node], down);

            // before adding child to queue, do child computations

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

            // this cal is based on node and children of node, and is specific for each child
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