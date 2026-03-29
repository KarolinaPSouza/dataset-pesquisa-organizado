/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Cup{
  int s,f,p;
 public Cup()
 {

 }
 public Cup(int a, int b, int c)
 {
  s=a;
  f=b;
  p=c;
 }
}
class Cmp implements Comparator<Cup>
{
 public int compare(Cup a, Cup b)
 {
  return a.f-b.f;
 }
}
class Ideone
{
 public static int find(Cup []a, int lo, int hi, int val)
 {
  int mid=-1,ans=-1;
  while(lo<=hi)
  {
   mid=(lo+hi)/2;
   if(a[mid].f<val)
   {
    ans=mid;
    lo=mid+1;
   }
   else{
    hi=mid-1;
   }
  }
  return ans;
 }
 public static void main (String[] args) throws java.lang.Exception
 {
  // your code goes here
  Scanner sc=new Scanner(System.in);
  InputStreamReader ip=new InputStreamReader(System.in);
  BufferedReader br =new BufferedReader(ip);


  //int n=sc.nextInt();
  int n=Integer.parseInt(br.readLine());
  Cup []arr=new Cup[n];
  for(int i=0;i<n;i++)
  {
   StringTokenizer st=new StringTokenizer(br.readLine());
   //int a,b,c;
   int a = Integer.parseInt(st.nextToken()); 
         int b = Integer.parseInt(st.nextToken()); 
   int c=Integer.parseInt(st.nextToken());
   // a=sc.nextInt();
   // b=sc.nextInt();
   // c=sc.nextInt();
   arr[i]=new Cup(a,b,c);
  }
  Arrays.sort(arr, new Cmp());
  long dp[]=new long[n+1];
  Arrays.fill(dp, 0);
  dp[1]=arr[0].p;
  for(int i=2;i<=n;i++)
  {
   long inc=arr[i-1].p;
   int idx=find(arr,0,i-1,arr[i-1].s);
   inc+=dp[idx+1];
   long  exc=dp[i-1];
   dp[i]=Math.max(inc,exc);
  }
  long ans=0;
  for(long i:dp)
  {
   ans=Math.max(i,ans);
  // System.out.print(i+" ");
  }
  System.out.println(ans);
 }
}