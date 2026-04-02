import java.util.*;
import java.io.*;

public class entry_798516 {

    static class Graph{
        boolean[] isVisited;
        ArrayList<ArrayList<Integer>> li;
        int n;
        Graph(int n){
            isVisited = new boolean[n+1];
            this.n=n;
            li = new ArrayList<>();
            for(int i=0;i<=n;i++){
                li.add(new ArrayList<>());
            }
        }

        void addEdge(int u,int v){
            this.li.get(u).add(v);
            this.li.get(v).add(u);
        }
        void dfs(int x){
            isVisited[x]=true;
            for(Integer adj: li.get(x)){
                if(isVisited[adj]==false){
                    dfs(adj);
                }
            }
        }
        ArrayList<Integer> bfs(int src, int dst){
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            isVisited[src]=true;
            int[] parent = new int[this.n+1];
            int[] dist = new int[this.n+1];
            for(int i=0;i<=n;i++){
                parent[i]=-1;
                dist[i]=Integer.MAX_VALUE;
            }
            while(!q.isEmpty()){
                int node = q.peek();
                q.poll();
                for(Integer adj: li.get(node)){
                    if(isVisited[adj]==false){
                        isVisited[adj]=true;
                        q.add(adj);
                        parent[adj]=node;
                        dist[adj] = dist[node]+1;
                    }
                }
            }
            ArrayList<Integer> ans = new ArrayList<>();
            if(parent[dst]==-1){
                return ans;
            }else{
                for(int i=dst;i!=src;i=parent[i]){
                    ans.add(i);
                }
                ans.add(src);
                return ans;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Graph g = new Graph(n);
        int i;
        int u,v;
        for(i=0;i<m;i++){
            s = br.readLine().trim().split(" ");
            u = Integer.parseInt(s[0]);
            v = Integer.parseInt(s[1]);
            g.addEdge(u,v);
        }
        ArrayList<Integer> ans = g.bfs(1,n);
        if(ans.size()==0){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(ans.size());
            for(i=ans.size()-1;i>=0;i--){
                System.out.print(ans.get(i)+" ");
            }
        }
    }

}