//package Concepts.CSES.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_2758589 {

    static final int mod = (int) 1e9 + 7;

    private static void solve(int t) {
        int n = fs.nextInt();
        int total = fs.nextInt();
        int coins[] = fs.readArray(n);

        int dp[] = new int[total + 1];
        Arrays.sort(coins);
        dp[0] = 1;
        for (int i = 1; i <= total; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) dp[i] = dp[i] % mod + dp[i - coins[j]] % mod;
                else break;
            }
        }
        System.out.println(dp[total] % mod);
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