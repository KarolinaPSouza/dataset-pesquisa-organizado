import java.io.*;
import java.util.*;

public class entry_14852457 {
    static List<Integer>[] tree;
    static int[] subCount;

    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Build tree
        tree = new ArrayList[n + 1];
        subCount = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int manager = Integer.parseInt(st.nextToken());
            tree[manager].add(i);
        }

        // Iterative post-order DFS
        iterativeDFS(n);

        // Output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subCount[i]).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    private static void iterativeDFS(int n) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> postOrder = new ArrayDeque<>();

        stack.push(1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.push(node); // Post-order reverse
            for (int child : tree[node]) {
                if (!visited[child]) {
                    stack.push(child);
                    visited[child] = true;
                }
            }
        }

        // Process in post-order
        while (!postOrder.isEmpty()) {
            int current = postOrder.pop();
            for (int child : tree[current]) {
                subCount[current] += 1 + subCount[child];
            }
        }
    }
}