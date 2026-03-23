import java.io.*;
import java.util.*;
public class entry_15308760 {
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
        int far1 = bfs(1)[0];
        int diameter = bfs(far1)[1];
        System.out.println(diameter);
    }
    static int[] bfs(int start) {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        arr.add(start);
        dist[start] = 0;
        int far = start;
        while (!arr.isEmpty()) {
            int u = arr.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    arr.add(v);
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
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}