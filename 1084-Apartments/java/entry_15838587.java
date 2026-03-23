import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class entry_15838587 {

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
         There are n applicants and m free apartments. Your task is to distribute the apartments so that as many applicants as possible will get an apartment.
        Each applicant has a desired apartment size, and they will accept any apartment whose size is close enough to the desired size.
        Input
        The first input line has three integers n, m, and k: the number of applicants, the number of apartments, and the maximum allowed difference.
        The next line contains n integers a_1, a_2, \ldots, a_n: the desired apartment size of each applicant. If the desired size of an applicant is x, they will accept any apartment whose size is between x-k and x+k.
        The last line contains m integers b_1, b_2, \ldots, b_m: the size of each apartment.
        Output
        Print one integer: the number of applicants who will get an apartment.
        Constraints
         1 \le n, m \le 2 \cdot 10^5
        0 \le k \le 10^9
        1 \le a_i, b_i \le 10^9
         1. sort applicants and apartments
        2. use pointer p which will indicate the smallest apartment
        3. iterate over applicants and pick the apartment for it if possible
           increase counter and p if aparmnet was selected
        4. return counter
          */

        int n = fs.nextInt();
        int m = fs.nextInt();
        long k = fs.nextLong();
        int[] aparts = new int[n];
        int[] applicants = new int[m];

        for(int i = 0; i < n; ++i) {
            aparts[i] = fs.nextInt();
        }
        for(int i = 0; i < m; ++i) {
            applicants[i] = fs.nextInt();
        }

        Arrays.sort(aparts);
        Arrays.sort(applicants);

        int p = 0, counter = 0;
        for(int i = 0; i < m && p < n; ++i) {
            int desiredSize = applicants[i];
            while(p < n && aparts[p] < desiredSize - k) {
                ++p;
            }

            if(p < n && desiredSize + k >= aparts[p] && desiredSize - k <= aparts[p]) {
                ++counter;
                ++p;
            }
        }

        out.append(counter);
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