import java.util.*;

public class entry_14350738 {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] coins = new int[n];
        for(int i = 0; i < n; i++) coins[i] = sc.nextInt();

        int[] dp = new int[x + 1];
        dp[0] = 1;
        for(int i = 1; i <= x; i++) {
            for(int coin: coins) {
                if(i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
        }
        System.out.print(dp[x]);
        sc.close();
    }
}