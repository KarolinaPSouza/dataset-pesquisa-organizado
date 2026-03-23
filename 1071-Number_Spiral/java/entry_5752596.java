import java.io.*;
import java.util.*;
import java.lang.*;

public class entry_5752596 {
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    //    static long MOD = (long) (1e9 + 7);
    static long MOD = 998244353;
    static long inv2 = 499122177;
    static long MOD2 = MOD * MOD;
    static FastReader sc = new FastReader();
    static int pInf = Integer.MAX_VALUE;
    static int nInf = Integer.MIN_VALUE;
    static long ded = (long)(1e18)+9;

    public static void main(String[] args) throws Exception {
        int test = 1;
        test = sc.nextInt();
        for (int i = 1; i <= test; i++){
//            out.print("Case #"+i+": ");
            solve();
        }
        out.flush();
        out.close();
    }

    static void solve(){
        int i = sc.nextInt();
        int j = sc.nextInt();
        long max = Math.max(i,j);
        long ans = max*max;
        if(max%2==1){
            if(j==max){
                ans -= (i-1);
            }else{
                ans -= max;
                ans -= (max-j);
                ans += 1;
            }

        }else{
            if(i==max){
                ans -= (j-1);
            }else{
                ans -= max;
                ans -= (max-i);
                ans += 1;
            }
        }
        out.println(ans);

    }
    public static void printArray(int[] a){
        StringBuffer sb = new StringBuffer();
        for(int x: a){
            sb.append(x+" ");
        }
        out.println(sb);
    }
    static int[] par,rank;
    static void makeSet(int n){
        par = new int[n];
        rank = new int[n];
        for(int i = 1; i < n; i++){
            par[i] = i;
            rank[i] = 0;
        }
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a != b) {
//            out.println(a+" "+b);
            if (rank[a] < rank[b]){
                int t = a;
                a = b;
                b = t;
            }
            par[b] = a;
            if (rank[a] == rank[b]) {
                rank[a]++;
            }
        }
    }
    static int find(int v) {
        if (v == par[v])
            return v;
        return par[v] = find(par[v]);
    }
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o){
//            if(this.y==o.y){
//                return Integer.compare((int)this.x,(int)o.x);
//            }
//            return Integer.compare(this.y,o.y);

            if(this.x==o.x){
//                if(this.y==o.y){
//                    return Integer.compare((int)this.p,(int)o.p);
//                }
                return Integer.compare((int)this.y,(int)o.y);
            }
            return Integer.compare(this.x,o.x);
        }

        @Override
        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';
//            return x+" "+y;
        }

//        public boolean equals(Pair o){
//            return this.x==o.x&&this.y==o.y;
//        }
    }
    static long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }
    public static long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    public static long sub(long a, long b) {
        return ((a%MOD)-(b%MOD)+MOD)%MOD;
    }
    public static long add(long a, long b) {
        if((a+b)>MOD){
            return a+b-MOD;
        }else{
            return a+b;
        }
//        return ((a % MOD) + (b % MOD)) % MOD;
    }
    public static long c2(long n) {
        if ((n & 1) == 0) {
            return mul(n / 2, n - 1);
        } else {
            return mul(n, (n - 1) / 2);
        }
    }
    //Shuffle Sort
    static final Random random = new Random();
    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n); int temp= a[oi];
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
    static long gcd(long A, long B) {
        if (B == 0) return A;
        return gcd(B, A % B);
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