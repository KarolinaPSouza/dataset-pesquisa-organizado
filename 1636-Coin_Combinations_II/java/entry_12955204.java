// package DynamicProgramming;

import java.util.Scanner;

public class entry_12955204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int amount = sc.nextInt();
        int[] coins = new int[x];
        for(int i =0;i<x;i++){
            coins[i] = sc.nextInt();
        }
        int mod = 1000000007;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin: coins){
            for(int i = 0;i<=amount;i++){
                if(i >= coin){
                    dp[i] = (dp[i] + dp[i- coin]) % mod;
                }
            }
        }
        System.out.println(dp[amount]);
    }

}