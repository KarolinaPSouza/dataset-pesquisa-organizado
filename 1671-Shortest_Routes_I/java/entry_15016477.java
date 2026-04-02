import java.io.*;
import java.util.*;

public class entry_15016477 {

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


    public static class Edge {

        int u;
        int v;
        int w;

        public Edge (int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

    }

    public static class Distancia {

        int u;
        long dist;

        public Distancia (int u, long dist) {
            this.u = u;
            this.dist = dist;
        }

    }

    public static long MAXINT = 1000000000000000L;
    public static int n;
    public static int m;
    public static ArrayList<Edge>[] adj;
    public static boolean[] visitado;
    public static long[] distancia;

    public static void Dijkstra() {

        PriorityQueue<Distancia> pq = new PriorityQueue<>(new Comparator<Distancia>() {
            public int compare(Distancia a, Distancia b) {
                return Long.compare(a.dist, b.dist);// ordena por menor distancia
            }
        });

        Distancia u = new Distancia(1,0);

        pq.add(u);

        while (!pq.isEmpty()) {

            Distancia actual = pq.poll();

            if (visitado[actual.u]) continue;

            visitado[actual.u] = true;
            distancia[actual.u] = actual.dist;

            for (Edge e : adj[actual.u]) {
                if (!visitado[e.v]) {
                    long nuevoDist = actual.dist + e.w;
                    pq.add(new Distancia(e.v,nuevoDist));
                }
            }

        }

    }

    public static void main(String[] args) {
        ///////////////////////////////////////

        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        n = in.nextInt();
        m = in.nextInt();

        adj = new ArrayList[n+1];// 1-based
        visitado = new boolean[n+1];// 1-based
        distancia = new long[n+1];// 1-based
        for (int i=1; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int w = in.nextInt();
            Edge e1 = new Edge(from,to, w);
            adj[from].add(e1);// unidireccional
        }

        Dijkstra();

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            if (i>1) sb.append(' ');
            sb.append(distancia[i]);
        }
        out.println(sb);





        ///////////////////////////////////////
        out.flush();
    }

    // Depuración rápida
    static void dbg(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }
}