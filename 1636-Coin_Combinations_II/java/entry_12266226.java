import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class entry_12266226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][j] represents number of ways to make j cents with first i coins
        int[] dp = new int[x+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= x; j++) {
                dp[j] = (dp[j] + dp[j-arr[i]]) % 1000000007;
            }
        }

        System.out.println(dp[x]);
    }
}