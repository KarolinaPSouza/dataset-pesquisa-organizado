import java.util.Scanner;

public class entry_11152731 {

    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt();  // number of coins
        int x = scanner.nextInt();  // desired sum
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // Solve the problem and print the result
        System.out.println(countWays(n, x, coins));
    }

    public static int countWays(int n, int x, int[] coins) {
        int[] dp = new int[x + 1];
        dp[0] = 1;  // Base case: one way to make sum 0 (by choosing no coins)

        // Fill the dp array
        for (int i = 1; i <= x; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
        }

        return dp[x];
    }
}