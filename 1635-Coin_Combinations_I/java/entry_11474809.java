import java.util.Scanner;

public class entry_11474809 {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input values
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // DP array to store the number of ways to make each sum
        long[] dp = new long[x + 1];
        dp[0] = 1; // Base case: one way to make sum 0

        // Nested loops to calculate the number of ways to make sum x
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= a[j]) {
                    dp[i] = (dp[i] + dp[i - a[j]]) % MOD;
                }
            }
        }

        // Output the result
        System.out.println(dp[x]);
    }
}