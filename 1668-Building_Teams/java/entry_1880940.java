import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class entry_1880940 {
    static class FastIO extends PrintWriter
    {
        BufferedReader br;
        StringTokenizer st;

        public FastIO()
        {
            super(new BufferedOutputStream(System.out));
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
    static boolean isBipartite = true;
    static boolean[] color;
    static boolean[] marked;

    private static void dfs(ArrayList<Integer>[] G, int v) {
        marked[v] = true;
        for (int w : G[v]) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            }
            else if (color[w] == color[v]) isBipartite = false;
        }
    }

    public static void main(String[] args) {

        FastIO ii = new FastIO();
        int n = ii.nextInt(), m = ii.nextInt();
        ArrayList<Integer>[] G = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            G[i] = new ArrayList<>();
        }
        marked = new boolean[n+1];
        color = new boolean[n+1];
        for (int i = 0; i < m; i++) {
            int a = ii.nextInt(), b = ii.nextInt();
            G[a].add(b);
            G[b].add(a);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            if (!marked[i]) dfs(G, i);
        }

        if (!isBipartite) System.out.println("IMPOSSIBLE");
        else {
            for (int i = 1; i <= n; ++i) {
                if (color[i]) sb.append("1");
                else sb.append("2");

                if (i != n) sb.append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}