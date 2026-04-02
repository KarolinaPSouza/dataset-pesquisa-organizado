import java.util.Scanner;

public class entry_9269560 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(editDistance(s1, s2));
    }

    public static int editDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i; // Deleting all characters from s1
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j; // Inserting all characters of s2
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,  // Substitution
                            Math.min(dp[i - 1][j] + 1,    // Deletion
                                    dp[i][j - 1] + 1));  // Insertion
                }
            }
        }

        // Return the result from the bottom-right corner of the table
        return dp[m][n];
    }
}