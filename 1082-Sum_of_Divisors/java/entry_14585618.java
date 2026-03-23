import java.util.*;

public class entry_14585618 {
    static final long MOD = 1_000_000_007L;

    public static long sumOfDivisorsUpto(long n) {
        long result = 0;
        long d = 1;
        long inv2 = (MOD + 1) / 2;  // modular inverse of 2

        while (d <= n) {
            long q = n / d;
            long R = n / q;

            long count = (R - d + 1) % MOD;
            long sumDR = ((count * ((d + R) % MOD)) % MOD * inv2) % MOD;

            result = (result + (q % MOD) * sumDR) % MOD;

            d = R + 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(sumOfDivisorsUpto(n));
    }
}