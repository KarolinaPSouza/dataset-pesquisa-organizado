import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class entry_13391301 {
    private static final int MOD = 1_000_000_007;
    private static int helper(int n, int m, String word1, String word2){

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int replace = 1 + dp[i-1][j-1];
                    int skip = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    dp[i][j] = Math.min(replace,Math.min(skip,delete));
                }
            }
        }
        return dp[n][m];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word1 = reader.readLine();
        String word2 = reader.readLine();

        int n = word1.length();
        int m = word2.length();
        long ways = helper(n, m, word1, word2);
        System.out.println(ways);

    }



}