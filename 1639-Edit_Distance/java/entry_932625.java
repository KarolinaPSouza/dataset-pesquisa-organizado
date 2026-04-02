//package contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_932625 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s1=br.readLine().trim();
        String s2=br.readLine().trim();
        System.out.println(minDistance(s1,s2));
    }

    public static int minDistance(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();

        int[][] dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++){

                if(i==0)
                {
                    dp[i][j]=j;
                }
                if(j==0)
                {
                    dp[i][j]=i;
                }

            }
        }


        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else{

                    int res=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                    dp[i][j]=1+res;


                }




            }
        }
        return dp[m][n];
    }





}