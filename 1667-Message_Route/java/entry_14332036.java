import java.util.*;
import java.io.*;
public class entry_14332036 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int roads= Integer.parseInt(st.nextToken());
     List<Integer> graph[]= new ArrayList[n+1];
     for(int i=0;i<=n;i++) graph[i]= new ArrayList<>();
        for(int i=0;i<roads;i++){
            st= new StringTokenizer(br.readLine());
            int v1= Integer.parseInt(st.nextToken());
            int v2= Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);

        }
        boolean vis[]= new boolean[n+1];
        int par []= new int[n+1];
        boolean found=false;
       Queue<Integer> q= new LinkedList<>();
       q.add(1);
       vis[1]=true;
       while(!q.isEmpty()){
        int size= q.size();
        while(size-->0){
           int curr= q.poll();
           if(curr==n){
            found=true;
            break;
           }
           for(int neigh: graph[curr]){
            if(!vis[neigh]){
                vis[neigh]=true;
                q.add(neigh);
                par[neigh]=curr;
            }
           }
        }
        if(found) break;
       }
        if(!found){
        System.out.print("IMPOSSIBLE");
        return;
       }
       StringBuilder sb = new StringBuilder();
       int node= n;
       int ans=0;
       List<Integer> l= new ArrayList<>();
       while(node!=0){
           l.add(node);
           node=par[node];
           ans++;
        }
      for(int i=l.size()-1;i>=0;i--) sb.append(l.get(i)).append(" ");
       System.out.println(ans);
       System.out.println(sb);
    }
}