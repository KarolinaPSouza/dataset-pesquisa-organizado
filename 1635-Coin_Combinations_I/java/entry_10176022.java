import java.util.*;

public class entry_10176022 {
    public static void main(String[] args) {
        final int MOD = 1000000007;
        Scanner sc = new Scanner(System.in);

        // Read input values
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        // Sort the array c
        Arrays.sort(c);

        // Initialize dp array
        int[] dp = new int[x + 1];
        dp[0] = 1;

        // Dynamic programming to find the number of ways
        for (int i = 1; i <= x; i++) {
            for (int j : c) {
                if (i >= j) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                } else {
                    break;
                }
            }
        }

        // Output the result
        System.out.println(dp[x]);
    }
}