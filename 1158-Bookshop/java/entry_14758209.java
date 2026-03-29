//package com.topics.dp;

import java.util.Scanner;

public class entry_14758209 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int[] prices = new int[n];
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pages[i] = in.nextInt();
        }
        System.out.println(maxPages3(n, x, prices, pages));
    }

    public static int maxPages(int n, int x, int[] prices, int[] pages) {
        int[][] dp = new int[n][x+1];
        int ans = find(n-1, x, prices, pages, dp);
        return ans == Integer.MAX_VALUE? 0: ans;
    }

    private static int find(int ind, int x, int[] prices, int[] pages, int[][] dp) {
        if (ind == 0) {
            if (prices[0] <= x) return pages[0];
            else return Integer.MIN_VALUE;
        }

        if (dp[ind][x] != 0) return dp[ind][x];

        int notPick = find(ind-1, x, prices, pages, dp);
        int pick = Integer.MIN_VALUE;
        if (prices[ind] <= x) {
            pick = pages[ind] + find(ind-1, x - prices[ind], prices, pages, dp);
        }
        return dp[ind][x] = Math.max(pick, notPick);
    }

    public static int maxPages2(int n, int x, int[] prices, int[] pages) {
        int[][] dp = new int[n+1][x+1];

        for (int i = 0; i < x+1; i++) {
            if (prices[0] <= i) {
                dp[0][i] = pages[0];
            } else {
                dp[0][i] = Integer.MIN_VALUE;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            for (int X = 0; X <= x; X++) {
                int notPick = dp[ind - 1][X];
                int pick = Integer.MIN_VALUE;
                if (prices[ind] <= X) {
                    pick = pages[ind] + dp[ind-1][X - prices[ind]];
                }
                dp[ind][X] = Math.max(pick, notPick);
            }
        }
        int ans = dp[n-1][x];
        return ans == Integer.MAX_VALUE? 0: ans;
    }

    // Space Optimization
    public static int maxPages3(int n, int x, int[] prices, int[] pages) {
        int[] prev = new int[x+1];

        for (int i = 0; i < x+1; i++) {
            if (prices[0] <= i) {
                prev[i] = pages[0];
            } else {
                prev[i] = 0;
            }
        }

        for (int ind = 1; ind < n; ind++) {
            int[] cur = new int[x+1];
            for (int X = 0; X <= x; X++) {
                int notPick = prev[X];
                int pick = 0;
                if (prices[ind] <= X) {
                    pick = pages[ind] + prev[X - prices[ind]];
                }
                cur[X] = Math.max(pick, notPick);
            }
            prev = cur;
        }
        return prev[x];
    }
}