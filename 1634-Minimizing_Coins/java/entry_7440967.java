import java.util.Arrays;
import java.util.Scanner;

public class entry_7440967 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();
        int result = solveDP(n, x, coins);
        System.out.println(result);
    }

    public static int solveDP(int n, int x, int[] coins) {
        int inf = Integer.MAX_VALUE;
        int[] dp = new int[x + 1];
        Arrays.fill(dp, inf);
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            // choose coins
            for (int c : coins) {
                if (i - c >= 0 && dp[i - c] != inf) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[x] == inf ? -1 : dp[x];
    }
}