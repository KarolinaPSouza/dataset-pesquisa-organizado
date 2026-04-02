import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Character.*;
import static java.lang.System.in;
import static java.lang.Math.*;
import static java.lang.System.out;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class entry_1830730 {
 static void solve() {
  int n = readInt(), x = readInt();
  int[] coins = new int[n];
  for (int i = 0; i < n; i++) {
   coins[i] = readInt();
  }
  long[] dp = new long[x + 1];
  fill(dp, Integer.MAX_VALUE);
  dp[0] = 0;
  for (int i = 0; i <= x; i++) {
   for (int ci = 0; ci < n; ci++) {
    if (i >= coins[ci]) {
     dp[i] = min(dp[i], dp[i - coins[ci]] + 1);
    }
   }
  }
  out.printf("%d%n", dp[x] == Integer.MAX_VALUE ? -1 : dp[x]);
 }

 public static void main(String[] args) {
  solve();
  out.flush();
 }

 // @formatter:off
 static final PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 static final BufferedReader br=new BufferedReader(new InputStreamReader(in));
 static StringTokenizer st;static String readLine(){try{return br.readLine();}catch(Exception e){throw new RuntimeException(e);}}
 static String read(){while(st==null||!st.hasMoreElements()){st=new StringTokenizer(readLine());}return st.nextToken();}
 static int readInt(){return parseInt(read());}static long readLong(){return parseLong(read());}
 static int[]readInts(int n){int[]array=new int[n];for(int i=0;i<n;i++){array[i]=readInt();}return array;}
 static long[]readLongs(int n){long[]array=new long[n];for(int i=0;i<n;i++){array[i]=readLong();}return array;}
}