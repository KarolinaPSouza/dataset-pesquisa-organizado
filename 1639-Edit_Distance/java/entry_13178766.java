import java.util.*;
import java.io.*;
public class entry_13178766 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String t = br.readLine();
        int n = s.length();
        int m = t.length();
        long dp[][] = new long[n+1][m+1];
        for(int i= 0; i <= n; i++){
            Arrays.fill(dp[i],(int)(1e5));
        }
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= m;j++){
            dp[0][j] = j;
        }
        for(int i =1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j] + 1);
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + 1);
                int c = s.charAt(i-1) == t.charAt(j-1) ? 0:1;
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1] + c);
            }

        }
        pw.println(dp[n][m]);
        pw.flush();;
    }
}