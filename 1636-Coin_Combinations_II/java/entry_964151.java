//package CSES;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class entry_964151 {

 public static final long mod = (long)1e9 + 7;

 public static void solve() {
  int n = s.nextInt();
  int x = s.nextInt();
  int[] c = new int[n];
  for(int i = 0; i < n; i++) {
   c[i] = s.nextInt();
  }
  long[] dp = new long[x + 1];
  dp[0] = 1L;
  for(int i = 0; i < n; i++) {
   for(int j = 0; j <= x; j++) {
    int to = j + c[i];
    if(to <= x) {
     dp[to] += dp[j];
     if(dp[to] >= mod) dp[to] -= mod;
    }
   }
  }
  out.println(dp[x]);
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