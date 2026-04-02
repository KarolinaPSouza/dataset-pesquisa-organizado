//package CompetitiveProgramming.CSES.DynamicProgramming;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_4230791 {
 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String[] first = br.readLine().split(" ");
  int n = Integer.parseInt(first[0]);
  int x = Integer.parseInt(first[1]);
  int[] coins = new int[n];
  String[] second = br.readLine().split(" ");
  for (int i = 0; i < n; i++) {
   coins[i] = Integer.parseInt(second[i]);
  }
  br.close();
  int[][] dp = new int[n + 1][x + 1];
  dp[0][0] = 1;
  for (int i = 1; i <= n; i++) {
   for (int j = 0; j <= x; j++) {
    dp[i][j] = dp[i - 1][j];
    int left = j - coins[i - 1];
    if (left >= 0) {
     dp[i][j] += dp[i][left];
     dp[i][j] %= 1000000007;
    }
   }
  }
  System.out.println(dp[n][x]);
 }
}