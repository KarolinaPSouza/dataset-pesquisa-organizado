import java.io.*;
import java.util.*;

public class entry_7965159 {
    static class pair {
        int node;
        long weight;
    }
    public static void main (String argv []) {
        Kattio shortestRoute = new Kattio();
        int n = shortestRoute.nextInt();
        int m = shortestRoute.nextInt();
        ArrayList<ArrayList<pair>> log = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<pair> temp = new ArrayList<>();
            log.add(temp);
        }
        for (int i = 0; i < m; i++) {
            pair temp = new pair();
            int a = shortestRoute.nextInt() - 1;
            temp.node = shortestRoute.nextInt() - 1;
            temp.weight = shortestRoute.nextInt();
            log.get(a).add(temp);
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<pair> q = new PriorityQueue<>(Comparator.comparingLong(i -> i.weight));
        pair start = new pair();
        q.add(start);
        long[] dis = new long[n];
        for (int i = 0; i < n; i++) {
            dis[i] = Long.MAX_VALUE;
        }
        dis[0] = 0;
        while (!q.isEmpty()) {
            int a = q.peek().node;
            long c = q.peek().weight;
            q.poll();
            if (visited[a]) continue;
            if (c != dis[a]) continue;
            visited[a] = true;
            for (int i = 0; i < log.get(a).size(); i++) {
                int b = log.get(a).get(i).node;
                long w = log.get(a).get(i).weight;
                if (dis[a] + w < dis[b]) {
                    dis[b] = dis[a] + w;
                    pair next = new pair();
                    next.node = b;
                    next.weight = dis[b];
                    q.add(next);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            shortestRoute.print(dis[i] + " ");
        }
        shortestRoute.println();
        shortestRoute.close();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
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