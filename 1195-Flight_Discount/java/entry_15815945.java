import java.io.*;
import java.util.*;

class Pair {
    int node;
    int used;
    long cost;
    Pair(int node, int used, long cost) {
        this.node = node;
        this.used = used;
        this.cost = cost;
    }
}

public class entry_15815945 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj.get(u).add(new long[]{v, w});
        }

        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dist[i][0] = dist[i][1] = Long.MAX_VALUE;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        pq.offer(new Pair(1, 0, 0));
        dist[1][0] = 0;

        long ans = Long.MAX_VALUE;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            int used = cur.used;
            long c = cur.cost;

            if (c > dist[u][used]) continue;
            if (c > ans) break;

            if (u == n) {
                ans = Math.min(ans, c);
                continue;
            }

            for (long[] e : adj.get(u)) {
                int v = (int) e[0];
                long w = e[1];

                if (dist[v][used] > c + w) {
                    dist[v][used] = c + w;
                    pq.offer(new Pair(v, used, dist[v][used]));
                }

                if (used == 0 && dist[v][1] > c + w / 2) {
                    dist[v][1] = c + w / 2;
                    pq.offer(new Pair(v, 1, dist[v][1]));
                }
            }
        }

        System.out.println(ans);
    }
}