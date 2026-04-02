import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class entry_15876248 {

    /* ================= FAST INPUT ================= */
    private static final class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, res = 0;
            do {
                c = readByte();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = readByte();
            }
            return res * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long res = 0;
            do {
                c = readByte();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = readByte();
            }
            return res * sign;
        }

        String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder();
            do {
                c = readByte();
            } while (c <= ' ');
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }

    /* ================= CONSTANTS ================= */
    static final long MOD = 1_000_000_007L;
    static final long INF = (long) 1e18;

    /* ================= GLOBALS (OPTIONAL) ================= */
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    /* ================= MAIN ================= */
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        /*
            There are n cities and m roads between them. Your task is to process q queries where you have to determine the length of the shortest route between two given cities.
            Input
            The first input line has three integers n, m and q: the number of cities, roads, and queries.
            Then, there are m lines describing the roads. Each line has three integers a, b and c: there is a road between cities a and b whose length is c. All roads are two-way roads.
            Finally, there are q lines describing the queries. Each line has two integers a and b: determine the length of the shortest route between cities a and b.
            Output
            Print the length of the shortest route for each query. If there is no route, print -1 instead.
            Constraints
             1 \le n \le 500
            1 \le m \le n^2
            1 \le q \le 10^5
            1 \le a,b \le n
            1 \le c \le 10^9
             use Floyd-Warshall algorithm to find the shortest paths between all pairs;
             1. create distance[n][m] array and initialize it with infinity
            2. change distance of nodes which are directly connected to weights values
            3. set node distance for itself to 0
            4.1 consider each node as an intermediate node k
            4.2 iterate over all pairs of vertices (i, j) and use formula to update distance: d[i][j] = math.min(d[i][j], d[i][k] + d[k][j])
          */

        int n = fs.nextInt();
        int m = fs.nextInt();
        int q = fs.nextInt();
        long INF = 1_000_000_000_000_000L;
        long[][] distance = new long[n + 1][n + 1];
        for(int i = 1; i <= n; ++i) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for(int i = 0; i < m; ++i) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            long c = fs.nextLong();

            distance[a][b] = Math.min(distance[a][b], c);
            distance[b][a] = Math.min(distance[a][b], c);
        }

        for(int k = 1; k <= n; ++k) {
            for(int i = 1; i <= n; ++i) {
                for(int j = 1; j <= n; ++j) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for(int i = 0; i < q; ++i) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            if(distance[a][b] == INF) {
                out.append(-1).append("\n");
            } else {
                out.append(distance[a][b]).append("\n");
            }
        }

        System.out.print(out.toString());
    }

    /* ================= UTILITIES ================= */

    // GCD
    static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    // Fast power mod
    static long modPow(long a, long e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }

    // Lower bound
    static int lowerBound(int[] a, int x) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    /* ================= GRAPH HELPERS ================= */

    static void initGraph(int n) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        visited = new boolean[n];
    }

    static void dfs(int u) {
        visited[u] = true;
        for (int v : graph[u]) {
            if (!visited[v]) dfs(v);
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    /* ================= PAIR ================= */
    static class Pair implements Comparable<Pair> {
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public int compareTo(Pair o) {
            return Integer.compare(this.a, o.a);
        }
    }
}