import java.io.*;
import java.util.*;

public class entry_13124387 {
    static int m;
 static int n;
    static int[][] dp;

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  String text1 = br.readLine();
  String text2 = br.readLine();

  br.close();

  m = text1.length();
  n = text2.length();

  dp = new int[m+1][n+1];

  for (int i = 0; i < m + 1; i++) {
   dp[i][n] = m - i;
  }

  for (int i = 0; i < n + 1; i++) {
   dp[m][i] = n - i;
  }

  for (int i = m - 1; i >= 0; i--) {
   for (int j = n - 1; j >= 0; j--) {
    if (text1.charAt(i) == text2.charAt(j)) {
     dp[i][j] = dp[i + 1][j + 1];
    } else {
     // insert
     int insert = dp[i + 1][j];
     int delete = dp[i][j + 1];
     int replace = dp[i + 1][j + 1];
     dp[i][j] = 1 + Math.min(insert, Math.min(replace, delete));
    }
   }
  }

  System.out.print(dp[0][0]);
 }

}