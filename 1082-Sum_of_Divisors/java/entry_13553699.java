import java.util.Scanner;

public class entry_13553699 {
    static final long MOD = 1000000007;
    static final long INV2 = 500000004;

    public static long solve(long n) {
        long ans = 0;
        long i = 1;

        while (i <= n) {
            long k = n / i;
            long last = n / k;

            long count = ((last - i + 1) % MOD + MOD) % MOD;
            long sum = ((i + last) % MOD + MOD) % MOD;

            long term = (((count * sum) % MOD) * INV2) % MOD;
            term = (term * (k % MOD)) % MOD;

            ans = (ans + term) % MOD;

            i = last + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(solve(n));
    }
}