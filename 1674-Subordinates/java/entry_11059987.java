import java.io.*;
import java.util.*;

// Anirudha Kale

public class entry_11059987 {

    static FastIO io;
    static int MAXN = (int) 2e5 + 1;
    static ArrayList<Integer>[] adj = new ArrayList[MAXN];
    static int[] dp = new int[MAXN];

    static {
        for (int i = 0; i < MAXN; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    static void dfs(int node) {
        for (int child : adj[node]) {
            dfs(child);
            dp[node] += dp[child] + 1;
        }
    }

    static void dfsIterative(int start) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> postOrder = new Stack<>(); // to process nodes in post-order
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.push(node);
            for (int child : adj[node]) {
                stack.push(child);
            }
        }

        while (!postOrder.isEmpty()) {
            int node = postOrder.pop();
            for (int child : adj[node]) {
                dp[node] += dp[child] + 1;
            }
        }
    }

    static void solve() throws IOException {
        int n = io.nextInt();

        // Reset adjacency list and dp array for each test case
        for (int i = 1; i <= n; i++) {
            adj[i].clear();
            dp[i] = 0;
        }

        for (int i = 2; i <= n; i++) {
            int x = io.nextInt();
            adj[x].add(i);
        }
        dfsIterative(1);

        // Efficiently output the results
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            result.append(dp[i]).append(" ");
        }
        io.bw.write(result.toString().trim());
        io.bw.newLine();
    }

    public static void main(String[] args) throws java.lang.Exception {
        io = new FastIO(); // Initialize the I/O utility
        solve();
        io.bw.flush(); // Flush the output at the end to ensure everything is printed
    }
}

class FastIO {
    BufferedReader br;
    BufferedWriter bw;
    StringTokenizer st;

    public FastIO() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    // Fast input methods
    String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}