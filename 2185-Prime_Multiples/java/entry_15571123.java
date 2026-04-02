import java.io.*;
import java.util.*;

public class entry_15571123 {
    static long n;
    static int k;
    static long[] a;
    static long ans;

    static long gcd(long x, long y) {
        while (y != 0) {
            long t = x % y;
            x = y;
            y = t;
        }
        return x;
    }

    static void dfs(int idx, long curLcm, int parity) {
        for (int i = idx; i < k; i++) {
            long g = gcd(curLcm, a[i]);
            long t = curLcm / g;
            if (t > n / a[i]) continue;
            long nl = t * a[i];
            long cnt = n / nl;
            if (parity == 0) ans += cnt;
            else ans -= cnt;
            dfs(i + 1, nl, 1 - parity);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        n = fs.nextLong();
        k = fs.nextInt();
        a = new long[k];
        for (int i = 0; i < k; i++) a[i] = fs.nextLong();
        Arrays.sort(a);
        ans = 0L;
        dfs(0, 1L, 0);
        System.out.println(ans);
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
        int nextInt() throws IOException { return (int) nextLong(); }
    }
}