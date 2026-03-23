import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class entry_2750349 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long n = in.nextLong();
        long ans = 0;
        for (long i = 1; i * i <= n; i++) {
            long from = i + 1, to = n / i;
            ans = add(ans, i);
            ans = add(ans, sumRange(from, to));
            ans = add(mul(to - from + 1, i), ans);
        }
        out.println(ans);
        out.flush();
    }

    static long sumRange(long from, long to) {
        long MOD = 1_000_000_007;
        long l = div(mul(from, from - 1), 2);
        long r = div(mul(to, to + 1), 2);
        return ((r % MOD) - (l % MOD) + MOD) % MOD;
    }

    static long binpow(long x, long y) {
        long res = 1;
        while (y > 0) {
            if (y % 2 == 1) res = mul(res, x);
            x = mul(x, x);
            y /= 2;
        }
        return res;
    }

    static long div(long x, long y) {
        long MOD = 1_000_000_007;
        return mul(x, binpow(y, MOD - 2));
    }

    static long add(long x, long y) {
        long MOD = 1_000_000_007;
        return ((x % MOD) + (y % MOD) + MOD) % MOD;
    }

    static long mul(long x, long y) {
        long MOD = 1_000_000_007;
        return ((x % MOD) * (y % MOD) + MOD) % MOD;
    }
}