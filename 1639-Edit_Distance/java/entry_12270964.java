import java.io.*;
import java.util.*;

public class entry_12270964{
    static int mod = (int) 1e9 + 7;
    static int dp[][];

    public static void main(String args[]) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new
            InputStreamReader(System.in));
            // BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));

            String arr[] = bufferedReader.readLine().split(" ");
            String arr2[] = bufferedReader.readLine().split(" ");
            String s1=arr[0];
            String s2=arr2[0];
            dp=new int[s1.length()+1][s2.length()+1];
           for(int i=0;i<=s2.length();i++){
            dp[0][i]=i;
           }
           for(int i=0;i<=s1.length();i++){
            dp[i][0]=i;
           }
            for(int i=1;i<=s1.length();i++){
                for(int j=1;j<=s2.length();j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1))dp[i][j]=dp[i-1][j-1];
                    else{
                        dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    }
                }
            }
            System.out.println(dp[s1.length()][s2.length()]);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int solve(int i,int j,String s1,String s2){
        if(i==s1.length())return s2.length()-j;
        if(j==s2.length())return s1.length()-i;

        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))return solve(i+1,j+1,s1,s2);

        return dp[i][j]=1+Math.min(solve(i+1,j+1,s1,s2),Math.min(solve(i+1,j,s1,s2),solve(i,j+1,s1,s2)));
    }

}
