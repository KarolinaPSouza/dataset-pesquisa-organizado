import java.io.*;
import java.util.*;

public class entry_13645888 {
    static ArrayList<Integer>[] tree;
    static int[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        dp = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            tree[boss].add(i);
        }

        // Iterative DFS using stack
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.push(node);
            for (int child : tree[node]) {
                stack.push(child);
            }
        }

        while (!postOrder.isEmpty()) {
            int node = postOrder.pop();
            for (int child : tree[node]) {
                dp[node] += 1 + dp[child];
            }
        }

        // Output
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            bw.write(dp[i] + " ");
        }
        bw.newLine();
        bw.flush();
    }
}