import java.util.*;
import java.io.*;

// https://cses.fi/problemset/task/1634

public class entry_5312981 {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCoins = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[numCoins];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<numCoins; i++)
        {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i<= target; i++)
        {
            for (int coin : coins)
            {
                if (i >= coin)
                if (dp[i-coin] != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        pw.println(dp[target] == Integer.MAX_VALUE ? -1:dp[target]);
        pw.close();
    }
}