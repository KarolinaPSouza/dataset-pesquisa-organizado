import java.util.Arrays;
import java.util.Scanner;

public class entry_10645029 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of coins
        int x = sc.nextInt(); // desired sum

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        Arrays.fill(dp, x + 1);
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != x + 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        System.out.println(dp[x] > x ? -1 : dp[x]);

    }
}