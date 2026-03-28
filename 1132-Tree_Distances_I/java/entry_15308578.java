import java.io.*;
import java.util.*;

public class entry_15308578 {

    static ArrayList<Integer>[] g;
    static int n;

    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }

    static int farthest(int[] dist) {
        int idx = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[idx]) idx = i;
        }
        return idx;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        n = fs.nextInt();
        g = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        // First BFS: from node 1 → get A
        int[] d1 = bfs(1);
        int A = farthest(d1);

        // Second BFS: from A → get B
        int[] da = bfs(A);
        int B = farthest(da);

        // Third BFS: from B
        int[] db = bfs(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(da[i], db[i])).append(' ');
        }

        System.out.println(sb.toString().trim());
    }

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
            while ((c = read()) <= ' ');
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int v = c - '0';
            while ((c = read()) > ' ') v = v * 10 + (c - '0');
            return v * sign;
        }
    }
}