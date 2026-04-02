//package algorithm.ArrayAlgo;

import java.util.*;
import java.io.*;

public class entry_6971425 {
 BufferedReader br;
 StringTokenizer st;
 BufferedWriter bw;
 static long mod = (long) (1e9 + 7);

 static long MOD = 998244353;

 public static void main(String[] args) throws Exception {
  new entry_6971425().run();
 }

 void run() throws IOException {
  br = new BufferedReader(new InputStreamReader(System.in));
  bw = new BufferedWriter(new OutputStreamWriter(System.out));
  solve();
 }

 void solve() throws IOException {
  int t = 1;

  while (t-- > 0) {

   sol();

  }

  bw.flush();
 }

 List<int[]>[] graph;

 ArrayList<ArrayList<Integer>> adj;

 int[] memo;

 public void sol() throws IOException {

  int n = ni();
  int m = ni();
  int q = ni();

  long dist [][] = new long[n][n];
  for(int i =0;i<n;i++)
  {
   Arrays.fill(dist[i], Long.MAX_VALUE);
   dist[i][i] = 0;
  }
  for(int i =0;i<m;i++)
  {
   int a = ni()-1;
   int b = ni()-1;
   long c = nl();
   dist[a][b] = Math.min(c, dist[a][b]);
   dist[b][a] = Math.min(c, dist[b][a]);



   //graph[b].add(new int[] {a,c});
  }
  StringBuilder sb = new StringBuilder();

  floydWarshall(dist);
  for(int i =0;i<q;i++)
  {
   int a = ni()-1;
   int b = ni()-1;
   long dis = dist[a][b];
   if(dis==Long.MAX_VALUE)
   {
        sb.append(-1+" ");
   }
   else
    sb.append(dis+" ");

  }


  System.out.println(sb);
 }

 public  void floydWarshall(long dist[][])
    {

        int i, j, k;

        long INF = Long.MAX_VALUE;
        for (k = 0; k < dist.length; k++) {

            for (i = 0; i < dist.length; i++) {

                for (j = 0; j < dist.length; j++) {

                 if (dist[i][k] != INF
                         && dist[k][j] != INF
                         && dist[i][k] + dist[k][j] < dist[i][j]) {
                     dist[i][j] = dist[i][k] + dist[k][j];
                 }
                }
            }
        }

    }

 class Pair implements Comparable<Pair> {
  long val, cnt;

  Pair(long val, long cnt) {
   this.val = val;
   this.cnt = cnt;
  }

  public int compareTo(Pair p) {

   return Long.compare(this.val, p.val);
  }
 }

 private void print(long[] ans2) {
  // TODO Auto-generated method stub
  StringBuilder sb = new StringBuilder();
  for (long e : ans2) {
   sb.append(e + " ");
  }
  System.out.println(sb);
 }

 private void printL(ArrayList<Long> ans2) {
  // TODO Auto-generated method stub
  StringBuilder sb = new StringBuilder();
  for (long e : ans2) {
   sb.append(e + " ");
  }
  System.out.println(sb);
 }

 public void print(ArrayList<Integer> al) {
  StringBuilder sb = new StringBuilder();
  for (int e : al) {
   sb.append(e + " ");
  }
  System.out.println(sb);
 }

 public void print(int[] al) {
  StringBuilder sb = new StringBuilder();
  for (int e : al) {
   sb.append(e + " ");
  }
  System.out.println(sb);
 }

 public int upperbound(long b, long[] k) {

  int lo = 0;
  int hi = k.length - 1;
  int ans = k.length;
  while (lo <= hi) {
   int mid = (lo + hi) / 2;
   if (k[mid] >= b) {
    ans = mid;
    hi = mid - 1;
   } else {
    lo = mid + 1;
   }
  }
  return ans;
 }

 public int lowerbound(long b, long[] k) {

  int lo = 0;
  int hi = k.length - 1;
  int ans = 0;
  while (lo <= hi) {
   int mid = (lo + hi) / 2;
   if (k[mid] <= b) {
    ans = mid;
    lo = mid + 1;
   } else {
    hi = mid - 1;
   }
  }
  return ans;
 }

