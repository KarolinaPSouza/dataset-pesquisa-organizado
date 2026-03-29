import java.util.*;

public class entry_9829378 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int maxW = scn.nextInt();
        int[] wt = new int[n];
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) wt[i] = scn.nextInt();
        for (int i = 0; i < n; i++) prices[i] = scn.nextInt();

        int[] dp = new int[maxW + 1];

        for (int i = 0; i < n; i++) {
            for (int j = maxW; j >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], prices[i] + dp[j - wt[i]]);
            }
        }

        int ans = dp[maxW];
        System.out.println(ans);
        scn.close();
    }
}