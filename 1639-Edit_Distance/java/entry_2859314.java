import java.io.*;
import java.lang.*;
import java.util.*;
public class entry_2859314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(), t = br.readLine();
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<=m; i++)   dp[0][i] = i;
        for(int i = 1; i<=n; i++)   dp[i][0] = i;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(s.charAt(i-1)==t.charAt(j-1))    dp[i][j] = dp[i-1][j-1];
                else    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        System.out.println(dp[n][m]);
    }
}