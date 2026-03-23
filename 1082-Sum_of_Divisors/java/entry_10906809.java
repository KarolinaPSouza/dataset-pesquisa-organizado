import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

public class entry_10906809 { 
    static FastInputReader in = new FastInputReader(); 
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws Exception {
        long n = in.nextLong();
        long MOD = (long)1e9+7;
        //System.out.println(n);
        long ans = 0;
        long half = modInverse(2, MOD);

        for (long i=1; i*i<=n; i++) {
            long end = n / i;
            long left = i * (end-i+1) % MOD;
            ans += left;
            ans %= MOD;

            long right = ((end-i) % MOD) * ((i+1+end) % MOD) % MOD * half % MOD;
            ans += right;
            ans %= MOD;
        }

        System.out.println(ans);
    }




























    // ==================================================================
    // ======================== Boilerplate Code ========================
    // ==================================================================
    static class FastInputReader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        public FastInputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        BigInteger nextBigInteger() throws IOException {
            return new BigInteger(next());
        }

        BigDecimal nextBigDecimal() throws IOException {
            return new BigDecimal(next());
        }

        char nextChar() throws IOException {
            String s = next();
            if (s.length() != 1) {
                throw new IOException("nextChar expecting token of length 1. Instead found: " + s);
            }
            return s.charAt(0);
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        String nextLine() throws IOException {
            String str;
            if (tokenizer != null && tokenizer.hasMoreTokens()) {
                str = tokenizer.nextToken("\n");
            } else {
                str = reader.readLine();
            }
            return str;
        }

        int[] nextArrayInt(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] nextArrayLong(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        double[] nextArrayDouble(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }

        char[] nextArrayChar(int n) throws IOException {
            return next().toCharArray();
        }

        BigInteger[] nextArrayBigInteger(int n) throws IOException {
            BigInteger[] arr = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextBigInteger();
            }
            return arr;
        }

        BigDecimal[] nextArrayBigDecimal(int n) throws IOException {
            BigDecimal[] arr = new BigDecimal[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextBigDecimal();
            }
            return arr;
        }

        String[] nextArrayString(int n) throws IOException {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = next();
            }
            return arr;
        }
    }

    static long gcd(long x, long y) {
        x = Math.abs(x);
        y = Math.abs(y);

        while (y != 0) {
            long c = x % y;
            x = y;
            y = c;
        }
        return x;
    }

    public static int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        while (y != 0) {
            int c = x % y;
            x = y;
            y = c;
        }
        return x;
    }


    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    // Returns the next permutation of [start, end) in ascending. 
    // Will return false when there are none left. Can handle duplicates just fine.
    public static boolean nextPermutation(int[] nums, int start, int end) { 
        for (int i=end-2; i>=start; i--) {
            if (nums[i] < nums[i+1]) {
                int replacement = nums[i+1]; 
                int replacementIndex = i+1;
                for (int j=i+2; j<end; j++) {
                    if (nums[j] > nums[i] && nums[j] <= replacement) {
                        replacement = nums[j];
                        replacementIndex = j;
                    }
                }
                swap(nums, i, replacementIndex);
                reverse(nums, i+1, end);  // sort the tail, which is conveniently reversed
                return true;
            }
        }
        return false;
    }

    public static void reverse(int[] nums, int start, int end) { // swaps [start, end)
        end--;
        while (start < end) {
            swap(nums, start, end);
            start++; 
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // Fisher-Yates shuffle algorithm - Can be used to avoid quicksort's O(N^2) worst case
    public static void arrayShuffle(int[] arr) { 
        Random r = new Random();
        for (int i=arr.length-1; i>=1; i--) {
            int inx = r.nextInt(i+1);
            int t = arr[inx];
            arr[inx] = arr[i];
            arr[i] = t;
        }
    }

    // Fisher-Yates shuffle algorithm - Can be used to avoid quicksort's O(N^2) worst case
    public static void arrayShuffle(long[] arr) { 
        Random r = new Random();
        for (int i=arr.length-1; i>=1; i--) {
            int inx = r.nextInt(i+1);
            long t = arr[inx];
            arr[inx] = arr[i];
            arr[i] = t;
        }
    }

    // Fisher-Yates shuffle algorithm - Can be used to avoid quicksort's O(N^2) worst case
    public static void arrayShuffle(double[] arr) { 
        Random r = new Random();
        for (int i=arr.length-1; i>=1; i--) {
            int inx = r.nextInt(i+1);
            double t = arr[inx];
            arr[inx] = arr[i];
            arr[i] = t;
        }
    }

    // Computes a^b % mod
    public static long modpow(long a, long b, long mod) {
        if (a == 0 || a == 1) {
            return a;
        }
        a %= mod;
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = (ans * a) % mod;
            }
            b >>= 1;
            a = a * a % mod; 
        }

        return ans;
    } 

    // WARNING: Only works for prime MOD. 
    public static long modInverse(long a, long mod) {  
        return modpow(a, mod-2, mod); // fermat's little theorem a^(p-1) = 1(mod p)
    }

    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static long[] concat(long[] a, long[] b) {
        long[] result = new long[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static String[] concat(String[] a, String[] b) {
        String[] result = new String[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static double[] concat(double[] a, double[] b) {
        double[] result = new double[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static char[] concat(char[] a, char[] b) {
        char[] result = new char[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    // Assumes non-zero arguments
    public static int min(int... x) {
        int m = x[0];
        for (int xx : x) {
            if (m > xx) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static long min(long... x) {
        long m = x[0];
        for (long xx : x) {
            if (m > xx) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static double min(double... x) {
        double m = x[0];
        for (double xx : x) {
            if (m > xx) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static char min(char... x) {
        char m = x[0];
        for (char xx : x) {
            if (m > xx) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static String min(String... x) {
        String m = x[0];
        for (String xx : x) {
            if (m.compareTo(xx) > 0) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static int max(int... x) {
        int m = x[0];
        for (int xx : x) {
            if (m < xx) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static long max(long... x) {
        long m = x[0];
        for (long xx : x) {
            if (m < xx) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static double max(double... x) {
        double m = x[0];
        for (double xx : x) {
            if (m < xx) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static char max(char... x) {
        char m = x[0];
        for (char xx : x) {
            if (m < xx) {
                m = xx;
            }
        }
        return m;
    }

    // Assumes non-zero arguments
    public static String max(String... x) {
        String m = x[0];
        for (String xx : x) {
            if (m.compareTo(xx) < 0) {
                m = xx;
            }
        }
        return m;
    }
}