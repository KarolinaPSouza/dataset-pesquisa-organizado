import java.io.*;
import java.io.PrintWriter;
//cannot read negative integers
import java.util.Arrays;

public class entry_2270759 {
 static class InputReader {
  InputStream is=System.in;
  byte[] bb = new byte[1 << 15];
  int k, l;
  byte getc() throws IOException {
   if (k >= l) {
    k = 0;
    l = is.read(bb);
    if (l < 0) return -1;
   }
   return bb[k++];
  }
  byte skip() throws IOException {
   byte b;
   while ((b = getc()) <= 32)
    ;
   return b;
  }
  int nextInt() throws IOException {
   int n = 0;
   for (byte b = skip(); b > 32; b = getc())
    n = n * 10 + b - '0';
   return n;
  }
 }
 static int KnapSack(int val[], int wt[], int n, int W){
     int []dp = new int[W+1]; 
     Arrays.fill(dp, 0);

     for(int i=0; i < n; ++i)
         for(int j = W; j >= wt[i]; --j)
             dp[j] = Math.max(dp[j] , val[i] + dp[j - wt[i]]);
     return dp[W];
 }

 public static void main(String args[] ) throws Exception {
  InputReader  sc=new InputReader();
  PrintWriter out=new PrintWriter(System.out);
  int n=sc.nextInt();
  int x=sc.nextInt();
  int[] price=new int[n];
  int[] pages=new int[n];

  for(int i=0;i<n;i++)
   price[i]=sc.nextInt();

  for(int i=0;i<n;i++)
   pages[i]=sc.nextInt();
  out.println(KnapSack(pages,price,n,x));
  out.flush();
 }
}