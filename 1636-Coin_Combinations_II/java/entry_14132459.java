//package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class entry_14132459 {

    private static final FastScanner fs = new FastScanner();

    private static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        int n = fs.nextInt();
        int x = fs.nextInt();
        int[] coins = fs.readArray(n);
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= x; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        System.out.println(dp[x]);

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
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}