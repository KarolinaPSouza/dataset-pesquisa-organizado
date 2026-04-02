import java.io.*;
import java.util.*;

public class entry_15677102 {
    static long MOD = (long)(1e9 + 7);

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16]; // 64 KB buffer
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        // -------- int --------
        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        // -------- long --------
        long nextLong() throws IOException {
            int c;
            long sign = 1, val = 0;

            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        // -------- String --------
        String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder();

            do {
                c = read();
            } while (c <= ' ');

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }

        // -------- char --------
        char nextChar() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');
            return (char) c;
        }
    }



    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();

        long[] dp = new long[n];
        Arrays.fill(dp, Long.MIN_VALUE);
        long max = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long val = fs.nextLong();   
            if( i == 0 ) dp[i] = val;
            else dp[i] = Math.max( val , val + dp[i - 1] );
            max = Math.max( max , dp[i] );
        }

        System.out.println(max);

        return ;
    }

}