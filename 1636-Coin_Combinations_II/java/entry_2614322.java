//package CoinCombinationII;
import java.io.*;
import java.util.*;

public class entry_2614322 {
 public static void main(String []args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int n = Integer.parseInt(st.nextToken());
  int sum = Integer.parseInt(st.nextToken());
  int val[] = new int[n];
  st = new StringTokenizer(br.readLine());
  for(int i = 0; i < n; ++i)
   val[i] = Integer.parseInt(st.nextToken());
  int dp[][] = new int[n + 1][sum + 1];
  dp[0][0] = 1;
  for(int i = 1; i <= n; ++i) {
   for(int j = 0; j <= sum; ++j) {
    dp[i][j] = dp[i-1][j];
    int rem = j - val[i-1];
    if(rem >= 0)
     dp[i][j] = (dp[i][j] + dp[i][rem]) % 1000000007;
   }
  }
  System.out.println(dp[n][sum]);
 }
}