import java.io.*;
import java.util.*;

public class entry_2592576 {

 public static void main(String[] args) {
  long limit = 500000000001l;
  int n = ni(), m = ni(), q = ni();

  long[][] dp = new long[n + 1][n + 1];

  for (int i = 1; i <= n; i++) {
   Arrays.fill(dp[i], limit);
   dp[i][i] = 0;
  }

  for (int i = 0; i < m; i++) {
   int u = ni(), v = ni(), length = ni();
   int min = (int) Math.min(dp[u][v], length);

   dp[u][v] = min;
   dp[v][u] = min;
  }

  for (int k = 1; k <= n; k++) {
   for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
     if (dp[i][k] == limit || dp[k][j] == limit) {
      continue;
     }
     dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
    }
   }
  }

  StringBuilder sb = new StringBuilder();
  for (int i = 0; i < q; i++) {
   int u = ni(), v = ni();

   if (dp[u][v] != limit) {
    sb.append(dp[u][v]).append('\n');
   } else {
    sb.append("-1\n");
   }
  }
  System.out.print(sb);

 }

 static InputStream is = System.in;
 static byte[] inbuf = new byte[1 << 24];
 static int lenbuf = 0, ptrbuf = 0;

 static int readByte() {
  if (lenbuf == -1)
   throw new InputMismatchException();
  if (ptrbuf >= lenbuf) {
   ptrbuf = 0;
   try {
    lenbuf = is.read(inbuf);
   } catch (IOException e) {
    throw new InputMismatchException();
   }
   if (lenbuf <= 0)
    return -1;
  }
  return inbuf[ptrbuf++];
 }

 static boolean isSpaceChar(int c) {
  return !(c >= 33 && c <= 126);
 }

 static boolean isSpaceChar2(int c) {
  return !(c >= 32 && c <= 126);
 }

 static int skip() {
  int b;
  while ((b = readByte()) != -1 && isSpaceChar(b))
   ;
  return b;
 }

 static double nd() {
  return Double.parseDouble(ns());
 }

 static char nc() {
  return (char) skip();
 }

 static String ns() {
  int b = skip();
  StringBuilder sb = new StringBuilder();
  while (!(isSpaceChar(b))) {
   sb.appendCodePoint(b);
   b = readByte();
  }
  return sb.toString();
 }

 static String nextLine() {
  int b = skip();
  StringBuilder sb = new StringBuilder();
  while (!(isSpaceChar2(b))) {
   sb.appendCodePoint(b);
   b = readByte();
  }
  return sb.toString();
 }

 static char[] ns(int n) {
  char[] buf = new char[n];
  int b = skip(), p = 0;
  while (p < n && !(isSpaceChar(b))) {
   buf[p++] = (char) b;
   b = readByte();
  }
  return n == p ? buf : Arrays.copyOf(buf, p);
 }

 static int ni() {
  int num = 0, b;
  boolean minus = false;
  while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
   ;
  if (b == '-') {
   minus = true;
   b = readByte();
  }
  while (true) {
   if (b >= '0' && b <= '9') {
    num = num * 10 + (b - '0');
   } else {
    return minus ? -num : num;
   }
   b = readByte();
  }
 }

 static long nl() {
  long num = 0;
  int b;
  boolean minus = false;
  while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
   ;
  if (b == '-') {
   minus = true;
   b = readByte();
  }
  while (true) {
   if (b >= '0' && b <= '9') {
    num = num * 10 + (b - '0');
   } else {
    return minus ? -num : num;
   }
   b = readByte();
  }
 }

}