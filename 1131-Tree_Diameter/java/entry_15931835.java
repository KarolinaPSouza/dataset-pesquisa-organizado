import java.io.*;
import java.util.*;

public class entry_15931835 {

    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            tree[a].add(b);
            tree[b].add(a);
        }

        // First BFS from node 1
        int[] first = bfs(1, n);
        int A = first[0];

        // Second BFS from A
        int[] second = bfs(A, n);
        int diameter = second[1];

        System.out.println(diameter);
    }

    // returns {farthestNode, maxDistance}
    static int[] bfs(int start, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        int farthestNode = start;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : tree[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > dist[farthestNode]) {
                        farthestNode = v;
                    }
                }
            }
        }

        return new int[]{farthestNode, dist[farthestNode]};
    }

    // Fast Input
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, val = 0;
            do {
                c = read();
            } while (c <= ' ');
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val;
        }
    }
}