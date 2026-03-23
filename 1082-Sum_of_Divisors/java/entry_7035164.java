import java.io.*;

public class entry_7035164 {
    static final int MOD = (int)1e9 + 7;
    static final int TWO_MOD_INV = 500000004;

    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(read.readLine());

        long total = 0;
        long at = 1;
        while (at <= n) {
            long add_amt = n / at;  // Our divisor to process
            // The largest number that still has the same value of q
            long last_same = n / add_amt;

            total = (total + add_amt * totalSum(at, last_same)) % MOD;
            at = last_same + 1;
        }

        System.out.println(total);
    }

    /** @return The sum of all numbers in [start, end] mod MOD. */
    static long totalSum(long start, long end) {
        return ((((end - start + 1) % MOD) * ((start + end) % MOD) % MOD) *
                TWO_MOD_INV % MOD);
    }
}