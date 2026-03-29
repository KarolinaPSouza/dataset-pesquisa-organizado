/******************************************************************************
                             Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.
 *******************************************************************************/
import java.util.*;
import java.io.*;
public class entry_11544361 {
 public static void main(String[] args) throws IOException {
  BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

  String[] s0 = sc.readLine().split(" ");
  int n = Integer.parseInt(s0[0]);
  int t = Integer.parseInt(s0[1]);
  int[] cost = new int[n];
  int[] pages = new int[n];
  String[] s1 = sc.readLine().split(" ");
  String[] s2 = sc.readLine().split(" ");
  int i = 0;
  for(String ch:s1){
      cost[i] = Integer.parseInt(ch);
      i++;
  }
  i = 0;
  for(String ch: s2){
      pages[i] = Integer.parseInt(ch);
      i++;
  }

  int[][] dp = new int[n+1][t+1]; //dp[i][j] -> max pages upto ith index with target j

  for(i = 1;i<=n;i++){
      for(int j = 1;j<=t;j++){
             dp[i][j] = dp[i-1][j];
          if(j - cost[i-1] >= 0)
              dp[i][j] = Math.max(dp[i][j],dp[i-1][j-cost[i-1]]+pages[i-1]);
      }
  }
  System.out.print(dp[n][t]);
 }
}