import java.util.Scanner;

public class entry_12895967 {
    static final int MOD = 1_000_000_007;

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

        for (int coin : coins) {
            for (int sum = coin; sum <= x; sum++) {
                dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
            }
        }

        System.out.println(dp[x]);
        sc.close();
    }
}
