import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.*;
public class entry_15819174 {
    static class Edge{
        int to;
        long w;
        Edge(int t, long w){
            this.to=t;
            this.w=w;
        }
    }
    static class State{
        int node, used;
        long dist;
        State(int node, int used, long dist){
            this.node = node;
            this.used = used;
            this.dist = dist;
        }
    }
    static final long inf = (long)1e18;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            adj.get(a).add(new Edge(b, c));
        }
        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dist[i][0] = dist[i][1] = inf;
        }
        PriorityQueue<State> q = new PriorityQueue<>(Comparator.comparingLong(s->s.dist));
        dist[1][0] = 0;
        q.add(new State(1, 0, 0));
        while(!q.isEmpty()){
            State cur = q.remove();
            int u = cur.node;
            int used = cur.used;
            long d = cur.dist;
            if(d>dist[u][used]) continue;
            for(Edge e:adj.get(u)){
                int v = e.to;
                long w = e.w;
                if(dist[v][used]>d+w){
                    dist[v][used] = d+w;
                    q.add(new State(v, used, dist[v][used]));
                }
                if(used == 0){
                    long discounted = d+(w/2);
                    if(dist[v][1] > discounted){
                        dist[v][1]=discounted;
                        q.add(new State(v, 1, dist[v][1]));
                    }
                }
            }
        }
        System.out.println(dist[n][1]);
    }
}