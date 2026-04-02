import java.io.*;
import java.util.StringTokenizer;

public class entry_14040145 {
    public static int calculateWays(int x, int[] coins) {
        final int MOD = 1_000_000_007;

        int[] dp = new int[x + 1];

        dp[0] = 1;

        for (int suma = 1; suma <= x; suma++) {
            for (int moneda : coins) {
                if (suma >= moneda) {
                    dp[suma] = (dp[suma] + dp[suma - moneda]) % MOD;
                }
            }
        }

        return dp[x];
    }

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

        int result = calculateWays(x, coins);

        System.out.println(result);
    }
}