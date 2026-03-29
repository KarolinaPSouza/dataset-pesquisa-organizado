//package CSES.DP07Jan;

import java.io.*;
import java.util.*;

public class entry_1517720 {
 public static void main(String[] args) throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String[] scn = br.readLine().trim().split(" ");
  int n = Integer.parseInt(scn[0]);
  pair[] arr = new pair[n];
  for (int i = 0; i < n; i++) {
   scn = br.readLine().trim().split(" ");
   int start = Integer.parseInt(scn[0]);
   int end = Integer.parseInt(scn[1]);
   int money = Integer.parseInt(scn[2]);
   arr[i] = new pair(start, end, money);
  }
  fun(arr, n);
 }

 static class pair {
  int start, end, money;

  pair(int start, int end, int money) {
   this.start = start;
   this.end = end;
   this.money = money;
  }
 }

 private static void fun(pair[] arr, int n) {
  Arrays.sort(arr, (a, b) -> {
   if (a.end == b.end) {
    return a.start - b.start;
   }
   return a.end - b.end;
  });
  int[] dp = new int[n];
  long[] costs = new long[n];
  long max = 0;
  for (int i = 0; i < n; i++) {
   int idx = bs(dp, i, arr[i].start);
   dp[i] = arr[i].end;
   costs[i] =arr[i].money;
   if (idx >= 0) {
    costs[i] += costs[idx];
   }
   if(i!=0)
   costs[i] = Math.max(costs[i-1],costs[i]);

//   System.out.println(idx + " " + dp[i] + " " + costs[i] + " " + arr[i].money);
  }
  System.out.println(costs[n-1]);
 }

 public static int bs(int[] arr, int end, int item) {
  int i = 0;
  int j = end - 1;
  while (i <= j) {
   int mid = (i + j) / 2;
   if (arr[mid] >= item) {
    j = mid - 1;
   } else {
    if (mid + 1 == end || arr[mid + 1] >= item) {
     return mid;
    } else {
     i = mid + 1;
    }
   }
  }
  return -i - 1;
 }

}