import java.util.*;
import java.io.*;

public class entry_13471985 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int k = sc.nextInt();

        long[] arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = sc.nextLong();
        }

        long ans = 0;

        for (int mask = 1; mask < (1 << k); mask++) {
            int count = 0;
            long product = 1;
            boolean overflow = false;

            for (int j = 0; j < k; j++) {
                if ((mask & (1 << j)) != 0) {
                    count++;

                    // Avoid overflow: if product * arr[j] > n, stop
                    if (product > n / arr[j]) {
                        overflow = true;
                        break;
                    }

                    product *= arr[j];
                }
            }

            if (overflow || product == 0) continue;

            long multiples = n / product;

            if ((count & 1) == 1) {
                ans += multiples;
            } else {
                ans -= multiples;
            }
        }

        System.out.println(ans);
    }
}