import java.io.*;
import java.util.*;

public class entry_10621449 {
    public static void dfs(ArrayList<ArrayList<Integer>> adjLs, int node, boolean[] vis){
        vis[node] = true;

        for(int neb : adjLs.get(node)){
            if(!vis[neb]) dfs(adjLs, neb, vis);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dim = br.readLine().split(" ");
        int n = Integer.parseInt(dim[0]); // no. of nodes
        int m = Integer.parseInt(dim[1]); // no of edges

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i=0; i<=n; i++) adjLs.add(new ArrayList<>());

        boolean[] vis = new boolean[n+1];

        for(int i=0; i<m; i++){
            String[] ar = br.readLine().split(" ");
            int a = Integer.parseInt(ar[0]); // no. of nodes
            int b = Integer.parseInt(ar[1]); 
            adjLs.get(a).add(b);
            adjLs.get(b).add(a);
        }
        StringBuilder sb = new StringBuilder();
        int cnt=0, prevNode=-1;
        for(int i=1; i<=n; i++){
            if(!vis[i]){
                cnt++;
                if(prevNode == -1) prevNode =i;
                else sb.append(prevNode+" " + i).append("\n");

                dfs(adjLs, i, vis);
            } 
        }
        System.out.println(cnt-1);
        System.out.println(sb);
    }
}