import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_10272169 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();

    int n = s1.length();
    int m = s2.length();
    // int[][] dp = new int[n + 1][m + 1];

    // for (int[] row : dp) {
    //   for (int i = 0; i < row.length; i++) {
    //     row[i] = -1;
    //   }
    // }

    System.out.println(iterative(s1, s2));
  }

  // public static int rec(int p1, String s1, int p2, String s2, int[][] dp) {
  //   if (p1 == s1.length()) return s2.length() - p2;
  //   if (p2 == s2.length()) return s1.length() - p1;
  //   if (dp[p1][p2] != -1) return dp[p1][p2];

  //   if (s1.charAt(p1) == s2.charAt(p2)) {
  //     return dp[p1][p2] = rec(p1 + 1, s1, p2 + 1, s2, dp);
  //   }

  //   int insert = 1 + rec(p1, s1, p2 + 1, s2, dp);
  //   int delete = 1 + rec(p1 + 1, s1, p2, s2, dp);
  //   int replace = 1 + rec(p1 + 1, s1, p2 + 1, s2, dp);

  //   return dp[p1][p2] = Math.min(insert, Math.min(delete, replace));
  // }

  private static int iterative( String s1, String s2 ){
    int n = s1.length();
    int m = s2.length();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        }
      }
    }

    return dp[n][m];
  }
}