import java.util.*;
public class entry_10533679 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] += dp[i - coins[j]];
                    dp[i] %= 1000000007;
                }
            }
        }

        System.out.println(dp[x]);
        scanner.close();
    }
}