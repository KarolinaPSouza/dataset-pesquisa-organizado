//package codeforces;
import java.util.*;
import java.io.*;
import java.lang.*;

public class entry_2374978 {
 public static void main(String[] args)throws IOException {
  // TODO Auto-generated method stub
  int mod = 1000000007;
  BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
  String s[] = br.readLine().split(" ");
  int n = Integer.parseInt(s[0]);
  int k = Integer.parseInt(s[1]);
  String str[] = br.readLine().split(" ");
  String s1[] = br.readLine().split(" ");
  int a[] = new int[n+1];
  int b[] = new int[n+1];
  for(int i=0;i<n;i++) {
   a[i+1] = Integer.parseInt(str[i]);
   b[i+1] = Integer.parseInt(s1[i]);
  }
  int dp[][]= new int[n+1][k+1];
  for(int i=1;i<=n;i++) {
   for(int j=1;j<=k;j++) {
    if(j-a[i]<0) {
     dp[i][j]=(dp[i-1][j]);
    }else {
     dp[i][j]=max(dp[i-1][j],dp[i-1][j-a[i]]+b[i]);
    }
   }
  }
  System.out.println(dp[n][k]);
 }
 public static int max(int a,int b) {
  return a>b?a:b;
 }
}
//a=4 5 8  3
//b=5 8 12 1


