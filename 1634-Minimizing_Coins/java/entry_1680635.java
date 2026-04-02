//package cses;

import java.util.Arrays;
import java.util.Scanner;

public class entry_1680635 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        int t = scan.nextInt();
        int[] coins = new int[c], dp = new int[t + 100];
        Arrays.fill(dp, Integer.MAX_VALUE/3);
        for(int i = 0;i<c;i++){
            coins[i] = scan.nextInt();
            if(coins[i] <= t) dp[coins[i]] = 1;
        }
        for(int i = 1;i<=t;i++){
            for(int j : coins){
                if(i - j > 0) dp[i] = Math.min(dp[i], dp[i-j]+1);
            }
        }
        if(dp[t] != Integer.MAX_VALUE/3) System.out.println(dp[t]);
        else System.out.println(-1);
    }
}