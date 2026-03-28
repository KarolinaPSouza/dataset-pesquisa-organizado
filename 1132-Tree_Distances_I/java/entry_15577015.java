import java.io.*;
import java.util.*;

public class entry_15577015 {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; ++i) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; ++i) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        int start = 1;
        int[] d1 = bfs(start, adj, n);
        int a = farthestNode(d1);
        int[] da = bfs(a, adj, n);
        int b = farthestNode(da);
        int[] db = bfs(b, adj, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            sb.append(Math.max(da[i], db[i]));
            if (i < n) sb.append(' ');
        }
        System.out.println(sb.toString());
    }

    static int[] bfs(int src, ArrayList<Integer>[] adj, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dist[src] = 0;
        dq.add(src);
        while (!dq.isEmpty()) {
            int v = dq.poll();
            for (int to : adj[v]) if (dist[to] == -1) {
                dist[to] = dist[v] + 1;
                dq.add(to);
            }
        }
        return dist;
    }

    static int farthestNode(int[] dist) {
        int best = 1;
        for (int i = 1; i < dist.length; ++i) {
            if (dist[i] > dist[best]) best = i;
        }
        return best;
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                } catch (Exception e) {
                    len = -1;
                }
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() {
            int c = read();
            while (c <= ' ') c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}