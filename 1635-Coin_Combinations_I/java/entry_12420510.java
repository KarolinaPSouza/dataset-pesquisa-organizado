import java.util.*;

public class entry_12420510 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int i = 1; i <= x; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);
    }
}