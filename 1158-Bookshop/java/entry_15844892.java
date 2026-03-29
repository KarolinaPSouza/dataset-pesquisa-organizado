import java.io.*;
import java.util.*;

public class entry_15844892 {

    static int sol(int[] prices, int[] pages, int x, int i, int price, int[][] dp) {
        if (i == prices.length)
            return 0;

        if (dp[i][price] != -1) {
            return dp[i][price];
        }
        int ans = 0;
        if (price + prices[i] <= x) {
            ans = Math.max(ans, sol(prices, pages, x, i + 1, price + prices[i], dp) + pages[i]);
        }
        ans = Math.max(ans, sol(prices, pages, x, i + 1, price, dp));
        return dp[i][price] = ans;
    }

    static void solve(FastScanner fs, FastWriter out) throws Exception {
        // Write Code
        int n = fs.nextInt();
        int x = fs.nextInt();

        int[] prices = new int[n];
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = fs.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pages[i] = fs.nextInt();
        }

        int[][] dp = new int[n + 1][x + 1];
        // for (int[] arr : dp) {
        // Arrays.fill(arr, -1);
        // }

        for (int i = 1; i <= n; i++) {
            for (int price = 0; price <= x; price++) {

                int skip = dp[i - 1][price];

                int take = 0;
                if (price >= prices[i-1]) {
                    take = pages[i-1] + dp[i - 1][price - prices[i-1]];
                }

                dp[i][price] = Math.max(skip, take);
            }
        }

        out.println(dp[n][x]);
        // out.println(sol(prices, pages, x, 0, 0, dp));
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        FastWriter out = new FastWriter();
        solve(fs, out);
        out.flush();
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') {
                if (c == -1)
                    return Integer.MIN_VALUE;
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') {
                if (c == -1)
                    return Long.MIN_VALUE;
            }
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }

        String next() throws IOException {
            int c;
            while ((c = readByte()) <= ' ') {
                if (c == -1)
                    return null;
            }
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }
    }

    static class FastWriter {
        private final StringBuilder sb = new StringBuilder();

        void print(String s) {
            sb.append(s);
        }

        void print(long x) {
            sb.append(x);
        }

        void println(String s) {
            sb.append(s).append('\n');
        }

        void println(long x) {
            sb.append(x).append('\n');
        }

        void flush() {
            System.out.print(sb.toString());
        }
    }

}