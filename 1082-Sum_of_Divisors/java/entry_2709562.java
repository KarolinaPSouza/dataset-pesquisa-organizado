import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.Math.PI;
import static java.lang.Math.min;
import static java.lang.System.arraycopy;
import static java.lang.System.exit;
import static java.util.Arrays.copyOf;

import java.util.LinkedList;
import java.util.Iterator;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.lang.StringBuilder;
import java.util.Collections;

import java.text.DecimalFormat;
public class entry_2709562 {


 static BufferedReader in;
 static PrintWriter out;
 static StringTokenizer tok;

 private static void solve() throws IOException{
  long n = scanLong();
  long mod = (long)1e9+7;
  long inverse = binaryExponent(2, mod-2, mod);
  long answer = 0;
  for(long i=1,j; i<=n; i=j){
   long q = n/i;
   j = n/q+1;
   long sumUptoJMinus1 = ((((j-1)%mod * (j%mod))%mod)*inverse)%mod;
   long sumUptoIMinus1 = ((((i-1)%mod * (i%mod))%mod)*inverse)%mod;
   long value = (sumUptoJMinus1-sumUptoIMinus1+mod)%mod;
   answer = (answer+ (q%mod)*value)%mod;
  }
  out.println(answer);

 }

 private static long binaryExponent(long a, long b, long mod){
  long result = 1;
  while(b > 0){
   if(b%2 != 0){
    result = (result * a) % mod;
   }
   a = (a*a) % mod;
   b >>= 1;
  }
  return result;
 }




 public static void main(String[] args) {
  try {
   long startTime = System.currentTimeMillis();

   in = new BufferedReader(new InputStreamReader(System.in));
   out = new PrintWriter(System.out);
   //in = new BufferedReader(new FileReader("input.txt"));
   //out = new PrintWriter(new FileWriter("output.txt"));
   //int test=scanInt();
   //for(int t=1; t<=test; t++){
    //out.print("Case #"+t+": ");
    solve();
   //}

   long endTime   = System.currentTimeMillis();
   long totalTime = endTime - startTime;
   //System.out.println(totalTime+"  "+System.currentTimeMillis() );
   in.close();
   out.close();

  } catch (Throwable e) {
   e.printStackTrace();
   exit(1);
  }
 }
 static int scanInt() throws IOException {
  return parseInt(scanString());
 }

 static long scanLong() throws IOException {
  return parseLong(scanString());
 }
 static double scanDouble() throws IOException {
  return parseDouble(scanString());
 }

 static String scanString() throws IOException {
  if (tok == null || !tok.hasMoreTokens()) {
   tok = new StringTokenizer(in.readLine());
  }
  return tok.nextToken();
 }
 static String scanLine() throws IOException {
  return in.readLine();
 }


}

