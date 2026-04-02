import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_4435977 {

 static int n;
 static int num[];
 public static void main(String[]args) throws NumberFormatException, IOException
 {
  BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
  n=Integer.parseInt(br.readLine());
  StringTokenizer st=new StringTokenizer(br.readLine());
  num=new int [n];
  for(int i=0;i<n;i++)
  {
   num[i]=Integer.parseInt(st.nextToken());
  }


  System.out.println(dpiter(num));




 }
// 
// 
// public static int dp(int i)
// {
//  if(i==n)
//   return 0;
//  
//  int take=num[i]+dp(i+1);
//  int leave=dp(i+1);
//  
//  return Math.max(take, leave);
//  
//  
//  
// }

 public static long dp(int i,boolean take)
 {
  if(i==n)
   return 0;

  if(!take)
   return 0;

  long ans=0;
  for(int j=i;j<n;j++)
  {
   ans=Math.max(num[j]+dp(j+1,true),dp(j+1,false));
  }


  return ans;

 }

 public static long dpiter(int []arr)
 {
  long ans=(long) -1e17;
  long badprefix=0;
  long sum=0;
  for(int i=0;i<arr.length;i++)
  {
   sum+=arr[i];
   ans=Math.max(ans, sum-badprefix);
   badprefix=Math.min(badprefix,sum);

  }
  return ans;
 }


}