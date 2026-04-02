//package dp;

import java.util.Scanner;

public class entry_9597681 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        System.out.println(func(str1,str2));
    }
    public static int func(String str1,String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = 10000000;
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }
                else if(i == 0){
                    dp[i][j] = j;
                }
                else if(j == 0){
                    dp[i][j] = i;
                }
                else{
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]);
                    }
                    else{
                        dp[i][j] = Math.min(dp[i][j],1+dp[i-1][j-1]);
                    }

                    dp[i][j] = Math.min(dp[i][j],1+Math.min(dp[i][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}