import java.util.*;
import java.io.*;

public class entry_328752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] w = new int[n];
        int[] v = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        pw.println(boundedKnapsack(w, v, x));
        pw.close();
    }

    private static int boundedKnapsack(int[] w, int[] v, int x) {
        int n = w.length;

        int[] dp = new int[x + 1]; // dp(i) = max value received, i = amount paid
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (dp[j] == -1) continue;
                if (j + w[i] < dp.length) {
                    dp[j + w[i]] = Math.max(dp[j + w[i]], dp[j] + v[i]);
                }
            }
            //System.out.println(Arrays.toString(dp));
        }

        int max = -1;
        for (int value : dp) {
            max = Math.max(max, value);
        }

        return max;
    }
}