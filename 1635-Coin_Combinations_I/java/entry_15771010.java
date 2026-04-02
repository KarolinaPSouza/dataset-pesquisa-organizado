import java.util.*;

public class entry_15771010 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.sort(coins); 

        int mod = 1000000007;
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            int ways = 0;
            for (int c : coins) {
                if (c > i) break;
                ways += dp[i - c];
                if (ways >= mod) ways -= mod;
            }
            dp[i] = ways;
        }

        System.out.println(dp[target]);
    }
}