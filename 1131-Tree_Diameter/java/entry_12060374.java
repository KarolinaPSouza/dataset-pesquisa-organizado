import java.io.*;
import java.util.*;

public class entry_12060374 {
    static int[][] adj;
    static int[] dist;
    static int n;

    /**
     * Realiza un recorrido DFS iterativo desde el nodo dado.
     * @param start Nodo inicial.
     */
    public static void dfs(int start) {
        Arrays.fill(dist, -1); 


        dist[start] = 0;


        Stack<Integer> stack = new Stack<>();
        stack.push(start);


        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int child : adj[node]) {
                if (dist[child] == -1) { 
                    dist[child] = dist[node] + 1;
                    stack.push(child);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        n = Integer.parseInt(br.readLine());


        adj = new int[n + 1][];
        dist = new int[n + 1];

        int[] degree = new int[n + 1];
        int[][] edges = new int[2 * (n - 1)][2];
        for (int i = 0, idx = 0; i < n - 1; i++) 
        {

            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);


            edges[idx][0] = u;
            edges[idx][1] = v;
            idx++;
            edges[idx][0] = v;
            edges[idx][1] = u;
            idx++;

            degree[u]++;
            degree[v]++;
        }


        for (int i = 1; i <= n; i++) {
            adj[i] = new int[degree[i]];
            degree[i] = 0;
        }


        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u][degree[u]++] = v;
        }


        dfs(1);


        int farthestNode = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] > dist[farthestNode]) {
                farthestNode = i;
            }
        }


        dfs(farthestNode);


        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }


        bw.write(maxDist + "\n");
        bw.flush(); bw.close(); br.close();
    }
}