import java.util.Scanner;

public class entry_12450171 {

    public static int memo(int i, int j, String a, String b, int[][] dp) {
        if (i == a.length() || j == b.length()) {
            if (i == a.length()) {
                return Math.abs(b.length() - j);
            }
            return Math.abs(a.length() - i);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return memo(i + 1, j + 1, a, b, dp);
        }
        int ans = 5000;
        ans = Math.min(memo(i + 1, j + 1, a, b, dp), ans);
        ans = Math.min(memo(i + 1, j, a, b, dp), ans);
        ans = Math.min(memo(i, j + 1, a, b, dp), ans);
        return dp[i][j] = 1 + ans;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int n = a.length(), m = b.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][m] = n - i;
            }
            for (int i = 0; i <= m; i++) {
                dp[n][i] = m - i;
            }
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    if (a.charAt(i) == b.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                    }
                }
            }
            System.out.println(dp[0][0]);
        }
    }
}