//This code is written by प्रविण शंखपाळ 

//package wizard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

 public class entry_1961381 {

 static long mod = (long) 1e9 + 7;

 public static void main(String[] args) {

//  try {

  FastReader fr = new FastReader();
  BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

//   Apartments

//   int n = fr.nextInt(), m = fr.nextInt(), k = fr.nextInt();
//
//   int A[] = new int[n];
//   int B[] = new int[m];
//
//   for (int i = 0; i < n; i++) {
//    A[i] = fr.nextInt();
//
//   }
//
//   for (int i = 0; i < m; i++) {
//
//    B[i] = fr.nextInt();
//
//   }
//   Arrays.sort(A);
//   Arrays.sort(B);
//   int ans = 0, j = 0;
//
//   for (int i = 0; i < n; i++) {
//
//    while (j < m && B[j] < A[i] - k) {
//
//     j++;
//    }
//
//    if (j < m && B[j] <= A[i] + k) {
//     ans++;
//     j++;
//    }
//
//   }
//
//   System.out.println(ans);

//   Ferris wheel

//   int n = fr.nextInt(), x = fr.nextInt();
//
//   int A[] = new int[n];
//
//   for (int i = 0; i < n; i++) {
//
//    A[i] = fr.nextInt();
//
//   }
//
//   int j = n - 1, ans = 0;
//
//   for (int i = 0; i < j;) {
//
//    while (i < j && A[i] + A[j] > x) {
//
//     j--;
//    }
//
//    if (i < j && A[i] + A[j] <= x) {
//     ans++;
//     i++;
//     j--;
//    }
//
//   }
//   
//   System.out.println(n-ans);

//   concert tickets

//  int n = fr.nextInt(), m = fr.nextInt();
//
//  int A[] = new int[n];
//  int B[] = new int[m];
//
//  for (int i = 0; i < n; i++) {
//   A[i] = fr.nextInt();
//  }
//  for (int i = 0; i < m; i++) {
//   B[i] = fr.nextInt();
//  }
//
//  Arrays.sort(A);
//  Arrays.sort(B);
//
//  boolean flag = false;
//
//  for (int i = 0, j = 0; i < n && j < m;) {
//
//   if (i < n) {
//
//    while (B[j] >= A[i]) {
//
//     i++;
//     flag = true;
//
//     if (i >= n) {
//      break;
//     }
//    }
//
//   }
//
//   System.out.println(flag ? A[i - 1] : -1);
//   flag = false;
//
//   j++;
//
//  }

//  maximum subarray sum

//  int n = fr.nextInt();
//
//  long local = (long) -1e18;
//  long global = (long) -1e18;
//
//  for (int i = 0; i < n; i++) {
//
//   long a = fr.nextLong();
//
//   local = Math.max(a, local + a);
//   global = Math.max(local, global);
//
//  }
//
//  System.out.println(global);

//  stick length

//  int n = fr.nextInt();
//
//  long A[] = new long[n];
//  long sum = 0, sum1 = 0;
//
//  for (int i = 0; i < n; i++) {
//   A[i] = fr.nextLong();
//   sum += A[i];
//
//  }
//
//  Arrays.sort(A);
//
//  long pp = A[n / 2];
//
//  for (int i = 0; i < n; i++) {
//
//   sum1 += Math.abs(pp - A[i]);
//
//  }
//
//  System.out.println(sum1);

//  *********************************************************************************************************************************************************************
//                                                                               dp
//        Minimizing coins

  int n = fr.nextInt(), x = fr.nextInt();
  int A[] = new int[(int) 1e6 + 1];

  for (int i = 0; i < n; i++) {
   A[i] = fr.nextInt();
  }

  int dp[] = new int[(int) 1e6 + 1];

  for (int i = 1; i <= x; i++) {

   dp[i] = (int) 1e9;

   for (int j = 0; j < n; j++) {

    if (A[j] <= i) {

     dp[i] = Math.min(dp[i], dp[i - A[j]] + 1);

    }
   }

  }
  System.out.println(dp[x] >= (int) 1e9 ? -1 : dp[x]);

//  Coin Combinations 1

//  int n = fr.nextInt(), x = fr.nextInt();
//
//  int A[] = new int[(int) 1e6 + 1];
//
//  for (int i = 0; i < n; i++) {
//
//   A[i] = fr.nextInt();
//
//  }
//
//  int dp[] = new int[(int) 1e6 + 1];
//
//  dp[0] = 1;
//  int mod = (int) 1e9 + 7;
//
//  for (int i = 1; i <= x; i++) {
//
//   for (int j = 0; j < n; j++) {
//
//    if (i >= A[j]) {
//
//     dp[i] = (dp[i - 1] + dp[i - A[j]]) % mod;
//     dp[i] %= mod;
//
//    }
//
//   }
//
//  }System.out.println(dp[x]);

//   } catch (
//
//  Exception e) {
//   return;
//  }
 }

 static class Pair implements Comparable<Pair> {
  int a, b;

  Pair(int a, int b) {
   this.a = a;
   this.b = b;
  }

  public int compareTo(Pair o) {
   // TODO Auto-generated method stub
   if (this.a != o.a)
    return Integer.compare(this.a, o.a);
   else
    return Integer.compare(this.b, o.b);
   // return 0;
  }

  public boolean equals(Object o) {
   if (o instanceof Pair) {
    Pair p = (Pair) o;
    return p.a == a && p.b == b;
   }
   return false;
  }

 }

 static int binarySearch(int arr[], int first, int last, int key) {
  int mid = (first + last) / 2;
  while (first <= last) {
   if (arr[mid] < key) {
    first = mid + 1;
   } else if (arr[mid] == key) {
    return mid;
   } else {
    last = mid - 1;
   }
   mid = (first + last) / 2;
  }
  return -1;
 }

 static class FastReader {
  BufferedReader br;
  StringTokenizer st;

  public FastReader() {
   br = new BufferedReader(new InputStreamReader(System.in));
  }

  String next() {
   while (st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  long nextLong() {
   return Long.parseLong(next());
  }

  double nextDouble() {
   return Double.parseDouble(next());
  }

  String nextLine() {
   String str = "";
   try {
    str = br.readLine();
   } catch (IOException e) {
    e.printStackTrace();
   }
   return str;
  }
 }
}
