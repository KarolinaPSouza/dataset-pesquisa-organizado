import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_2645116 {
    static class Pair {
        int start, end, cost;
        public Pair(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static int bs(Pair[] arr, int val, int idx) {
        int start = 0;
        int end = idx;
        int ans = -1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if(arr[mid].end < val) {
                ans = mid;
                start = mid+1;
            } else {
                end = mid;
            }
        }
        return ans;
    }
    public static void A() {
       int n = sc.nextInt();
       Pair[] arr = new Pair[n];
       for(int i=0; i<arr.length; i++) {
           arr[i] = new Pair(sc.nextInt(), sc.nextInt(), sc.nextInt());
       }
       ArrayList<Pair> a = new ArrayList<>();
       for(Pair p : arr) a.add(p);
       Collections.sort(a, (f, s) -> f.end-s.end);
       for(int i=0; i<a.size(); i++) arr[i] = a.get(i);
       long[] dp = new long[n];
       long maxv = 0;
       for(int i=0; i<dp.length; i++) {
           long ans = 0;
           int idx = bs(arr, arr[i].start, i);
           ans += arr[i].cost;
           if(idx != -1) ans += dp[idx];
           dp[i] = Math.max(dp[i], ans);
           if(i != 0) dp[i] = Math.max(dp[i-1], dp[i]);
           maxv = Math.max(maxv, dp[i]);
       }
       p.writeln(maxv);
    }

    public static void B() {

    }

    public static void C() {

    }

    public static void solve() {
        A();
//        B();
//        C();
    }

    public static void main(String[] args) {
        int t = 1;
//        t = sc.nextInt();
        while (t-- != 0) {
            solve();
        }
        p.print();
    }


    static final Integer MOD = (int) 1e9 + 7;
    static final FastReader sc = new FastReader();
    static final Print p = new Print();

    static class Functions {

        static void sort(int[] a) {
            ArrayList<Integer> l = new ArrayList<>();
            for (int i : a) l.add(i);
            Collections.sort(l);
            for (int i = 0; i < a.length; i++) a[i] = l.get(i);
        }

        static void sort(long[] a) {
            ArrayList<Long> l = new ArrayList<>();
            for (long i : a) l.add(i);
            Collections.sort(l);
            for (int i = 0; i < a.length; i++) a[i] = l.get(i);
        }

        static int max(int[] a) {
            int max = Integer.MIN_VALUE;
            for (int val : a) max = Math.max(val, max);
            return max;
        }

        static int min(int[] a) {
            int min = Integer.MAX_VALUE;
            for (int val : a) min = Math.min(val, min);
            return min;
        }

        static long min(long[] a) {
            long min = Long.MAX_VALUE;
            for (long val : a) min = Math.min(val, min);
            return min;
        }

        static long max(long[] a) {
            long max = Long.MIN_VALUE;
            for (long val : a) max = Math.max(val, max);
            return max;
        }

        static long sum(long[] a) {
            long sum = 0;
            for (long val : a) sum += val;
            return sum;
        }

        static int sum(int[] a) {
            int sum = 0;
            for (int val : a) sum += val;
            return sum;
        }

        public static long mod_add(long a, long b) {
            return (a % MOD + b % MOD + MOD) % MOD;
        }

        public static long pow(long a, long b) {
            long res = 1;
            while (b > 0) {
                if ((b & 1) != 0)
                    res = mod_mul(res, a);
                a = mod_mul(a, a);
                b >>= 1;
            }
            return res;
        }

        public static long mod_mul(long a, long b) {
            long res = 0;
            a %= MOD;
            while (b > 0) {
                if ((b & 1) > 0) {
                    res = mod_add(res, a);
                }
                a = (2 * a) % MOD;
                b >>= 1;
            }
            return res;
        }

        public static long gcd(long a, long b) {
            if (a == 0) return b;
            return gcd(b % a, a);
        }

        public static long factorial(long n) {
            long res = 1;
            for (int i = 1; i <= n; i++) {
                res = (i % MOD * res % MOD) % MOD;
            }
            return res;
        }

        public static int count(int[] arr, int x) {
            int count = 0;
            for (int val : arr) if (val == x) count++;
            return count;
        }

        public static ArrayList<Integer> generatePrimes(int n) {
            boolean[] primes = new boolean[n];
            for (int i = 2; i < primes.length; i++) primes[i] = true;
            for (int i = 2; i < primes.length; i++) {
                if (primes[i]) {
                    for (int j = i * i; j < primes.length; j += i) {
                        primes[j] = false;
                    }
                }
            }
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < primes.length; i++) {
                if (primes[i]) arr.add(i);
            }
            return arr;
        }
    }

    static class Print {
        StringBuffer strb = new StringBuffer();

        public void write(Object str) {
            strb.append(str);
        }

        public void writes(Object str) {
            strb.append(str).append(" ");
        }

        public void writeln(Object str) {
            strb.append(str).append("\n");
        }

        public void writeln() {
            strb.append('\n');
        }

        public void writes(int[] arr) {
            for (int val : arr) {
                write(val);
                write(' ');
            }
        }

        public void writes(long[] arr) {
            for (long val : arr) {
                write(val);
                write(' ');
            }
        }

        public void writeln(int[] arr) {
            for (int val : arr) {
                writeln(val);
            }
        }

        public void print() {
            System.out.print(strb);
        }

        public void println() {
            System.out.println(strb);
        }
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

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        double[] readArrayDouble(int n) {
            double[] a = new double[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
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