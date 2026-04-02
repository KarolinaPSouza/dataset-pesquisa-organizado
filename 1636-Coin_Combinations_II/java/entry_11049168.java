import java.util.*;
// Kattio Imports
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Ryan Huynh
 * University of Texas at Austin, eid: rh38596
 *
 * Course: Computer Science (CS) 104c - Competitive Programming
 * Professor: Etienne Vouga
 * Assignment: CSES - 8. Week of 21 Oct - Coin Combinations II
 *
 * CSES Account: Username- huynhry, #- 272359
 */

public class entry_11049168 {
    static final int MOD = (int) 1e9 + 7;
    static long[] dp = new long[1000001];

    public static void main(String[] args) {
        Kattio input = new Kattio(System.in);

        int n = input.getInt();
        int x = input.getInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = input.getInt();
        }

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int weight = 0; weight <= x; weight++) {
                if (weight - coins[i - 1] >= 0) { 
                    dp[weight] = (dp[weight] + dp[weight - coins[i - 1]]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);
        input.close();
    }

    static class Kattio extends PrintWriter {
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public boolean hasMoreTokens() {
            return peekToken() != null;
        }
        public int getInt() {
            return Integer.parseInt(nextToken());
        }
        public double getDouble() {
            return Double.parseDouble(nextToken());
        }
        public long getLong() {
            return Long.parseLong(nextToken());
        }
        public String getWord() {
            return nextToken();
        }
    }

    private static BufferedReader r;
    private static String line;
    private static StringTokenizer st;
    private static String token;

    private static String peekToken() {
        if (token == null) {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        }
        return token;
    }

    private static String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}