
import java.io.*;
import java.util.*;

public class entry_12813837 {

 static PrintWriter out = new PrintWriter(System.out);

 static long[][] distance = new long[500 + 1][500 + 1];

 public static void main(String[] args) throws java.lang.Exception {

  FastReader fs = new FastReader();
  int n = fs.nextInt(), m = fs.nextInt(), q = fs.nextInt();

  long max = 1000000000000L;

  for (int i = 1; i <= n; i++) {
   for (int j = 1; j <= n; j++) {
    if (i == j)
     distance[i][j] = 0L;
    else
     distance[i][j] = max;
   }
  }

  for (int i = 0; i < m; i++) {
   int a = fs.nextInt(), b = fs.nextInt();
   long c = fs.nextLong();
   distance[a][b] = Math.min(distance[a][b], c);
   distance[b][a] = Math.min(distance[b][a], c);
  }

  for (int k = 1; k <= n; k++) {
   for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
     distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
    }
   }
  }

  while (q-- > 0) {
   int a = fs.nextInt(), b = fs.nextInt();

   long val = distance[a][b];
   if (val == max)
    out.println(-1);
   else
    out.println(distance[a][b]);
  }

  out.flush();
 }

}

class Pair {
 int idx;
 long cost;

 public Pair(int idx, long cost) {
  this.idx = idx;
  this.cost = cost;
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