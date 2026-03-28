import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] dis1 = bfs(adj, 0, n);
        int A = 0;
        for (int i = 0; i < n; i++)
            if (dis1[i] > dis1[A])
                A = i;

        int[] disA = bfs(adj, A, n);
        int B = 0;
        for (int i = 0; i < n; i++)
            if (disA[i] > disA[B])
                B = i;

        int[] disB = bfs(adj, B, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Math.max(disA[i], disB[i])).append(' ');
        }
        out.println(sb);
        out.flush();
    }

    static int[] bfs(List<Integer>[] adj, int start, int n) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        int[] dis = new int[n];

        vis[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
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
    }
}