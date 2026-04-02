import java.util.*;
import java.io.*;

public class entry_1224128 {


 static int find(int ar[],int sum,int len)
 {
  int dp[][] = new int[len+1][sum+1];


  for(int i=0;i<=len;i++)
   dp[i][0] = 1;

  for(int i=1;i<=len;i++)
  {
   for(int j=1;j<=sum;j++)
   {
    if(ar[i-1]<=j)
    {
     dp[i][j] = (dp[i][j-ar[i-1]]+dp[i-1][j])%1000000007;
    }else dp[i][j]=dp[i-1][j];
   }
  }

  return dp[len][sum];
 }
 // static int find(int ar[],int sum,int len)
 // {
 //  if(sum==0)
 //   return 1;

 //  if(len==0)
 //   return 0;



 //  if(ar[len-1]<=sum)
 //    return (find(ar,sum-ar[len-1],len)%1000000007+find(ar,sum,len-1)%1000000007)%1000000007;
 //  else return find(ar,sum,len-1)%1000000007;
 // }
 public static void main(String[] args) {
  PrintWriter out=new PrintWriter(System.out);

  Scanner sc = new Scanner();

  int n = sc.nextInt();
  int sum = sc.nextInt();

  int ar[] = new int[n];

  for(int i=0;i<n;i++)
  {
   ar[i]=sc.nextInt();
  }

  out.println(find(ar,sum,n));
    out.close();

 }
 /////////////////DONT TOUCH THiS//////////////////////////////////////////////////////////////////
 static class Scanner {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st=new StringTokenizer("");
  String next() {
   while (!st.hasMoreTokens())
    try { 
                                        st=new StringTokenizer(br.readLine());                   
                                } catch (IOException e) {}
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }
  long nextLong() {
   return Long.parseLong(next());
  }
 }
 ///////////////////////////////////////////////////////////////////////////////////////////////////
}