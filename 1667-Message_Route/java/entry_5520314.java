import java.io.*;
import java.util.*;
public class entry_5520314 {
    public static String ans="";

 public static void main(String[] args) throws IOException 
    {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            String s[]=br.readLine().split(" ");
            int u=Integer.parseInt(s[0])-1;
            int v=Integer.parseInt(s[1])-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[]=new int[n];
        Arrays.fill(vis,-1);
        bfs(0,vis,adj,n-1);
        if(vis[n-1]!=-1)
        {
            ArrayList<Integer> ans=new ArrayList<>();
            int next=n-1;
            ans.add(n);
            while(next!=0)
            {
                ans.add(vis[next]+1);
                next=vis[next];
            }
            //ans.add(1);
            pw.println(ans.size());
            Collections.reverse(ans);
            for(int i:ans)
            pw.print(i+" ");
            pw.println();
        }
        else
        pw.println("IMPOSSIBLE");
        pw.flush();
    }
    public static void bfs(int i,int[] vis,ArrayList<ArrayList<Integer>> adj,int n)
    {
        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.add(i);
        vis[i]=0;
        while(!q.isEmpty())
        {
            int curr=q.pollFirst();
            for(int next:adj.get(curr))
            {
                if(vis[next]==-1)
                {
                    if(next==n)
                    {
                        vis[n]=curr;
                        return;
                    }
                    q.add(next);
                    vis[next]=curr;
                }
            }
        }
    }
    public static boolean dfs(int i,int[] vis,ArrayList<ArrayList<Integer>> adj,int n)
    {
        vis[i]=1;
        if(i==n)
        {
            return true;
        }
        for(int next:adj.get(i))
        {
            if(vis[next]==1)
            continue;
            boolean cr=dfs(next,vis,adj,n);
            if(cr)
            {
                ans=(next+1)+" "+ans;
                return true;
            }
        }
        return false;
    }

}