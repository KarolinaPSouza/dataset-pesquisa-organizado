import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_14078307 {
    static long mod = 1000000007;

    static List<List<Integer>> g = new ArrayList<>();
    static int[] team;
    static boolean isBipartite;

    static void dfs(int node, int color) {
        team[node] = color;
        for (int v : g.get(node)) {
            if (team[v] == 0) {
                dfs(v, 3 - color);
            } else if (team[v] == team[node]) {
                isBipartite = false;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        // your code goes here
        FastReader sc = new FastReader();
        int n = sc.nextInt(); 
        int m = sc.nextInt();

        g.clear();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }

        team = new int[n + 1];
        isBipartite = true;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (team[i] == 0) {
                dfs(i, 1); // Start with team 1
            }
        }

        if (!isBipartite) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = 1; i <= n; i++) {
                System.out.print(team[i] + " ");
            }
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreElements())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        String nextLine() throws IOException {
            return br.readLine();
        }
    }
}