import java.io.*;
import java.util.*;

public class entry_14051471 {
    static final int MAX = (int) 2e5 + 5;
    static int[] ans = new int[MAX];
    static ArrayList<Integer>[] adj = new ArrayList[MAX];

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt();

        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            int v = fr.nextInt();
            adj[v].add(i);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i] - 1);
            if (i < n) sb.append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int start) {
        int[] stack = new int[MAX];
        int[] idx = new int[MAX];
        int top = 0;
        stack[top++] = start;

        while (top > 0) {
            int u = stack[top - 1];

            if (idx[u] == 0) ans[u] = 1; // first visit

            if (idx[u] < adj[u].size()) {
                int v = adj[u].get(idx[u]++);
                stack[top++] = v;
            } else {
                // All children processed
                for (int v : adj[u]) ans[u] += ans[v];
                top--;
            }
        }
    }

    // Ultra-fast input reader
    static class FastReader {
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
                val = val * 10 + c - '0';
                c = readByte();
            }
            return val * sign;
        }
    }
}