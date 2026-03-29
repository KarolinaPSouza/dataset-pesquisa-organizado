import java.io.*;
import java.util.*;

public class entry_2711503 {
  static PrintWriter out = new PrintWriter((System.out));
  static Reader sc = new Reader();
  static int MOD = (int) Math.pow(10, 9) + 7;

  public static void main(String args[]) throws IOException {

    // int t = sc.nextInt();
    // while (t-- > 0) {
    solve();
    // }
    out.close();
  }

  public static void solve() {
    int n = sc.nextInt();
    int sum = sc.nextInt();
    int[][] dp = new int[n + 1][sum + 1];
    int[] books = new int[n];
    int[] pages = new int[n];
    for (int i = 0; i < n; i++) {
      books[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      pages[i] = sc.nextInt();
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= sum; j++) {
        dp[i][j] = dp[i - 1][j];
        int left = j - books[i - 1];
        if (left >= 0) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][left] + pages[i - 1]);
        }
      }
    }
    out.println(dp[n][sum]);
  }

  static class Reader {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    public String next() {
      while (!st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public String nextLine() {
      try {
        return br.readLine();
      } catch (Exception e) {
        e.printStackTrace();
      }
      return null;
    }

    public boolean hasNext() {
      String next = null;
      try {
        next = br.readLine();
      } catch (Exception e) {
      }
      if (next == null) {
        return false;
      }
      st = new StringTokenizer(next);
      return true;
    }
  }
}