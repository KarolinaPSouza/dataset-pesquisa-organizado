import java.util.*;
import java.io.*;

public class entry_12067795 {
 static InputStream inputStream;
 static OutputStream outputStream;
 static InputReader in;
 static PrintWriter out;
 static int MULTIPLE_TESTCASES = 0;
 static String PROB_NAME = "";

 ///////////////////////////////////////
 // solution
 ///////////////////////////////////////
 static class Solution {

  public void solve(int tc) throws IOException {
   int n = in.ni(), m = in.ni(), q = in.ni();
   long[][] dp = new long[n][n];
   long INF = (long) 1e18;
   for (int i = 0; i < n; ++i) {
    Arrays.fill(dp[i], INF);
    dp[i][i] = 0L;
   }
   for (int i = 0; i < m; ++i) {
    int x = in.ni(), y = in.ni();
    long w = in.nl();
    --x;
    --y;
    dp[x][y] = Math.min(dp[x][y], w);
    dp[y][x] = Math.min(dp[y][x], w);
   }
   for (int k = 0; k < n; ++k) {
    for (int i = 0; i < n; ++i) {
     for (int j = i + 1; j < n; ++j) {
      dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
      dp[j][i] = dp[i][j];
     }
    }
   }
   for (int i = 0; i < q; ++i) {
    int u = in.ni(), v = in.ni();
    --u;
    --v;
    out.println(dp[u][v] == INF ? -1 : dp[u][v]);
   }
  }
 }

 private static void precompute() {

 }

 ///////////////////////////////////////
 // template
 ///////////////////////////////////////
 public static void main(String[] args) throws IOException {
  inputStream = System.in;
  outputStream = System.out;
  if (PROB_NAME != "") {
   inputStream = new FileInputStream(new File(PROB_NAME + ".in"));
   outputStream = new FileOutputStream(new File(PROB_NAME + ".out"));
  }
  in = new InputReader(inputStream);
  out = new PrintWriter(outputStream);
  int tc = 1;
  if (MULTIPLE_TESTCASES > 0)
   tc = in.ni();
  precompute();
  Solution sol = new Solution();
  for (int i = 1; i <= tc; ++i) {
   sol.solve(i);
  }
  in.close();
  out.close();
 }

 static class InputReader {
  BufferedReader reader;
  StringTokenizer st;

  public InputReader(InputStream in) {
   reader = new BufferedReader(new InputStreamReader(in));
   st = null;
  }

  public String ns() throws IOException {
   while (st == null || !st.hasMoreTokens()) {
    st = new StringTokenizer(reader.readLine());
   }
   return st.nextToken();
  }

  public Long nl() throws IOException {
   return Long.parseLong(ns());
  }

  public Integer ni() throws IOException {
   return Integer.parseInt(ns());
  }

  public int[] nia(int n) throws IOException {
   int[] a = new int[n];
   for (int i = 0; i < n; ++i) {
    a[i] = ni();
   }
   return a;
  }

  public long[] nla(int n) throws IOException {
   long[] a = new long[n];
   for (int i = 0; i < n; ++i) {
    a[i] = nl();
   }
   return a;
  }

  public void close() throws IOException {
   reader.close();
  }
 }
}