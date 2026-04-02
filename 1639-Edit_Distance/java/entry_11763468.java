import java.util.Scanner;

public class entry_11763468 {

    public static int tabulation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();


        int dp[][] = new int[m + 1][n + 1];


        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {

                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int inserion = 1 + dp[i][j - 1];
                        int deletion = 1 + dp[i - 1][j];
                        int replacement = 1 + dp[i - 1][j - 1];

                        dp[i][j] = Math.min(inserion, Math.min(deletion, replacement));
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String m = sc.next();
        String n = sc.next();

        System.out.println(tabulation(m, n));

    }
}