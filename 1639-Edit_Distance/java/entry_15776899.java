import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class entry_15776899 {

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        String nextLine() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) != -1 && c != '\n')
                sb.append((char) c);
            return sb.toString();
        }
    }

    static int[][] dp;

    public static void main(String args[]) throws IOException {
        FastScanner fs = new FastScanner(System.in);

        String w1 = fs.nextLine();
        String w2 = fs.nextLine();

        int n = w1.length();
        int m = w2.length();

        dp = new int[n + 1][m + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(solve(n, m, w1, w2));
    }

    public static int solve(int i, int j, String w1, String w2) {

        // base cases
        if (i == 0) return j;
        if (j == 0) return i;

        // memo check
        if (dp[i][j] != -1)
            return dp[i][j];

        // if characters match
        if (w1.charAt(i - 1) == w2.charAt(j - 1)) {
            return dp[i][j] = solve(i - 1, j - 1, w1, w2);
        }

        // insert, delete, replace
        int delete = solve(i - 1, j, w1, w2);
        int insert = solve(i, j - 1, w1, w2);
        int replace = solve(i - 1, j - 1, w1, w2);

        return dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
    }
}