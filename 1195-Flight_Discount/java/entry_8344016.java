import java.io.*;
import java.util.*;
public class entry_8344016 {
    public static void main(String[] args) throws IOException {
        (new entry_8344016()).start();
    }
    public void start() throws IOException {
        //Scanner sc= new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        ArrayList<ArrayList<DSP.Edge>> adjlist = new ArrayList<>(n);
        ArrayList<ArrayList<DSP.Edge>> radjlist = new ArrayList<>(n);
        for (int i = 0; i<n; i++) {
            adjlist.add(new ArrayList<>(0));
            radjlist.add(new ArrayList<>(0));
        }
        ArrayList<DSP.Edge> edgeList = new ArrayList<>(m);
        for (int i = 0; i<m; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0])-1;
            int b = Integer.parseInt(tokens[1])-1;
            int c = Integer.parseInt(tokens[2]);
            adjlist.get(a).add(new DSP.Edge(a,b,c));
            radjlist.get(b).add(new DSP.Edge(b,a,c));
            edgeList.add(new DSP.Edge(a,b,c));
        }
        br.close();
        final DSP dsp1 = new DSP(n,m, adjlist);
        long[] distsFrom1 = dsp1.dijkstra(0);
        final DSP dsp2 = new DSP(n,m, radjlist);
        long[] distsFromN = dsp2.dijkstra(n-1);
        long ans = distsFrom1[n-1];
        for (DSP.Edge e : edgeList) {
            ans = Math.min(ans, distsFrom1[e.from] + (long) e.cost/2 + distsFromN[e.to]);
        }
        System.out.println(ans);
    }
    public static class DSP {
        public static final long INF = 1_000_000L * 1_000_000_000L;
        public final int V, E;
        public final ArrayList<ArrayList<Edge>> adjlist;
        public static final class T implements Comparable<T> {
            int n; 
            long dist;
            public T(int n, long dist) {this.n=n; this.dist=dist;}
            public int compareTo(T other) {return Long.compare(this.dist, other.dist);}
            public String toString() {return "<T n="+n + " dist=" + dist + ">";}
        }
        public static final class Edge {
            int from, to;
            long cost;
            public Edge(int from, int to, int cost) {this.from=from; this.to=to; this.cost=cost;}
        }
        public DSP(int V, int E, ArrayList<ArrayList<Edge>> new_adjlist) throws java.lang.IllegalArgumentException {
            if (V != new_adjlist.size())
                throw new IllegalArgumentException("adjlist of wrong size");
            int actual_E = 0;
            for (int i = 0; i<V; i++)
                actual_E+=new_adjlist.get(i).size();
            if (actual_E != E) 
                throw new IllegalArgumentException("num edges is wrong");
            this.V=V;
            this.E=E;
            this.adjlist=new_adjlist;
        }
        public final long[] dijkstra(int src) {
            boolean[] visited = new boolean[V];
            PriorityQueue<T> pq = new PriorityQueue<T>();
            pq.add(new T(src, 0));
            long[] dists = new long[V];
            for (int i = 0; i<V; i++) dists[i] = INF;
            while (pq.size() > 0) {
                //System.out.println(pq);
                T top = pq.poll();
                if (visited[top.n]) continue;
                dists[top.n]= top.dist;

                visited[top.n]=true;
                for (Edge e : adjlist.get(top.n)) {
                    if (visited[e.to]) continue;
                    pq.add(new T(e.to, dists[top.n] + e.cost));
                }
            }
            return dists;
        }
    }
}