import java.util.*;
import java.io.*;

public class entry_1592474 {

    static FastReader sc;
    static PrintWriter out;
    static int mod = 1000000007;

    public static void main(String[] args) {
        sc = new FastReader();
        out = new PrintWriter(System.out);
        solve(sc, out);
        out.flush();
        out.close();
    }

    static void solve(FastReader sc, PrintWriter out) {
        // int t = sc.nextInt();
        // StringBuffer ans = new StringBuffer("");
        // while (t-- > 0) {

        // }
        // out.println(ans);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] cost = new int[n + 1], pages = new int[n + 1];
        for (int i = 1; i <= n; i++)
            cost[i] = sc.nextInt();
        for (int i = 1; i <= n; i++)
            pages[i] = sc.nextInt();
        int[][] dp = new int[n + 1][x + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= x; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + pages[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        out.println(dp[n][x]);
    }

    static void sieve(boolean[] prime, int n) { // Sieve Of Eratosthenes
        for (int i = 1; i <= n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = 2; i * j <= n; j++) {
                    prime[i * j] = false;
                }
            }
        }
    }

    static void fillGraph(ArrayList<ArrayList<Integer>> adj, FastReader sc) {
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj, PrintWriter out) {
        for (int i = 1; i < adj.size(); i++) {
            out.print(i + "->");
            for (int e : adj.get(i)) {
                out.print(e + " ");
            }
            out.println();
        }
    }

    static long minCost(int[] h, int i, int n, long[] dp, int k) {
        if (i == n - 1) {
            return 0;
        }
        if (i >= n)
            return Integer.MAX_VALUE;
        if (dp[i] != -1)
            return dp[i];
        long c2 = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i + j < n) {
                c2 = Math.min(c2, Math.abs(h[i] - h[i + j]) + minCost(h, i + j, n, dp, k));
            }
        }
        return dp[i] = c2;
    }

    int fib(int n) { // n-th Fibonacci Number
        int a = 0, b = 1, c, i;
        if (n == 0)
            return a;
        for (i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    static long nCr(int n, int r) { // Combinations
        if (n < r)
            return 0;
        if (r > n - r) { // because nCr(n, r) == nCr(n, n - r)
            r = n - r;
        }
        long ans = 1L;
        for (int i = 0; i < r; i++) {
            ans *= (n - i);
            ans /= (i + 1);
        }
        return ans;
    }

    static long catalan(int n) { // n-th Catalan Number
        long c = nCr(2 * n, n);
        return c / (n + 1);
    }

    static class Pair implements Comparable<Pair> { // Pair Class
        long x;
        long y;

        Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return (int) (this.x - o.x);
        }
    }

    static class Trip<E, T, Z> { // Triplet Class
        E x;
        T y;
        Z z;

        Trip(E x, T y, Z z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public boolean equals(Trip<E, T, Z> o) {
            if (o instanceof Trip) {
                Trip<E, T, Z> t = o;
                return t.x == x && t.y == y && t.z == z;
            }
            return false;
        }

        public int hashCode() {
            return Integer.valueOf((int) x).hashCode() * 62 + Integer.valueOf((int) y).hashCode() * 31
                    + Integer.valueOf((int) z).hashCode();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}