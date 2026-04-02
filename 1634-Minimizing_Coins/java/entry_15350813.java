import java.util.*;
import java.io.*;

public class entry_15350813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");


        int n = Integer.parseInt(first[0]);
        int x = Integer.parseInt(first[1]);

        String[] parts = br.readLine().split(" ");
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(parts[i]);
        }

        int INF = (int)1e9;
        int[] dp = new int[x + 1];

        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            for (int c : coins) {
                if (i - c >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }

        System.out.println(dp[x] == INF ? -1 : dp[x]);
    }
}