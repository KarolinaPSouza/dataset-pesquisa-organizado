import java.util.*;
import java.io.*;
public class entry_12008349 {
    static int ans=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        List<Integer>[] tree=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            String[] str=br.readLine().split(" ");
            int u=Integer.parseInt(str[0]),v=Integer.parseInt(str[1]);
            tree[u].add(v);
            tree[v].add(u);
        }
        boolean[] visited=new boolean[n+1];
        Pair temp=helper(1,tree,visited);
        Arrays.fill(visited,false);
        Pair temp2=helper(temp.node,tree,visited);
        System.out.println(temp2.level);
    }
    public static Pair helper(int node,List<Integer>[] tree,boolean[] visited){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(node,0));
        visited[node]=true;
        Pair temp=new Pair(0,0);
        while(!q.isEmpty()){
            Pair p=q.poll();
            temp=p;
            int curr=p.node;
            int depth=p.level;
            for(int i:tree[curr]){
                if(!visited[i]){
                    visited[i]=true;
                    q.add(new Pair(i,depth+1));
                }
            }
        }
        return temp;
    }
    static class Pair{
        int node,level;
        Pair(int node,int level){
            this.node=node;
            this.level=level;
        }
    }
}