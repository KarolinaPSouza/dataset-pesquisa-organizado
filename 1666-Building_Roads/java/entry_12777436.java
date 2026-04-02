import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;
public class entry_12777436 {
 static PrintWriter out = new PrintWriter(System.out);
 public static void main(String[] args) throws java.lang.Exception {
  FastReader fs = new FastReader();
  int test = 1;
  while (test-- > 0) {
   int n = fs.nextInt();
   int m = fs.nextInt();
   List<List<Integer>> roads = new ArrayList();
   for(int i = 0; i <= n; i++){
    roads.add(new ArrayList());
   }
   for(int i = 0; i < m; i++){
    int u = fs.nextInt(), v = fs.nextInt();
    roads.get(u).add(v); roads.get(v).add(u);
   }
   int curI = 1;
   boolean[] visited = new boolean[n+1];
   Map<Integer,Integer> map = new HashMap();
   for(int i = 1; i <= n; i++){
    if(visited[i]) continue;
    visited[i] = true;
    map.put(curI, i); curI++;
    Queue<Integer> q = new LinkedList();
    q.add(i);
    while(!q.isEmpty()){
     int u = q.poll();
     for(int v : roads.get(u)){
      if(visited[v]) continue;
      visited[v]=true;
      q.add(v);
     }
    }
   }
   out.println(curI-2);
   for(int i = 2; i < curI; i++){
    out.println(map.get(1)+" "+map.get(i));
   }
  }
  out.flush();
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
   if (b == 0) return a;
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
  for (int i = 0; i < n; i++) res[i] = nextInt();
  return res;
 }
 long[] nextArrLong(int n) {
  long[] res = new long[n];
  for (int i = 0; i < n; i++) res[i] = nextLong();
  return res;
 }
}