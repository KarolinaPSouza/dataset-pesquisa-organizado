import java.io.*;
import java.util.*;

public class entry_7294760 {

 static void ruffleSort(long[] a) {
  int n = a.length;
  Random random = new Random();
  for (int i = 0; i < n; i++) {
   int oi = random.nextInt(n);
   long temp = a[oi];
   a[oi] = a[i];
   a[i] = temp;
  }
  Arrays.sort(a);
 }

 static void ruffleSort(int[] a) {
  int n = a.length;
  Random random = new Random();
  for (int i = 0; i < n; i++) {
   int oi = random.nextInt(n);
   int temp = a[oi];
   a[oi] = a[i];
   a[i] = temp;
  }
  Arrays.sort(a);
 }

 public static int Lcm(int a, int b) {
  int max = Math.max(a, b);
  for (int i = 1;; i++) {
   if ((max * i) % a == 0 && (max * i) % b == 0)
    return (max * i);
  }

 }

 static void sieve(int n, boolean prime[]) {

  // boolean prime[] = new boolean[n + 1];
  for (int i = 0; i <= n; i++)
   prime[i] = true;

  for (int p = 2; p * p <= n; p++) {

   if (prime[p] == true) {

    for (int i = p * p; i <= n; i = i + p)
     prime[i] = false;
   }
  }

 }

 // public static String run(int ar[],int n)
 // {

 // }

 public static int upperbound(int s, int e, long ar[], long x) {
  int res = -1;
  while (s <= e) {
   int mid = ((s - e) / 2) + e;
   if (ar[mid] > x) {
    e = mid - 1;
    res = mid;
   } else if (ar[mid] < x) {
    s = mid + 1;
   } else {
    e = mid - 1;
    res = mid;
    if (mid > 0 && ar[mid] == ar[mid - 1])
     e = mid - 1;
    else
     break;
   }

  }
  return res;
 }

 public static long lowerbound(int s, int e, long ar[], long x) {
  long res = -1;
  while (s <= e) {
   int mid = ((s - e) / 2) + e;
   if (ar[mid] > x) {
    e = mid - 1;
   } else if (ar[mid] < x) {
    s = mid + 1;
    res = mid;
   } else {
    res = mid;
    if (mid + 1 < ar.length && ar[mid] == ar[mid + 1])
     s = mid + 1;
    else
     break;
   }

  }
  return res;
 }

 static long modulo = 1000000007;

 public static long power(long a, long b) {
  if (b == 0)
   return 1;
  long temp = power(a, b / 2) % modulo;

  if ((b & 1) == 0)
   return (temp * temp) % modulo;
  else
   return (((temp * temp) % modulo) * a) % modulo;
 }

 public static long powerwithoutmod(long a, long b) {
  if (b == 0)
   return 1;
  long temp = power(a, b / 2);

  if ((b & 1) == 0)
   return (temp * temp);
  else
   return ((temp * temp) * a);
 }

 public static double log2(long a) {
  double d = Math.log(a) / Math.log(2);
  return d;

 }

 public static int log10(long a) {
  double d = Math.log(a) / Math.log(10);
  return (int) d;

 }

 public static long gcd(long a, long b) {
  if (a == 0)
   return b;

  return gcd(b % a, a);
 }

 public static void swap(int i, int j, int ar[]) {
  int t = ar[i];
  ar[i] = ar[j];
  ar[j] = t;
 }

 public static void main(String[] args) throws Exception {
  FastIO sc = new FastIO();

  // sc.println();
  // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx CODE xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  // int test = sc.nextInt();

  // // double c=Math.log(10);
  // boolean prime[]=new boolean[233334];
  // sieve(233334, prime);
  // HashMap<Character,Integer> hm=new HashMap<>(9);
  // char c='1';
  // for(int i=1;i<=9;i++)
  // hm.put(c++,i);

  // while (test-- > 0) {

    int n=sc.nextInt();
    int k=sc.nextInt();
    ArrayList<int[]> al=new ArrayList<>();
    for(int i=0;i<n;i++)
    {
     int a=sc.nextInt();
     int b=sc.nextInt();
     al.add(new int[]{a,b});
    }
    Collections.sort(al,(a,b)->(a[1]-b[1]));
    TreeMap<Integer,Integer> tm=new TreeMap<>();
    int count=0;
    for(int it[]:al)
    {
     int s=it[0],e=it[1];
     Map.Entry<Integer,Integer> rep=tm.floorEntry(s);
     if(rep!=null)
     {
      tm.put(e,tm.getOrDefault(e, 0)+1);
      if(rep.getValue()==1)
       tm.remove(rep.getKey());
      else
       tm.put(rep.getKey(),rep.getValue()-1);
      count++;
     }
     else
     {
      if(k>0)
      {
       tm.put(e,tm.getOrDefault(e, 0)+1);
       k--;
       count++;
      }

     }


    }
    sc.println(count);

  // }

  // xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx CODE xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
  sc.close();
 }
}

