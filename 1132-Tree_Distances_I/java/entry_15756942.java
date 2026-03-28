import java.io.*;
import java.util.*;

public class entry_15756942 {
    // Fast input
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do c = read(); while (c <= 32);
            if (c == '-') { s = -1; c = read(); }
            while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    static int n, ei;
    static int[] head, to, next, in, out, parent, order;

    static void addEdge(int u, int v) {
        to[ei] = v; next[ei] = head[u]; head[u] = ei++;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        n = fs.nextInt();
        head = new int[n];
        Arrays.fill(head, -1);
        to = new int[2 * (n - 1)];
        next = new int[2 * (n - 1)];
        in = new int[n];
        out = new int[n];
        parent = new int[n];
        order = new int[n];
        ei = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt() - 1, v = fs.nextInt() - 1;
            addEdge(u, v);
            addEdge(v, u);
        }

        // Build parent[] and a DFS order (preorder) iteratively
        int[] stack = new int[n];
        int sp = 0, ord = 0;
        Arrays.fill(parent, -2); // -2 = unvisited
        parent[0] = -1;
        stack[sp++] = 0;
        while (sp > 0) {
            int u = stack[--sp];
            order[ord++] = u;
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (parent[v] == -2) {
                    parent[v] = u;
                    stack[sp++] = v;
                }
            }
        }

        // Post-order DP for in[u] using reverse order
        for (int i = ord - 1; i >= 0; i--) {
            int u = order[i];
            int best = -1;
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                best = Math.max(best, in[v] + 1);
            }
            in[u] = Math.max(in[u], best);
            if (in[u] < 0) in[u] = 0; // leaves
        }

        // Top-down DP for out[v], iteratively in preorder
        out[0] = 0;
        for (int i = 0; i < ord; i++) {
            int u = order[i];

            // find top two child in[] values
            int first = -1, second = -1;
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                int val = in[v];
                if (val >= first) { second = first; first = val; }
                else if (val > second) { second = val; }
            }

            // propagate to children
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                int use = (in[v] == first) ? second : first; // best among siblings
                int fromUp = out[u] + 1;
                int fromSib = (use == -1) ? -1 : use + 2;
                out[v] = Math.max(fromUp, fromSib);
            }
        }

        StringBuilder sb = new StringBuilder(3 * n);
        for (int i = 0; i < n; i++) {
            int ans = Math.max(in[i], out[i]);
            sb.append(ans);
            if (i + 1 < n) sb.append(' ');
        }
        System.out.println(sb.toString());
    }
}