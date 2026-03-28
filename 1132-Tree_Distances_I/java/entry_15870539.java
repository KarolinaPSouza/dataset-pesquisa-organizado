import java.io.*;
import java.util.*;

public class entry_15870539 {

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
            do c = read(); while (c <= ' ');
            boolean neg = (c == '-');
            if (neg) c = read();
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }
    }

    public static int[] solve(int n, int[][] edges) {
        if (n <= 0) return new int[0];
        if (n == 1) return new int[]{0};

        int[] head = new int[n];
        Arrays.fill(head, -1);
        int[] to = new int[2 * (n - 1)];
        int[] next = new int[2 * (n - 1)];
        int idx = 0;

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            to[idx] = v; next[idx] = head[u]; head[u] = idx++;
            to[idx] = u; next[idx] = head[v]; head[v] = idx++;
        }

        int nodeA = bfs(0, n, head, to, next).node;
        Result resA = bfs(nodeA, n, head, to, next);
        int nodeB = resA.node;
        Result resB = bfs(nodeB, n, head, to, next);

        int[] distA = resA.distances;
        int[] distB = resB.distances;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = Math.max(distA[i], distB[i]);
        }
        return result;
    }

    private static Result bfs(int startNode, int n, int[] head, int[] to, int[] next) {
        int[] dists = new int[n];
        Arrays.fill(dists, -1);
        int[] queue = new int[n];
        int headQ = 0, tailQ = 0;

        queue[tailQ++] = startNode;
        dists[startNode] = 0;

        int farthestNode = startNode;
        while (headQ < tailQ) {
            int u = queue[headQ++];
            if (dists[u] > dists[farthestNode]) {
                farthestNode = u;
            }
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (dists[v] == -1) {
                    dists[v] = dists[u] + 1;
                    queue[tailQ++] = v;
                }
            }
        }
        return new Result(farthestNode, dists);
    }

    static class Result {
        int node;
        int[] distances;
        Result(int node, int[] distances) {
            this.node = node;
            this.distances = distances;
        }
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        if (n == 0) return;
        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = fs.nextInt();
            edges[i][1] = fs.nextInt();
        }

        int[] res = solve(n, edges);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]).append(i == n - 1 ? "" : " ");
        }
        System.out.println(sb.toString());
    }
}