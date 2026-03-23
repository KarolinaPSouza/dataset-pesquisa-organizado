import java.io.*;
import java.util.*;

public class entry_15308552 {

    static ArrayList<Integer>[] g;
    static int n;

    static class Pair {
        int node, dist;
        Pair(int n, int d) { this.node = n; this.dist = d; }
    }

    static Pair bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        int farNode = start;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > dist[farNode]) farNode = v;
                }
            }
        }
        return new Pair(farNode, dist[farNode]);
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

        Pair p1 = bfs(1);               // find farthest from node 1
        Pair p2 = bfs(p1.node);         // farthest from p1 is diameter

        System.out.println(p2.dist);
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
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int v = c - '0';
            while ((c = read()) > ' ') v = v * 10 + (c - '0');
            return v * sign;
        }
    }
}