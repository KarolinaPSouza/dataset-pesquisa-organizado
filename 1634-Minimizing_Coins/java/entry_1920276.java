//package cses;

//Completed by Dinesh Bojja on 3/31/21

import java.io.*;
import java.util.*;

public class entry_1920276 {
 public static void main (String args []) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  StringTokenizer st = new StringTokenizer(in.readLine());
  int n = Integer.parseInt(st.nextToken());
  int x = Integer.parseInt(st.nextToken());
  int[] coins = new int[n];
  int[] tot = new int[x+1];
  Arrays.fill(tot, 9999999);
  tot[0] = 0;
  st = new StringTokenizer(in.readLine());
  for (int i = 0; i < n; i++) {
   coins[i] = Integer.parseInt(st.nextToken());
   if (coins[i] <= x) tot[coins[i]] = 1;
  }
  Arrays.sort(coins);
  for (int i = 0; i <= x; i++) {
   for (int j = 0; j < coins.length; j++) {
    if (i-coins[j] > 0) tot[i] = Math.min(tot[i], tot[i-coins[j]] + 1);
   }
  }
  if (tot[x] >= 9999999) tot[x] = -1;
  out.println(tot[x]);
  out.close();
  in.close();
 }
}