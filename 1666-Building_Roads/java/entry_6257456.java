import java.io.*;
import java.util.*;
import java.lang.*;

public class entry_6257456 {
    static int dx[]={1,0,-1,0};
    static int dy[]={0,1,0,-1};

    static int DFS(int node,boolean visited[],ArrayList<Integer> adj[])
    {
        visited[node]=true;

        for(int child:adj[node])
        {
            if(visited[child]==false)
                DFS(child,visited,adj);
        }
        return node;
    }
    static StringBuilder solve(int n,int m,ArrayList<Integer> adj[])
    {
        boolean visited[]=new boolean[n+1];
        int compo=0;
        ArrayList<Integer> arr=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++)
        {
            if(visited[i]==false)
            {
                int node=DFS(i,visited,adj);
                compo++;
                arr.add(node);
                //System.out.println(Arrays.toString(visited));
            }
        }
        sb.append((compo-1)+"\n");
        for(int i=1;i<arr.size();i++)
            sb.append(arr.get(i-1)+" "+arr.get(i)+"\n");
        return sb;
    }
    public static void main (String[] args) throws java.lang.Exception {

        BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        String st1[]=(buf.readLine().split(" "));
        int n=Integer.parseInt(st1[0]);
        int m=Integer.parseInt(st1[1]);

        ArrayList<Integer> adj[]=new ArrayList[n+1];
        for(int i=1;i<=n;i++)
            adj[i]=new ArrayList<>();

        for(int i=0;i<m;i++)
        {
            String st2[]=(buf.readLine()).split(" ");
            int u=Integer.parseInt(st2[0]);
            int v=Integer.parseInt(st2[1]);
            adj[u].add(v);
            adj[v].add(u);
        }

        System.out.println(solve(n,m,adj));
    }

}