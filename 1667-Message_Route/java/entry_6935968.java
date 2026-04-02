import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class entry_6935968 {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n+1];

        for(int i = 1; i < n+1; i++){
            visited[i] = false;
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b); adj[b].add(a); 
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int node = queue.poll();

            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    queue.add(next);
                }

                if(next == n){
                    queue.clear();
                    break;
                }
            }
        }
        if(visited[n] == false){
            System.out.println("IMPOSSIBLE");
            return;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(n);
        int a = n;
        while(a != 1){
            a = parent[a];
            ans.add(a);
        }
        System.out.println(ans.size());
        for(int i = ans.size() - 1; i >= 0; i--){
            System.out.print(ans.get(i) + " ");
        }
    }
}