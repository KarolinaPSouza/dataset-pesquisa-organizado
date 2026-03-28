import java.io.*;
import java.util.*;

public class entry_14115320 {
    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastReader(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                ptr = 0;
                len = in.read(buffer);
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ' && c != -1);
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static ArrayList<Integer>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader(System.in);
        int n = fr.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dist = new int[n + 1];
        int u = far(1);
        int v = far(u);

        int[] distU = bfsDist(u);
        int[] distV = bfsDist(v);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distU[i], distV[i])).append(" ");
        }
        System.out.println(sb);
    }

    static int far(int src) {
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        dist[src] = 0;
        int far = src;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph[cur]) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[cur] + 1;
                    q.add(nei);
                    if (dist[nei] > dist[far]) far = nei;
                }
            }
        }
        return far;
    }

    static int[] bfsDist(int src) {
        int[] d = new int[dist.length];
        Arrays.fill(d, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        d[src] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : graph[cur]) {
                if (d[nei] == -1) {
                    d[nei] = d[cur] + 1;
                    q.add(nei);
                }
            }
        }
        return d;
    }
}