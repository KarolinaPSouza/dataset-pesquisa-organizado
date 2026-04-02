//package org.example.Dp.CSES;

import java.util.Scanner;

public class entry_11105170 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int mod = (int) 1e9 + 7;
        int n = read.nextInt();
        int target = read.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<coins.length;i++)
            coins[i] = read.nextInt();
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=0;i<=target;i++)
        {
            if(dp[i] == 0)
                continue;

            for(int coin : coins)
            {
                if(i + coin <= target)
                dp[i + coin] = (dp[i + coin] + dp[i]) % mod;
            }

        }

        System.out.println(dp[target]);


    }
}