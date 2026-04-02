import java.io.*;
import java.util.*;

public class entry_16035164 {

    public static void main(String[] args) {
        // long TC = l();
        long TC = 1;
        while (TC-- > 0) solve();
        out.close();
    }

    public static void solve() {
        int n = i();
        int x = i();
        int []coins = ai(n);

        /*
        * State: dp[s] = minimum number of coins required to achieve the target X
        * Transition: dp[s] = mn(dp[s], 1 + dp[s - coin]) where coin is the coin we are using 
                      to achieve the sum X from the given set of coins such that x-coin >= 0
        * TC : O(X * N) + O(N)
        */

        int []dp = new int[x + 1];
        fill(dp, imax);
        dp[0] = 0;

        for(int s = 1; s <= x; s++) {
            for(int i = 0; i < n; i++) {
                if(s - coins[i] >= 0 && dp[s - coins[i]] != imax) {
                    dp[s] = mn(dp[s], 1 + dp[s - coins[i]]);
                }
            }
        }

        pl(dp[x] == imax ? -1 : dp[x]);
    }

    static class FastReader {   
        BufferedReader br; StringTokenizer st;
        public FastReader() {br = new BufferedReader(new InputStreamReader(System.in));}
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {st = new StringTokenizer(br.readLine());}
                catch (IOException e) {e.printStackTrace();}
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try {
                if(st.hasMoreTokens()) str = st.nextToken("\n");
                else str = br.readLine();
            }
            catch (IOException e){e.printStackTrace(); }
            return str;
        }
    }

    static void flush() {out.flush();}
    static FastReader sc = new FastReader(); static OutputStream outputStream = System.out; static PrintWriter out = new PrintWriter(outputStream);
    static  final  long mod = (long)1e9+7; static final int imin = Integer.MIN_VALUE; static final int imax = Integer.MAX_VALUE;static final long lmin = Long.MIN_VALUE; static final long lmax = Long.MAX_VALUE;
    static  class  IP {int v1, v2; IP(int v1, int v2){this.v1 = v1;this.v2 = v2;} @Override public String toString() {return "(" + v1 + ", " + v2 + ")";}}
    static  class  LP {long v1, v2; LP(long v1, long v2){this.v1 = v1;this.v2 = v2;} @Override public String toString() {return "(" + v1 + ", " + v2 + ")";}}
    static void     pl(long []arr){for(long a : arr) p(a + " ");pl("");}
    static void     pl(int []arr){for(int a : arr) p(a + " ");pl("");}
    static void     pl(char []arr){for(char a : arr) p(a + " ");pl("");}
    static void     pl(int [][]mat){for(int i=0; i<mat.length;i++){for(int j=0;j<mat[0].length;j++)p(mat[i][j] + " ");pl("");}}
    static void     pl(long [][]mat){for(int i=0; i<mat.length;i++){for(int j=0;j<mat[0].length;j++)p(mat[i][j] + " ");pl("");}}
    static void     pl(List<Long> ls){for(long v:ls)p(v+" ");pl("");}
    static void     p(int a){out.print(a);}static void     pl(int a){out.println(a);}
    static void     p(long a){out.print(a);}static void     pl(long a){out.println(a);}
    static void     pl(double d){out.println(d);}static void     p(double d){out.print(d);}
    static void     pl(char ch){out.println(ch);}static void     p(char ch){out.print(ch);}
    static void     pl(String s){out.println(s);}static void     p(String s){out.print(s);}
    static void     yes(){pl("YES");} static void     no(){pl("NO");}
    static int      i(){return sc.nextInt();}static long     l(){return sc.nextLong();}
    static double   d(){return sc.nextDouble();}
    static String   s(){return sc.next();} static char     ch(){return sc.next().charAt(0);}
    static int[]    ai(int n){int arr[] = new int[n]; for(int i = 0; i < n; i++) arr[i] = i(); return arr;}
    static int[]    aio(int n){int arr[] = new int[n + 1]; for(int i = 1; i <= n; i++) arr[i] = i(); return arr;}
    static long[]   al(int n){long arr[] = new long[n];for(int i = 0; i < n; i++) arr[i] = l();return arr;}
    static long[]   alo(int n){long arr[] = new long[n + 1];for(int i = 1; i <= n; i++) arr[i] = l();return arr;}
    static double[] ad(int n){double arr[] = new double[n];for(int i = 0; i < n; i++) arr[i] = d();return arr;}
    static int[][]  imx(int n, int m){int mat[][] = new int[n][m]; for(int i = 0; i < mat.length; i++) for(int j = 0; j < mat[0].length; j++) mat[i][j] = i();return mat;}
    static long[][] lmx(int n, int m){long mat[][] = new long[n][m];for(int i = 0; i < mat.length; i++) for(int j = 0; j < mat[0].length; j++) mat[i][j] = l();return mat;}
    static long[]   psum(long []a){long []psum=new long[a.length];psum[0]=a[0];for(int i=1;i<a.length;i++)psum[i]=psum[i-1]+a[i];return psum;}
    static int[]    psum(int []a){int []psum=new int[a.length];psum[0]=a[0];for(int i=1;i<a.length;i++)psum[i]=psum[i-1]+a[i];return psum;}
    static void     sort(int []a){Arrays.sort(a);}static void     sort(long []a){Arrays.sort(a);}
    static void     fill(int []a, int val) {Arrays.fill(a, val);}
    static void     fill(long []a, long val) {Arrays.fill(a, val);}
    static int      mx(int a, int b){return Math.max(a,b);}static long     mx(long a, long b){return Math.max(a,b);}
    static int      mn(int a, int b){return Math.min(a,b);}static long     mn(long a, long b){return Math.min(a,b);}
    static long     abs(long a, long b){return Math.abs(a - b);}static int      abs(int a, int b){return Math.abs(a - b);}
    static String   rev(String s){return new StringBuilder(s).reverse().toString();}
    static boolean  isPalin(String s){int i=0,j=s.length()-1;while(i<=j){if(s.charAt(i++)!=s.charAt(j--))return false;}return true;}
    static boolean  isPalin(int n){String s = Integer.toString(n), tmp = s;String rev = new StringBuilder(tmp).reverse().toString();return s.equals(rev);}
    static int      add(int a, int b, int m){return ((a % m) + (b % m)) % m;}
    static long     add(long a, long b, long m){return ((a % m) + (b % m)) % m;}
    static long     sub(long a, long b, long m) {return (((a + m) % m + ((-b) + m) % m) % m);}
    static long     mul(long a, long b, long m){return ((a % m) * (b % m)) % m;}
    static long     div(long a, long b, long m){return ((a % m) * powMod(b, m - 2, m)) % m;}

    /*
        if gcd(a, b) = 1 then a and b are said to be coprime
        gcd(a, 0) == a && gcd(a, 1) == 1 && gcd(a, a) = a
        gcd(a, b) = gcd(a - b, b)
        gcd(m â�� a, m â�� b) = m â�� gcd(a, b) (m > 0)
        gcd(a,b) = g, then a/g and b/g should be coprime
        gcd(a, b) = gcd(a+(m*b), b)
        gcd(a, b) = gcd(b, a % b) 
    */
    static int gcd(int a, int b){if(b == 0) return a;return gcd(b, a % b);}
    static long gcdL(long a, long b){if(b == 0) return a;return gcdL(b, a % b);}

    /*
        lcm(a, a + 1) = a * (a + 1)
        min(a, b) <= lcm(a, b) <= a * b 
    */
    static long lcmL(long a, long b) {return ((a * b) / gcdL(a, b));}
    static int lcm(int a, int b) {return ((a * b) / gcd(a, b));}

    static List<Integer> getDivisors(int n) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i * i <= n; i++)
            if (n % i == 0) {
                ls.add(i);
                if (n / i != i) ls.add(n / i);
            }
        return ls;
    }

    static List<Long> getDivisors(long n) {
        List<Long> ls = new ArrayList<>();
        for (long i = 1; i *  i <= n; i++)
            if (n % i == 0) {
                ls.add(i);
                if (n / i != i) ls.add(n / i);
            }
        return ls;
    }

    static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        while (n % 2 == 0) {factors.add(2); n /= 2;}
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {factors.add(i); n /= i;}
        }
        if (n > 2) factors.add(n);
        return factors;
    }

    static List<Long> primeFactors(long n) {
        List<Long> factors = new ArrayList<>();
        while (n % 2 == 0) {factors.add(2L); n /= 2;}
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {factors.add(i); n /= i;}
        }
        if (n > 2) factors.add(n);
        return factors;
    }

    static long powMod(long a, long b, long mod) {
        a %= mod;
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res = mul(res, a, mod);
            a = mul(a, a, mod); b = (b >> 1);
        }
        return res;
    }

    static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res *= a;
            a *= a;
            b >>= 1;
        }
        return res;
    }

    static long sqrt(long x) {
        long start = 0, end = (long)3e9, ans = 1;
        while(start<=end){
            long mid = end - ((start - end) >> 1);
            if(mid * mid <= x){ans = mid; start = mid+1;}
            else end = mid-1;
        }
        return ans;
    }

    static long inv(long b, long _mod) {return powMod(b, _mod - 2, _mod);}

    //not correct--needs upgrade
    static boolean[] sieve(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++)
            if (prime[p] == true)
                for (int i = p * p; i <= n; i += p) prime[i] = false;
        return prime;
    }

    static boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;
        if (n <= 1 || n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i = i + 6) if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }

    static boolean isPrime(long n) {
        if (n == 2 || n == 3) return true;
        if (n <= 1 || n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i <= Math.sqrt(n); i = i + 6) if (n % i == 0 || n % (i + 2) == 0) return false;
        return true;
    }

    static long findGCD(long a[]) {
        long gcd = a[0];
        for(int i = 1; i < a.length; i++) {
            gcd = gcdL(gcd, abs(a[i], a[a.length - 1 - i]));
            if(gcd == 1) return 1;
        }
        return gcd;
    }

    static int[] KMP(String newS) {
        int []pi = new int[newS.length()];
        for(int i = 1; i < pi.length; i++) {
            int j = pi[i - 1];
            while(j > 0 && newS.charAt(i) != newS.charAt(j)) j = pi[j - 1];
            if(newS.charAt(i) == newS.charAt(j)) j++;
            pi[i] = j;
        }
        return pi;
    }

    static long hash(String s) {
        long hash = 0, pow = 1; int prime = 31;
        for (char c : s.toCharArray()) {
            hash += ((c - 'a' + 1) * pow) % mod;
            pow = (pow * prime) % mod;
        }
        return hash;
    }

    static int nearestVal(int i, List<Integer> ls) {
        int ans = -1, l = 0, r = ls.size() - 1;
        while(l <= r) {
            int mid = r + ((l - r) >> 1);
            if(ls.get(mid) >= i) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ls.get(ans);
    }

    static boolean bs(long val, long []arr) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = r + ((l - r) >> 1);
            if(arr[m] == val) return true;
            else if(arr[m] < val) l = m + 1;
            else r = m - 1;
        }
        return false;
    }

    static long []factorial; static long []inv_factorial;
    static void factorialAndInverseFactorial(int n, long _mod) {
        inv_factorial = new long[n + 1]; factorial = new long[n + 1];
        factorial[0] = 1; int i;
        for(i = 1; i < n + 1; i++) factorial[i] = (i * factorial[i - 1]) % _mod;
        i--;
        inv_factorial[i] = powMod(factorial[i], _mod - 2, _mod);
        for(i--; i >= 0; i--) inv_factorial[i] = (inv_factorial[i + 1] * (i + 1)) % _mod;
    }

    static long nCr(int n, int r, long _mod) {
        if(r > n || r < 0 || n < 0) return 0;
        return ((factorial[n] * inv_factorial[r]) % _mod) * inv_factorial[n - r] % _mod;
    }
} 