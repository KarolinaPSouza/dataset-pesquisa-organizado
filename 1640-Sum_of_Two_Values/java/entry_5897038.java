// File: entry_5897038.java
// Date: 04/15/2023
// Author: Corey Zhu

import java.io.*;
import java.util.*;

public class entry_5897038 {

    static void solve(Kattio io){
  int n = io.nextInt(); int target = io.nextInt();
  int[][] arr = new int[n][2];
  for (int i = 0; i < n; i++) {
   arr[i][0] = io.nextInt();
   arr[i][1] = i+1;
  }
  Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
  int j = n-1;
  for (int i = 0; i < n; i++) {
   while (j > 0 && arr[i][0] + arr[j][0] > target) {
    j -= 1;
   }
   if (arr[i][0] + arr[j][0] == target && i != j) {
    io.println(arr[i][1] + " " + arr[j][1]);
    return;
   }
  }
  io.println("IMPOSSIBLE");
    }

    // Run
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio();
        solve(io);
        io.close();
    }

    // IO
 static class Kattio extends PrintWriter {
  private BufferedReader r;
  private StringTokenizer st;
  // standard input
  public Kattio() { this(System.in, System.out); }
  public Kattio(InputStream i, OutputStream o) {
   super(o);
   r = new BufferedReader(new InputStreamReader(i));
  }
  // USACO-style file input
  public Kattio(String problemName) throws IOException {
   super(problemName + ".out");
   r = new BufferedReader(new FileReader(problemName + ".in"));
  }
  // returns null if no more input
  public String next() {
   try {
    while (st == null || !st.hasMoreTokens())
     st = new StringTokenizer(r.readLine());
    return st.nextToken();
   } catch (Exception e) { }
   return null;
  }
  public int nextInt() { return Integer.parseInt(next()); }
  public double nextDouble() { return Double.parseDouble(next()); }
  public long nextLong() { return Long.parseLong(next()); }
 }
}