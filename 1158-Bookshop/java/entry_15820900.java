import java.io.*;
import java.util.*;

public class entry_15820900 {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        int x = fs.nextInt();

        int[] price = new int[n];
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = fs.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pages[i] = fs.nextInt();
        }

        int[][] dp = new int[n + 1][x + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {

                dp[i][j] = dp[i - 1][j];

                if (j >= price[i - 1]) {
                    dp[i][j] = Math.max(
                            dp[i][j],
                            pages[i - 1] + dp[i - 1][j - price[i - 1]]
                    );
                }
            }
        }

        out.println(dp[n][x]);
        out.flush();
    }

    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}