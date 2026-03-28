import java.io.*;
import java.util.*;

public class entry_14337221 {
    static int n;
    static ArrayList<Integer>[] adj;

    static int[] bfs(int start) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
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

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        n = fr.nextInt();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        // First BFS
        int[] d1 = bfs(0);
        int A = 0;
        for (int i = 1; i < n; i++) if (d1[i] > d1[A]) A = i;

        // Second BFS from A
        int[] dA = bfs(A);
        int B = 0;
        for (int i = 1; i < n; i++) if (dA[i] > dA[B]) B = i;

        // Third BFS from B
        int[] dB = bfs(B);

        // Answer for each node
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Math.max(dA[i], dB[i])).append(" ");
        }
        out.println(sb.toString().trim());
        out.flush();
    }

    // Custom super-fast input
    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int bId = 0, size = 0;
        private char c;
        private int readByte() throws IOException {
            if (bId == size) {
                size = System.in.read(buffer);
                bId = 0;
                if (size == -1) return -1;
            }
            return buffer[bId++];
        }
        int nextInt() throws IOException {
            int neg = 1, res = 0;
            do { c = (char) readByte(); } while (c <= ' ');
            if (c == '-') { neg = -1; c = (char) readByte(); }
            while (c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
                c = (char) readByte();
            }
            return res * neg;
        }
    }
}