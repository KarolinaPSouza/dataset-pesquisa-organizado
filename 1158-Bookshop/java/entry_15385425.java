import java.io.*;
import java.util.*;

public class entry_15385425 {
    private static final int mod = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        // FastScanner sc = new FastScanner("input.txt");
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int money = sc.nextInt();
        int[] price = new int[n];
        int[] pages = new int[n];

        int[] dp = new int[money + 1];

        for (int i = 0; i < n; i++)
            price[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            pages[i] = sc.nextInt();

        for (int j = 0; j < n; j++) {
            for (int i = money; i >= price[j]; i--){
                if (i >= price[j]) {
                    dp[i] = Math.max(pages[j] + dp[i - price[j]], dp[i]);
                }
            }
        }

        System.out.println(dp[money]);
    }

    // Fast scanner
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        // Read from standard input
        FastScanner() {
            this.in = System.in;
        }

        // Read from file
        FastScanner(String fileName) throws FileNotFoundException {
            this.in = new FileInputStream(fileName);
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1)
                    return null;
            }
            do {
                sb.append((char) c);
                c = read();
            } while (c > ' ');
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1)
                    return Integer.MIN_VALUE;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1)
                    return Long.MIN_VALUE;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}