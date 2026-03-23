import java.io.*;
import java.util.*;

public class entry_15027191 {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        long n = sc.nextLong();
        long ans = 0;

        long i = 1;
        while (i <= n) {
            long q = n / i;
            long j = n / q;
            long count = j - i + 1;

            // Compute sumD = (i + j) * count / 2 safely
            long a = (i + j) % MOD;
            long b = count;
            if (b % 2 == 0) {
                b /= 2;
            } else {
                a = (a * modInverse(2, MOD)) % MOD;
            }
            long sumD = (a % MOD * (b % MOD)) % MOD;

            ans = (ans + sumD * (q % MOD) % MOD) % MOD;

            i = j + 1;
        }

        System.out.println(ans);
    }

    static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    static long modPow(long a, long b, long mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}
