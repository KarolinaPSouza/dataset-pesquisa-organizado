import java.io.*;
import java.util.*;
public class entry_9383220 {
    public static void main (String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i ++)
        {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        long[] dp = new long[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int weight = 0; weight <= x; weight++) {
                if (weight - coins[i - 1] >= 0) {  // prevent out of bounds cases
                    dp[weight] += dp[weight - coins[i - 1]];
                    dp[weight] %= 1000000007;
                }
            }
        }
        pw.println(dp[x]);
        pw.close();
    }
}