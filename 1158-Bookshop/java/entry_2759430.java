//package Concepts.CSES.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_2759430 {

    static final int mod = (int) 1e9 + 7;

    private static void solve(int t) {
        int n = fs.nextInt();
        int total = fs.nextInt();
        int prices[] = fs.readArray(n);
        int pages[] = fs.readArray(n);
        int dp[][] = new int[total + 1][n + 1];
        for (int i = 0; i < total + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = iterative(total, prices, pages);
//        int ans = recursive(0, total, prices, pages, dp);
        System.out.println(ans);

    }

    private static int iterative(int total, int[] prices, int[] pages) {
//        int dp[][] = new int[prices.length + 1][total + 1];
//        for (int i = 1; i < prices.length + 1; i++) {
//            for (int j = 0; j < total + 1; j++) {
//                dp[i][j] = dp[i - 1][j];
//                if (prices[i - 1] <= j) {
//                    dp[i][j] = Math.max(dp[i - 1][j], pages[i - 1] + dp[i - 1][j - prices[i - 1]]);
//                }
//            }
//        }
        int dp[] = new int[total + 1];
        for (int i = 1; i <= prices.length; ++i) {
            for (int j = total; j > 0; --j)
                if (j - prices[i - 1] >= 0)
                    dp[j] = Math.max(dp[j], pages[i - 1] + dp[j - prices[i - 1]]);
        }

        return dp[total];
    }

    //    4 10
//4 8 5 3
//5 12 8 1
//You can buy books 1 and 3. Their price is 4+5=9 and the number of pages is 5+8=13.
    private static int recursive(int start, int total, int[] prices, int[] pages, int[][] dp) {

        if (total < 0) return Integer.MIN_VALUE;
        if (start >= prices.length) return dp[total][start] = 0;
        if (dp[total][start] != -1) return dp[total][start];
        int totalPages = 0;
        int buying = pages[start] + recursive(start + 1, total - prices[start], prices, pages, dp);
        int notBuying = recursive(start + 1, total, prices, pages, dp);
        totalPages = Math.max(buying, notBuying);
        return dp[total][start] = totalPages;
    }


    public static void main(String[] args) {
        fs = new FastScanner();
        out = new PrintWriter(System.out);
        long s = System.currentTimeMillis();
        int t = 1;//fs.nextInt();
        for (int i = 1; i <= t; i++) solve(t);
        out.close();
//        System.err.println( System.currentTimeMillis() - s + "ms" );
    }

    static boolean DEBUG = true;
    static PrintWriter out;
    static FastScanner fs;

    static void trace(Object... o) {
        if (!DEBUG) return;
        System.err.println(Arrays.deepToString(o));
    }

    static void pl(Object o) {
        out.println(o);
    }

    static void p(Object o) {
        out.print(o);
    }

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    static void sieveOfEratosthenes(int n, int factors[]) {
        factors[1] = 1;
        for (int p = 2; p * p <= n; p++) {
            if (factors[p] == 0) {
                factors[p] = p;
                for (int i = p * p; i <= n; i += p)
                    factors[i] = p;
            }
        }
    }

    static long mul(long a, long b) {
        return a * b % mod;
    }

    static long fact(int x) {
        long ans = 1;
        for (int i = 2; i <= x; i++) ans = mul(ans, i);
        return ans;
    }

    static long fastPow(long base, long exp) {
        if (exp == 0) return 1;
        long half = fastPow(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long modInv(long x) {
        return fastPow(x, mod - 2);
    }

    static long nCk(int n, int k) {
        return mul(fact(n), mul(modInv(fact(k)), modInv(fact(n - k))));
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}