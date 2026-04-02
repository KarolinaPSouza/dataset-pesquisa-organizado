//package GeeksForGeeks.algo.topicwise.searchingAlgo;

import java.io.IOException;

public class entry_828341 {
 public static void main(String[] args) throws IOException {
  java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
  String m = br.readLine();
  String n = br.readLine();
  int dp[][] = new int[m.length() + 1][n.length() + 1];
  for (int i = 0; i <= m.length(); i++) {
   for (int j = 0; j <= n.length(); j++) {
    if (i == 0)
     dp[i][j] = j;
    else if (j == 0)
     dp[i][j] = i;
    else if (m.charAt(i - 1) == n.charAt(j - 1))
     dp[i][j] = dp[i - 1][j - 1];
    else {
     dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
    }
   }
  }
  System.out.println(dp[m.length()][n.length()]);
 }

}