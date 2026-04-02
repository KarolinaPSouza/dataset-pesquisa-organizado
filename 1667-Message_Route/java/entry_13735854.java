import java.util.*;
import java.io.*;


public class entry_13735854 {

    public static int n,m;

    public static int[] minPath(List<List<Integer>> adj){

        Queue<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{1,0});
        int parent[]=new int[n+1];
        Arrays.fill(parent,-1);

        int[] cost=new int[n+1];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[1]=0;
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int node=temp[0];
            int d=temp[1];
            if(node==n) return parent;
            for(int x:adj.get(node)){
                if(cost[x]<=d+1) continue; 
                parent[x]=node;
                q.offer(new int[]{x,d+1});
                cost[x]=d+1;
            }
        }

        return new int[0];

    }
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String[] order=br.readLine().split(" ");
        n=Integer.parseInt(order[0]);
        m=Integer.parseInt(order[1]);
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            String[] edge=br.readLine().split(" ");
            int u=Integer.parseInt(edge[0]),v=Integer.parseInt(edge[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] min=minPath(adj);

        if(min.length==0){
            System.out.println("IMPOSSIBLE");
        }
        else{
            List<Integer> path=new ArrayList<>();
            int node=n;
            while(node!=-1){
                path.add(node);
                node=min[node];
            }
            Collections.reverse(path);
            System.out.println(path.size());
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i)+" ");
            }
        }


    }
}