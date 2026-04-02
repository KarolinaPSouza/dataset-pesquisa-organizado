import java.io.*;
import java.util.*;

public class entry_15518943{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            String[] edge = br.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!vis[i]){
                ans.add(i);
                help(i,adj,vis);
            }
        }
        System.out.println(ans.size()-1);
        for(int i=0;i<ans.size()-1;i++){
            System.out.println(ans.get(i)+" "+ans.get(i+1));
        }
    }
    public static void help(int i,List<List<Integer>> adj,boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        vis[i] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int n:adj.get(temp)){
                if(!vis[n]){
                    q.offer(n);
                    vis[n] = true;
                }
            }
        }
    }
}
