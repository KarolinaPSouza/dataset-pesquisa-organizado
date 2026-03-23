import java.util.Scanner;

public class entry_12101489 {
    static final long MOD = 1000000007;
    static final long INV2 = (MOD + 1) / 2; // Modular inverse of 2 under MOD

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = 0;

        for (long i = 1; i <= n; ) {
            long q = n / i;
            long last = n / q;
            ans = (ans + (q * sum(i, last)) % MOD) % MOD;
            i = last + 1;
        }

        System.out.println(ans);
    }

    private static long sum(long first, long last) {
        long n = last - first + 1;
        long sum = (n % MOD * ((first + last) % MOD) % MOD * INV2) % MOD; // Use modular inverse
        return sum;
    }
}