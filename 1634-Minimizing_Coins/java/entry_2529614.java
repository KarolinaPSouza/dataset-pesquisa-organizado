/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "entry_2529614" only if the class is public. */
  public class entry_2529614 {
 public static void main (String[] args) throws java.lang.Exception
 {
     try {

         Scanner sc =new Scanner(System.in);
         int n=sc.nextInt();
         int x=sc.nextInt();
         int arr[]=new int[n];
         for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();
         }
         int dp[]=new int[x+1];
         for(int i=0;i<=x;i++){
             dp[i]=Integer.MAX_VALUE-1;
         }
         dp[0]=0;
         for(int i=1;i<dp.length;i++){
             for(int j=0;j<arr.length;j++){
                 if(arr[j]<=i)
                     dp[i]= Math.min(dp[i],1+dp[i-arr[j]]);
             }
         }
         if(dp[x]>=Integer.MAX_VALUE-1)
             System.out.println(-1);
         else
             System.out.println(dp[x]);

     } catch(Exception e) {
     }
 }

}