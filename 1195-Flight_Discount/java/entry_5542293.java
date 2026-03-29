import java.util.*;
import java.io.*;
public class entry_5542293 {
    static class Pair
    {
        int u;
        long d;
        int v;
        public Pair(int a,int b,long c)
        {
            u=a;d=c;v=b;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        ArrayList<ArrayList<Pair>> revadj=new ArrayList<>();
        ArrayList<Pair> edges=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
            revadj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            s=br.readLine().split(" ");
            int u=Integer.parseInt(s[0])-1;
            int v=Integer.parseInt(s[1])-1;
            long d=Long.parseLong(s[2]);
            adj.get(u).add(new Pair(v,0,d));
            revadj.get(v).add(new Pair(u,0,d));
            edges.add(new Pair(u,v,d));
        }
        long dis1[]=new long[n];
        long dis2[]=new long[n];
        int vis[]=new int[n];      
        Arrays.fill(dis1,Long.MAX_VALUE);
        Arrays.fill(dis2,Long.MAX_VALUE);
        dis1[0]=0;
        dis2[n-1]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair x,Pair y)
            {
                if(x.d-y.d>0)
                return 1;
                return -1;
            }
        });
        q.add(new Pair(0,0,0));
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            if(vis[curr.u]==1)
            continue;
            vis[curr.u]=1;
            for(Pair p:adj.get(curr.u))
            {
                if(curr.d+p.d<dis1[p.u])
                {
                    dis1[p.u]=curr.d+p.d;
                    q.add(new Pair(p.u,0,dis1[p.u]));
                }
            }
        }
        q.add(new Pair(n-1,0,0));
        vis=new int[n];
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            if(vis[curr.u]==1)
            continue;
            vis[curr.u]=1;
            for(Pair p:revadj.get(curr.u))
            {
                if(curr.d+p.d<dis2[p.u])
                {
                    dis2[p.u]=curr.d+p.d;
                    q.add(new Pair(p.u,0,dis2[p.u]));
                }
            }
        }
        long ans=Long.MAX_VALUE;
        for(Pair p:edges)
        {
            if(dis1[p.u]==Long.MAX_VALUE||dis2[p.v]==Long.MAX_VALUE)
            continue;
            long d=dis1[p.u]+p.d/2+dis2[p.v];
            ans=Math.min(ans,d);
        }
        //pw.println(dis[n-1]);

        pw.println(ans);
        pw.flush();
    }
}