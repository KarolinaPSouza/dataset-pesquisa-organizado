import java.io.*;
import java.util.*;

public class entry_15510157 {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long ans = 0;
        long d = 1;

        while (d <= n) {
            long v = n / d;  
            long r = n / v;  


            long L = d, R = r;
            long count = (R - L + 1) % MOD;
            long sumLR = ( (L + R) % MOD ) * count % MOD * inv2() % MOD;

            ans = (ans + v % MOD * sumLR) % MOD;

            d = r + 1;
        }

        System.out.println(ans);
    }


    static long inv2() {
        return 500000004L; // since 2^(MOD-2) mod MOD = 500000004
    }
}