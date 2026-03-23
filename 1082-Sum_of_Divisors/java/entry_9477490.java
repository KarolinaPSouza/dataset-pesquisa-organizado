import java.io.*;
import java.util.*;


public class entry_9477490 {
    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();
    static int mod = (int) 1e9+7;
    static int dirx[] = new int[]{0, 0, 1, -1};
    static int diry[] = new int[]{1, -1, 0, 0};
    static void helper(int n, HashMap<Integer, Integer> map){
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                map.put(i, map.getOrDefault(i, 0)+1);
                if(n/i!=i)
                map.put(n/i, map.getOrDefault(n/i, 0)+1);
            }
        }
    }
    static long helper(long start, long end){
        return (((end-start+mod)%mod)*((end+start)%mod)%mod+(end-start)%mod)*500000004%mod;
    }
    public static void main(String args[]) throws IOException {

        // int T = in.nextInt();
        // while(T-->0){
            long n = in.nextLong();
            long ans = 0;
            for(long i=1;i<=n;){
                long divisor = n/i;
                long lastN = n/divisor;
                ans=(ans+(helper(i-1, lastN)*divisor)%mod)%mod;
                i=lastN+1;
            }
            out.println(ans);
        // }


        out.close();
    }



















    // ========================================================n================================================================================================================================================

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    static long pow(long n, long p, long mod) {
        if (p == 0)
            return 1;
        long next = pow(n, p / 2, mod);
        next = (next * next) % mod;
        if (p % 2 == 1l) {
            next = (next * n) % mod;
        }
        return next;
    }

    static boolean isSorted(char arr[], int i) {
        char prev = '0';
        for (char c : arr) {
            if (c < prev)
                return false;
            prev = c;
        }
        return true;
    }

    static int[] nextArr(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    static void reverse(int a[]) {
        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }
    }

    static ArrayList<ArrayList<Integer>> getAdj(int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    // sieve method
    // boolean sieve[]=new boolean[10000001];
    // Arrays.fill(sieve, true);
    // for(int i=2;i*i<=10000000;i++){
    // if(sieve[i]){
    // for(int j=i*i;j<=10000000;j+=i){
    // sieve[j]=false;
    // }
    // }
    // }
    // ArrayList<Integer> list=new ArrayList<>();
    // for(int i=2;i<=10000000;i++){
    // if(sieve[i])list.add(i);
    // }
    static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1)
            return false;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        for (int i = 5; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static int[] sort(int[] a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : a)
            list.add(i);
        Collections.sort(list);
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        return a;
    }
}

class FastReader {
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String nextToken() {
        while (!st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(buf.readLine());
            } catch (IOException e) {
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    String next() {
        try {
            return buf.readLine();
        } catch (IOException e) {
        }
        return "";
    }
}

class FastWriter {
    BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

    void print(Object object) throws IOException {
        buf.append("" + object);
    }

    void println(Object object) throws IOException {
        print(object);
        buf.append('\n');
    }

    void close() throws IOException {
        buf.close();
    }
}

class Pair {
    int l;
    int r;
    int ind;

    public Pair(int z, int x, int y) {
        this.l = x;
        this.r = y;
        this.ind = z;
    }

    @Override
    public String toString() {
        return "Pair [l=" + l + ", r=" + r + ", ind=" + ind + "]";
    }

    // @Override
    // public boolean equals(Object o) {
    //     Pair a = (Pair) o;
    //     Pair b = this;
    //     return a.l == b.l && a.r == b.r && a.ind==b.ind;
    // }

    // @Override
    // public int hashCode() {
    //     return ("" + this.r + this.r).hashCode();
    // }
}