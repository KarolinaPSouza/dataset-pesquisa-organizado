//<---------------------HAR HAR MAHADEV------------------------>

//import com.sun.source.tree.Tree;

import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;
import java.math.*;

 public class entry_6550988 {
    static long mod = (long) 1e9 + 7;
    //    static  long mod=(long) 998244353;
    static long  fact[]=new long[200005];

    static void modFact() {
        fact[0] = 1;
        for (long i = 1; i < fact.length; i++) {
            fact[(int) i] = (i * fact[(int) i - 1]) % mod;
        }
    }
    static long modexp(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    static int prime[]=new int[1000001];

    public static void Khud_Bhi_Krle_Kuch(int cct,int tcc) throws IOException {
    long n=nl();
    int k=ni();
    long arr[]=al(k);
    long x=modexp(2,k);
    long ans=0;
    for(int i=1;i<x;i++)
    {
        long xx=n;
        int a=i;
        int ind =0;
        int ct=0;
        while(a>0)
        {
            if(a%2==1) {
            xx/=arr[ind];
            ct++;
            }
            ind++;
            a/=2;
        }
        if(ct%2==0)
            ans-=xx;
        else
            ans+=xx;

    }
    out.println(ans);
    }
    // *-----------------------------------MAIN--------------------------------------------//
    public static void main(String[] args) throws Exception {
//        count();
//        out.println(primeSet);
//        out.println(primeSet.size());
//        modFact();
//
//        sieve();
//        modFact();

//        int t=ni();
        int t=1;
        int ct=1;
//

        while (t--!=0)
        {

//            out.println(Integer.MAX_VALUE/2);
            Khud_Bhi_Krle_Kuch(ct,t);

//            out.println("Case "+ct+": "+(x==-1?"Impossible":x));
            ct++;

        }
//
        out.close();}
    //--------------------------------------------Other Functions----------------------------------------------------//

    static long gcd(long a, long b) {
        BigInteger x = BigInteger.valueOf(a).gcd(BigInteger.valueOf(b));
        return Long.parseLong(String.valueOf(x));
    }
    public static long countfactors(long n) {
        long ans = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                ans += 2;
                if (n / i == i) ans--;
            }
        }
        return ans;
    }

    public static boolean isprime(long n) {
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int[] copy(int[] arr) {
        int[] brr = new int[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        return brr;
    }
    public static char[] copy(char[] arr) {
        char[] brr = new char[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        return brr;
    }

    public static long[] copy(long[] arr) {
        long[] brr = new long[arr.length];
        System.arraycopy(arr, 0, brr, 0, arr.length);
        return brr;
    }


    public static long countDigit(long n) {
        long count = 0;
        while (n != 0) {
            n = n / 10;
            ++count;
        }
        return count;
    }

    public static List<pair> sortpair(long[] n, long[] h) {
        List<pair> A = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            A.add(new pair(h[i], n[i]));
        }
        A.sort(Comparator.comparingLong(a -> a.first));
        return A;
    }

    public static long kadane(long a[]) {
        long max_so_far = Long.MIN_VALUE, max_ending_here = 0;
        for (long l : a) {
            max_ending_here = max_ending_here + l;
            if (max_so_far < max_ending_here) max_so_far = max_ending_here;
            if (max_ending_here < 0) max_ending_here = 0;
        }
        return max_so_far;
    }

    public static long gcd(long arr[]) {
        long gc = arr[0];
        for (int i = 1; i < arr.length; i++) gc = gcd(arr[i], gc);
        return gc;
    }

    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static boolean isSorted(long[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    static int msbNumber(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    static int msbNumber(long n) {
        return (int) (Math.log(n) / Math.log(2));
    }

    public static void reverse(int[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }

    public static int
    justLower(long[] a, long t) {
        int l = 0, r = a.length - 1;
        if (t < a[0]) {
            return -1;
        }
        if (t >= a[r]) {
            return r;
        }
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (a[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return a[r] <= t ? r : l;
    }

    public static int justLower(long[] a, long t, int l, int r) {
        if (t < a[l]) {
            return l - 1;
        }
        if (t >= a[r]) {
            return r;
        }
        while (l < r - 1) {
            int m = l + (r - l) / 2;
            if (a[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return a[r] <= t ? r : l;
    }

    public static int justUpper(long[] a, long t, int l, int r) {
        if (t <= a[l]) {
            return l;
        }
        if (t > a[r]) {
            return -1;
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }

    public static int justUpper(long[] a, long t) {
        int l = 0, r = a.length - 1;
        if (t <= a[0]) {
            return 0;
        }
        if (t > a[r]) {
            return a.length;
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    public static void reverse(long[] a) {
        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            long temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }

    public static boolean isPalindrome(char ac[]) {
        for (int i = 0; i < ac.length / 2; i++) {
            if (ac[i] != ac[ac.length - i - 1]) return false;
        }
        return true;
    }

    static ArrayList<Long> sieve = new ArrayList<>();
    static TreeSet<Long> primeSet = new TreeSet<>();

    public static void sieve(int n) {
        int[] flag = new int[n + 1];
        for (int i = 2; i*i <= n; i++) {
            if (flag[i] == 0) {


                primeSet.add((long)i);


                for (int j = i * i; j <= n; j += i) {
                    flag[j] = 1;
                }
            }


        }
        for(int i=2;i<flag.length;i++)
        {
            if (flag[i]==i||flag[i]==0)
                primeSet.add((long)i);
        }

    }

    static ArrayList<Long> allPrime;

    public static void allprimeFactors(long n) {
        // Print the number of 2s that divide n
        allPrime = new ArrayList<>();
        while (n % 2 == 0) {
            allPrime.add(2L);
            n /= 2;
        }

        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            // While i divides n, print i and divide n
            while (n % i == 0) {
                allPrime.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
            allPrime.add(n);

    }

    static long[][] nCr;

    public static void ncr(int n, int k) {
        nCr = new long[n + 1][k + 1];
        for (int i = 1; i < nCr.length; i++) {
            nCr[i][0] = 1;
        }
        for (int i = 1; i < nCr.length; i++) {
            for (int j = 1; j <= i && j < nCr[0].length; j++) {
                if (i == 1 && j == 1) {
                    nCr[i][j] = 1;
                } else {
                    nCr[i][j] = (nCr[i - 1][j] + nCr[i - 1][j - 1]) % (mod);
                }
            }
        }
    }

    static class pair {
        long first;
        long second;

        pair(long first, long second) {
            this.first = first;
            this.second = second;
        }

        pair(long first, boolean f) {
            if (f) this.first = first;
            else this.second = first;
        }
    }

    static class Reader {
        BufferedReader in;
        StringTokenizer st;

        public Reader() {
            in = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        public String nextLine() throws IOException {
            st = new StringTokenizer("");
            return in.readLine();
        }

        public String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    static Reader in = new Reader();
    static PrintWriter out = new PrintWriter(System.out);




    //-----------------------------INPUT-------------------------------------------------//
    public static int ni() throws IOException {
        return in.nextInt();
    }

    public static long nl() throws IOException {
        return in.nextLong();
    }

    public static double nd() throws IOException {
        return in.nextDouble();
    }

    public static String rl() throws IOException {
        return in.next();
    }

    public static char nc() throws IOException {
        return in.next().charAt(0);
    }

    //----------------------------ARRAYS INPUT--------------------------------------------//
    public static int[] ai(long n) throws IOException {
        int[] arr = new int[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        return arr;
    }

    public static long[] al(long n) throws IOException {
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        return arr;
    }

    public static char[] ac() throws IOException {
        String s = in.next();
        return s.toCharArray();
    }

    public static int[] ac(int n) throws IOException {
        String s = in.next();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = s.charAt(i) - '0';
        return arr;
    }

    //----------------------------Print---------------------------------------------------//
    public static void pt(int[] arr) {
        for (int j : arr) out.print(j + " ");
        out.println(" ");
    }

    public static void pt(long[] arr) {
        for (long l : arr) out.print(l + " ");
        out.println();
    }

    public static void pt(char[] arr) {
        for (char l : arr) out.print(l);
        out.println();
    }

    public static void yes() {
        out.println("YES");
    }

    public static void no() {
        out.println("NO");
    }


}