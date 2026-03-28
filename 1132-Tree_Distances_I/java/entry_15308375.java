import java.io.*;
import java.util.*;

public class entry_15308375 {
    static ArrayList<Integer>[] graph;
    static int N;

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        N = scanner.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        int end1 = bfsFind(1)[0];
        int end2 = bfsFind(end1)[0];

        int[] dist1 = bfsDist(end1);
        int[] dist2 = bfsDist(end2);

        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= N; i++)
            out.append(Math.max(dist1[i], dist2[i])).append(" ");

        System.out.print(out);
    }

    static int[] bfsDist(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : graph[x]) {
                if (dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    queue.add(y);
                }
            }
        }
        return dist;
    }

    static int[] bfsFind(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        queue.add(start);
        dist[start] = 0;

        int farNode = start;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : graph[x]) {
                if (dist[y] == -1) {
                    dist[y] = dist[x] + 1;
                    queue.add(y);
                    if (dist[y] > dist[farNode]) farNode = y;
                }
            }
        }
        return new int[]{farNode, dist[farNode]};
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buf = new byte[1 << 16];
        private int idx = 0, size = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (idx >= size) {
                size = in.read(buf);
                idx = 0;
                if (size <= 0) return -1;
            }
            return buf[idx++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ');
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val;
        }
    }
}