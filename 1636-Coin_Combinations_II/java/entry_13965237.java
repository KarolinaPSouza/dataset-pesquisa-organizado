import java.io.*;
import java.util.*;

public class entry_13965237 {
    public static void main(String[] args) throws IOException {
        final int MOD = 1_000_000_007;

        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] den = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            den[i] = Integer.parseInt(st.nextToken());
        }

        // Step 1: Sort and remove duplicates
        Arrays.sort(den);
        int[] uniqueDen = Arrays.stream(den).toArray();

        // Step 2: Initialize dp array
        int[] dp = new int[x + 1];
        dp[0] = 1;

        // Step 3: Fill dp array
        for (int j = 0; j<n; j++) {
            for (int i = den[j]; i <=x; i++) {
                dp[i] = (dp[i] + dp[i - uniqueDen[j]]) % MOD;
            }
        }

        // Step 4: Output answer
        System.out.println(dp[x]);
    }
}