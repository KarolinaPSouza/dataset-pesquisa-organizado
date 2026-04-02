import java.io.*;
import java.util.*;

public class entry_1472966 {
    private static StreamTokenizer in;
    private static PrintWriter out;

    public static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }

    public static void main(String[] args) throws IOException {
//        Scanner in = new Scanner(System.in);
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        in = new StreamTokenizer(new BufferedReader(new FileReader("src\\main\\resources\\test_input.txt")));
        out = new PrintWriter(System.out);

        String a = next();
        String b = next();
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][m] = n - i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[n][i] = m - i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp(a, b, i, j, dp);
            }
        }
        out.println(dp[0][0]);
        out.flush();
    }

    private static int dp(String a, String b, int i, int j, int[][] dp) {
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = dp[i + 1][j + 1];
        }
        return dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
    }
}
