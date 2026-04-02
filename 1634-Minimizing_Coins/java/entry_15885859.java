//package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_15885859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lineOne = br.readLine().split(" ");
        int n = Integer.parseInt(lineOne[0]);
        int x = Integer.parseInt(lineOne[1]);
        int[] coins = new int[n];
        String[] weights = br.readLine().split(" ");
        for (int i = 0; i<n ; i++) {
            coins[i] = Integer.parseInt(weights[i]);
        }
        minimizingCoins(coins,n, x);
    }

    private static void minimizingCoins(int[] coins, int n, int x) {
        Arrays.sort(coins);
        long[] dp = new long[x+1];
//        dp[0] = 1;
        for(int i = 1 ; i<=x ; i++) {
            long coinCount = Long.MAX_VALUE;
            for(int coin:coins) {
                if(i<coin){
                    break;
                }
                long prev = dp[i-coin];
                if(prev == Long.MAX_VALUE)
                    continue;
                long count = prev + 1;
                coinCount = Math.min(coinCount, count);
            }
            dp[i] = coinCount;
        }
        if(dp[x] == Long.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[x]);
    }

}