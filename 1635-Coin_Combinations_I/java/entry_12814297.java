//https://cses.fi/problemset/task/1635

//package DSA.DynamicProgramming.CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_12814297 {
    public static void main(String[] args) throws IOException {
        final int MOD = 1_000_000_007;

        // Input Reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int sum = Integer.parseInt(temp[1]);

        int[] coins = new int[n];
        temp = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(temp[i]);



        // Programming Logic
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for(int target = 1; target <= sum; target++)
            for(int coin : coins)
                if(target - coin >= 0)
                    dp[target] = (dp[target] + dp[target - coin]) % MOD;

        System.out.print(dp[sum]);
    }
}