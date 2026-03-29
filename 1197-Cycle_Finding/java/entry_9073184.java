import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class entry_9073184 {
    static Kattio io = new Kattio();
    static int n, m, v;

    static Edge[] edges;

    static ArrayList<Integer> cycle = new ArrayList<>();
    static boolean CYCLE_FOUND = false;


    public static void main(String[] args) {
        n = io.nextInt();
        m = io.nextInt();
        fillEdges();

        if (CYCLE_FOUND) {
            printYES();
            return;
        }

        // Bellman-Ford
        long[] dist = new long[n];
        int[] relaxations = new int[n];
        boolean wasImproved;

        for (int i = 1; i <= n; i++) {
            wasImproved = false;

            for (Edge edge : edges)
                if (dist[edge.b] > dist[edge.a] + edge.d) {
                    dist[edge.b] = dist[edge.a] + edge.d;
                    relaxations[edge.b] = edge.a;
                    wasImproved = true;
                    v = edge.b;
                }

            if (!wasImproved) {
                printNo();
                return;
            }
        }


        int x = relaxations[v];

        for (int i = 0; i < n; i++) {
            x = relaxations[x];
        }
        cycle.add(x);
        int p = x;
        for (int i = 0; i < n; i++) {
            p = relaxations[p];
            cycle.add(p);
            if (p == x) break;
        }
        printYES();
    }


    static void printNo() {
        io.println("NO");
        io.close();
    }

    static void printYES() {
        io.println("YES");

        for (int i = cycle.size() - 1; i >= 0; i--)
            io.print((cycle.get(i) + 1) + " ");

        io.close();
    }

    static void fillEdges() {
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int a = io.nextInt() - 1, b = io.nextInt() - 1;
            long d = io.nextLong();

            if (a == b && d < 0) {
                CYCLE_FOUND = true;
                cycle.add(a);
                cycle.add(b);
            }
            edges[i] = new Edge(a, b, d);
        }
    }

    static class Edge {
        public int a;
        public int b;
        public long d;

        public Edge(int a, int b, long d) {
            this.a = a;
            this.b = b;
            this.d = d;
        }
    }

    static class Kattio extends PrintWriter {
        private final BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}