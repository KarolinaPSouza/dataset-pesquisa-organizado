import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_12789457 {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        // Initialize dp array - using integer is sufficient with modulo
        int[] dp = new int[x + 1];
        dp[0] = 1;

        // Calculate ways for each sum
        for (int sum = 1; sum <= x; sum++) {
            for (int i = 0; i < n; i++) {
                if (coins[i] <= sum) {
                    // Add the number of ways to make the remaining sum
                    dp[sum] = (dp[sum] + dp[sum - coins[i]]) % MOD;
                }
            }
        }

        // Output the result
        pw.println(dp[x]);
        pw.flush();
        pw.close();
        br.close();
    }
}