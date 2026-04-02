import java.io.*;
import java.util.*;

public class entry_14637903 {
    static class FastScanner {
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
            int c, sgn = 1, x = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sgn = -1; c = read(); }
            while (c > ' ') {
                x = x * 10 + (c - '0');
                c = read();
            }
            return x * sgn;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();

        List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        boolean[] vis = new boolean[n + 1];
        List<Integer> reps = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int v = 1; v <= n; v++) {
            if (!vis[v]) {
                reps.add(v);
                stack.clear();
                stack.push(v);
                vis[v] = true;
                while (!stack.isEmpty()) {
                    int u = stack.pop();
                    for (int w : g[u]) {
                        if (!vis[w]) {
                            vis[w] = true;
                            stack.push(w);
                        }
                    }
                }
            }
        }

        StringBuilder out = new StringBuilder();
        int k = reps.size();
        out.append(k - 1).append('\n');
        for (int i = 0; i + 1 < k; i++) {
            out.append(reps.get(i)).append(' ').append(reps.get(i + 1)).append('\n');
        }
        System.out.print(out.toString());
    }
}