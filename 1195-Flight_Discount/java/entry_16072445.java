import java.util.*;
import java.io.*;

public class entry_16072445 {

    public static void main(String[] args)throws IOException{
        FastScanner sc=new FastScanner();
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<long[]>[] adj=new ArrayList[n+1];
        for (int i=1;i<=n;i++) {
            adj[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++) {
            int u=sc.nextInt();
            int v=sc.nextInt();
            long w=sc.nextLong();
            adj[u].add(new long[]{v,w});
        }

        long INF=(long) 1e18;
        long[][] dp=new long[n+1][2];
        for (int i=1;i<=n;i++) {
            dp[i][0]=dp[i][1]=INF;
        }

        dp[1][0]=0;

        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));

        pq.add(new long[]{0,1,0});

        while(!pq.isEmpty()) {
            long[] curr=pq.poll();
            long dist=curr[0];
            int u=(int) curr[1];
            int used=(int) curr[2];

            if(dist>dp[u][used]) continue;

             if(u==n && used==1) {
                System.out.println(dist);
                return;
            }


            for(long[] edge:adj[u]){
                int v=(int)edge[0];
                long w=edge[1];

                if(dp[v][used]>dist+w) {
                    dp[v][used]=dist+w;
                    pq.add(new long[]{dp[v][used],v,used});
                }
                if(used==0) {
                    long discounted=dist+w/2;
                    if (dp[v][1]>discounted) {
                        dp[v][1]=discounted;
                        pq.add(new long[]{dp[v][1],v,1});
                    }
                }
            }
        }

        System.out.println(dp[n][1]);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}