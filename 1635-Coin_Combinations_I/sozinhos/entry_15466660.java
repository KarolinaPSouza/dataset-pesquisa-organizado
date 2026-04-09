


import java.util.*;

public class entry_15466660 {
}

class Solution {
    public static final int mod = 1_000_000_007;

    public static int count(int[] coins, int target) {
        int n = coins.length;
        final int inf = target + 1;
        int[] dp = new int[inf];
        dp[0] = 1;

        for (int subTarget = 0; subTarget < inf; ++subTarget) {
            for (int i = 0; i < n; ++i) {
                if (coins[i] <= subTarget) {
                    dp[subTarget] += dp[subTarget - coins[i]];
                    dp[subTarget] %= mod;
                }
            }
        }

        return dp[target];
    }

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.printf("%d\n", count(coins, target));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solve();
    }
}
