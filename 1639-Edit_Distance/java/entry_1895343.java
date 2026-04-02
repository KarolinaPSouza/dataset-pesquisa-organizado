// package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class entry_1895343 {
 static final int MOD = 1000000007;
 static int dp[][];

 public static void main(String[] args) {
  FastScanner in = new FastScanner();
  char ch1[] = in.next().toCharArray();
  char ch2[] = in.next().toCharArray();
  int n = ch1.length;
  int m = ch2.length;
  dp = new int[n + 1][m + 1];
  System.out.println(edit(ch1, ch2, n, m));
 }

 public static int edit(char x[], char y[], int n, int m) {
  if (n == 0)
   return m;
  if (m == 0)
   return n;
  if (dp[n][m] > 0)
   return dp[n][m];
  if (x[n - 1] == y[m - 1]) {
   int ans = edit(x, y, n - 1, m - 1);
   dp[n][m] = ans;
   return ans;
  } else {
   int ans = 1 + Math.min(edit(x, y, n - 1, m), Math.min(edit(x, y, n, m - 1), edit(x, y, n - 1, m - 1)));
   dp[n][m] = ans;
   return ans;
  }
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