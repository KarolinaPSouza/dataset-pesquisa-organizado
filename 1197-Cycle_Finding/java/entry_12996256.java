import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class entry_12996256 {
    public static void main(String[] args) throws IOException{
        InputStreamReader isr= new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(isr);
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        List<Pair> edges= new ArrayList<>();
        for(int i=0; i<m; i++) {
            st= new StringTokenizer(br.readLine());
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());
            long wt= Long.parseLong(st.nextToken());
            edges.add(new Pair(u,v,wt));
        }
        long[] dist= new long[n+1];
        Arrays.fill(dist,(long)1e18);
        dist[1]=0;

        int[] parent= new int[n+1];
        int node=-1;
        for(int i=0; i<n; i++) {
            node= -1;
            for(Pair ed: edges) {
                if(dist[ed.v] >  dist[ed.u]+ed.wt) {
                    node= ed.v;
                    parent[ed.v] =ed.u;
                    dist[ed.v]= dist[ed.u]+ed.wt;
                }
            }
        }
        if(node == -1) System.out.println("NO");
        else {
            System.out.println("YES");
            for(int i=0; i<n-1; i++) {
                node= parent[node];
            }
            List<Integer> ans= new ArrayList<>();
            int cur= node;
            do { 
                ans.add(0,cur);
                cur= parent[cur];
            } while (cur != node);
            ans.add(0,node);
            for(int i=0; i< ans.size(); i++) System.out.print(ans.get(i)+" ");
        }
    }
    static class Pair {
        int u,v; long wt;
        Pair(int x, int y, long z) {
            u= x; v= y; wt= z;
        }
    }
}