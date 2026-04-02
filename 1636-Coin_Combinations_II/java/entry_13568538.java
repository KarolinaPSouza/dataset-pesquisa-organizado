//package CSES;

import java.util.Arrays;
import java.util.Scanner;

public class entry_13568538 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] coins = new int[n], dp = new int[target+1];
        int MOD = (int)(1e9+7);

        for(int i = 0; i < n; i++) coins[i] = sc.nextInt();
        Arrays.fill(dp, 0);
        Arrays.sort(coins);

        dp[0] = 1;
        for(int e: coins) {
            for(int t = 1; t <= target; t++) {
                if(t-e >= 0) dp[t] = (dp[t] + dp[t-e]) % MOD;
            }
        }

        System.out.println(dp[target]);
    }
}