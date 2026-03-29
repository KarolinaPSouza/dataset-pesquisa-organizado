import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Booksknsck {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String[] lo = reader.readLine().split(" ");
        int n = Integer.parseInt(lo[0]);
        int x = Integer.parseInt(lo[1]);
        int[] prices = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] pages = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[n+1][x+1];
        //dp[i][j] -> max no of pages i can get by spending atmost j on books with indices {i,i+1....n-1}
        //dp[i][j] -> max(dp[i+1][j],pages[i]+dp[i+1][j-prices[i]]);
        for (int i = n-1; i >=0 ; i--) {
            for (int j = 0; j <=x ; j++) {
                if(prices[i]<=j) dp[i][j] = Math.max(dp[i+1][j],pages[i]+dp[i+1][j-prices[i]]);
                else dp[i][j] = dp[i+1][j];
            }
        }
        System.out.println(dp[0][x]);
    }
}
