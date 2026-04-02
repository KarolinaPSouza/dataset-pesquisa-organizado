// PROBLEM ID AND NAME HERE

import java.io.*;
import java.util.*;

public class entry_1962582 {
    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    public static void main(String[] args) {
        int mod = (int) 1e9 + 7;
        int n = r.nextInt();
        int x = r.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = r.nextInt();
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= x; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                    if (dp[i] >= mod) {
                        dp[i] -= mod;
                    }
                }
            }
        }

        pw.println(dp[x]);
        pw.close();
    }

    public static void solve() {
        // CODE GOES HERE
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
    }
}