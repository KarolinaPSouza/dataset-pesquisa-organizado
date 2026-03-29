import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_12953338 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<List<Pair>> g1= new ArrayList<>();
        List<List<Pair>> g2= new ArrayList<>();
        for(int i=0; i<=n; i++) { g1.add(new ArrayList<>()); g2.add(new ArrayList<>()); }
        for(int i=0; i<m; i++) {
            st= new StringTokenizer(br.readLine());
            int u= Integer.parseInt(st.nextToken()); int v= Integer.parseInt(st.nextToken()); int wt= Integer.parseInt(st.nextToken());
            g1.get(u).add(new Pair(v, wt));
            g2.get(v).add(new Pair(u, wt));
        }
        long[] dist1, dist2;
        dist1= new long[n+1];
        dist2= new long[n+1];
        Arrays.fill(dist1, (long)1e18);
        Arrays.fill(dist2, (long)1e18);
        dijsktra(1,dist1,g1);
        dijsktra(n,dist2,g2);
        long ans= (long)1e18;
        for(int i=1; i<=n; i++) {
            for(Pair child: g1.get(i)) {
                ans= Math.min(ans, 0l+dist1[i]+dist2[child.u]+ child.wt/2);
            }
        }
        System.out.println(ans);
    }
    static int n, m;


    static void dijsktra(int src, long[] dist, List<List<Pair>> g) {
        dist[src]= 0;
        PriorityQueue<Pair> pq= new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair p, Pair q) { return p.wt  - q.wt <=0 ? -1 :1; }
        });
        int[] vis= new int[dist.length+1];
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()) {
            Pair p= pq.poll();
            if(vis[p.u]==1) continue;
            vis[p.u]= 1;
            for(Pair child: g.get(p.u)) {
                if(dist[child.u] > dist[p.u]+child.wt) {
                    dist[child.u] = dist[p.u]+child.wt;
                    pq.add(new Pair(child.u,dist[child.u]));
                }
            }
        }
    }

}
class Pair {
    int u;
    long wt;
    Pair(int a, long c) {
        u= a; wt= c;
    }
}