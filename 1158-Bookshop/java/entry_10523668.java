import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class entry_10523668 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(in));
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
            return parseInt(next());
        }

        long nextLong() {
            return parseLong(next());
        }

        double nextDouble() {
            return parseDouble(next());
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

    static final int MOD = 1000000007;

    public static void solve(FastReader sc) {
        // Read input values
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] p = new int[n];
        int[] nop = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nop[i] = sc.nextInt();
        }

        int[][] dp = new int[n + 1][x + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - p[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], nop[i - 1] + dp[i - 1][j - p[i - 1]]);
                }
            }
        }

        System.out.println(dp[n][x]);
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        solve(sc);
    }
}