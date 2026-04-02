import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class entry_15870306 {

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
            There are n pupils in Uolevi's class, and m friendships between them. Your task is to divide the pupils into two teams in such a way that no two pupils in a team are friends. You can freely choose the sizes of the teams.
            Input
            The first input line has two integers n and m: the number of pupils and friendships. The pupils are numbered 1,2,\dots,n.
            Then, there are m lines describing the friendships. Each line has two integers a and b: pupils a and b are friends.
            Every friendship is between two different pupils. You can assume that there is at most one friendship between any two pupils.
            Output
            Print an example of how to build the teams. For each pupil, print "1" or "2" depending on to which team the pupil will be assigned. You can print any valid team.
            If there are no solutions, print "IMPOSSIBLE".
            Constraints
             1 \le n \le 10^5
            1 \le m \le 2 \cdot 10^5
            1 \le a,b \le n
           */

        int n = fs.nextInt();
        int m = fs.nextInt();
        List<Integer>[] adj = new ArrayList[n + 1];
        int[] colors = new int[n + 1];
        for(int i = 1; i <= n; ++i) adj[i] = new ArrayList<>();

        for(int i = 0; i < m; ++i) {
            int a = fs.nextInt();
            int b = fs.nextInt();

            adj[a].add(b);
            adj[b].add(a);
        }

        boolean isBipartie = true;
        for(int i = 1; i <= n; ++i) {
            if(colors[i] == 0) {
                isBipartie = dfsBuildTeams(adj, colors, i);
            }

            if(!isBipartie) {
                break;
            }
        }

        if(isBipartie) {
            for(int i = 1; i <= n; ++i) {
                out.append(colors[i]).append(" ");
            }
        } else {
            out.append("IMPOSSIBLE\n");
        }

        System.out.print(out.toString());
    }

    static boolean dfsBuildTeams(List<Integer>[] adj, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1;

        while(!queue.isEmpty()) {
            Integer current = queue.poll();
            int color = colors[current] == 1 ? 2 : 1;

            for(int a : adj[current]) {
                if(colors[a] == colors[current]) {
                    return false;
                }

                if(colors[a] == 0) {
                    colors[a] = color;
                    queue.offer(a);
                }
            }
        }

        return true;
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