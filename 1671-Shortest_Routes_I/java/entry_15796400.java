import java.io.*;
import java.util.*;

public class entry_15796400 {

    static class FastScanner {
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

        long nextLong() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') ;
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }
    }

    static class Edge {
        int to;
        long w;
        Edge(int to, long w) {
            this.to = to;
            this.w = w;
        }
    }

    static class State {
        int node;
        long dist;
        State(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = (int) fs.nextLong();
        int m = (int) fs.nextLong();

        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = (int) fs.nextLong();
            int v = (int) fs.nextLong();
            long w = fs.nextLong();
            adj.get(u).add(new Edge(v, w));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));
        pq.add(new State(1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist != dist[cur.node]) continue;

            for (Edge e : adj.get(cur.node)) {
                long nd = cur.dist + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new State(e.to, nd));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(dist[i]).append(' ');
        System.out.print(sb);
    }
}