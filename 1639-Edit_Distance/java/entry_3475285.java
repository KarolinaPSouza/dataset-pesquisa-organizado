import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_3475285 {
    private static final int M = (int) 1e9 + 7;

    private void solve(FastScanner fastScanner, PrintWriter writer) throws IOException {
        String s1 = fastScanner.next();
        String s2 = fastScanner.next();
        int n = s1.length();
        int m = s2.length();
        if (n == 0 || m == 0) {
            writer.println(Math.max(n - m, m - n));
            return;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        writer.println(dp[n][m]);
    }

    public static void main(String[] args) throws IOException {
        FastScanner fastScanner = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        new entry_3475285().solve(fastScanner, writer);
        writer.flush();
        writer.close();
    }

    private static class FastScanner {
        private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer stringTokenizer = new StringTokenizer("");

        public String next() {
            while (!stringTokenizer.hasMoreTokens())
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}