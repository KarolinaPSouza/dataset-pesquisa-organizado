import java.io.*;
import java.lang.*;
import java.util.*;

public class entry_6529111 {
    private static void solve() throws IOException {
        //Solve here
        int n = sc.nextInt();
        int[] ar = arrayIn(n);
        Set<Integer> set = new HashSet<>();
        for(int a:ar) set.add(a);
        ans.append(set.size());

    }





    public static void main(String[] args) throws IOException {
        int t = 1;
        // int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        System.out.println(ans);
        out.flush();
        out.close();
    }





























    static final FastReader sc = new FastReader();
    static final PrintWriter out = new PrintWriter(System.out);
    static StringBuilder ans = new StringBuilder();
    static boolean[] prime;
    static final Random random = new Random();
    static int M = 1_000_000_007;

    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        Arrays.sort(arr);
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static long nCk(int n, int k) {
        return (modMult(fact(n), power(modMult(fact(n - k), fact(k)), M - 2)));
    }

    static long fact(long n) {

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = modMult(fact, i);
        }
        return fact % M;
    }

    static int lower_bound(int[] array, int key) {

        int index = Arrays.binarySearch(array, key);
        if (index < 0) {
            return Math.abs(index) - 1;
        } else {
            while (index > 0) {
                if (array[index - 1] == key)
                    index--;
                else
                    return index;
            }
            return index;
        }
    }

    static long modMult(long a, long b) {
        return a * b % M;
    }

    static long power(long x, long y) {
        long res = 1;
        x = x % M;
        if (x == 0)
            return 0;
        while (y > 0) {
            if ((y & 1) != 0)
                res = (res * x) % M;
            y = y >> 1;
            x = (x * x) % M;
        }
        return res;
    }

    static void sieveOfEratosthenes(int n) {
        prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;
        prime[0] = false;
        if (1 <= n)
            prime[1] = false;
        for (int p = 2; p * p <= n; p++) {

            if (prime[p]) {

                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
    }

    static int[] arrayIn(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    static class Pair<E, F> implements Comparable {
        private E v1;
        private F v2;

        Pair(E v1, F v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        Pair() {
        }

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
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