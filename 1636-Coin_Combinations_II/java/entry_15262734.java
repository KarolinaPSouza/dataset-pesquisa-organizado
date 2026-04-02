import java.util.*;

public class entry_15262734 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        long[] dp = new long[x + 1];
        dp[0] = 1; 

        for (int coin : coins) {
            for (int i = coin; i <= x; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        System.out.println(dp[x]);
        sc.close();
    }
}