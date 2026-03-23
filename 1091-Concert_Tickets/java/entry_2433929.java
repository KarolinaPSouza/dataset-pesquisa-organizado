import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class entry_2433929 {
 static InputStream is = System.in;
 static TreeMap<Integer, Integer> priceTickets = new TreeMap<Integer, Integer>();

 public static void main(String[] args) {
  int n = ni();
  int customers = ni();
  addTicket(n);
  solve(customers);
 }

 static void addTicket(int n) {
  for (int i = 0; i < n; i++) {
   int temp = ni();
   if (priceTickets.containsKey(temp)) {
    priceTickets.put(temp, priceTickets.get(temp) + 1);
   } else {
    priceTickets.put(temp, 1);
   }
  }
 }

 static void solve(int customers) {
  StringBuilder output = new StringBuilder();
  Integer temp;
  for (int i = 0; i < customers; i++) {
   int p = ni();
   temp = priceTickets.floorKey(p);

   if (temp != null) {
    // <= maxpay > other
    output.append(temp).append("\n");
    if (priceTickets.get(temp) > 1) { // tickets vs same price
     priceTickets.put(temp, priceTickets.get(temp) - 1);
    } else {
     priceTickets.remove(temp);
    }
   } else {
    output.append(-1).append("\n");
   }
  }
  System.out.println(output);
 }

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