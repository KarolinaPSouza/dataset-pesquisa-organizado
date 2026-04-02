import java.io.*;
import java.util.*;

public class entry_15103552 {
    public static ArrayList<Integer> adj[];
    public static int[] count;
    public static void main(String[] args) throws IOException{
        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(io.readLine());
        int n = Integer.parseInt(token.nextToken());

        adj = new ArrayList[n+1];
        token = new StringTokenizer(io.readLine());
        for(int i = 0; i < n+1; i++) adj[i] = new ArrayList<Integer>();
        for(int i = 2; i < n+1; i++) {
            int b = Integer.parseInt(token.nextToken());
            adj[b].add(i); //b is the boss of a
        }
        count = new int[n+1];
        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(count[i]).append(" ");
        System.out.println(sb);
    }

    public static void dfs(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        ArrayList<Integer> order = new ArrayList<>();

        // Collect all nodes using BFS
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            order.add(currentNode);

            // Add all children to queue
            for (int child : adj[currentNode]) {
                queue.add(child);
            }
        }

        // Process nodes from bottom up
        for (int i = order.size() - 1; i >= 0; i--) {
            int currentNode = order.get(i);
            int total = 0;
            for (int child : adj[currentNode]) {
                total += count[child] + 1;
            }
            count[currentNode] = total;
        }
    }
}