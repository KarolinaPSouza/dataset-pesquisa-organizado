import java.io.*;
import java.util.*;

public class entry_15305524 {
    static ArrayList<Integer>[] adj;
    static int n;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        n = fs.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        int A = bfs(1)[0];       
        int B = bfs(A)[0];       

        int[] distA = bfs(A, true);
        int[] distB = bfs(B, true);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++)
            sb.append(Math.max(distA[i], distB[i])).append(" ");

        System.out.print(sb);
    }

    static int[] bfs(int start, boolean returnDist) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }

    static int[] bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        int far = start;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > dist[far]) far = v;
                }
            }
        }
        return new int[]{far, dist[far]};
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
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val;
        }
    }
}