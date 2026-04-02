import java.util.*;

public class entry_13274277 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of coin types
        int x = sc.nextInt(); // Target sum

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int INF = Integer.MAX_VALUE - 1; // Prevent overflow when adding 1
        int[] dp = new int[x + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0; // Base case

        for (int coin : coins) {
            for (int i = coin; i <= x; i++) {
                if (dp[i - coin] != INF) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        System.out.println(dp[x] == INF ? -1 : dp[x]);
    }
}