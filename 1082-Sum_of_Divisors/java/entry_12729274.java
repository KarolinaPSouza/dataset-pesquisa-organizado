import java.util.Scanner;

public class entry_12729274 {
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long result = 0;

        long sqrtN = (long) Math.sqrt(n);

        // Sum for d from 1 to sqrt(n)
        for (long d = 1; d <= sqrtN; d++) {
            long count = n / d;
            result = (result + d * count) % MOD;
        }

        // Sum for k from 1 to floor(n / (sqrt(n) + 1))
        // Here, k = floor(n / d) for d > sqrt(n)
        long maxK = n / (sqrtN + 1);
        for (long k = 1; k <= maxK; k++) {
            long start = n / (k + 1) + 1;
            long end = n / k;
            if (start > end) continue;

            // Sum of d from start to end: sum = (start + end) * (end - start + 1) / 2
            long sum = (start + end) % MOD;
            sum = sum * ((end - start + 1) % MOD) % MOD;
            sum = sum * inv(2) % MOD; // Using modular inverse for division by 2
            result = (result + k * sum) % MOD;
        }

        System.out.println(result);
    }

    // Modular inverse using Fermat's little theorem (only works if MOD is prime)
    private static long inv(long a) {
        return pow(a, MOD - 2);
    }

    // Fast exponentiation method
    private static long pow(long a, long b) {
        long result = 1;
        a = a % MOD;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % MOD;
            }
            a = (a * a) % MOD;
            b = b / 2;
        }
        return result;
    }
}