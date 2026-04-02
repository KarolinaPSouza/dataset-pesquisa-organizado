//package CSES;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;

public class entry_954470 {

 public static LinkedList<Integer>[] adj;
 public static int[] depth;
 public static int[] parent;
 public static boolean[] visited;

 public static Pair dfs(int curr, int ht, int pr) {
  parent[curr] = pr;
  visited[curr] = true;
  depth[curr] = ht;
  for(Integer x : adj[curr]) {
   if(!visited[x]){
    Pair get = dfs(x, ht + 1, curr);
    if(get.x != -1 && get.y != -1) {
     return get;
    }
   }else if(Math.abs(depth[x] - depth[curr]) <= 1) {
    continue;
   }else {
    return new Pair(curr, x);
   }
  }
  return new Pair(-1, -1);
 }

 public static class Pair {
  int x;
  int y;
  public Pair(int x, int y) {
   this.x = x;
   this.y = y;
  }
 }

 public static void solve() {
  int n = s.nextInt();
  int m = s.nextInt();
  adj = new LinkedList[n];
  for(int i = 0; i < n; i++) {
   adj[i] = new LinkedList<Integer>();
  }
  visited = new boolean[n];
  parent = new int[n];
  depth = new int[n];
  Arrays.fill(parent, -1);
  for(int i = 0; i < m; i++) {
   int u = s.nextInt() - 1;
   int v = s.nextInt() - 1;
   adj[u].add(v);
   adj[v].add(u);
  }
  for(int i = 0; i < n; i++) {
   if(parent[i] == -1) {
    Pair val = dfs(i, 0, -1);
    if(val.x != -1 && val.y != -1) {
     ArrayList<Integer> ans = new ArrayList<Integer>();
     int start = val.y, end = val.x;
     ans.add(start + 1);
     while(end != start) {
      ans.add(end + 1);
      end = parent[end];
     }
     ans.add(end + 1);
     out.println(ans.size());
     for(Integer x : ans) {
      out.print(x + " ");
     }
     return;
    }
   }
  }
  out.println("IMPOSSIBLE");
 }

 public static void main(String[] args) {
  new Thread(null, null, "Thread", 1 << 27) {
   public void run() {
    try {
     out = new PrintWriter(new BufferedOutputStream(System.out));
     s = new FastReader(System.in);
     solve();
     out.close();
    } catch (Exception e) {
     e.printStackTrace();
     System.exit(1);
    }
   }
  }.start();
 }

 public static PrintWriter out;
 public static FastReader s;

 public static class FastReader {

  private InputStream stream;
  private byte[] buf = new byte[4096];
  private int curChar, snumChars;

  public FastReader(InputStream stream) {
   this.stream = stream;
  }

  public int read() {
   if (snumChars == -1) {
    throw new InputMismatchException();
   }
   if (curChar >= snumChars) {
    curChar = 0;
    try {
     snumChars = stream.read(buf);
    } catch (IOException E) {
     throw new InputMismatchException();
    }
   }
   if (snumChars <= 0) {
    return -1;
   }
   return buf[curChar++];
  }

  public int nextInt() {
   int c = read();
   while (isSpaceChar(c)) {
    c = read();
   }
   int sgn = 1;
   if (c == '-') {
    sgn = -1;
    c = read();
   }
   int number = 0;
   do {
    number *= 10;
    number += c - '0';
    c = read();
   } while (!isSpaceChar(c));
   return number * sgn;
  }

  public long nextLong() {
   int c = read();
   while (isSpaceChar(c)) {
    c = read();
   }
   long sgn = 1;
   if (c == '-') {
    sgn = -1;
    c = read();
   }
   long number = 0;
   do {
    number *= 10L;
    number += (long) (c - '0');
    c = read();
   } while (!isSpaceChar(c));
   return number * sgn;
  }

  public int[] nextIntArray(int n) {
   int[] arr = new int[n];
   for (int i = 0; i < n; i++) {
    arr[i] = this.nextInt();
   }
   return arr;
  }

  public long[] nextLongArray(int n) {
   long[] arr = new long[n];
   for (int i = 0; i < n; i++) {
    arr[i] = this.nextLong();
   }
   return arr;
  }

  public String next() {
   int c = read();
   while (isSpaceChar(c)) {
    c = read();
   }
   StringBuilder res = new StringBuilder();
   do {
    res.appendCodePoint(c);
    c = read();
   } while (!isSpaceChar(c));
   return res.toString();
  }

  public String nextLine() {
   int c = read();
   while (isSpaceChar(c)) {
    c = read();
   }
   StringBuilder res = new StringBuilder();
   do {
    res.appendCodePoint(c);
    c = read();
   } while (!isEndofLine(c));
   return res.toString();
  }

  public boolean isSpaceChar(int c) {
   return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  public boolean isEndofLine(int c) {
   return c == '\n' || c == '\r' || c == -1;
  }

 }


}