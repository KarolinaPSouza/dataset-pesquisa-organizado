import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_15500771 {

    static int MOD = 1000_000_007;

    public static int solveRecursion(int x, int i, int[] coins) {
        if (x == 0)
            return 1;

        if (x < 0 || i == coins.length)
            return 0;

        int take = solveRecursion(x - coins[i], i, coins);

        int skip = solveRecursion(x, i + 1, coins);

        return take + skip;
    }

    public static int solveMem(int x, int i, int[] coins, int[][] dp) {
        if (x == 0) {
            return 1;
        }
        if (x < 0 || i == coins.length)
            return 0;

        if (dp[i][x] != -1)
            return dp[i][x];

        int take = solveMem(x - coins[i], i, coins, dp);

        int skip = solveMem(x, i + 1, coins, dp);

        return dp[i][x] = (take + skip) % MOD;

    }

    public static int solveTabulation(int x, int[] coins, int n) {
        int[][] dp = new int[n + 1][x + 1];

        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 1;

        for (int idx = 1; idx <= n; idx++) {
            for (int val = 1; val <= x; val++) {
                if (val - coins[idx - 1] >= 0) {
                    dp[idx][val] = (dp[idx][val - coins[idx - 1]] + dp[idx - 1][val]) % MOD;
                } else {
                    dp[idx][val] = (dp[idx - 1][val]) % MOD;
                }
            }
        }
        return dp[n][x];
    }

    public static int solveCSCE(int x, int[] coins) {
        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int sum = coin; sum <= x; sum++) {
                int val = dp[sum] + dp[sum - coin];
                if (val >= MOD)
                    val -= MOD; // cheaper than %
                dp[sum] = val;
            }
        }
        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // int ans = solveRecursion(x, 0, arr);

        // --------------------------------------

        // int[][] dp = new int[n][x + 1];

        // for (int i = 0; i < n; i++)
        // Arrays.fill(dp[i], -1);

        // int ans = solveMem(x, 0, arr, dp);

        // ----------------------------------------

        // int ans = solveTabulation(x, arr, n);

        int ans = solveCSCE(x, arr);

        System.out.println(ans);

    }
}