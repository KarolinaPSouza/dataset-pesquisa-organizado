import java.io.*;
import java.util.*;

public class entry_13548296 {
    static List<Integer>[] adj;
    static int[] subCount;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        subCount = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            adj[parent].add(i);
        }

        dfsIterative(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subCount[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void dfsIterative(int root) {
        Stack<Integer> stack = new Stack<>();
        Stack<Boolean> post = new Stack<>();

        stack.push(root);
        post.push(false);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            boolean processed = post.pop();

            if (processed) {
                // Post-order: calculate subordinate count
                for (int child : adj[node]) {
                    subCount[node] += 1 + subCount[child];
                }
            } else {
                stack.push(node);
                post.push(true);
                for (int i = adj[node].size() - 1; i >= 0; i--) {
                    stack.push(adj[node].get(i));
                    post.push(false);
                }
            }
        }
    }
}