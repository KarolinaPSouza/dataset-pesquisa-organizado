import java.util.Arrays;
import java.util.Scanner;

public class entry_14458102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        sc.close();

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++){
            dp[i][0] = i;
        }
        for(int j = 1; j <= m; j++){
            dp[0][j] = j;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                boolean match = s1.charAt(i - 1) == s2.charAt(j - 1);
                if(match){
                    dp[i][j] = dp[i-1][j - 1];
                }else{
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        System.out.println(dp[n][m]);
    }
//    public static int memo(String s1, String s2, int i, int j, int[][] dp){
//        if(i == 0 && j == 0){
//            return 0;
//        }else if(i == 0){
//            return j;
//        }else if(j == 0){
//            return i;
//        }
//        if(dp[i][j] != -1) return dp[i][j];
//
//        boolean match = s1.charAt(i - 1) == s2.charAt(j - 1);
//        if(match){
//            return dp[i][j] = memo(s1, s2, i - 1, j - 1, dp);
//        }
//
//        int insert = 1 + memo(s1, s2, i, j - 1, dp);
//        int delete = 1 + memo(s1, s2, i - 1, j, dp);
//        int replace = 1 + memo(s1, s2, i - 1, j - 1, dp);
//        return dp[i][j] = Math.min(Math.min(delete, insert), replace);
//    }
}