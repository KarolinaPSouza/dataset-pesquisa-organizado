//AUTHOR : Shashwata_32
import java.io.*;
import java.util.*;

public class entry_15961343 {


 // Some properties of number theory are listed here : 
 // 1. ax + by = c here c can only be multiples of gcd(a,b) and the largest number which cant be made using them is lcm(a,b)-a-b (Chicken Nugget Theorum)
 // 2. F1(x) + F2 + F3 ... F1e9(y) = ? Answer : F(y+2) - F(x+1)
 // 3. gcd(Fx , Fy) = gcd (x , y)
 // 4. To check if a no is fibonacci or not check if 5x^2 + 4 or 5x^2 - 4 is a perfect square or not
    static FastReader ob = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static final int MOD = (int)1e9 + 7;
    static final int N = (int)1e6 + 5;
    static long[] fact = new long[N];
    static boolean[] isPrime = new boolean[N];
    static long[] der = new long[1000001];
    static int[] tree, arr;

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    static int ans = Integer.MAX_VALUE;

    static void solve() {
        String s = ob.next(), t = ob.next();
        int i, n = s.length(), m = t.length(), j;

        int dp[][] = new int[n + 1][m + 1];

        // dp[i][j] -> no of transtions required for (1, i) in s to (1, j) in t

        for(i=0;i<=m;i++) dp[0][i] = i;
        for(i=0;i<=n;i++) dp[i][0] = i;
        for(i=1;i<=n;i++) {
            char ch1 = s.charAt(i - 1);
            for(j=1;j<=m;j++) {
                char ch2 = t.charAt(j - 1);

                if(ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                else {
                    int x = dp[i - 1][j - 1]; // delete
                    int y = dp[i - 1][j];
                    int z = dp[i][j - 1];
                    dp[i][j] = 1 + Math.min(x, Math.min(y, z));
                }
            }
        }

        // for(i=0;i<=n;i++) {
        //     for(j=0;j<=m;j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[n][m]);
    }

    static void perm(int a[], int p[], int x) {
        if(x == 3) {
            cal(a, p, 0);
            return;
        }

        int i;
        for(i=x;i<3;i++) {
            swap(p, x, i);
            perm(a, p, x + 1);
            swap(p, x, i);
        }
    }

    static void cal(int a[], int p[], int x) {
        int arr[] = p.clone();
        int c = 0, idx = 0, i;

        for(i=0;i<4;i++) {
            int temp = a[i];
            int col = 0;
            while (temp > 0) {
                if(arr[idx] == 0) idx++;
                col++;

                int take = Math.min(temp, arr[idx]);
                arr[idx] -= take;
                temp -= take;

            }

            c += col;
        }

        ans = Math.min(ans, c);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static long binExp(long a, long b, long mod) {
        a %= mod;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    static void sieve(int n) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = false;
            }
        }
    }

    static void precomputeFactorials() {
        fact[0] = 1;
        for (int i = 1; i < N; i++)
            fact[i] = (fact[i - 1] * i) % MOD;
    }

    static void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node + 1, l, mid);
        build(2 * node + 2, mid + 1, r);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    static void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            tree[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) update(2 * node + 1, l, mid, idx, val);
        else update(2 * node + 2, mid + 1, r, idx, val);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    static int query(int node, int l, int r, int ql, int qr) {
        if (qr < l || ql > r) return 0;
        if (ql <= l && r <= qr) return tree[node];
        int mid = (l + r) / 2;
        return query(2 * node + 1, l, mid, ql, qr) + query(2 * node + 2, mid + 1, r, ql, qr);
    }

    static long modInverse(long a, long mod) {
        return binExp(a, mod - 2, mod);
    }

    static long nCr(int n, int r) {
        if (r > n || r < 0) return 0;
        return fact[n] * modInverse(fact[r], MOD) % MOD * modInverse(fact[n - r], MOD) % MOD;
    }

static void computeDerangements(int N, int MOD) {
der[1] = 0;
der[2] = 1;
for (int i = 3; i <= N; i++) {
der[i] = ((i - 1L) * (der[i - 1] + der[i - 2]) % MOD) % MOD;
}
}
// Used for ax + by = gcd(a,b) [Bezout's identity]
// We give input as a and b and it not only returns gcd but also the values of x and y for which the equation satisfies

static long modInverseGCD(long a, long m) {
    long[] res = extendedGCD(a, m);
    long g = res[0], x = res[1];
    if (g != 1) throw new ArithmeticException("Inverse doesn't exist");
    return (x % m + m) % m;
}

static long[] extendedGCD(long a, long b) {
    if (b == 0) return new long[]{a, 1, 0};
    long[] res = extendedGCD(b, a % b);
    long d = res[0], x = res[2], y = res[1] - (a / b) * res[2];
    return new long[]{d, x, y};
}

static class Pair<A extends Comparable<A>, B extends Comparable<B>> implements Comparable<Pair<A, B>> {
    A first;
    B second;

    Pair(A a, B b) {
        this.first = a;
        this.second = b;
    }

    @Override
    public int compareTo(Pair<A, B> p) {
        int cmp = this.first.compareTo(p.first);
        return (cmp != 0) ? cmp : this.second.compareTo(p.second);
    }

    @Override
    public String toString() {
        return first + " " + second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair<?, ?> p = (Pair<?, ?>) o;
        return first.equals(p.first) && second.equals(p.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}