import java.util.*;
import java.io.*;

public class entry_15429054 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        ArrayList<Integer> addp = new ArrayList<>(n);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i] == false) {
                addp.add(i);
                DFS(i, visited, adj);
            }
        }
        System.out.println(addp.size() - 1);
        for (int i = 0; i < addp.size() - 1; i += 1) {
            System.out.println(addp.get(i) + " " + addp.get(i + 1));
        }
    }
    static void DFS(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int child : adj.get(node)) {
            if (!visited[child]) {
                DFS(child, visited, adj);
            }
        }
    }
}