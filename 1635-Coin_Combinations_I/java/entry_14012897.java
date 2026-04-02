import java.util.Scanner;

public class entry_14012897 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] coins = new int[n];
        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();


        dp[0] = 1;
        for (int t = 1; t <= m; t++) {
            for (int c : coins) {
                if (c > t) continue;
                dp[t] = (dp[t] + dp[t - c])% 1_000_000_007;
            }
        }
        System.out.println(dp[m]);
    }
}
