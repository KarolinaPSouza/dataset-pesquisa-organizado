import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;

public class entry_1600595 {
 public static void main(String[] args) throws Exception {
  new entry_1600595().run();
 }



 public void run() throws Exception {
  FastScanner f = new FastScanner();
  PrintWriter out = new PrintWriter(System.out);




  int n=f.nextInt();
  int x=f.nextInt();
  int[] coins=f.readArray(n);

  int[] dp=new int[x+1];
  dp[0]=1;

  int mod=1000000007;

  for(int i=0;i<n;i++){
   for(int j=coins[i];j<=x;j++){
    dp[j]+=(dp[j-coins[i]])%mod;
    dp[j]%=mod;
   }
  }

  out.println(dp[x]);

  // out.println(rec(coins, x, 0));




  // flush
  out.flush();

 }

 private int rec(int[] coins, int sum, int index){
  if(index>=coins.length)return 0;
  if(sum<0)return 0;
  if(sum==0)return 1;

  return rec(coins, sum-coins[index], index)+rec(coins, sum, index+1);


 }







 // Fast Scanner class
 static class FastScanner {
  public BufferedReader reader;
  public StringTokenizer tokenizer;

  public FastScanner() {
   reader = new BufferedReader(new InputStreamReader(System.in), 32768);
   tokenizer = null;
  }

  public String next() {
   while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    try {
     tokenizer = new StringTokenizer(reader.readLine());
    } catch (IOException e) {
     throw new RuntimeException(e);
    }
   }
   return tokenizer.nextToken();
  }

  public int nextInt() {
   return Integer.parseInt(next());
  }

  public long nextLong() {
   return Long.parseLong(next());
  }

  public double nextDouble() {
   return Double.parseDouble(next());
  }

  public int[] readArray(int n) {
   int[] a = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  public String nextLine() {
   try {
    return reader.readLine();
   } catch (IOException e) {
    throw new RuntimeException(e);
   }
  }
 }
}