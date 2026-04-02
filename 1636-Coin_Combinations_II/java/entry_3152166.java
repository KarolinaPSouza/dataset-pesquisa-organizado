import java.util.*;

public class entry_3152166 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= x; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = (dp[j] + dp[j - coins[i]]) % MOD;
                }
            }
        }
        System.out.println(dp[x]);
    }
}