import java.util.*;

public class entry_14980754 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        sc.close();

        long[] dp = new long[x + 1];
        dp[0] = 1;  // base case
        for (int coin : coins){
            for (int i = 1; i <= x; i++)  {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
        }

        System.out.println(dp[x]);
    }
}