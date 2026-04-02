import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;

public class entry_970309 {
 public static FastScanner in = new FastScanner();
 static Stack<Integer> st = new Stack<Integer>();
 static int done = 0;
 static int []dop = new int[200100];
 static ArrayList<Integer> ans = new ArrayList<>();
 static int []instack = new int[200100];
 static ArrayList<ArrayList<Integer>> G = new ArrayList<>();
 public static void main(String[] args) throws IOException {
   for(int i=0; i<200100; ++i) G.add(new ArrayList<Integer>());
    int n = ri(), m = ri();
    int start = -1;
    for(int i=0; i<m; ++i) {
      int u = ri(), v = ri();
      start = u;
      G.get(u).add(v);
      G.get(v).add(u);
    }
    fill(instack, 0);
    //print(start);
    fill(dop, 0);
    for(int i=1; i<=n; ++i) {
      //System.out.println(i+" "+dop[i]);
      if(dop[i] == 1) continue;
      if(done == 1) break;
      dfs(i, -1);
    }
    if(done == 0){
      System.out.println("IMPOSSIBLE");
      System.exit(0);
    }
    //print(st.size());
    int top = st.peek();
    //print(top);
    ans.add(st.pop());
    while(st.peek() != top){
      ans.add(st.peek());
      st.pop();
    }
    ans.add(top);
    print(ans.size());
    for (Integer an : ans) System.out.print(an + " ");
 }

 static void dfs(int n, int parent){
   if(done == 1) return;
  // System.out.print(n+" ");
   st.push(n);
   dop[n] = 1;
   instack[n] = 1;
   for(int x:G.get(n)){
     if(x == parent) continue;
     if(instack[x] == 1){
       st.push(x);
       done = 1;
       return;
      }
     dfs(x, n);
      if(done == 1) return;
    }
   if(done == 1) return;
   st.pop();
   instack[n] = 0;
  }

 static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  long nextLong() {
   return Long.parseLong(next());
  }

  double nextDouble() {
   return Double.parseDouble(next());
  }
 }

 static final int IBIG = 1000000007;
 static final int IMAX = 2147483647;
 static final int IMIN = -2147483648;
 static final long LMAX = 9223372036854775807L;
 static final long LMIN = -9223372036854775808L;

 static int powmod(int a, int b, int mod) {
  if (a == 0)
   return 0;
  int ans = 1;
  while (b > 0) {
   if ((b & 1) > 0)
    ans *= a;
   a *= a;
   a %= mod;
   ans %= mod;
   b >>= 1;
  }
  return ans;
 }

 static long powmod(long a, long b, long mod) {
  if (a == 0)
   return 0;
  long ans = 1;
  while (b > 0) {
   if ((b & 1) > 0)
    ans *= a;
   a *= a;
   a %= mod;
   ans %= mod;
   b >>= 1;
  }
  return ans;
 }

 static int gcd(int a, int b) {
  return b == 0 ? a : gcd(b, a % b);
 }

 static long gcd(long a, long b) {
  return b == 0 ? a : gcd(b, a % b);
 }

 static int lcm(int a, int b) {
  return a * b / gcd(a, b);
 }

 static long lcm(long a, long b) {
  return a * b / gcd(a, b);
 }

 static void reverse(int[] a) {
  for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
   int swap = a[i];
   a[i] = a[n - i - 1];
   a[n - i - 1] = swap;
  }
 }

 static void reverse(long[] a) {
  for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
   long swap = a[i];
   a[i] = a[n - i - 1];
   a[n - i - 1] = swap;
  }
 }

 static void reverse(char[] a) {
  for (int i = 0, n = a.length, half = n / 2; i < half; ++i) {
   char swap = a[i];
   a[i] = a[n - i - 1];
   a[n - i - 1] = swap;
  }
 }

 static int[] copy(int[] a) {
  int[] ans = new int[a.length];
  for (int i = 0; i < a.length; ++i)
   ans[i] = a[i];
  return ans;
 }

 static long[] copy(long[] a) {
  long[] ans = new long[a.length];
  for (int i = 0; i < a.length; ++i)
   ans[i] = a[i];
  return ans;
 }

 static char[] copy(char[] a) {
  char[] ans = new char[a.length];
  for (int i = 0; i < a.length; ++i)
   ans[i] = a[i];
  return ans;
 }

 static int ri() {
  return in.nextInt();
 }

 static long rl() {
  return in.nextLong();
 }

 static void print(int n) {
  System.out.println(n);
 }

 static void print(long n) {
  System.out.println(n);
 }

 static void print(char[] n) {
  System.out.println(n);
 }

 static void print(int[] a) {
  for (int i = 0; i < a.length; ++i)
   System.out.print(a[i] + " ");
  System.out.println();
 }

 static void print(long[] a) {
  for (int i = 0; i < a.length; ++i)
   System.out.print(a[i] + " ");
  System.out.println();
 }

 static int[] ria(int n) {
  int[] a = new int[n];
  for (int i = 0; i < n; ++i)
   a[i] = in.nextInt();
  return a;
 }

 static long[] rla(int n) {
  long[] a = new long[n];
  for (int i = 0; i < n; ++i)
   a[i] = rl();
  return a;
 }

 static char[] rca(int n) {
  char[] a = in.next().toCharArray();
  return a;
 }

 static void out() {
  System.exit(0);
 }
}