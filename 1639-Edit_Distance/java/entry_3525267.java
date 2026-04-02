import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_3525267 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();

        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i)
            dp[i][0] = i;
        for (int j = 0; j <= m; ++j)
            dp[0][j] = j;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - 1]);
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }

        System.out.println(dp[n][m]);
    }
}