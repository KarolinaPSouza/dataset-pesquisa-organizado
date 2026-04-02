import java.io.*;
import java.util.*;

public class entry_12458417 {
    static final int MOD = (int)1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        // DP array to store the number of ways to make sum j
        int[] dp = new int[x + 1];
        dp[0] = 1;

        // Process each coin first to ensure unique orderings
        for (int coin : coins) {
            for (int j = coin; j <= x; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % MOD;
            }
        }

        System.out.println(dp[x]);
    }
}