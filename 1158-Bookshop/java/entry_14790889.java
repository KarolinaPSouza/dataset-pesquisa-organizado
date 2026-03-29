import java.io.*;
import java.util.*;

public class entry_14790889 {
    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();

        int n = fs.nextInt();
        int sum = fs.nextInt();
        int[] prices = new int[n];
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) prices[i] = fs.nextInt();
        for (int i = 0; i < n; i++) pages[i] = fs.nextInt();

        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= prices[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - prices[i - 1]] + pages[i - 1]);
                }
            }
        }

        System.out.println(dp[n][sum]);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
        String nextLine() throws IOException { return br.readLine(); }
    }
}