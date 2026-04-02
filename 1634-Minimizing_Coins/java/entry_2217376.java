/*package whatever //do not write package name here */

import java.util.*;

public class entry_2217376 {
    static int mod=1000000007;
 public static void main (String[] args) {
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int x=sc.nextInt();
  int a[]=new int[n];
  for(int i=0;i<n;i++) a[i]=sc.nextInt();
  int ans=solve(a,n,x);
  System.out.println(ans);
 }
 public static int solve(int a[],int n,int x)
 {
     int dp[]=new int[x+1];
     for(int i=1;i<=x;i++)
     {
         dp[i]=(int)1e9;
         for(int j=0;j<n;j++){
             if(a[j]<=i){
                 dp[i]=Math.min(dp[i],1+dp[i-a[j]]);
             }
         }
     }
     return dp[x]==(int)1e9?-1:dp[x];
 }
}
