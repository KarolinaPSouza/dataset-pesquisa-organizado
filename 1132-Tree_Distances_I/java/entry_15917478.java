import java.io.*;
import java.util.*;

public class entry_15917478 {

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sgn = 1, res = 0;
            do c = read(); while (c <= ' ');
            if (c == '-') { sgn = -1; c = read(); }
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res * sgn;
        }
    }

    static int n;
    static List<List<Integer>> adj;
    static int[] distA, distB;

    static void bfs(int start, int[] dist) {
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
    }

    static int farthest(int[] dist) {
        int node = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[node]) node = i;
        }
        return node;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        n = fs.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        distA = new int[n + 1];
        distB = new int[n + 1];

        bfs(1, distA);
        int A = farthest(distA);

        bfs(A, distA);
        int B = farthest(distA);

        bfs(B, distB);

        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            out.append(Math.max(distA[i], distB[i])).append(' ');
        }
        System.out.print(out);
    }
}