import java.util.*;

public class entry_12433729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = sc.nextInt();
        long[] a = new long[k];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextLong();
        }

        long ans = 0;
        for (int i = 1; i < (1 << k); i++) {
            long primeProduct = 1;
            for (int j = 0; j < k; j++) {
                // check if we are using a[j] in this number
                if ((i & (1 << j)) != 0) {
                    // check to not overflow, if we do set primeProduct to n+1 so
                    // ans doesn't change
                    if (primeProduct > n / a[j]) {
                        primeProduct = n + 1;
                        break;
                    }
                    primeProduct *= a[j];
                }
            }

            // Integer.bitCount gives the number of 1's in binary representation,
            // which is also the number of primes we have multiplied
            if (Integer.bitCount(i) % 2 == 1) {
                ans += n / primeProduct;
            } else {
                ans -= n / primeProduct;
            }
        }

        System.out.println(ans);
    }
}