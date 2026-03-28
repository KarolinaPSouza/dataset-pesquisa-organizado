import java.io.*;
import java.util.*;

public class entry_15245347 {

    static ArrayList<Integer>[] adj;
    static int n;

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt(), b = fs.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        // Find farthest node from 1 → A
        int[] dist = bfs(1);
        int A = farthestNode(dist);

        // Find farthest node from A → B
        int[] distA = bfs(A);
        int B = farthestNode(distA);

        //  Distances from B
        int[] distB = bfs(B);

        //  Answer = max(distA[i], distB[i])
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(' ');
        }
        System.out.println(sb);
    }

    //  BFS (iterative, no recursion)
    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int next : adj[node]) {
                if (dist[next] == -1) {
                    dist[next] = dist[node] + 1;
                    q.add(next);
                }
            }
        }
        return dist;
    }

    static int farthestNode(int[] dist) {
        int idx = 1;
        for (int i = 2; i <= n; i++) {
            if (dist[i] > dist[idx]) idx = i;
        }
        return idx;
    }

    //  Ultra-fast input
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = System.in.read(buffer);
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
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}