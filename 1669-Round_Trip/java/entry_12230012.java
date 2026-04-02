import java.io.*;
import java.util.*;

public class entry_12230012 {
    static int cycleStart;
    static int cycleEnd;
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int node,int[] parent){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(!vis[it]){
                parent[it]=node;
                if(dfs(adj,vis,it,parent)){
                    return true;
                }
            }
            else{
                if(it!=parent[node]){
                    cycleStart=it;
                    cycleEnd=node;
                    return true;
                }
            }
        }
        return false;
    }
    public static String findCyclePath(int[] parent, int cycleStart, int cycleEnd) {
        List<Integer> cyclePath = new ArrayList<>();
        cyclePath.add(cycleStart);
        StringBuilder sb=new StringBuilder();
        int current = cycleEnd;
        while (current != cycleStart) {
            cyclePath.add(current);
            current = parent[current];
        }

        cyclePath.add(cycleStart);  // To complete the cycle
        Collections.reverse(cyclePath);  // Reverse to get correct order

        System.out.println(cyclePath.size());
        for (int city : cyclePath) {
            sb.append(city).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] input=br.readLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int conn=Integer.parseInt(input[1]);
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<conn;i++){
            String[] connec=br.readLine().split(" ");
            int source=Integer.parseInt(connec[0]);
            int dest=Integer.parseInt(connec[1]);
            adj.get(source).add(dest);
            adj.get(dest).add(source);
        }
        boolean flag=false;
        boolean[] vis=new boolean[n+1];
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                flag=dfs(adj,vis,i,parent);
                if(flag){
                    System.out.println(findCyclePath(parent,cycleStart,cycleEnd));
                    break;
                }
            }
        }
        if(!flag){
            System.out.println("IMPOSSIBLE");
        }
    }
}