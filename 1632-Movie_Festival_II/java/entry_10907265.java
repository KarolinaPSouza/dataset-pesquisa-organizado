/* Jai Guru Dev*/
/*सब सुख लहै तुम्हारी सरना ।
तुम रक्षक काहू को डरना ॥*/
/*Don't cry in a corner, if you want something, mehnat kar, best ban, aur cheen le.*/
//Modulus properties
//1 (a+b)%y = (a%y+b%y)%y also 
// <if to find pairs st (a+b)%y==0 entry_10907265 is (a%y) and other is b%y==((y-(a%y))%y)> 
// < if (a+b)%y == (c+b)%y  then a%y = c%y (in  terms of remainder) >
// 2 (a-b)%y = (a%y-b%y+y)%y also  
//   < if (a-b)%y ==0 then a%y = b%y  >
import java.io.*;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class entry_10907265 {

    static final int INF = Integer.MAX_VALUE;
    static final long MOD = 1000000007L;
    static class FastIO extends PrintWriter {
 private InputStream stream;
 private byte[] buf = new byte[1 << 16];
 private int curChar;
 private int numChars;

 // standard input
 public FastIO() { this(System.in, System.out); }

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
  if (numChars == -1) { throw new InputMismatchException(); }
  if (curChar >= numChars) {
   curChar = 0;
   try {
    numChars = stream.read(buf);
   } catch (IOException e) { throw new InputMismatchException(); }
   if (numChars == -1) {
    return -1;  // end of file
   }
  }
  return buf[curChar++];
 }

 // to read in entire lines, replace c <= ' '
 // with a function that checks whether c is a line break
 public String next() {
  int c;
  do { c = nextByte(); } while (c <= ' ');

  StringBuilder res = new StringBuilder();
  do {
   res.appendCodePoint(c);
   c = nextByte();
  } while (c > ' ');
  return res.toString();
 }

 public int nextInt() {  // nextLong() would be implemented similarly
  int c;
  do { c = nextByte(); } while (c <= ' ');

  int sgn = 1;
  if (c == '-') {
   sgn = -1;
   c = nextByte();
  }

  int res = 0;
  do {
   if (c < '0' || c > '9') { throw new InputMismatchException(); }
   res = 10 * res + c - '0';
   c = nextByte();
  } while (c > ' ');
  return res * sgn;
 }

 public double nextDouble() { return Double.parseDouble(next()); }
}
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }

    static class Graph {
        int V;
        LinkedList<Integer>[] adjList;

        @SuppressWarnings("unchecked")
        Graph(int V) {
            this.V = V;
            adjList = new LinkedList[V];
            for (int i = 0; i < V; i++)
                adjList[i] = new LinkedList<>();
        }

        void addEdge(int u, int v) {
            adjList[u].add(v);
        }

        // Add more graph algorithms as needed
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot)
                return;
            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if (rank[xRoot] > rank[yRoot])
                parent[yRoot] = xRoot;
            else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;

        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static boolean[] sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;
    }

    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        FastIO sc = new FastIO();
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Pair> a = new ArrayList<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            a.add(new Pair(x, y));
        }
        Collections.sort(a, (p, q) -> {
            if (p.b == q.b){
                return p.a - q.a;}
            return p.b - q.b;
        });
        // for (int i = 0; i < k; i++) {

        // }
        long ans = 0;
        int j = 0;
        while (j<n) {
            Pair p = a.get(j);
            Integer fk = tm.floorKey(p.a);
            if (fk!=null) {
                // System.out.println(fk + " " + p.a + " " + p.b);
                ans++;
                tm.put(p.b, tm.getOrDefault(p.b, 0) + 1);
                tm.put(fk, tm.get(fk) - 1);
                if (tm.get(fk) == 0) {
                    tm.remove(fk);
                }
            } 
            else{
               if(k>0){
                // System.out.println(p.a+" "+p.b);
                tm.put(p.b, tm.getOrDefault(p.b, 0) + 1);
                k--;
                ans++;
               }
            }
            j++;
        }
        // System.out.println(tm);
        System.out.println(ans);
    }
}