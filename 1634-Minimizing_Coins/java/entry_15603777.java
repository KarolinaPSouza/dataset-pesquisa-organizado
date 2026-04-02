// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class entry_15603777 {
 public static void main(String[] args) throws IOException {
  Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int target = scan.nextInt();
        int[] dp = new int[target+1];
        Arrays.fill(dp, (int)(1e9));
        dp[0] = 0;

        int[] coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = scan.nextInt();
        }

        for(int i=1; i<=target; i++) {
            for(int c : coins) {
                if(i >= c) {
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }
        }

        System.out.println(dp[target] == (int)(1e9) ? -1 : dp[target]);
 }
}