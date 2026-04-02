import java.util.*;

public class entry_5165883 {
 static final int MOD = 1000000007;
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int x = sc.nextInt();

  int[] coins = new int[n];
  for (int i = 0; i < n; i++) {
   coins[i] = sc.nextInt();
  }

  // dp[w] = the number of ordered ways to add coins up to w
  int[] dp = new int[x + 1];
  dp[0] = 1;
  for (int i = 0; i < n; i++) {  // loop through coins
   for (int w = 0; w <= x; w++) {  // loop through sums
    if (w - coins[i] >= 0) {  // prevent out of bounds cases
     dp[w] = (dp[w] + dp[w - coins[i]]) % MOD;
    }
   }
  }
  System.out.println(dp[x]);
 }
}