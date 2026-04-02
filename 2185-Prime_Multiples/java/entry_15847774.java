import java.io.*;
import java.util.*;

public class entry_15847774 {

    // SINGLE FUNCTION containing all logic
    static long solve(long n, long[] a) {
        int k = a.length;
        Arrays.sort(a);
        long ans = 0;

        // stack-based DFS to avoid extra functions
        Deque<long[]> stack = new ArrayDeque<>();
        stack.push(new long[]{0, 1, 0}); // idx, lcm, parity

        while (!stack.isEmpty()) {
            long[] cur = stack.pop();
            int idx = (int) cur[0];
            long curLcm = cur[1];
            int parity = (int) cur[2];

            for (int i = idx; i < k; i++) {

                // gcd inline
                long x = curLcm, y = a[i];
                while (y != 0) {
                    long t = x % y;
                    x = y;
                    y = t;
                }
                long g = x;

                long t = curLcm / g;
                if (t > n / a[i]) continue;

                long nl = t * a[i];
                long cnt = n / nl;

                if (parity == 0) ans += cnt;
                else ans -= cnt;

                stack.push(new long[]{i + 1, nl, 1 - parity});
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        long n = fs.nextLong();
        int k = fs.nextInt();

        long[] a = new long[k];
        for (int i = 0; i < k; i++) a[i] = fs.nextLong();

        System.out.println(solve(n, a));
    }

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
            if (c == '-') { sign = -1; c = read(); }
            long val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}