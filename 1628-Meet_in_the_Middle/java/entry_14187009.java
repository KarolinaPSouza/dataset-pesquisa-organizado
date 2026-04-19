import java.io.*;
import java.util.*;
 
public class entry_14187009 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int n = fs.nextInt();
        long x = fs.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = fs.nextLong();
 
        int n1 = n / 2, n2 = n - n1;
        int L = 1 << n1, R = 1 << n2;
 
        long[] left = new long[L];
        long[] right = new long[R];
 
        // left sums via ctz DP: left[mask] = left[mask ^ lsb] + a[bit]
        for (int mask = 1; mask < L; mask++) {
            int lsb = mask & -mask;
            int bit = Integer.numberOfTrailingZeros(lsb); // 0..n1-1
            left[mask] = left[mask ^ lsb] + a[bit];
        }
        // right sums
        for (int mask = 1; mask < R; mask++) {
            int lsb = mask & -mask;
            int bit = Integer.numberOfTrailingZeros(lsb); // 0..n2-1
            right[mask] = right[mask ^ lsb] + a[n1 + bit];
        }
 
        Arrays.sort(left);
        Arrays.sort(right);
 
        long ans = 0;
        int i = 0, j = R - 1;
        while (i < L && j >= 0) {
            long sum = left[i] + right[j];
            if (sum == x) {
                long lv = left[i], rv = right[j];
                long c1 = 0, c2 = 0;
                while (i < L && left[i] == lv) { ++c1; ++i; }
                while (j >= 0 && right[j] == rv) { ++c2; --j; }
                ans += c1 * c2;
            } else if (sum < x) {
                ++i;
            } else {
                --j;
            }
        }
 
        System.out.println(ans);
    }
 
    // Fast input
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) { len = in.read(buffer); ptr = 0; if (len <= 0) return -1; }
            return buffer[ptr++];
        }
        long nextLong() throws IOException {
            int c; long sgn = 1, val = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sgn = -1; c = read(); }
            for (; c > ' '; c = read()) val = val * 10 + (c - '0');
            return val * sgn;
        }
        int nextInt() throws IOException { return (int) nextLong(); }
    }
}