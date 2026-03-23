import java.util.Scanner;

class SumOfDivisors{

    static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long sum = 0;

        for (long l = 1; l <= N; l++) {
            long r = N / (N / l);
            sum += (N / l) % MOD * (sigma(r) - sigma(l - 1) + MOD) % MOD;
            sum = (sum + MOD) % MOD;
            l = r;
        }

        System.out.println(sum);
    }

    static long sigma(long x) {
        return ((x % MOD) * ((x + 1) % MOD) / 2) % MOD;
    }
}