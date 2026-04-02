import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class entry_1410507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String word1 = br.readLine();
        String word2 = br.readLine();
        long [][] dp = new long[word1.length()+1][word2.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+1);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+1);
                }
                if (i > 0 && j > 0) {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                    }
                    else {
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+1);
                    }
                }
            }
        }
        out.println(dp[word1.length()][word2.length()]);
        out.close();
    }
}