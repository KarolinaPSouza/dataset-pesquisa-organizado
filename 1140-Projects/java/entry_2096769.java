//package DP;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class entry_2096769 {
 public static final int MOD = 1000000007;
 public static final int INT_INF = 200000000;
 public static final long LONG_INF = (long) Math.pow(10, 15);

 public static void main(String[] args) throws IOException
 {
  FastScanner scanner = new FastScanner();
  PrintWriter out = new PrintWriter(System.out);

  int n = scanner.nextInt();

  Pair[] time = new Pair[n];

  for (int i = 0; i < n; i++)
  {
   time[i] = new Pair(scanner.nextInt(), scanner.nextInt());
   time[i].value = scanner.nextLong();
  }

  Arrays.sort(time);

  long[] dp = new long[n + 1];
  //dp[0] = time[0].value;

  for (int i = 1; i < dp.length; i++)
  {
   int l = 0, r = i - 2;
   int res = -1;

   while (l <= r)
   {
    int j = (l + r) / 2;

    if (time[j].second < time[i - 1].first)
    {
     res = j;
     l = j + 1;
    }
    else
     r = j - 1;
   }

   long search = 0;
   if (res != -1)
    search = dp[res + 1];

   dp[i] = Math.max(dp[i - 1], search + time[i - 1].value);
  }

  System.out.println(dp[dp.length - 1]);
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

class Pair implements Comparable<Pair>
{
 public int first, second;
 public long value;

 public Pair(int f, int s)
 {
  first = f;
  second = s;
 }

 @Override
 public int compareTo(Pair other)
 {

  int comp = new Integer(this.second).compareTo(other.second);

  if (comp != 0)
   return comp;

  comp = new Integer(this.first).compareTo(other.first);

  if (comp != 0)
   return comp;

  return new Integer(this.first).compareTo(other.first);
 }

 @Override
 public boolean equals(Object o)
 {
  if (o == this)
   return true;

  if (!(o instanceof Pair))
   return false;

  Pair c = (Pair) o;

  return Double.compare(first, c.first) == 0 && Double.compare(second, c.second) == 0;
 }

 public String toString()
 {
  return "(" + first + ", " + second + ")";
 }

}