import java.io.*;
import java.util.*;

public class entry_15570824 {

    static final long MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();

        long ans = 0;
        long i = 1;

        while (i <= n) {
            long v = n / i;
            long last = n / v;

            long sumRange = sum(last) - sum(i - 1);
            if (sumRange < 0) sumRange += MOD;

            ans = (ans + (sumRange % MOD) * (v % MOD)) % MOD;

            i = last + 1;
        }

        System.out.println(ans % MOD);
    }

    // sum of 1..x modulo MOD
    static long sum(long x) {
        x %= MOD;
        return (x * ((x + 1) % MOD) % MOD) * 500000004 % MOD;  // inverse of 2 mod MOD
    }

    // FastScanner same as previous solutions
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= 32) if (c == -1) return -1;

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}