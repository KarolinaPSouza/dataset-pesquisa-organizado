import java.util.*;

public class entry_14086143 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long mod = 1000000007;
        long inv2 = 500000004; // modular inverse of 2 under mod
        long sum = 0;

        for (long i = 1; i <= Math.sqrt(n); i++) {
            long l = n / (i + 1) + 1;
            long r = n / i;
            long nums = r - l + 1;

            long part1 = (((r + l) % mod * (nums % mod)) % mod  * inv2 % mod * i % mod) % mod;
            sum = (sum + part1) % mod;

            long j = n / i;
            if (i != j) {
                l = n / (j + 1) + 1;
                r = n / j;
                nums = r - l + 1;

                long part2 = (((r + l) % mod * (nums % mod)) % mod * inv2 % mod * j % mod) % mod;
                sum = (sum + part2) % mod;
            }
        }

        System.out.println(sum);
    }
}