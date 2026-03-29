import java.io.*;
import java.util.*;

public class entry_12884374 {
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt(), m = fr.nextInt();
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = fr.nextInt(), b = fr.nextInt(), c = fr.nextInt();
            graph[a].add(new int[]{b, c});
        }

        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) Arrays.fill(dist[i], Long.MAX_VALUE);
        dist[1][0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, 1, 0}); // {cost, node, discountUsed(0/1)}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long cost = curr[0];
            int u = (int) curr[1];
            int used = (int) curr[2];

            if (cost > dist[u][used]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0], w = edge[1];

                if (dist[v][used] > cost + w) {
                    dist[v][used] = cost + w;
                    pq.add(new long[]{dist[v][used], v, used});
                }

                if (used == 0) {
                    long discounted = cost + (w / 2);
                    if (dist[v][1] > discounted) {
                        dist[v][1] = discounted;
                        pq.add(new long[]{discounted, v, 1});
                    }
                }
            }
        }

        System.out.println(dist[n][1]);
    }
}