import java.io.*;
import java.util.*;


public class entry_1822162 {
    static int mod=(int)1e9+7;
    public static void main(String arg[])throws IOException
    {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      String s1=br.readLine();
      String s2=br.readLine();
      int n=s1.length();
      int m=s2.length();
      int dp[][]=new int[n+1][m+1];
      for(int i=0;i<=n;i++)
      {
          for(int j=0;j<=m;j++)
          {
              if(i==0)
                  dp[i][j]=j;
              else if(j==0)
                  dp[i][j]=i;
              else if(s1.charAt(i-1)==s2.charAt(j-1))
                  dp[i][j]=dp[i-1][j-1];
              else
                  dp[i][j]=1+Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
          }
      }
      int com=dp[n][m];
      //int ans=Math.abs(n-m)+Math.min(m-com,n-com);
      System.out.println(com);
    }
}