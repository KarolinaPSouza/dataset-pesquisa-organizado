import java.util.Scanner;

public class entry_14585544 {
    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        long ans = 0;
        long d = 1;
        long inv2 = (MOD + 1) / 2;

        while (d <= n) {
            long q = n / d;
            long maxD = n / q;

            long count = maxD - d + 1;
            long sum = (d + maxD) % MOD;
            long sumD = (((count % MOD) * sum) % MOD * inv2) % MOD;

            ans = (ans + (q % MOD) * sumD) % MOD;
            d = maxD + 1;
        }

        System.out.println(ans);
    }
}