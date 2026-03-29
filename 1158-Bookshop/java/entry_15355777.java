import java.io.*;
import java.util.*;

public class entry_15355777 {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int k = fs.nextInt();

        int[] cost = new int[n];
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) cost[i] = fs.nextInt();
        for (int i = 0; i < n; i++) pages[i] = fs.nextInt();

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            for (int w = k; w >= cost[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - cost[i]] + pages[i]);
            }
        }

        System.out.println(dp[k]);
    }

    // FAST INPUT
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) { in = is; }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') if (c == -1) return -1;
            int sign = 1;
            if (c == '-') { sign = -1; c = read(); }
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}