import java.io.*;
import java.util.*;

public class entry_15375134 {

    // Entrada rápida
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try { return br.readLine(); }
            catch (IOException e) { e.printStackTrace(); return null; }
        }

        boolean hasNext() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    String line = br.readLine();
                    if (line == null) return false;
                    st = new StringTokenizer(line);
                }
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    private static <T> ArrayList<ArrayList<T>> vvt(int n, int m, T value) {
        ArrayList<ArrayList<T>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<T> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(value);
            }
            res.add(row);
        }
        return res;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static int n;
    public static int maxDist = -1;
    public static int maxDistNode = -1;
    public static ArrayList<Integer>[] adj;

    public static class Nodo {

        int u, dist;

        public Nodo (int u, int dist) {
            this.u = u;
            this.dist = dist;
        }

    }

    public static void dfs(int ini) {

        boolean[] visited = new boolean[n+1];// 1-based
        Stack<Nodo> s = new Stack<>();
        s.add(new Nodo(ini,0));

        while (!s.isEmpty()) {
            Nodo actual = s.pop();
            int u = actual.u;
            int dist = actual.dist;
            if (visited[u]) continue;
            visited[u] = true;
            if (maxDist < dist) {
                maxDist = dist;
                maxDistNode = u;
            }
            for (Integer v : adj[u]) {
                if (!visited[v]) {
                    s.add(new Nodo(v,dist+1));
                }
            }
        }

    }

    public static void main(String[] args) {
        ///////////////////////////////////////

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        adj = new ArrayList[n+1];// 1-based
        for (int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        for (int i=0; i<n-1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        // primer DFS
        dfs(1);// DFS desde nodo arbitrario

        // segundo DFS
        dfs(maxDistNode);

        out.println(maxDist);





        ///////////////////////////////////////
        out.flush();
    }

    // Depuración rápida
    static void dbg(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}