import java.util.Scanner;

public class entry_12480638 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.println(countWays(coins, x));
    }

    public static int countWays(int[] coins, int target) {
        final int MOD = 1000000007;
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int sum = 1; sum <= target; sum++) {
                if (sum - coin >= 0) {
                    dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
                }
            }
        }

        return dp[target];
    }
}