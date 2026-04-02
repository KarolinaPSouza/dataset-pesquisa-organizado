import java.util.Scanner;

public class entry_9508846 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int k = scanner.nextInt();
        long[] a = new long[k];
        for (int i = 0; i < k; i++) a[i] = scanner.nextLong();

        long ans = 0;
        for (long i = 1; i < (1 << k); i++) {
            long prime_product = 1;
            for (int j = 0; j < k; j++) {
                if ((i & (1 << j)) != 0) {
                    if (prime_product > n / a[j]) {
                        prime_product = n + 1;
                        break;
                    }
                    prime_product *= a[j];
                }
            }

            if (Long.bitCount(i) % 2 == 1) {
                ans += n / prime_product;
            } else {
                ans -= n / prime_product;
            }
        }

        System.out.println(ans);
    }
}