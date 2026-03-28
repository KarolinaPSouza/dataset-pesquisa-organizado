import java.io.*;
import java.util.*;

public class entry_15194068 {

    static ArrayList<Integer>[] graph;

    // Helper class to return multiple values from BFS
    static class BFSResult {
        int farthestNode;
        int distance;
        int[] dist;
        BFSResult(int farthestNode, int distance, int[] dist) {
            this.farthestNode = farthestNode;
            this.distance = distance;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // Step 1: find one endpoint of the diameter (A)
        BFSResult first = bfs(1, n);
        int A = first.farthestNode;

        // Step 2: find the other endpoint (B)
        BFSResult second = bfs(A, n);
        int B = second.farthestNode;
        int[] distA = second.dist;

        // Step 3: get distances from B
        BFSResult third = bfs(B, n);
        int[] distB = third.dist;

        // Step 4: for each node, max distance = max(distA[i], distB[i])
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    // BFS returns a BFSResult object with distances
    static BFSResult bfs(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        int farthestNode = start;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int u : graph[v]) {
                if (dist[u] == -1) {
                    dist[u] = dist[v] + 1;
                    q.add(u);
                    if (dist[u] > dist[farthestNode]) {
                        farthestNode = u;
                    }
                }
            }
        }

        return new BFSResult(farthestNode, dist[farthestNode], dist);
    }

    // Fast scanner for large input
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int len = 0, ptr = 0;
        private final InputStream in;
        FastScanner(InputStream in) { this.in = in; }

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
            do c = readByte(); while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            for (; c > ' '; c = readByte()) val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}