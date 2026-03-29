import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Took Solution -> 2 State Dijsktra , shortest distance from src to v, coupon used, and other shortes distance from src to v coupon not used
public class entry_14510326 {
    static int n;
    static int m;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        ArrayList<int[]> graph[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++) {
            String[] p = br.readLine().split(" ");
            int x = Integer.parseInt(p[0]);
            int y = Integer.parseInt(p[1]);
            int c = Integer.parseInt(p[2]);
            graph[x].add(new int[]{y,c});
        }
        long dist[][] = new long[n+1][2];
        for(int i=1; i<=n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }
        dist[1][0] = 0;

        PriorityQueue<long[]> q = new PriorityQueue<>((a,b)-> {
            return Long.compare(a[1], b[1]);
        });
        q.add(new long[]{1,0,0});
        while(!q.isEmpty()) {
            long curr[] = q.remove();
            int node = (int)curr[0];
            long dis = curr[1];
            int used = (int)curr[2];
            if(dis>dist[node][used]) {
                continue;
            }
            for(int j=0; j<graph[node].size(); j++) {
                int next[] = graph[node].get(j);
                long nextWt = next[1];
                int nextNode = next[0];
                //don't use coupan to this node, if not there obviously you will not use, as already used, and state of next will also be used
                if(dist[node][used]+nextWt<dist[nextNode][used]) {
                    dist[nextNode][used] = dist[node][used]+nextWt;
                    q.add(new long[]{nextNode,dist[nextNode][used],used});
                }
                //use coupan, if not use in past
                if(used==0) {
                    if(dist[node][used]+(nextWt/2)<dist[nextNode][1]) {
                        dist[nextNode][1] = dist[node][used]+(nextWt/2);
                        q.add(new long[]{nextNode,dist[nextNode][1],1});
                    }
                }
            }
        }
        System.out.println(dist[n][1]);
    }
}