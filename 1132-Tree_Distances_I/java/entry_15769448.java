import java.io.*;
import java.util.*;

public class entry_15769448 {

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] ans = solution(n, adj);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static int maxi = 0;

    public static int[] solution(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] ans = new int[n + 1];
        int[] distA = new int[n + 1];
        int[] distB = new int[n + 1];
        int[] dist = new int[n + 1];

        dist[1] = 0;
        dfs(1, -1, adj, dist);

        int A = 1;
        for (int i = 1; i <= n; i++) {
            if (dist[A] < dist[i]) {
                A = i;
            }
        }

        distA[A] = 0;
        dfs(A, -1, adj, distA);

        int B = A;
        for (int i = 1; i <= n; i++) {
            if (distA[B] < distA[i]) {
                B = i;
            }
        }

        distB[B] = 0;
        dfs(B, -1, adj, distB);

        for (int i = 1; i <= n; i++)
            ans[i] = Math.max(distA[i], distB[i]);
        return ans;
    }

    public static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] dist) {
        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[] { node, parent });

        while (!st.isEmpty()) {
            int[] curr = st.pop();
            int Node = curr[0];
            int par = curr[1];

            for (int it : adj.get(Node)) {
                if (it == par) continue;
                dist[it] = dist[Node] + 1;
                st.push(new int[]{it, Node});
            }
        }
    }
}