import java.util.*;
import java.io.*;

public class entry_13415439 {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // Build adjacency list
        List<int[]>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a].add(new int[]{b, c});
        }

        // Modified Dijkstra with state (city, coupon_used)
        // dist[city][0] = min cost without using coupon
        // dist[city][1] = min cost having used coupon
        long[][] dist = new long[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        dist[1][0] = 0;

        // Priority queue: {distance, city, coupon_used}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 1, 0}); // {distance, city, coupon_used}

        boolean[][] visited = new boolean[n + 1][2];

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long d = current[0];
            int u = (int) current[1];
            int coupon = (int) current[2];

            if (visited[u][coupon]) continue;
            visited[u][coupon] = true;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int cost = edge[1];

                // Option 1: Don't use coupon on this flight
                long newDist1 = d + cost;
                if (newDist1 < dist[v][coupon]) {
                    dist[v][coupon] = newDist1;
                    if (!visited[v][coupon]) {
                        pq.offer(new long[]{newDist1, v, coupon});
                    }
                }

                // Option 2: Use coupon on this flight (only if not used before)
                if (coupon == 0) {
                    long newDist2 = d + cost / 2;
                    if (newDist2 < dist[v][1]) {
                        dist[v][1] = newDist2;
                        if (!visited[v][1]) {
                            pq.offer(new long[]{newDist2, v, 1});
                        }
                    }
                }
            }
        }

        // Answer is minimum of reaching destination with or without using coupon
        long result = Math.min(dist[n][0], dist[n][1]);
        out.println(result);
        out.flush();
    }
}