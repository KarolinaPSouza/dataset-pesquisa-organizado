import java.io.*;
import java.util.*;

public class entry_14970721 {

    static final long MOD = 1000000007L;

    // Fast modular exponentiation
    static long myPow(long a, long n, long m) {
        long res = 1;
        a %= m;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * a) % m;
                n--;
            }
            a = (a * a) % m;
            n /= 2;
        }
        return res;
    }

    // Modular inverse using Fermat's Little Theorem
    static long modInverse(long num) {
        return myPow(num, MOD - 2, MOD);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long ans = 0;

        for (long i = 1; i * i <= n; i++) {
            ans = (ans + ((n / i) * i) % MOD) % MOD;
        }

        long l = (long) Math.sqrt(n);
        for (long i = (long) Math.sqrt(n); i >= 1; i--) {
            long r = n / i;
            long currSum = 0;

            currSum += (((r % MOD) * ((r + 1) % MOD)) % MOD * modInverse(2)) % MOD;
            currSum %= MOD;

            currSum -= (((l % MOD) * ((l + 1) % MOD)) % MOD * modInverse(2)) % MOD;
            currSum = (currSum + MOD) % MOD;

            currSum = (currSum * i) % MOD;
            l = r;
            ans = (ans + currSum) % MOD;
        }

        System.out.println(ans);
    }
}