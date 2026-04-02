import java.io.*;
import java.util.*;

public class entry_14083576 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static boolean impossible;

    public static void bfs(List<Integer>[] adj, int start, boolean[] vis, int[] color) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neigh : adj[node]) {
                if (!vis[neigh]) {
                    vis[neigh] = true;
                    color[neigh] = 3 - color[node]; // flip 1↔2
                    q.add(neigh);
                } else if (color[neigh] == color[node]) {
                    impossible = true;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        boolean[] vis = new boolean[n + 1];
        int[] color = new int[n + 1];
        impossible = false;

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                color[i] = 1;
                bfs(adj, i, vis, color);
                if (impossible) break;
            }
        }

        if (impossible) {
            out.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= n; i++) {
                out.print(color[i] + " ");
            }
        }
        out.flush();
    }
}