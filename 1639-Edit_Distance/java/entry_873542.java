//package dynamic_programming;

import java.util.Scanner;

public class entry_873542 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a=s.nextLine();
        String b=s.nextLine();

        int[][] dp=new int[a.length()+1][b.length()+1];
        for (int i=0;i<a.length()+1;i++){
            for (int j=0;j<b.length()+1;j++){
                if (j!=0){
                    dp[i][j]=dp[i][j-1]+1;
                }
                if (i!=0){
                    if (dp[i][j]!=0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    else{
                        dp[i][j]=dp[i-1][j]+1;
                    }
                }
                if (i!=0 && j!=0){
                    dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]+1);
                    if (a.charAt(i-1)==b.charAt(j-1)){
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j-1]);
                    }
                }

            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}