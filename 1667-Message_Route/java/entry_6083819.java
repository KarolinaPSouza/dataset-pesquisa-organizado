import java.util.*;

import java.io.*;

public class entry_6083819 extends Modulo {
    private static SuperFastReader sc = new SuperFastReader();
    private static PrintWriter out = new PrintWriter(System.out);

    // static {
    // try {
    // sc = new SuperFastReader("input.txt");
    // out = new PrintWriter("output.txt");
    // } catch (Exception e) {
    // debug(e);
    // }
    // }

    public static void main(String[] args) throws IOException {
        // int t = sc.Int();
        // for (int i = 1; i <= t; ++i) {
        //     // System.out.print("Case #" + i + ": ");
        //     solve();
        // }
        solve();
        sc.close();
        out.close();
    }

    public static void solve() throws IOException {
        int n = sc.Int();
        int m = sc.Int();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i <= n;i++) adj.add(new ArrayList<>());
        for(int i = 0;i < m;i++){
            int u = sc.Int();
            int v = sc.Int();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visit[] = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        Map<Integer,Integer> mp = new HashMap<>();
        for(;!q.isEmpty();){
            int s = q.size();
            for(;s > 0;--s){
                int node = q.poll();
                if(node == n){
                    break;
                }
                for(var c:adj.get(node)){
                    if(!visit[c]){
                        visit[c] = true;
                        mp.put(c,node);
                        q.add(c);
                    }
                }
            }
        }
        if(!visit[n]){
            println("IMPOSSIBLE");
            return;
        }
        List<Integer> path = new ArrayList<>();
        for(int curr = n;curr != 1;){
            path.add(curr);
            curr = mp.get(curr);
        }
        path.add(1);
        println(path.size());
        for(int i = path.size() - 1;i >= 0;--i){
            print(path.get(i) + " ");
        }
        println();

    }

    public static <T> void debug(T data) {
        System.out.println(data);
    }

    public static <T> void print(T data) {
        out.print(data);
    }

    public static <T> void println(T data) {
        out.println(data);
    }

    public static void println() {
        out.println();
    }

    public static void read(int arr[]) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.Int();
        }
    }

    public static void read(long arr[]) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.Long();
        }
    }

    public static void read(String arr[]) throws IOException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }
    }

    public static void read(int mat[][]) throws IOException {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.Int();
            }
        }
    }

    public static void read(long mat[][]) throws IOException {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.Long();
            }
        }
    }

    public static void reverse(int[] a, int l, int r) {
        for (; l < r; ++l, --r) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
        }
    }

    public static void reverse(long[] a, int l, int r) {
        for (; l < r; ++l, --r) {
            long t = a[l];
            a[l] = a[r];
            a[r] = t;
        }
    }

}

class DSU {
    private int par[];
    private long size[];

    public DSU(int n) {
        par = new int[n];
        size = new long[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }
    }

    public int get(int c) {
        if (c == par[c])
            return c;
        return par[c] = get(par[c]);
    }

    public void union(int x, int y) {
        x = get(x);
        y = get(y);
        if (x != y) {
            if (size[x] < size[y]) {
                int t = x;
                x = y;
                y = t;
            }
            par[y] = x;
            size[x] += size[y];
        }
    }
}

class SuperFastReader {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar, numChars;

    // standard input
    public SuperFastReader() {
        stream = System.in;
    }

    // file input
    public SuperFastReader(String file) throws IOException {
        stream = new FileInputStream(file);
    }

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

    public String nextLine() {
        int c;
        do {
            c = nextByte();
        } while (c < '\n');
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c > '\n');
        return res.toString().trim(); // .trim() used to remove '\n' from either ends
    }

    public int Int() {
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

    public long Long() {
        int c;
        do {
            c = nextByte();
        } while (c <= ' ');
        int sgn = 1;
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

    public double Double() {
        return Double.parseDouble(next());
    }

    public char Char() {
        return next().charAt(0);
    }

    public void close() throws IOException {
        stream.close();
    }
}

class Pair<K, V> {
    public K key;
    public V value;

    Pair(K k, V v) {
        key = k;
        value = v;
    }
}

class Modulo {
    public static final int MOD = (int) 1e9 + 7;

    public static long inv[];

    public static long fact[];

    public static long invFact[];

    // static {
    // int N = (int) 1e5;
    // inv = new long[N + 1];
    // fact = new long[N + 1];
    // invFact = new long[N + 1];

    // fact[0] = 1;
    // for (int i = 1; i <= N; ++i) {
    // fact[i] = mulMod(fact[i - 1], i);
    // }

    // invFact[0] = 1;
    // for (int i = 1; i <= N; ++i) {
    // invFact[i] = mulMod(invFact[i - 1], invMod(i));
    // }
    // }

    private static void preComputeInverse(int N) {
        inv[0] = 0;
        inv[1] = 1;
        for (int i = 2; i <= N; ++i) {
            inv[i] = (MOD - (MOD / i)) * inv[MOD % i] % MOD;
        }
    }

    public static long powMod(long base, long exp) {
        long ans = 1;
        for (; exp != 0;) {
            if ((exp & 1) == 1) {
                ans *= base;
                ans %= MOD;
            }
            base *= base;
            base %= MOD;
            exp = exp >> 1;
        }
        return ans;
    }

    public static long mulMod(long a, long b) {
        long ans = 0;
        for (; b != 0;) {
            if ((b & 1) == 1) {
                ans += a;
                ans %= MOD;
            }
            a += a;
            a %= MOD;
            b >>= 1;
        }
        return ans;
    }

    public static long invMod(long num) {
        return powMod(num, MOD - 2); // only works if MOD is prime
    }

    public static long divMod(long a, long b) {
        return mulMod(a, invMod(b));
    }

    public static long factMod(int n) {
        return fact[n];
    }

    public static long nCrMod(int n, int r) {
        if (n < r)
            return 0;
        if (r == 0)
            return 1;

        return mulMod(fact[n], mulMod(invFact[n - r], invFact[r]));
    }
}