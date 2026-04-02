import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_12602656 {
    public static void main(String[] args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tok = new StringTokenizer(br.readLine());
        String s = tok.nextToken();
        int n = s.length();

        tok = new StringTokenizer(br.readLine());
        String t = tok.nextToken();
        int m = t.length();

        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){

               if(s.charAt(i) == t.charAt(j)){
                   if (i==0 && j==0){
                       dp[i][j] = 0;
                   }
                   else if(i==0){
                       dp[i][j] = j;
                   }
                   else if(j==0){
                       dp[i][j] = i;
                   }
                   else{
                       dp[i][j] = dp[i-1][j-1];
                   }
               }else {
                    if(i==0 && j==0){
                        dp[i][j] = 1;
                    }
                    else if(i==0){
                        dp[i][j] = 1 + dp[i][j-1];
                    }
                    else if(j==0){
                        dp[i][j] = 1 + dp[i-1][j];
                    }
                    else{
                        dp[i][j] = Math.min(1+ dp[i-1][j-1], Math.min(1+ dp[i-1][j], 1+ dp[i][j-1]));
                    }
               }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}