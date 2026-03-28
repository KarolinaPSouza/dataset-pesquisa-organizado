import java.io.*;
import java.util.*;

public class entry_15239911 {

    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int bId = 0, size = 0;
        private final InputStream in;

        FastReader(InputStream in) { this.in = in; }

        private int read() throws IOException {
            if (bId == size) {
                size = in.read(buffer);
                bId = 0;
                if (size == -1) return -1;
            }
            return buffer[bId++];
        }

        int nextInt() throws IOException {
            int c, neg = 1, val = 0;
            do { c = read(); } while (c <= 32 && c != -1);
            if (c == '-') { neg = -1; c = read(); }
            while (c > 32 && c != -1) {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * neg;
        }
    }

    static int n;
    static ArrayList<Integer>[] g;

    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
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

    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader(System.in);
        n = fr.nextInt();
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        int[] d1 = bfs(1);
        int A = 1;
        for (int i = 2; i <= n; i++) if (d1[i] > d1[A]) A = i;

        int[] dA = bfs(A);
        int B = 1;
        for (int i = 2; i <= n; i++) if (dA[i] > dA[B]) B = i;

        int[] dB = bfs(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(dA[i], dB[i])).append(' ');
        }
        System.out.print(sb);
    }
}