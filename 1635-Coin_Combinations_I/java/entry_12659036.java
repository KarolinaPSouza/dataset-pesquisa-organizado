import java.util.*;

public class entry_12659036 {

        static final int MOD = 1000000007;

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);

            int n = s.nextInt();  // number of coin types
            int x = s.nextInt();  // target sum

            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = s.nextInt();
            }

            int[] dp = new int[x + 1];
            dp[0] = 1;  // Base case: 1 way to make sum 0

            for (int i = 1; i <= x; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        dp[i] = (dp[i] + dp[i - coin]) % MOD;
                    }
                }
            }

            System.out.println(dp[x]);
        }


}