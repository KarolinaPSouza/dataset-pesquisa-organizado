import java.io.*;
import java.util.*;

public class entry_14066719 {
    static ArrayList<Integer>[] adj;
    static int n;

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n-1; i++) {
            int u = fr.nextInt(), v = fr.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        // 1st BFS: from any node (1)
        int A = bfs(1, null);

        // 2nd BFS: from A
        int[] distA = new int[n+1];
        int B = bfs(A, distA);

        // 3rd BFS: from B
        int[] distB = new int[n+1];
        bfs(B, distB);

        // Answer
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(" ");
        }
        System.out.println(sb);
    }

    // BFS: returns farthest node, optionally fills distance array
    static int bfs(int start, int[] dist) {
        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;
        if (dist != null) dist[start] = 0;

        int farthestNode = start;
        while (!q.isEmpty()) {
            int u = q.poll();
            farthestNode = u;
            for (int v : adj[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    if (dist != null) dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return farthestNode;
    }

    // FastReader
    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

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
            do { c = readByte(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = readByte();
            }
            return val * sign;
        }
    }
}