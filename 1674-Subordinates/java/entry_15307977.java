import java.io.*;
import java.util.*;

public class entry_15307977 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] parent = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
        }

        // Build adjacency list (tree)
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            adj[parent[i]].add(i);
        }

        int[] sub = new int[n + 1]; // subtree sizes

        // Iterative DFS to avoid stack overflow
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> order = new ArrayDeque<>();

        stack.push(1);
        while (!stack.isEmpty()) {
            int u = stack.pop();
            order.push(u); // post-order later
            for (int v : adj[u]) stack.push(v);
        }

        // Post-order: accumulate subtree sizes
        while (!order.isEmpty()) {
            int u = order.pop();
            for (int v : adj[u]) {
                sub[u] += 1 + sub[v];
            }
        }

        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(sub[i]).append(" ");
        System.out.println(sb.toString().trim());
    }
}