 public static void sort(long[] a2) {
  ArrayList<Long> al = new ArrayList<>();
  for (long i : a2)
   al.add(i);
  Collections.sort(al);
  for (int i = 0; i < a2.length; i++) {
   a2[i] = al.get(i);
  }

 }

 public long inverse(long a) {
  return binpow(a, mod - 2);
 }

 static long gcd(long a, long b) {
  if (a == 0)
   return b;
  return gcd(b % a, a);
 }

 // method to return LCM of two numbers
 static long lcm(long a, long b) {
  return (a * b / gcd(a, b));
 }

 static boolean isPowerOfTwo(long n) {
  if (n == 0)
   return false;

  return (int) (Math.ceil((Math.log(n) / Math.log(2)))) == (int) (Math.floor(((Math.log(n) / Math.log(2)))));
 }

 static int highestPowerof2(long n) {

  int p = (int) (Math.log(n) / Math.log(2));
  return p;
 }

 static int gcd(int a, int b) {
  if (b == 0)
   return a;
  return gcd(b, a % b);
 }

 static int smallestDivisor(int n) {
  // if divisible by 2
  if (n % 2 == 0)
   return 2;

  // iterate from 3 to sqrt(n)
  for (int i = 3; i * i <= n; i += 2) {
   if (n % i == 0)
    return i;
  }

  return n;
 }

 /////////////////////////////////////// FOR INPUT
 /////////////////////////////////////// ///////////////////////////////////////

 public static class data1 {
  int h, w;

  public data1(int a, int b) {
   h = a;
   w = b;
  }
 }

 public data1[] dataArray1(int n) {
  data1 d[] = new data1[n];
  for (int i = -1; ++i < n;)
   d[i] = new data1(ni(), ni());

  return d;
 }

 public static class data {
  int a, b, c, d;

  public data(int a, int b, int x, int y) {
   this.a = a;
   this.b = b;
   c = x;
   d = y;
  }
 }

 public data[] dataArray(int n) {
  data d[] = new data[n];
  for (int i = -1; ++i < n;)
   d[i] = new data(ni(), ni(), ni(), ni());

  return d;
 }

 long binpow(long a, long b) {
  if (b == 0)
   return 1;
  long res = binpow(a, b / 2);
  res = res * res % mod;
  if (b % 2 == 1)
   return res * a % mod;
  else
   return res;
 }

 int[] nai(int n) {
  int a[] = new int[n];
  for (int i = -1; ++i < n;)
   a[i] = ni();
  return a;
 }

 Integer[] naI(int n) {
  Integer a[] = new Integer[n];
  for (int i = -1; ++i < n;)
   a[i] = ni();
  return a;
 }

 Long[] naL(int n) {
  Long a[] = new Long[n];
  for (int i = -1; ++i < n;)
   a[i] = nl();
  return a;
 }

 long[] nal(int n) {
  long a[] = new long[n];
  for (int i = -1; ++i < n;)
   a[i] = nl();
  return a;
 }

 char[] nac() {
  char c[] = nextLine().toCharArray();
  return c;
 }

 char[][] nmc(int n) {
  char c[][] = new char[n][];
  for (int i = -1; ++i < n;)
   c[i] = nac();
  return c;
 }

 int[][] nmi(int r, int c) {
  int a[][] = new int[r][c];
  for (int i = -1; ++i < r;)
   a[i] = nai(c);
  return a;
 }

 String next() {
  while (st == null || !st.hasMoreElements()) {
   try {
    st = new StringTokenizer(br.readLine());
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
  return st.nextToken();
 }

 int ni() {
  return Integer.parseInt(next());
 }

 byte nb() {
  return Byte.parseByte(next());
 }

 short ns() {
  return Short.parseShort(next());
 }

 long nl() {
  return Long.parseLong(next());
 }

 double nd() {
  return Double.parseDouble(next());
 }

 String nextLine() {
  String str = "";
  try {
   str = br.readLine();
  } catch (IOException e) {
   e.printStackTrace();
  }
  return str;
 }
}