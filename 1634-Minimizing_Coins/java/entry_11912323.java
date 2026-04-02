import java.util.*;

public class entry_11912323 {
    public static int MOD = 1000000007;

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int c[] = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        Arrays.sort(c);

        long dp[][] = new long[2][x + 1];

        for (long[] rows : dp) {
            Arrays.fill(rows, Integer.MAX_VALUE - 1);
        }

        for (int i = 0; i <=1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= x; i++) {
            if (i % c[0] == 0) {
                dp[0][i] = i / c[0];
            }
        }
        if(n==1)
        {
            System.out.println(dp[0][x] == Integer.MAX_VALUE - 1 ? -1 : dp[0][x]);
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                if (j >= c[i - 1]) {
                    dp[1][j] = Math.min(dp[1][j - c[i - 1]] + 1, dp[0][j]);
                } else {
                    dp[1][j] = dp[0][j];
                }
            }
            System.arraycopy(dp[1], 0, dp[0], 0, x + 1);
        }
        if(n>1)
        System.out.println(dp[1][x] == Integer.MAX_VALUE - 1 ? -1 : dp[1][x]);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve(sc);
        sc.close();
    }
}