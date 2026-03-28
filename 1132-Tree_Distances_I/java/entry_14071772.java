import java.io.*;
import java.util.*;

public class entry_14071772 {
    // Fast scanner
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= 32) if (c == -1) return Integer.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();                // read number of nodes
        // Build adjacency using edge arrays (fast)
        int m = (n - 1) * 2;
        int[] head = new int[n + 1];
        Arrays.fill(head, -1);
        int[] to = new int[m + 5];
        int[] next = new int[m + 5];
        int ei = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            to[ei] = v; next[ei] = head[u]; head[u] = ei++;
            to[ei] = u; next[ei] = head[v]; head[v] = ei++;
        }

        int[] parent = new int[n + 1];
        int[] order = new int[n];
        int ordIdx = 0;

        // iterative stack to build parent[] and order[] (preorder in order[], then we'll process reverse for postorder)
        int[] stack = new int[n];
        int sp = 0;
        int root = 1;
        stack[sp++] = root;
        parent[root] = 0; // 0 means no parent

        while (sp > 0) {
            int u = stack[--sp];
            order[ordIdx++] = u;
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                parent[v] = u;
                stack[sp++] = v;
            }
        }

        // down[u] = longest downward distance from u to any descendant
        int[] down = new int[n + 1];
        for (int i = ordIdx - 1; i >= 0; i--) {
            int u = order[i];
            int best = 0;
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                best = Math.max(best, down[v] + 1);
            }
            down[u] = best;
        }

        // compute for each node top two child distances (max1, max2)
        int[] max1 = new int[n + 1];
        int[] max2 = new int[n + 1];
        for (int i = 0; i < ordIdx; i++) {
            int u = order[i];
            int a = 0, b = 0;
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                int d = down[v] + 1;
                if (d > a) { b = a; a = d; }
                else if (d > b) { b = d; }
            }
            max1[u] = a;
            max2[u] = b;
        }

        // up[u] = best distance from u going upwards (towards parent or sibling subtrees)
        int[] up = new int[n + 1];
        // preorder traversal using order[] (which currently is preorder), root up[root] = 0
        // note: order[] is preorder from earlier stack fill; we can reuse it (start from 0 to ordIdx-1)
        for (int i = 0; i < ordIdx; i++) {
            int u = order[i];
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (v == parent[u]) continue;
                int use = max1[u];
                if (down[v] + 1 == max1[u]) use = max2[u];
                up[v] = Math.max(up[u] + 1, use + 1);
            }
        }

        // answer per node = max(down[u], up[u])
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(down[i], up[i])).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}