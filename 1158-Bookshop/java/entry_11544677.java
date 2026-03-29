//package DynamicPrograming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_11544677 {
    static int[][] dp;

    private static int maxPages(int[] price, int[] pages, int currentBudget, int i) {
        if (i >= pages.length || currentBudget <= 0) return 0;
        if (dp[i][currentBudget] != 0) return dp[i][currentBudget];
        int withoutConsider = maxPages(price, pages, currentBudget, i + 1);
        int withConsider = 0;
        if (currentBudget >= price[i]) {
            withConsider = maxPages(price, pages, currentBudget - price[i], i + 1) + pages[i];
        }
        return dp[i][currentBudget] = Math.max(withConsider, withoutConsider);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());
        int[] price = readArray(br, n);
        int[] pages = readArray(br, n);
        dp = new int[n+1][amount + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (price[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - price[i - 1]] + pages[i - 1]));
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][amount]);
    }

    private static int[] readArray(BufferedReader br, int n) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}