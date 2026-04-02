import java.io.*;
import java.util.*;

public class entry_15835808 {
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m= Integer.parseInt(st.nextToken());   
        int n = Integer.parseInt(st.nextToken());   

        int[] coins = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int x = 1; x <= n; x++) {
            for (int c : coins) {
                if (x - c >= 0) {
                    dp[x] = Math.min(dp[x], dp[x - c] + 1);
                }
            }
        }

        System.out.println(dp[n] == INF ? -1 : dp[n]);
    }
}