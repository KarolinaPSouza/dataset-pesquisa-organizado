import java.util.Scanner;

public class entry_10005437 {

    private static int getEditDidIterative(String s, String t, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else {
                    int a = s.charAt(i - 1);
                    int b = t.charAt(j - 1);
                    if (a == b)
                        dp[i][j] = dp[i - 1][j - 1];
                    else {
                        int rem = dp[i][j - 1];
                        int add = dp[i - 1][j];
                        int rep = dp[i - 1][j - 1];
                        dp[i][j] = 1 + Math.min(rem, Math.min(add, rep));
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        int ans = getEditDidIterative(s, t, s.length(), t.length());
        System.out.println(ans);
    }
}