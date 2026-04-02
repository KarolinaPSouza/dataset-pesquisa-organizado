import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


public class entry_3189342 {
 //static HashMap<String, Long> hm=new HashMap<String,Long>();
 public static void main(String args[]) throws IOException
 {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
     String[] inp=br.readLine().split(" ");
     int n=Integer.parseInt(inp[0]);
     int m=Integer.parseInt(inp[1]);
     int val[]=new int[n+1];
     inp=br.readLine().split(" ");
     for(int i=0;i<n;i++) val[i+1]=Integer.parseInt(inp[i]);
     int dp[][]=new int[n+1][m+1];
     dp[0][0]=1;
     for(int i=1;i<=n;i++)
     {
      for(int j=0;j<=m;j++)
      {
       dp[i][j]=dp[i-1][j];
       if(val[i]<=j) dp[i][j]=(dp[i][j]+dp[i][j-val[i]])%1000000007;
      }
     }
      System.out.println(dp[n][m]);
 }



}