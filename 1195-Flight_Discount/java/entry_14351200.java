import java.io.*;
import java.util.*;

public class entry_14351200 {
    static class Edge { int to; long w; Edge(int t, long ww){to=t; w=ww;} }
    static class State implements Comparable<State> {
        int node, used; long dist;
        State(int n, int u, long d){ node=n; used=u; dist=d; }
        public int compareTo(State o){ return Long.compare(dist, o.dist); }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Edge>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj[a].add(new Edge(b, c));
        }

        final long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n+1][2];
        for (int i = 1; i <= n; i++) Arrays.fill(dist[i], INF);
        dist[1][0] = 0;

        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(1, 0, 0L));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.dist != dist[cur.node][cur.used]) continue;

            for (Edge e : adj[cur.node]) {
                // 1) move normally, keep used flag
                if (dist[e.to][cur.used] > cur.dist + e.w) {
                    dist[e.to][cur.used] = cur.dist + e.w;
                    pq.add(new State(e.to, cur.used, dist[e.to][cur.used]));
                }
                // 2) if coupon not used yet, use it on this edge
                if (cur.used == 0) {
                    long newCost = cur.dist + (e.w / 2);
                    if (dist[e.to][1] > newCost) {
                        dist[e.to][1] = newCost;
                        pq.add(new State(e.to, 1, newCost));
                    }
                }
            }
        }

        long answer = Math.min(dist[n][0], dist[n][1]);
        System.out.println(answer);
    }
}