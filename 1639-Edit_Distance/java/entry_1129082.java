import java.util.*;
import java.io.*;

/**
 * Made by egor https://github.com/chermehdi/egor.
 * 
 * @author Azuz
 * 
 */
public class entry_1129082 {

    void solve(Scanner in, PrintWriter out) {
      char[] a = in.next().toCharArray();
      char[] b = in.next().toCharArray();

      int n = a.length, m = b.length;
      int[][] dp = new int[n + 1][m + 1];
      for (int i = 0; i <= n || i <= m; ++i) {
        if (i <= n) dp[i][0] = i;
        if (i <= m) dp[0][i] = i;
      }

      for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= m; ++j) {
          int diff = a[i - 1] == b[j - 1] ? 0 : 1;
          dp[i][j] = Math.min(
              dp[i - 1][j] + 1, Math.min(
                dp[i][j - 1] + 1, dp[i - 1][j - 1] + diff
                ));
        }
      }

      out.println(dp[n][m]);
    }

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      PrintWriter out = new PrintWriter(System.out);
      new entry_1129082().solve(in, out);
      out.close();
    }

}