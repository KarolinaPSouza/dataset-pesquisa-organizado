//package com.example.codesnippets.competitiveprogramming;

import java.util.Scanner;

public class entry_2343562 {

    public static void main(String[] args) {

        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();
        int x = sca.nextInt();

        int coins[] = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sca.nextInt();
        }

        System.out.println(combinations(coins, x));

    }

    static int combinations(int[] coins, int n) {

        int[] dp = new int[n + 1];
        for(int i = 0; i < dp.length; i++)
            dp[i] = 0;

        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(i - coins[j] >= 0) {
                    dp[i] = (dp[i] + dp[i - coins[j]]) % 1000000007;
                }
            }
        }

        return dp[n];

    }

}
