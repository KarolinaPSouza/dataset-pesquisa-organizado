//package org.example;
import java.util.*;

public class entry_11240133 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int x=0; x<dp[0].length; x++){
            dp[dp.length-1][x] = t.length() - x;
        }
        for(int x=0; x<dp.length; x++){
            dp[x][dp[0].length-1] = s.length() - x;
        }
        for(int i = s.length()-1; i>=0; i--){
            for(int j = t.length()-1; j>=0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i][j+1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                }
            }
        }
        System.out.println(dp[0][0]);
    }
    public static int helper(int i, int j, String s, String t, int[][] dp) {
        if(j == t.length()) {
            return s.length() - i;
        }
        if(i == s.length()){
            return t.length() - j;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        if(s.charAt(i) == t.charAt(j)){
            ans = Math.min(ans, helper(i+1, j+1, s, t, dp));
        }
        else{
            int x = 1 + helper(i, j+1, s, t, dp);
            int y = 1 + helper(i+1, j, s, t, dp);
            int z = 1 + helper(i+1, j+1, s, t, dp);
            ans = Math.min(ans, Math.min(x, Math.min(y, z)));
        }
        dp[i][j] = ans;
        return ans;
    }
}