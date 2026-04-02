import java.io.*;
import java.util.*;

public class entry_15589382 {
    static ArrayList<ArrayList<Integer>> cons = new ArrayList<>();
    static int[] visited;
    static int[] teams;
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        int n = io.nextInt(); 
        int m = io.nextInt();
        visited = new int[n];
        for (int i = 0; i < n; ++i)
        {
            cons.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i)
        {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            cons.get(a).add(b);
            cons.get(b).add(a);

        }
        teams = new int[n];
        for (int i = 0; i < n; ++i)
        {
            if (visited[i] == 0)
            {
                dfs(i, 1);
            }
        }
        for (int i = 0; i < n; ++i)
            if (teams[i] == -1)
            {
                io.println("IMPOSSIBLE");
                io.close();
                return;
            }

        for (int i = 0; i < n; ++i)
        {
            io.print(teams[i] + " ");
        }


        io.close();
    }
    static void dfs(int node, int team)
    {
        if (teams[node] == 0 || teams[node] == team) 
            teams[node] = team;
        else
            teams[node] = -1;
        ArrayList<Integer> canidates = cons.get(node);
        visited[node] = 1;
        if (team == 1)
        {
            for (int i :canidates)
            {
                if (visited[i] == 0)
                {
                    dfs(i, 2);
                }
                else
                {
                    if (teams[i] == team)
                        teams[i] = -1;
                }
            }
        }   
        else
        {
            for (int i :canidates)
            {
                if (visited[i] == 0)
                {
                    dfs(i, 1);
                }
                else
                {
                    if (teams[i] == team)
                        teams[i] = -1;
                }
            }
        }
    }

    // Fast I/O
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}