import java.io.*;
import java.util.*;

public class entry_12773684 {

 static PrintWriter out = new PrintWriter(System.out);

 public static void main(String[] args) throws java.lang.Exception {

  FastReader fs = new FastReader();
  int n = fs.nextInt();
  int m = fs.nextInt();
  char[][] A = new char[n][m];
  for (int i = 0; i < n; i++) {
   String s = fs.nextLine();
   A[i] = s.toCharArray();
  }
  solve(n, m, A);
  out.flush();
 }

 static void solve(int n, int m, char[][] A) {

  boolean[][] visited = new boolean[n][m];
  int[][] dirs = new int[][] { new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 0, -1 } };

  int res = 0;
  for (int i = 0; i < n; i++) {
   for (int j = 0; j < m; j++) {
    if (A[i][j] == '#')
     continue;
    if (visited[i][j])
     continue;
    res++;
    dfs(i, j, A, visited, dirs);
   }
  }

  out.println(res);

 }

 static void dfs(int i, int j, char[][] A, boolean[][] visited, int[][] dirs) {

  Stack<Pair> stack = new Stack<>();
  stack.push(new Pair(i, j));

  while (stack.size() > 0) {
   Pair p = stack.pop();
   if (p.i < 0 || p.i >= A.length || p.j < 0 || p.j >= A[0].length)
    continue;
   if (A[p.i][p.j] == '#')
    continue;
   if (visited[p.i][p.j])
    continue;
   visited[p.i][p.j] = true;

   for (int[] dir : dirs) {
    int idxi = p.i + dir[0];
    int idxj = p.j + dir[1];
    stack.push(new Pair(idxi, idxj));

   }
  }

 }

}

class Pair {
 int i, j;

 public Pair(int i, int j) {
  this.i = i;
  this.j = j;
 }
}

class Algo {

 static long mod = 1000000007;

 static long power(long n) {
  long result = 1;
  long x = 2;
  while (n > 0) {
   if (n % 2 == 1)
    result = (result * x) % mod;
   n /= 2;
   x = (x * x) % mod;
  }
  return result;
 }

 static int getCountPrimeFactors(long num) {

  int res = 0;
  while (num % 2 == 0) {
   num = num / 2;
   res++;
  }
  for (long i = 3; i * i <= num; i += 2) {
   while (num % i == 0) {
    num = num / i;
    res++;
   }
  }
  if (num > 2)
   res++;
  return res;
 }

 static boolean[] fillSieve(int n) {

  boolean[] primes = new boolean[n + 1];
  Arrays.fill(primes, true);
  primes[0] = false;
  primes[1] = false;
  for (int i = 2; i < primes.length; ++i) {
   if (primes[i]) {
    for (int j = 2; i * j < primes.length; ++j) {
     primes[i * j] = false;
    }
   }
  }
  return primes;
 }

 static long gcd(long a, long b) {
  if (b == 0)
   return a;
  return gcd(b, a % b);
 }

 static long lcm(long a, long b) {
  return a * (b / gcd(a, b));
 }

}

class FastReader {
 BufferedReader br;
 StringTokenizer st;

 public FastReader() {
  br = new BufferedReader(new InputStreamReader(System.in));
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

 int nextInt() {
  return Integer.parseInt(next());
 }

 long nextLong() {
  return Long.parseLong(next());
 }

 double nextDouble() {
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

 int[] nextArrInt(int n) {
  int[] res = new int[n];
  for (int i = 0; i < n; i++)
   res[i] = nextInt();
  return res;
 }

 long[] nextArrLong(int n) {
  long[] res = new long[n];
  for (int i = 0; i < n; i++)
   res[i] = nextLong();
  return res;
 }
}