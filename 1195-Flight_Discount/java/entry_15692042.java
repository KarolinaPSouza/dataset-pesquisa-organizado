// AUTHOR: UNIVERSAL ADMIN

import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class entry_15692042 {
    public static void main(String[] args) {
        new Thread(null, ()-> {
            new Main2().start();
        }, "", 1 << 27).start();
    }
}
//----------------------------------------------------------------------------------------------------------------------------------------------
class Main2 {
    void start() {
        int t = 1;
        while(t-- > 0)
            solve();

        w.close();
    }

    static class Edge {
        int to;
        long cost;
        boolean isHalf;

        public Edge (int to, long cost, boolean isHalf) {
            this.to = to;
            this.cost = cost;
            this.isHalf = isHalf;
        }
    }

    void solve() {
        int n = ni(), edges = ni();
        List<Edge>[] graph = new List[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        // Take input
        for(int i = 0; i < edges; i++) {
            int from = ni() - 1, to = ni() - 1;
            long cost = ni();
            graph[from].add(new Edge(to, cost, false));
        }

        // Dijkstra's setup
        Queue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        pq.add(new Edge(0, 0, false));
        long[][] dist = new long[2][n]; // no half, half
        Arrays.fill(dist[0], -1);
        Arrays.fill(dist[1], -1);
        dist[0][0] = 0;
        boolean[][] visited = new boolean[2][n];

        while(!pq.isEmpty()) {
            Edge polled = pq.poll();
            int isHalf = (polled.isHalf) ? 1 : 0;
            if(visited[isHalf][polled.to]) continue; // optimization to avoid recalculation of a visited node, since we will reach it at best distance
            visited[isHalf][polled.to] = true;
            if(polled.to == n-1) break; // optimization to stop early

            for(Edge edgeFrom: graph[polled.to]) {
                if(polled.isHalf) {
                    long newHalfDistance = edgeFrom.cost + polled.cost;
                    long currHalfDistance = dist[1][edgeFrom.to];
                    if(currHalfDistance == -1 || currHalfDistance > newHalfDistance) {
                        dist[1][edgeFrom.to] = newHalfDistance;
                        pq.add(new Edge(edgeFrom.to, newHalfDistance, true));
                    }
                } else {
                    long newDistance = edgeFrom.cost + polled.cost;
                    long currDistance = dist[0][edgeFrom.to];
                    if(currDistance == -1 || currDistance > newDistance) {
                        dist[0][edgeFrom.to] = newDistance;
                        pq.add(new Edge(edgeFrom.to, newDistance, false));
                    }

                    long newHalfDistance = edgeFrom.cost/2 + polled.cost;
                    long currHalfDistance = dist[1][edgeFrom.to];
                    if(currHalfDistance == -1 || currHalfDistance > newHalfDistance) {
                        dist[1][edgeFrom.to] = newHalfDistance;
                        pq.add(new Edge(edgeFrom.to, newHalfDistance, true));
                    }
                }
            }
        }

        p(dist[1][n-1]);
    }
//----------------------------------------------------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------
    long lma = Long.MAX_VALUE, lmi = Long.MIN_VALUE;
    int ima = Integer.MAX_VALUE, imi = Integer.MIN_VALUE;
    long mod = 1000000007;
    //    long mod = 998244353;

    //--------------------------------------------------------------------------------------
    PrintWriter w = new PrintWriter(System.out);
    void p(int i) {w.println(i);} void p(long l) {w.println(l);}
    void p(double d) {w.println(d);} void p(String s) { w.println(s);}
    void pr(int i) {w.print(i);} void pr(long l) {w.print(l);}
    void pr(double d) {w.print(d);} void pr(String s) { w.print(s);}
    void pl() {w.println();}

    //--------------------------------------------------------------------------------------
    public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");
    String next() {
        while (!st.hasMoreTokens()) {
            try { st = new StringTokenizer(br.readLine());} catch (IOException e) { e.printStackTrace(); }
        }
        return st.nextToken();
    }

    int ni() { return Integer.parseInt(next()); }
    long nl() { return Long.parseLong(next()); }
    double nd() { return Double.parseDouble(next()); }
    String ns() { return next(); }

    int[] na(long n) {int[]ret=new int[(int)n]; for(int i=0;i<n;i++) ret[i]=ni(); return ret;}
    long[] nal(long n) {long[]ret=new long[(int)n]; for(int i=0;i<n;i++) ret[i]=nl(); return ret;}
    Integer[] nA(long n) {Integer[]ret=new Integer[(int)n]; for(int i=0;i<n;i++) ret[i]=ni(); return ret;}
    Long[] nAl(long n) {Long[]ret=new Long[(int)n]; for(int i=0;i<n;i++) ret[i]=nl(); return ret;}
}