// class pair implements Comparable<pair>{
// int a;
// int b;
// pair(int a,int b)
// {this.a=a;
// this.b=b;

// }
// public int compareTo(pair p)
// {

// return (this.a-p.a);
// }
// }
class pair {
 int r, c;

 pair(int r, int c) {
  this.r = r;
  this.c = c;
 }
}

class dsu {
 int parent[];
 int size[];

 dsu(int n) {
  parent = new int[n];
  size = new int[n];
  for (int i = 0; i < n; i++) {
   size[i] = 1;
   parent[i] = i;
  }
 }

 public int findParent(int u) {
  if (parent[u] == u)
   return u;

  return parent[u] = findParent(parent[u]);
 }

 public void union(int u, int v) {
  int ul_pu = findParent(u), ul_pv = findParent(v);
  if (ul_pu == ul_pv)
   return;

  if (size[ul_pv] > size[ul_pu]) {
   parent[ul_pu] = ul_pv;
   size[ul_pv] += size[ul_pu];
  } else {
   parent[ul_pv] = ul_pu;
   size[ul_pu] += size[ul_pv];
  }
 }
}

class FastIO extends PrintWriter {
 private InputStream stream;
 private byte[] buf = new byte[1 << 16];
 private int curChar, numChars;

 // standard input
 public FastIO() {
  this(System.in, System.out);
 }

 public FastIO(InputStream i, OutputStream o) {
  super(o);
  stream = i;
 }

 // file input
 public FastIO(String i, String o) throws IOException {
  super(new FileWriter(o));
  stream = new FileInputStream(i);
 }

 // throws InputMismatchException() if previously detected end of file
 private int nextByte() {
  if (numChars == -1)
   throw new InputMismatchException();
  if (curChar >= numChars) {
   curChar = 0;
   try {
    numChars = stream.read(buf);
   } catch (IOException e) {
    throw new InputMismatchException();
   }
   if (numChars == -1)
    return -1; // end of file
  }
  return buf[curChar++];
 }

 public String nextLine() {
  int c;
  do {
   c = nextByte();
  } while (c <= '\n');
  StringBuilder res = new StringBuilder();
  do {
   res.appendCodePoint(c);
   c = nextByte();
  } while (c > '\n');
  return res.toString();
 }

 public String next() {
  int c;
  do {
   c = nextByte();
  } while (c <= ' ');
  StringBuilder res = new StringBuilder();
  do {
   res.appendCodePoint(c);
   c = nextByte();
  } while (c > ' ');
  return res.toString();
 }

 public int nextInt() {
  int c;
  do {
   c = nextByte();
  } while (c <= ' ');
  int sgn = 1;
  if (c == '-') {
   sgn = -1;
   c = nextByte();
  }
  int res = 0;
  do {
   if (c < '0' || c > '9')
    throw new InputMismatchException();
   res = 10 * res + c - '0';
   c = nextByte();
  } while (c > ' ');
  return res * sgn;
 }

 public long nextLong() {
  int c;
  do {
   c = nextByte();
  } while (c <= ' ');
  long sgn = 1;
  if (c == '-') {
   sgn = -1;
   c = nextByte();
  }
  long res = 0;
  do {
   if (c < '0' || c > '9')
    throw new InputMismatchException();
   res = 10 * res + c - '0';
   c = nextByte();
  } while (c > ' ');
  return res * sgn;
 }

 public double nextDouble() {
  return Double.parseDouble(next());
 }
}