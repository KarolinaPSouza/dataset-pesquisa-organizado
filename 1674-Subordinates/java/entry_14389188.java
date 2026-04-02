// package  Assignment_9_Trees.Tree_1;


// public class entry_14389188 {

//     private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] dp) {
//         for (int child : adj.get(node)) {
//             dfs(child, adj, dp);
//             dp[node] += dp[child] + 1;
//         }
//     }

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

//         int n = Integer.parseInt(br.readLine());
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n + 1);
//         for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 2; i <= n; i++) {
//             int boss = Integer.parseInt(st.nextToken());
//             adj.get(boss).add(i); // only boss → employee
//         }

//         int[] dp = new int[n + 1];
//         dfs(1, adj, dp);

//         for (int i = 1; i <= n; i++) {
//             out.print(dp[i] + " ");
//         }
//         out.flush();
//     }
// }
import java.io.*;
import java.util.*;

public class entry_14389188 {

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();

        // build adjacency list (boss -> employees only)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 2; i <= n; i++) {
            int boss = fs.nextInt();
            adj.get(boss).add(i);
        }

        int[] dp = new int[n + 1];
        // iterative DFS using stack
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> order = new Stack<>(); // for postorder
        stack.push(1);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            order.push(node);
            for (int child : adj.get(node)) {
                stack.push(child);
            }
        }

        // process in reverse order to simulate recursion
        while (!order.isEmpty()) {
            int node = order.pop();
            for (int child : adj.get(node)) {
                dp[node] += dp[child] + 1;
            }
        }

        // fast output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    // ⚡ super fast scanner
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;
        FastScanner(InputStream in) { this.in = in; }
        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = readByte(); }
            for (; c > ' '; c = readByte()) val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}