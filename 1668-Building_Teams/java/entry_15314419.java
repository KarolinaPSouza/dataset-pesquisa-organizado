import java.io.*;
import java.util.*;

public class entry_15314419 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                q.add(i);

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int neigh : adj.get(node)) {
                        if (color[neigh] == -1) {
                            color[neigh] = 1 - color[node];
                            q.add(neigh);
                        } else if (color[neigh] == color[node]) {
                            System.out.println("IMPOSSIBLE");
                            return;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(color[i] + 1).append(' ');
        System.out.println(sb.toString());
    }

    // FAST SCANNER (no split())
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
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ') {
                val = val * 10 + (c - '0');
            }
            return val * sign;
        }
    }
}