import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class entry_1473460 {

 static int mod = (int) 1e9 + 7;

 public static void main(String[] args) {
  FastScanner fs = new FastScanner();
  int n = fs.nextInt();
  int capacity = fs.nextInt();
  int[] cost = fs.readArray(n);
  int[] pages = fs.readArray(n);

  int[][] dp = new int[n + 1][capacity + 1];
  // dp[i][j] = max pages you can get from the subset up to ith book for capacity
  // of j

  for (int i = 1; i <= n; i++) {
   int c = cost[i - 1];
   int p = pages[i - 1];
   for (int j = capacity; j > 0; j--) {
    dp[i][j] = dp[i - 1][j];
    if (j >= c) {
     dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - c] + p);
    }
   }
  }
  System.out.println(dp[n][capacity]);
 }

 static void sort(int[] a) {
  ArrayList<Integer> l = new ArrayList<>();
  for (int i : a)
   l.add(i);
  Collections.sort(l);
  for (int i = 0; i < a.length; i++)
   a[i] = l.get(i);
 }

 static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  int[] readArray(int n) {
   int[] a = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  long nextLong() {
   return Long.parseLong(next());
  }
 }

}