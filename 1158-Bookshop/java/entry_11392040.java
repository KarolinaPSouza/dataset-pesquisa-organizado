import java.io.*;
import java.util.StringTokenizer;

public class entry_11392040 {
    public static void main (String argv []) throws IOException {
        BufferedReader bookstore = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter crow = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(bookstore.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] dp = new int[x + 1][2];
        int[] prices = new int[n];
        st = new StringTokenizer(bookstore.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }
        int[] pages = new int[n];
        st = new StringTokenizer(bookstore.readLine());
        for (int i = 0; i < n; i++) {
            pages[i] = Integer.parseInt(st.nextToken());
        }
        int index = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] <= x) {
                dp[prices[i]][index] = Math.max(dp[prices[i]][index], pages[i]);
                ans = Math.max(ans, dp[prices[i]][index]);
            }
            for (int j = 0; j <= x; j++) {
                if (dp[j][1 - index] > 0) {
                    dp[j][index] = Math.max(dp[j][index], dp[j][1 - index]);
                    if (j + prices[i] <= x) {
                        dp[j + prices[i]][index] = Math.max(dp[j + prices[i]][index], dp[j][1 - index] + pages[i]);
                        ans = Math.max(dp[j + prices[i]][index], ans);
                    }
                }
            }
            index = 1 - index;
        }

        crow.println(ans);
        bookstore.close();
        crow.close();
    }
}