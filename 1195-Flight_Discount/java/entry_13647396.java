import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class entry_13647396 {

    static class Pair {
        int node;
        long dist;
        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static class Edge {
        int to;
        int weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int n, m;
    static ArrayList<Edge>[] adj;
    static ArrayList<Edge>[] revAdj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        adj = new ArrayList[n + 1];
        revAdj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            revAdj[i] = new ArrayList<>();
        }

        int[][] flights = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);

            adj[u].add(new Edge(v, w));
            revAdj[v].add(new Edge(u, w));
            flights[i] = new int[]{u, v, w};
        }

        long[] dist1 = dijkstra(1, adj);
        long[] dist2 = dijkstra(n, revAdj);

        long ans = Long.MAX_VALUE;

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int w = flight[2];

            if (dist1[u] != Long.MAX_VALUE && dist2[v] != Long.MAX_VALUE) {
                ans = Math.min(ans, dist1[u] + w / 2 + dist2[v]);
            }
        }

        System.out.println(ans);
    }

    static long[] dijkstra(int start, ArrayList<Edge>[] graph) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.dist));
        pq.add(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            long d = current.dist;

            if (d > dist[u]) continue;

            for (Edge e : graph[u]) {
                int v = e.to;
                int w = e.weight;
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}