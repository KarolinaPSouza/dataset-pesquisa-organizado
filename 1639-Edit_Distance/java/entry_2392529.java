/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class entry_2392529 {
 public static void main(String[] args) throws java.lang.Exception {
  FastReader in = new FastReader(System.in);
  StringBuilder sb = new StringBuilder();
  int t = 1;
 // t = in.nextInt();
  while (t > 0) {
   --t;
   String s1 = in.next();
   String s2 = in.next();
   int n = s1.length();
   int m = s2.length();
            int dp[][] = new int[n+1][m+1];
            for(int i = 0;i<=m;i++)
            dp[0][i] = i;
            for(int i = 0;i<=n;i++)
            dp[i][0] = i;

            for(int i = 1;i<=m;i++)
            {
             for(int j = 1;j<=n;j++)
             {
              if(s2.charAt(i-1) == s1.charAt(j-1))
              {
               dp[j][i] = dp[j-1][i-1];
              }
              else 
              {
               dp[j][i] = Math.min(dp[j-1][i-1],Math.min(dp[j-1][i],dp[j][i-1]))+1;
              }
             }
            }

   sb.append(dp[n][m]+"\n");

  }
  System.out.print(sb);
 }

 static long gcd(long a, long b) {
  if (a == 0)
   return b;
  else
   return gcd(b % a, a);
 }

 static long lcm(long a, long b) {
  return (a / gcd(a, b)) * b;
 }

 static void sort(long[] a) {
  ArrayList<Long> l = new ArrayList<>();
  for (long i : a)
   l.add(i);
  Collections.sort(l);
  for (int i = 0; i < a.length; i++)
   a[i] = l.get(i);
 }
}

class FastReader {

 byte[] buf = new byte[2048];
 int index, total;
 InputStream in;

 FastReader(InputStream is) {
  in = is;
 }

 int scan() throws IOException {
  if (index >= total) {
   index = 0;
   total = in.read(buf);
   if (total <= 0) {
    return -1;
   }
  }
  return buf[index++];
 }

 String next() throws IOException {
  int c;
  for (c = scan(); c <= 32; c = scan())
   ;
  StringBuilder sb = new StringBuilder();
  for (; c > 32; c = scan()) {
   sb.append((char) c);
  }
  return sb.toString();
 }

 String nextLine() throws IOException {
  int c;
  for (c = scan(); c <= 32; c = scan())
   ;
  StringBuilder sb = new StringBuilder();
  for (; c != 10 && c != 13; c = scan()) {
   sb.append((char) c);
  }
  return sb.toString();
 }

 char nextChar() throws IOException {
  int c;
  for (c = scan(); c <= 32; c = scan())
   ;
  return (char) c;
 }

 int nextInt() throws IOException {
  int c, val = 0;
  for (c = scan(); c <= 32; c = scan())
   ;
  boolean neg = c == '-';
  if (c == '-' || c == '+') {
   c = scan();
  }
  for (; c >= '0' && c <= '9'; c = scan()) {
   val = (val << 3) + (val << 1) + (c & 15);
  }
  return neg ? -val : val;
 }

 long nextLong() throws IOException {
  int c;
  long val = 0;
  for (c = scan(); c <= 32; c = scan())
   ;
  boolean neg = c == '-';
  if (c == '-' || c == '+') {
   c = scan();
  }
  for (; c >= '0' && c <= '9'; c = scan()) {
   val = (val << 3) + (val << 1) + (c & 15);
  }
  return neg ? -val : val;
 }
}
