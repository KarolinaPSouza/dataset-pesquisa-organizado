import java.io.*;
import java.util.*;

public class entry_12810551 {
    static final int MOD = (int) 1e9 + 7;

    public static int noOfWays(int[] coins, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to make sum 0

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        out.println(noOfWays(coins, target));
        out.flush();
    }
}