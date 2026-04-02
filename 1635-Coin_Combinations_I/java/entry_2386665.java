import java.io.*;
import java.util.*;
import java.math.*;

public class entry_2386665 {
 public static void main(String[] args) {
  int mod = 1_000_000_007;
  int n = ni(), x = ni();

  int[] coints = new int[x];
  for (int i = 0; i < n; i++) {
   coints[i] = ni();
  }

  int[] values = new int[x + 1];
  values[0] = 1;
  for (int i = 1; i <= x; i++) {
   for (int j = 0; j < n; j++) {
    int coint = coints[j];
    if (i >= coint) {
     values[i] = values[i] + values[i - coint];
     if (values[i] >= mod) {
      values[i] -= mod;
     }
    }
   }
  }
  System.out.println(values[x]);
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