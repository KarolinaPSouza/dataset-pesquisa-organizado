import java.io.*;
import java.util.*;

class Reader {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
    }
}

public class entry_14910422 {
    static class Pair {
        int node;
        long cost;
        int used; // 0 = coupon not used, 1 = coupon used
        Pair(long cost, int node, int used) {
            this.cost = cost;
            this.node = node;
            this.used = used;
        }
    }

    public static void main(String[] args) {
        Reader.FastReader sc = new Reader.FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            long w = sc.nextLong();
            adj.get(u).add(new long[]{v, w});
        }

        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Long.MAX_VALUE);
        dist[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p.cost));
        pq.add(new Pair(0, 0, 0)); // cost, node, usedCoupon

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            long cost = cur.cost;
            int used = cur.used;

            if (cost > dist[node][used]) continue;

            for (long[] edge : adj.get(node)) {
                int next = (int) edge[0];
                long w = edge[1];

                // Case 1: Don't use coupon
                if (dist[next][used] > cost + w) {
                    dist[next][used] = cost + w;
                    pq.add(new Pair(dist[next][used], next, used));
                }

                // Case 2: Use coupon (only if not used yet)
                if (used == 0 && dist[next][1] > cost + w / 2) {
                    dist[next][1] = cost + w / 2;
                    pq.add(new Pair(dist[next][1], next, 1));
                }
            }
        }

        out.println(dist[n - 1][1]);
        out.flush();
    }
}