
import java.io.*;
import java.util.*;

public class entry_3522070 {

    static BufferedReader br;
    static StringTokenizer st;
    static int m = (int)1e9 + 7;

    public static void main(String[] args) throws IOException
    {

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        } 

        Arrays.sort(coins);

        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {

                int index = i - coins[j];
                if (index < 0) break;
                dp[i] += dp[index];
                if (dp[i] >= m) dp[i] -= m;

            }
        }

        System.out.println(dp[x]);

    }

}