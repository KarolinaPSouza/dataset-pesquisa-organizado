import java.util.Scanner;

public class entry_11152811 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of coins and the desired sum
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // Initialize dp array
        int[] dp = new int[x + 1];
        dp[0] = 1;

        // Fill the dp array using the coins
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = (dp[i] + dp[i - coins[j]]) % MOD;
                }
            }
        }

        // Print the result
        System.out.println(dp[x]);
        scanner.close();
    }
}