//package DSEANDSP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class entry_14776215 {
    // public static int helper(int n, int totalAmount, int[] prices, int[] pages,
    // int index, int[][] dp) {
    // if (index == n || totalAmount <= 0) {
    // return 0;
    // }
    // if (index == 0) {
    // if (prices[0] <= totalAmount) {
    // return pages[0];
    // } else {
    // return 0;
    // }
    // }
    // if (dp[index][totalAmount] != -1) {
    // return dp[index][totalAmount];

    // }
    // int exclude = helper(n, totalAmount, prices, pages, index - 1, dp);
    // int include = 0;
    // if (prices[index] <= totalAmount) {
    // include = pages[index] + helper(n, totalAmount - prices[index], prices,
    // pages, index - 1, dp);
    // }
    // return dp[index][totalAmount] = Math.max(include, exclude);
    // }

    public static int maxPages(int n, int totalAmount, int[] prices, int[] pages) {
        int[][] dp = new int[n][totalAmount + 1];
        for (int j = 0; j <= totalAmount; j++) {
            if (prices[0] <= j) {
                dp[0][j] = pages[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= totalAmount; j++) {
                int exclude = dp[i - 1][j];
                int include = 0;
                if (prices[i] <= j) {
                    include = pages[i] + dp[i - 1][j - prices[i]];

                }
                dp[i][j] = Math.max(include, exclude);
            }
        }
        return dp[n - 1][totalAmount];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int totalAmount = Integer.parseInt(st.nextToken());
        int[] prices = new int[n];
        int[] pages = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            prices[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());

            }
            pages[i] = Integer.parseInt(st.nextToken());
        }
        out.println(maxPages(n, totalAmount, prices, pages));
        out.flush();
        out.close();
    }
}