//package EditDistance;
import java.io.*;

public class entry_2718201 {
 public static void main(String []args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String str1 = br.readLine();
  String str2 = br.readLine();

  int n = str1.length();
  int m = str2.length();
  int dp[][] = new int[m + 1][n + 1];

  for(int i = 0; i <= m; ++i) 
   dp[i][0] = i;
  for(int j = 0; j <= n; ++j)
   dp[0][j] = j;

  for(int i = 1; i <= m; ++i) {
   for(int j = 1; j <= n; ++j) {
    dp[i][j] = dp[i-1][j-1];
    if(str1.charAt(j-1) != str2.charAt(i-1)) {
     int temp = Math.min(dp[i-1][j], dp[i][j-1]);
     dp[i][j] = Math.min(dp[i][j], temp) + 1;
    }
   }
  }
  System.out.println(dp[m][n]);
 }
}