import java.util.Scanner;

public class entry_6109245 {
    public static void main(String[] args) {
        final int MOD = 1000000007;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int w = 1; w <= x; w++) {
            for (int i = 0; i < n; i++) {
                if (w - c[i] >= 0) {
                    dp[w] += dp[w - c[i]];
                    dp[w] %= MOD;
                }
            }
        }

        System.out.println(dp[x]);
    }
}