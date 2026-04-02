import java.io.*;
import java.util.*;

public class entry_13651405 {
    static List<Integer>[] tree;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) tree[i] = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int boss = in.nextInt();
            tree[boss].add(i);
        }

        dp = new int[n + 1];
        dfsIterative(1); // ✅ iterative DFS = no stack overflow

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(' ');
        }

        out.println(sb.toString());
        out.flush();
    }

    // ✅ ITERATIVE DFS to avoid StackOverflow
    static void dfsIterative(int root) {
        int[] visited = new int[tree.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.push(node);
            for (int child : tree[node]) {
                stack.push(child);
            }
        }

        while (!postOrder.isEmpty()) {
            int node = postOrder.pop();
            int count = 0;
            for (int child : tree[node]) {
                count += 1 + dp[child];
            }
            dp[node] = count;
        }
    }

    // ✅ FastReader
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}