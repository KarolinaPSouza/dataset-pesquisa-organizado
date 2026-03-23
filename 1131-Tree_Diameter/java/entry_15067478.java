import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        out.println(solve(adj, n));
        out.flush();
    }

    static int solve(List<List<Integer>> adj, int n) {
        int[] dis1 = bfs(adj, 0, n);
        int node = 0;
        for (int i = 0; i < n; i++) {
            if (dis1[i] > dis1[node])
                node = i;
        }

        int[] dis2 = bfs(adj, node, n);
        int ans = 0;
        for (int d : dis2)
            ans = Math.max(ans, d);
        return ans;
    }

    static int[] bfs(List<List<Integer>> adj, int start, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];

        vis[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (!vis[v]) {
                    vis[v] = true;
                    dis[v] = dis[u] + 1;
                    q.add(v);
                }
            }
        }
        return dis;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}