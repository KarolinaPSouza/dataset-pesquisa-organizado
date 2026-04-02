// package BuildingTeams;
import java.io.*;
import java.util.*;

public class entry_13426348 {

    public static boolean dfs(int node,int[] vis,int[] colors,ArrayList<Integer>graph[],int color){
        vis[node]=1;
        colors[node]=color;
        for(int childNode : graph[node]){
            if(vis[childNode]==0){
                // colors[childNode]=colors[node-1];
                if(dfs(childNode,vis,colors,graph,1-color)==true){
                    return true;
                }
            }
            else{
                if(colors[childNode]==colors[node]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>graph[] = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());   
            graph[u].add(v);
            graph[v].add(u);         
        }
        int[] vis = new int[n+1];
        int[] colors = new int[n+1];

        boolean isCycle = false;

        for(int i=1;i<=n;i++){
            if(vis[i]==1){
                continue;
            }
            if(dfs(i,vis,colors,graph,0)==true){
                isCycle = true;
            }
        }
        if(isCycle == true){
            System.out.println("IMPOSSIBLE");
        }
        else{
            for(int i=1;i<=n;i++){
                System.out.print(colors[i]+1 + " ");
            }
        }
    }
}