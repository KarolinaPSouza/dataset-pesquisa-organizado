//package DP;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class entry_2068653 {
 public static final int MOD = 1000000007;
 public static final int INT_INF = 200000000;
 public static final long LONG_INF = (long)Math.pow(10, 15);


 public static void main(String[] args) throws IOException
 {
  FastScanner scanner = new FastScanner();
  PrintWriter out = new PrintWriter(System.out);


  int n = scanner.nextInt();
  int x = scanner.nextInt();
  int[] c = scanner.nextIntArray(n);

  int[] dp = new int[x + 1];
  dp[0] = 1;

  for (int i = 0; i < n; i++)
  { 
   for (int j = 0; j <= x; j++)
   {
    if (j - c[i] >= 0)
     dp[j] += dp[j - c[i]];

    dp[j] %= MOD;
   }
  }

  System.out.println(dp[x]);

  out.close();
 }

 private static int add(int a, int b)
 {
  if (a + b < MOD)
   return a + b;

  return a + b - MOD;
 }

 static class FastScanner
 {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next()
  {
   while (!st.hasMoreTokens())
    try
    {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e)
    {
    }
   return st.nextToken();
  }

  int nextInt()
  {
   return Integer.parseInt(next());
  }

  long nextLong()
  {
   return Long.parseLong(next());
  }

  double nextDouble()
        {
            return Double.parseDouble(next());
        }

  int[] nextIntArray(int n)
  {
   int[] arr = new int[n];

   for (int i = 0; i < n; i++)
    arr[i] = this.nextInt();

   return arr;
  }

  long[] nextLongArray(int n)
  {
   long[] arr = new long[n];

   for (int i = 0; i < n; i++)
    arr[i] = this.nextLong();

   return arr;
  }
 }
}