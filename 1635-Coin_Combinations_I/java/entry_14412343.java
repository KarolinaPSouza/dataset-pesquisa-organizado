import java.io.*;
import java.util.*;

public class entry_14412343 {
    public static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= target; sum++) {
            long ways = 0; 
            for (int i = 0; i < n; i++) {
                if (sum >= arr[i]) {
                    ways += dp[sum - arr[i]];
                    if (ways >= (1L << 62)) ways %= MOD; 
                }
            }
            dp[sum] = (int)(ways % MOD);
        }

        System.out.println(dp[target]);
    }
}