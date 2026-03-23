import java.io.*;
import java.util.*;
import java.lang.*;

public class entry_1739490 {
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static long MOD = (long) (1e9 + 7);
    //static int MOD = 998244353;
    static long MOD2 = MOD * MOD;
    static FastReader sc = new FastReader();
    static int pInf = Integer.MAX_VALUE;
    static int nInf = Integer.MIN_VALUE;
    static long ded = (long)(1e17)+9;
    public static void main                                                                                                                                                         (String[] args) throws Exception {
        int test = 1;
//        test = sc.nextInt();
        for (int i = 1; i <= test; i++){
            //out.print("Case #"+i+": ");
            solve();
        }
        out.flush();
        out.close();
    }
    static void solve() throws Exception{
        long n = sc.nextLong();
        long ans = 0L;
        for(long l = 1, r = 0; l <= n; l = r+1){
            r = Math.min(n/(n/l),n);
            ans = add(ans,mul(sub(C2(r+1),C2(l)),(n/l)));
        }
        out.println(ans%MOD);
    }
    static long C2(long a){
        return mul(mul(a,a-1),(MOD+1)/2);
    }
    static long sub(long a,long b){
        return ((a%MOD)-(b%MOD)+MOD)%MOD;
    }
    public static long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    public static long add(long a, long b) {
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    //Pair Class
    static class Pair implements Comparable<Pair> {
        int x;int y;int z;
        public Pair(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        @Override
        public int compareTo(Pair o) {
            return this.x-o.x;
        }
    }
    //Shuffle Sort
    static final Random random = new Random();
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n); int temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    //Brian Kernighans Algorithm
    static long countSetBits(long n) {
        if (n == 0) return 0;
        return 1 + countSetBits(n & (n - 1));
    }
    //Euclidean Algorithm
    static long gcd(long A, long entry_1739490) {
        if (entry_1739490 == 0) return A;
        return gcd(entry_1739490, A % entry_1739490);
    }
    //Modular Exponentiation
    static long fastExpo(long x, long n) {
        if (n == 0) return 1;
        if ((n & 1) == 0) return fastExpo((x * x) % MOD, n / 2) % MOD;
        return ((x % MOD) * fastExpo((x * x) % MOD, (n - 1) / 2)) % MOD;
    }
    //AKS Algorithm
    static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i += 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }
    public static long modinv(long x) {
        return modpow(x, MOD - 2);
    }
    public static long modpow(long a, long b) {
        if (b == 0) {
            return 1;
        }
        long x = modpow(a, b / 2);
        x = (x * x) % MOD;
        if (b % 2 == 1) {
            return (x * a) % MOD;
        }
        return x;
    }
         static class FastReader {
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
     }
}