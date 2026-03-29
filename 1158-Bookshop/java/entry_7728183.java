//package DP;
import java.util.*;
public class entry_7728183 {
static int[][]dp;
 public static void main(String[] args) {
  // TODO Auto-generated method stub 
  Scanner sc=new Scanner(System.in); 
  int n=sc.nextInt();
  int x=sc.nextInt(); 
  int []price=new int[n]; 
  for (int i = 0; i < price.length; i++) {
   price[i]=sc.nextInt();
  } 
  int []pages=new int[n]; 
  for (int i = 0; i < pages.length; i++) {
   pages[i]=sc.nextInt();
  } 

//  dp=new int[n][x+1];
//  for(int []row:dp) {
//   Arrays.fill(row, -1);
//  }

        //System.out.println(helper(price,pages,x,0));
  System.out.println(iterativeDP(price, pages, x));
 }
 public static int helper(int []price,int []pages,int x,int i) {
  if(i==price.length) {
   return 0;
  } 
  if(x<=0) {
   return 0;
  } 

  if(dp[i][x]!=-1) {
   return dp[i][x];
  }
  int ans=0;  
  int take=0;
  if(price[i]<=x) {
     take=pages[i]+helper(price,pages,x-price[i],i+1);
  }
  int nottake=0+helper(price,pages,x,i+1);

  ans=Math.max(take, nottake);
  return dp[i][x]=ans;
 } 

 public static int iterativeDP(int []price,int []pages,int x) {
  int n=price.length;
  int []prev=new int[x+1];
  prev[0]=0;
  for(int i=0;i<n;i++) {
   int []curr=new int[x+1];
   curr[0]=0;
   for(int j=1;j<=x;j++) {
    int nottake=prev[j]; 
    int take=0;
    if(j>=price[i]) {
     take=pages[i]+prev[j-price[i]];
    }
    curr[j]=Math.max(nottake, take);
   }
   prev=curr;
  } 
  return prev[x]; 



 }

}