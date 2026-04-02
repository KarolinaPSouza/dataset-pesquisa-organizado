import java.util.*;

public class entry_15599589 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= x; sum++) {
            for (int coin : a) {
                if (sum - coin >= 0) {
                    dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
                }
            }
        }
        System.out.println(dp[x]);
    }
}