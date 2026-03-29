import java.io.*;
import java.util.*;

public class entry_14379868 {

    public static int soln(int X, int[] pages, int[] prices, int n) {
        int[][] dp = new int[n + 1][X + 1];
        for (int i = 0; i <= X; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= X; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= prices[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], pages[i - 1] + dp[i - 1][j - prices[i - 1]]);
                }
            }
        }
        return dp[n][X];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] prices = new int[n];
        int[] pages = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(soln(x, pages, prices, n));
    }
}