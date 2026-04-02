import java.io.*;
import java.util.*;

public class entry_15193746 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        int m = fs.nextInt();

        // adjacency list
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = fs.nextInt(), b = fs.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        int[] color = new int[n + 1]; // 0 = uncolored, 1 or 2 = team
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean ok = true;

        for (int start = 1; start <= n && ok; start++) {
            if (color[start] != 0) continue;
            color[start] = 1;
            q.add(start);

            while (!q.isEmpty() && ok) {
                int v = q.poll();
                int want = (color[v] == 1 ? 2 : 1);
                for (int u : g[v]) {
                    if (color[u] == 0) {
                        color[u] = want;
                        q.add(u);
                    } else if (color[u] == color[v]) {
                        ok = false; // same team on an edge => not bipartite
                        break;
                    }
                }
            }
        }

        if (!ok) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(color[i]).append(' ');
        }
        // trim trailing space
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }

    // Fast input
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { this.in = is; }
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
            do c = readByte(); while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            for (; c > ' '; c = readByte()) val = val * 10 + c - '0';
            return val * sign;
        }
    }
}