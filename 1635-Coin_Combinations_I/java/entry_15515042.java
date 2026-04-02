import java.io.*;
import java.util.*;

public class entry_15515042 {
    static final int mod = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= x; sum++) {
            long res = 0;
            for (int coin : coins) {
                if (coin <= sum) {
                    res += dp[sum - coin];
                    if (res >= mod) res -= mod;
                }
            }
            dp[sum] = (int)res;
        }

        System.out.println(dp[x]);
    }
}
