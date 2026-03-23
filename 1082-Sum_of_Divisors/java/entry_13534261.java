import java.util.Scanner;

class Main {
    // modulus
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();

        long ans = 0;
        long d = 1;
        while (d <= n) {
            long q = n / d;            // floor(n/d)
            long r = n / q;            // last d' with same floor(n/d')
            // we need sum_{k=d..r} k  = (r + d)*(r - d + 1)/2
            long cnt = r - d + 1;
            long sumDR = ((d + r) % MOD) * (cnt % MOD) % MOD * inv2 % MOD;

            // add contribution: q * sum_{k=d..r} k
            ans = (ans + q % MOD * sumDR) % MOD;

            d = r + 1;
        }

        System.out.println(ans);
    }

    // modular inverse of 2 under MOD
    static final long inv2 = (MOD + 1) / 2;
}