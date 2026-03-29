import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Pair {
    int node;
    long dist;
    Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class entry_14301903 {
    static long INF = (long)1e15;
    static int n, m;
    static ArrayList<Pair>[] adj;
    static long[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        dist = new long[n+1][2];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Pair(v, w));
        }

        shortestPath(1);
        long ans = Math.min(dist[n][0], dist[n][1]);
        System.out.println(ans);

    }
    private static void shortestPath(int src) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{1, 0, 0}); // u, cost, used(0->false, 1->true)
        dist[1][0] = 0;

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int u = (int)cur[0];
            long w = cur[1];
            int used = (int) cur[2];

            if (w > dist[u][used]) continue; 

            for(Pair e : adj[u]) {
                if (used == 0) {
                    long nCost = w + e.dist / 2;
                    if (nCost < dist[e.node][1]) { 
                        dist[e.node][1] = nCost;
                        pq.add(new long[]{e.node, nCost, 1});
                    }
                }

                if(w + e.dist < dist[e.node][(int)used]) {
                    dist[e.node][(int)used] = w + e.dist;
                    pq.add(new long[]{e.node, w + e.dist, used});
                }
            }
        }

    }
}