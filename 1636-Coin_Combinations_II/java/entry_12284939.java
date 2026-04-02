import java.util.*;

public class entry_12284939 {
    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = A[i]; j <= x; j++) {
                dp[j] = (dp[j] + dp[j - A[i]]) % MOD;
            }
        }

        System.out.println(dp[x]);
        scanner.close();
    }
}