import java.util.*;
import java.io.*;
public class entry_12625210 {
  static final int mod = (int)1e9 + 7;
  static long sum(long s,long e)
  {
    long res=((s+e)%mod)*(((e-s+1)/2)%mod)%mod;
    if((e-s+1)%2==1)
    res+=(s+e)/2;
    res%=mod;
    return res;
  }
    public static void main(String[] args) throws IOException
    {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw=new PrintWriter(System.out);
      StringTokenizer st=new StringTokenizer(br.readLine());
      long n=Long.parseLong(st.nextToken());
      long res=0;
      long curr=1;
      while(curr<=n)
      {
        long divAmt=n/curr;
        long upperBound=n/divAmt;
        res=(res+divAmt*sum(curr,upperBound))%mod;
        curr=upperBound+1;
      }
      pw.println(res);
      pw.close();
    }
}