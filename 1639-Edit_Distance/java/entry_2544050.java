/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "entry_2544050" only if the class is public. */
public class entry_2544050 {
 public static void main (String[] args) throws java.lang.Exception
 {
  try {
      Scanner sc=new Scanner(System.in);
      String a=sc.nextLine();
      String b=sc.nextLine();
      int ans=editDistance(a,b);
      System.out.println(ans);
  } catch(Exception e) {
      System.out.println(e);
  }

 }
 public static int editDistance(String a,String b){
     int n=a.length();
     int m=b.length();
     int dp[][]=new int[n+1][m+1];
     dp[0][0]=0;
     for(int i=1;i<=n;i++){
         dp[i][0]=i;
     }
     for(int i=1;i<=m;i++){
         dp[0][i]=i;
     }
     for(int i=1;i<=n;i++){
         for(int j=1;j<=m;j++){
             if(a.charAt(i-1)==b.charAt(j-1)){
                 dp[i][j]=dp[i-1][j-1];
             }else{
                 dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
             }
         }
     }
     return dp[n][m];
 }
}