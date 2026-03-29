import java.io.*;
import java.util.*;

public class entry_12937084 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<List<Pair>> g1 = new ArrayList<>();
        List<List<Pair>> g2 = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g1.add(new ArrayList<>());
            g2.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int wt = Integer.parseInt(st.nextToken());
            g1.get(u).add(new Pair(v, wt));
            g2.get(v).add(new Pair(u, wt));
        }

        long[] dist1 = new long[n + 1];
        long[] dist2 = new long[n + 1];
        Arrays.fill(dist1, (long) 1e18);
        Arrays.fill(dist2, (long) 1e18);

        dijkstra(1, dist1, g1);
        dijkstra(n, dist2, g2);

        long ans = (long) 1e18;
        for (int u = 1; u <= n; u++) {
            for (Pair edge : g1.get(u)) {
                int v = edge.u;
                long wt = edge.wt;
                ans = Math.min(ans, dist1[u] + wt / 2 + dist2[v]);
            }
        }

        System.out.println(ans);
    }

    static void dijkstra(int src, long[] dist, List<List<Pair>> g) {
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (dist[curr.u] < curr.wt)
                continue;
            for (Pair neighbor : g.get(curr.u)) {
                if (dist[neighbor.u] > dist[curr.u] + neighbor.wt) {
                    dist[neighbor.u] = dist[curr.u] + neighbor.wt;
                    pq.add(new Pair(neighbor.u, dist[neighbor.u]));
                }
            }
        }
    }
}

class Pair implements Comparable<Pair> {
    int u;
    long wt;

    Pair(int u, long wt) {
        this.u = u;
        this.wt = wt;
    }

    public int compareTo(Pair other) {
        return Long.compare(this.wt, other.wt);
    }
}