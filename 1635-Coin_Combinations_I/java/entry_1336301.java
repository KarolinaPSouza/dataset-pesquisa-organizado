import java.util.*;
import java.io.*;
public class entry_1336301
{
 static final long mod=1000000007;
 public static void main(String args[]) throws IOException
 {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String ar[]=br.readLine().split(" ");
  int sum=0;
  sum=Integer.parseInt(ar[1]);
  String cr[]=br.readLine().split(" ");
  int coins[]=new int[cr.length];
  for(int i=0;i<cr.length;i++)
  {
   coins[i]=Integer.parseInt(cr[i]);
  }
  long count[]=new long[sum+1];
  count[0]=1;
  for(int i=1;i<=sum;i++)
  {
   for(int j=0;j<coins.length;j++)
   {
    if(i-coins[j]>=0)
    {
     count[i]+=count[i-coins[j]];
     count[i]%=mod;
    }
   }
  }
  System.out.println(count[count.length-1]);
 }
}
