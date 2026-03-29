//package com.dsa.cses.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_14924342 {
    int maxPagesBought(int n, int maxTotalPrice, int[] prices, int[] pages) {
        int[][] dp = new int[n + 1][maxTotalPrice + 1];
        for (int i = 1; i <= n; ++i) {
            for (int currentBalance = 1; currentBalance <= maxTotalPrice; ++currentBalance) {
                dp[i][currentBalance] = dp[i - 1][currentBalance];
                if (currentBalance >= prices[i - 1]) {
                    dp[i][currentBalance] = Math.max(dp[i][currentBalance], dp[i - 1][currentBalance - prices[i - 1]] + pages[i - 1]);
                }
            }
        }
        return dp[n][maxTotalPrice];
    }

    /*
    This gave TLE, probably due to more conditionals and bad memory access patterns
     */
//        int maxPagesBought(int n, int maxTotalPrice, int[] prices, int[] pages) {
//        int[][] dp = new int[maxTotalPrice + 1][n];
//        for (int currentBalance = 1; currentBalance <= maxTotalPrice; ++currentBalance) {
//            for (int j = 0; j < n; ++j) {
//                int currentBookPrice = prices[j];
//                int currentBookPages = pages[j];
//
//                int pagesIfIDontPickThisBook = 0;
//                if (j > 0) pagesIfIDontPickThisBook = dp[currentBalance][j - 1];
//
//                dp[currentBalance][j] = pagesIfIDontPickThisBook;
//
//                int pagesIfIPickThisBook = 0;
//                if (currentBalance >= currentBookPrice) {
//                    pagesIfIPickThisBook = currentBookPages;
//                    if (j > 0)
//                        pagesIfIPickThisBook = (pagesIfIPickThisBook + dp[currentBalance - currentBookPrice][j - 1]);
//                }
//                dp[currentBalance][j] = Math.max(pagesIfIPickThisBook, pagesIfIDontPickThisBook);
//            }
//        }
//
//        return dp[maxTotalPrice][n - 1];
//    }
//
    public static void main(String[] args) throws IOException {
        entry_14924342 solver = new entry_14924342();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int maxTotalPrice = Integer.parseInt(s[1]);

        String[] pricesString = br.readLine().split(" ");
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(pricesString[i]);
        }

        String[] pagesString = br.readLine().split(" ");
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(pagesString[i]);
        }

        System.out.println(solver.maxPagesBought(n, maxTotalPrice, prices, pages));

//        input is giving TLE, hence switched to `BufferedReader`
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int maxTotalPrice = sc.nextInt();
//        int[] prices = new int[n];
//        int[] pages = new int[n];
//        for (int i = 0; i < n; ++i) prices[i] = sc.nextInt();
//        for (int i = 0; i < n; ++i) pages[i] = sc.nextInt();
//        System.out.println(solver.maxPagesBought(n, maxTotalPrice, prices, pages));
//
    }
}