import java.io.*;
import java.util.*;
import java.math.*;

/* 1 is divisor of 1..n, 2 is divisor of 2, 4..[n/2]*2 ...
 * Sum = 1*[n/1] + 2*[n/2] ...+ i*[n/i]
 * Sum = n-n%1   + n-(n%2) ...+ n-(n%i)
 * For 10^6...10^12 => Calculate for each segment [A..B] like the example: 
 * Let A=[n/5]+1...<=i<=...[n/4]=B => n%i = reverse(n%B, n%B+4, n%B+8...n%A) = C
 * Sum[X..Y] = (Y-X)*N - Sum(C)
 */
public class entry_2367263 {
 public static void main(String[] args) {
  int mod = 1_000_000_000 + 7;
  long n = nl();
  long sqrt = (int) Math.sqrt(n);
  long mid = n / sqrt;

  //mid = n;
  long sum = 0;
  for (int i = 1; i <= mid; i++) {
   sum += n / i * i;
   // sum += n - n % i;
  }
  sum %= mod;

  for (long j = n / mid; j > 1; j--) {
   long A = n / j + 1, B = n / (j - 1);
   long fA = n - n % A, fB = n - n % B;
   long nItem = ((fB - fA) / (j - 1) + 1);
   long temp = fA + fB;
   if (nItem % 2 == 0) {
    nItem /= 2;
   } else {
    temp /= 2;
   }
   // sum += nItem * (fA + fB) / 2;
   sum += (nItem % mod) * (temp % mod);
   sum %= mod;
  }

  System.out.println(sum);
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