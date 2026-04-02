import java.util.*;
import java.io.*;

public class entry_8934974 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line1 = in.readLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int x = Integer.parseInt(line1.split(" ")[1]);

        String line2 = in.readLine();
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(line2.split(" ")[i]);
        }

        long[] dp = new long[1_000_001];
        dp[0] = 0;

        for (int i = 1; i <= 1_000_000; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= 1_000_000; i++) {
            long min = Long.MAX_VALUE;
            boolean reachable = false;

            for (int j = 0; j < n; j++) {
                if (i - c[j] < 0)
                    continue;

                if (dp[i - c[j]] < 0)
                    continue;

                min = Math.min(min, dp[i - c[j]]);
                reachable = true;
            }

            if (reachable)
                dp[i] = min + 1;
        }

        out.println(dp[x]);

        in.close();
        out.close();
    }

}

// dp[i] = minimum number of coins needed to produce sum i
//
// dp[0] = 0 (base case)
// dp[i] = min{dp[i - c1], dp[i - c2], dp[i - c3], ...} + 1