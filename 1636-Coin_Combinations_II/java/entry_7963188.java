//package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_7963188 {
    static int mod = 1000000007;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int x = Integer.parseInt(input1[1]);

        int[] coins = new int[n];
        String[] input2 = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(input2[i]);
        }

        int[] dp = new int[x+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= x ; j++) {
                if (j>=coins[i]) {
                    dp[j] = (dp[j] + dp[j-coins[i]])%mod;
                }
            }
        }

        System.out.println(dp[x]);
    }
}