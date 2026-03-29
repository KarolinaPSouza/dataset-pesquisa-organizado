import java.io.*;
import java.util.*;

public class entry_3595266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, ArrayList<Edge>> hm = new HashMap<>();
        HashMap<Integer, ArrayList<Edge>> h2 = new HashMap<>();
        ArrayList<trip> edges = new ArrayList<>();
        for (int i=0; i<N; i++) {
            hm.put(i, new ArrayList<>());
            h2.put(i, new ArrayList<>());
        }
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            hm.get(a).add(new Edge(b, c));
            h2.get(b).add(new Edge(a, c));
            edges.add(new trip(a, b, c/2));
        }
        long[] dist = new long[N];
        Arrays.fill(dist, 1_000_000_000_000_000L);
        dist[0] = 0;
        long[] disn = new long[N];
        Arrays.fill(disn, 1_000_000_000_000_000L);
        disn[N-1] = 0;
        boolean[] vis = new boolean[N];
        boolean[] vin = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Long.compare(a.d, b.d));
        pq.add(new Edge(0, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            int node = e.b;
            long eds = e.d;
            if (vis[node]) continue;
            vis[node] = true;
            for (Edge ne: hm.get(node)) {
                int nnode = ne.b;
                long ndist = ne.d;
                if(dist[node] + ndist < dist[nnode]) {
                    dist[nnode] = dist[node] + ndist;
                    pq.add(new Edge(nnode, dist[nnode]));
                }
            }
        }
        pq.add(new Edge(N-1, 0));
        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            int node = e.b;
            long eds = e.d;
            if (vin[node]) continue;
            vin[node] = true;
            for (Edge ne: h2.get(node)) {
                int nnode = ne.b;
                long ndist = ne.d;
                if(disn[node] + ndist < disn[nnode]) {
                    disn[nnode] = disn[node] + ndist;
                    pq.add(new Edge(nnode, disn[nnode]));
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (trip t : edges) {
            int a = t.a;
            int b = t.b;
            long c = t.d;
            ans = Math.min(ans, disn[b] + dist[a] + c);
        }
        System.out.println(ans);
    }
    static class trip {
        int a, b;
        long d;
        trip(int x, int y, long z) {
            a=x; b=y; d=z;
        }
    }
    static class Edge {
        int b;
        long d;
        Edge(int y, long z) {
            b=y;
            d=z;
        }
    }
}