import java.io.*;
import java.util.*;

public class entry_13862059 {
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
                } catch (IOException e) {}
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt(), m = sc.nextInt();
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        bfs(1, n);
        if (!visited[n]) {
            out.println("IMPOSSIBLE");
        } else {
            ArrayList<Integer> path = new ArrayList<>();
            for (int cur = n; cur != 0; cur = parent[cur]) path.add(cur);
            Collections.reverse(path);
            out.println(path.size());
            for (int x : path) out.print(x + " ");
            out.println();
        }
        out.flush();
    }

    static void bfs(int start, int end) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        parent[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nbr : graph[node]) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    parent[nbr] = node;
                    q.add(nbr);
                }
            }
        }
    }
}