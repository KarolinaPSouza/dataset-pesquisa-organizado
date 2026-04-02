import java.io.*;
import java.util.*;

public class entry_3717378 {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of coins
        int x = sc.nextInt(); // desired sum
        int[] coins = new int[n]; // arr of denominations
        int[] dp = new int[x + 1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }
        for (int c = 1; c <= n; c++) {
      for (int t = 0; t <= x; t++) {
       if(t - coins[c - 1] >= 0) {  // prevent out of bounds cases
        dp[t] += dp[t - coins[c - 1]];
        dp[t] %= 1000000007;
       }
      }
     }
        System.out.println(dp[x]);
    }

}