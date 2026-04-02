import java.io.*;
import java.util.*;

public class entry_15730197 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        ArrayList<Integer>[] tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            int boss = fs.nextInt();
            tree[boss].add(i);
        }

        int[] sub = new int[n + 1];
        int[] parent = new int[n + 1];

        // Stack for DFS
        int[] stack = new int[n];
        int top = 0;

        // Order list (post-order)
        int[] order = new int[n];
        int idx = 0;

        stack[top++] = 1;
        parent[1] = -1;

        // Build traversal order
        while (top > 0) {
            int u = stack[--top];
            order[idx++] = u;
            for (int v : tree[u]) {
                parent[v] = u;
                stack[top++] = v;
            }
        }

        // Process nodes in reverse order (post-order)
        for (int i = idx - 1; i >= 0; i--) {
            int u = order[i];
            sub[u] += 1;
            if (parent[u] != -1) {
                sub[parent[u]] += sub[u];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sub[i] - 1).append(" ");
        }
        System.out.println(sb);
    }

    // Very fast input
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
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