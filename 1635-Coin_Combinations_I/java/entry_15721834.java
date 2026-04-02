import java.io.*;

public class entry_15721834 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int x = fs.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = fs.nextInt();

        int[] dp = new int[x+1];
        dp[0] = 1;

        for(int sum = 1; sum <= x; sum++){
            int ways = 0;
            for(int i = 0; i < n; i++){
                int c = arr[i];
                if(sum >= c){
                    ways += dp[sum - c];
                    if(ways >= MOD) ways -= MOD;
                }
            }
            dp[sum] = ways;
        }

        System.out.println(dp[x]);
    }

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
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

        int nextInt() throws IOException {
            int c, sgn = 1, res = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sgn = -1; c = read(); }
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }
            return res * sgn;
        }
    }
}