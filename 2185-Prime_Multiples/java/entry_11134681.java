import java.util.Scanner;

public class entry_11134681 {
    static long n;
    static int k;
    static long[] primes;
    static long total = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextLong();
        k = scanner.nextInt();

        primes = new long[k];
        for (int i = 0; i < k; i++) {
            primes[i] = scanner.nextLong();
        }

        dfs(0, 0, 1L);

        System.out.println(total);
        scanner.close();
    }

    static void dfs(int index, int count, long prod) {
        if (index == k) {
            if (count == 0) return;
            long cnt = n / prod;
            if ((count & 1) == 1) {
                total += cnt;
            } else {
                total -= cnt;
            }
            return;
        }

        if (safeMultiply(prod, primes[index], n)) {
            dfs(index + 1, count + 1, prod * primes[index]);
        }
        dfs(index + 1, count, prod);
    }

    static boolean safeMultiply(long a, long b, long limit) {
        if (a == 0 || b == 0) return true;
        if (a > limit / b) return false;
        return true;
    }
}