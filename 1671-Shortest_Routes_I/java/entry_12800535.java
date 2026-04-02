import java.io.*;
import java.util.*;

public class entry_12800535 {

 static PrintWriter out = new PrintWriter(System.out);

 public static void main(String[] args) throws java.lang.Exception {

  FastReader fs = new FastReader();
  int n = fs.nextInt(), m = fs.nextInt();

  HashMap<Integer, HashMap<Integer, Long>> map = new HashMap<>();
  for (int i = 0; i < m; i++) {
   int a = fs.nextInt(), b = fs.nextInt();
   long c = fs.nextLong();
   map.putIfAbsent(a, new HashMap<>());
   HashMap<Integer, Long> mapa = map.get(a);
   mapa.put(b, Math.min(mapa.getOrDefault(b, Long.MAX_VALUE), c));
  }

  boolean[] visited = new boolean[n + 1];
  long[] distance = new long[n + 1];
  Arrays.fill(distance, Long.MAX_VALUE);
  distance[1] = 0;
  //visited[1] = true;
  PriorityQueue<Pair> pq = new PriorityQueue<>(
    (a, b) -> (a.cost != b.cost ? Long.compare(a.cost, b.cost) : a.idx - b.idx));
  pq.offer(new Pair(1, 0L));

  while (!pq.isEmpty()) {
   Pair p = pq.poll();

   if (visited[p.idx])
    continue;
   visited[p.idx] = true;

   if (!map.containsKey(p.idx))
    continue;
   HashMap<Integer, Long> adjmap = map.get(p.idx);
   for (Map.Entry<Integer, Long> entry : adjmap.entrySet()) {
    int adj = entry.getKey();
    long newcost = entry.getValue() + p.cost;

    if (distance[adj] <= newcost)
     continue;
    distance[adj] = newcost;
    pq.offer(new Pair(adj, newcost));
   }
  }

  for (int i = 1; i <= n; i++) {
   out.print(distance[i]);
   out.print(" ");
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