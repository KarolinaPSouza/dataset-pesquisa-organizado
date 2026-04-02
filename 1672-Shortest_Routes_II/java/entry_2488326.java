import java.io.*;
import java.util.*;

public class entry_2488326 {
 static long MAX = Long.MAX_VALUE / 2;

 public static void main(String[] args) {
  int n = ni(), m = ni(), q = ni();
  long[][] matrix = new long[n][n];
  for (var i = 0; i < n; i++) {
   Arrays.fill(matrix[i], MAX);
   matrix[i][i] = 0;
  }
  for (int i = 0; i < m; i++) {
   int u = ni() - 1, v = ni() - 1, w = ni();
   matrix[u][v] = Math.min(matrix[u][v], w);
   matrix[v][u] = Math.min(matrix[v][u], w);
  }

  for (var i = 1; i < n; i++) {
   for (var j = i - 1; j >= 0; j--) {
    for (var k = j - 1; k >= 0; k--) {
     matrix[i][k] = Math.min(matrix[i][k], matrix[i][j] + matrix[j][k]);
     matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[j][k]);
     matrix[j][k] = Math.min(matrix[j][k], matrix[i][j] + matrix[i][k]);
    }
   }
  }
  for (var i = 1; i < n; i++) {
   for (var j = i - 1; j >= 0; j--) {
    for (var k = j - 1; k >= 0; k--) {
     matrix[i][k] = Math.min(matrix[i][k], matrix[i][j] + matrix[j][k]);
     matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[j][k]);
     matrix[j][k] = Math.min(matrix[j][k], matrix[i][j] + matrix[i][k]);
    }
   }
  }

  StringBuilder outBuffer = new StringBuilder();
  for (var i = 0; i < q; i++) {
   int u = ni() - 1, v = ni() - 1;
   if (u > v) {
    outBuffer.append(matrix[u][v] != MAX ? matrix[u][v] : -1).append("\n");
   } else if (u < v) {
    outBuffer.append(matrix[v][u] != MAX ? matrix[v][u] : -1).append("\n");
   } else {
    outBuffer.append("0\n");
   }
  }
  System.out.println(outBuffer);
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