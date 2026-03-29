import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class entry_14756812 {
    private static final long INF = 4_000_000_000_000_000_000L; // 4e18 sentinel (>> any possible path sum)

    private static final class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) return null; // EOF
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(Objects.requireNonNull(next())); }
        long nextLong() throws IOException { return Long.parseLong(Objects.requireNonNull(next())); }
    }

    private static final class FastWriter {
        private final BufferedWriter bw;
        FastWriter() { bw = new BufferedWriter(new OutputStreamWriter(System.out)); }
        void println(long x) throws IOException { bw.write(Long.toString(x)); bw.newLine(); }
        void flush() throws IOException { bw.flush(); }
    }

    private static final class Edge { int to; long w; Edge(int t, long w){ this.to=t; this.w=w; } }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        FastWriter fw = new FastWriter();
        int n = fs.nextInt();
        int m = fs.nextInt();

        if (n == 1) { // start == destination, cost is zero (no discount needed)
            fw.println(0L);
            fw.flush();
            return;
        }

        @SuppressWarnings("unchecked")
        List<Edge>[] adj = new ArrayList[n];
        @SuppressWarnings("unchecked")
        List<Edge>[] radj = new ArrayList[n];
        for (int i = 0; i < n; i++) { adj[i] = new ArrayList<>(); radj[i] = new ArrayList<>(); }

        int[] from = new int[m];
        int[] to = new int[m];
        long[] w = new long[m];

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;
            long c = fs.nextLong();
            from[i] = a; to[i] = b; w[i] = c;
            adj[a].add(new Edge(b, c));
            radj[b].add(new Edge(a, c)); // reverse edge with same weight
        }

        long[] distStart = dijkstra(n, adj, 0);
        long[] distEnd = dijkstra(n, radj, n - 1); // distances to end using reverse graph

        long ans = INF;
        for (int i = 0; i < m; i++) {
            int u = from[i];
            int v = to[i];
            if (distStart[u] == INF || distEnd[v] == INF) continue; // edge not usable in any s->...->u->v->...->t path
            long candidate = distStart[u] + (w[i] >> 1) + distEnd[v]; // w[i]/2 via shift (weights fit in long)
            if (candidate < ans) ans = candidate;
        }

        if (ans == INF) ans = -1; // unreachable (no path at all)
        fw.println(ans);
        fw.flush();
    }

    // Dijkstra returning distance array from a source
    private static long[] dijkstra(int n, List<Edge>[] g, int src) {
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[src] = 0L;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0L, src});
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int)cur[1];
            if (d != dist[u]) continue; // stale
            for (Edge e : g[u]) {
                long nd = d + e.w;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new long[]{nd, e.to});
                }
            }
        }
        return dist;
    }
}