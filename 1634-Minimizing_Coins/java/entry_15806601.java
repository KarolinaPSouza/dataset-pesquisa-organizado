import java.util.*;

public class entry_15806601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();

        int INF = (int)1e9;
        int[] dp = new int[x + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        System.out.println(dp[x] == INF ? -1 : dp[x]);
    }
}