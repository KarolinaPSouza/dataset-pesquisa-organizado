import java.util.*;
import java.io.*;

public class entry_14619119 {
    public static void main(String[] args) throws IOException{
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(io.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<Integer>();
        for(int i = 0; i < m; i++) {
            token = new StringTokenizer(io.readLine());
            int a = Integer.parseInt(token.nextToken())-1;
            int b = Integer.parseInt(token.nextToken())-1;

            adj[a].add(b);
            adj[b].add(a); 
        }

        //----------------------------------------
        //dfs
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) visited[i] = false;
        int count = 0;
        List<Integer> countArray = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (visited[i]==true){
                continue;
            }
            else {
                countArray.add(i+1);
                count++;
                if (adj[i].isEmpty()==false){
                    dfs(i, visited, adj);
                }
            }
        }
        System.out.println(count-1);
        for (int i=0; i<count-1; i++){
            System.out.print(countArray.get(i)+" ");
            System.out.println(countArray.get(i+1));
        }
    }

    public static void dfs(int node, boolean[] visited, ArrayList<Integer> adj[]){
        visited[node] = true;
        for (int neighbor : adj[node]) {
            if (visited[neighbor] == false) {
                dfs(neighbor, visited, adj);
            }
        }
    }
}