import java.io.*;
import java.util.*;

public class entry_14861896 {
    static final long MOD = 1_000_000_007;
    static final long INV2 = (MOD + 1) / 2; // modular inverse of 2

    static long sumOfN(long n) {
        n %= MOD;
        return n * ((n + 1) % MOD) % MOD * INV2 % MOD;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long ans = 0;

        for (long i = 1, j; i <= n; i = j + 1) {
            long q = n / i;
            j = n / q;
            long rangeSum = (sumOfN(j) - sumOfN(i - 1) + MOD) % MOD;
            ans = (ans + q % MOD * rangeSum) % MOD;
        }

        System.out.println(ans);
    }
}