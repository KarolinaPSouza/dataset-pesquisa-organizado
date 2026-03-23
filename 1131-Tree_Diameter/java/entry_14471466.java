import java.io.*;
import java.util.*;

public class entry_14471466 {

    private static final class FastScanner {
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
            while ((c = read()) <= ' ') if (c == -1) return Integer.MIN_VALUE;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    private static int bfsFarthest(int start, int[][] adj, int[] head, int[] dist, int n) {
        Arrays.fill(dist, -1);
        dist[start] = 0;
        int far = start;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.pollFirst();
            for (int e = head[u]; e != -1; e = adj[e][1]) {
                int v = adj[e][0];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    if (dist[v] > dist[far]) far = v;
                    q.addLast(v);
                }
            }
        }
        return far;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        if (n <= 1) {
            System.out.print(0);
            return;
        }

        int[][] edges = new int[2 * (n - 1)][2];
        int[] head = new int[n];
        Arrays.fill(head, -1);
        int ptr = 0;

        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            edges[ptr][0] = v;
            edges[ptr][1] = head[u];
            head[u] = ptr++;
            edges[ptr][0] = u;
            edges[ptr][1] = head[v];
            head[v] = ptr++;
        }

        int[] dist = new int[n];
        int a = bfsFarthest(0, edges, head, dist, n);
        int b = bfsFarthest(a, edges, head, dist, n);
        System.out.print(dist[b]);
    }
}