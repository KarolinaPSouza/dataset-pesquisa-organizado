//package csesproblemlist.introductoryproblems.dp;

import java.util.Scanner;

public class entry_11336628 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bookCount = scanner.nextInt();
        int budget = scanner.nextInt();

        int[] prices = new int[bookCount];
        int[] pages = new int[bookCount];

        for (int i = 0; i < bookCount; i++) {
            prices[i] = scanner.nextInt();
        }

        for (int i = 0; i < bookCount; i++) {
            pages[i] = scanner.nextInt();
        }

        int[] dp = new int[budget + 1];

        for (int book = 0; book < prices.length; book++) {
            for (int price = budget; price >= prices[book]; price--) {
                dp[price] = Math.max(dp[price], dp[price - prices[book]] + pages[book]);
            }
        }

        System.out.println(dp[budget]);
    }

    private static boolean isValid(int budget, int[] prices, int[] pages, int targetPages) {
        int[] dp = new int[budget + 1];

        for (int book = 0; book < prices.length; book++) {
            for (int price = budget; price >= prices[book]; price--) {
                dp[price] = Math.max(dp[price], dp[price - prices[book]] + pages[book]);
            }
        }

        for (int j : dp) {
            if (j >= targetPages) return true;
        }

        return false;
    }
}