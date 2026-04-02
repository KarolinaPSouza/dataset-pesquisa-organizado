import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;



public class entry_570147 {
 public static class FastReader {
   BufferedReader br;
   StringTokenizer root;


   public FastReader() {
    br = new BufferedReader(new InputStreamReader(System.in));
   }

   String next() {
    while (root == null || !root.hasMoreTokens()) {
     try {
      root = new StringTokenizer(br.readLine());
     } catch (Exception addd) {
      addd.printStackTrace();
     }
    }
    return root.nextToken();
   }

   int nextInt() {
    return Integer.parseInt(next());
   }

   double nextDouble() {
    return Double.parseDouble(next());
   }

   long nextLong() {
    return Long.parseLong(next());
   }

   String nextLine() {
    String str = "";
    try {
     str = br.readLine();
    } catch (Exception addd) {
     addd.printStackTrace();
    }
    return str;
   }
  }

 public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
 public static FastReader sc = new FastReader();

 static int mod = (int)(1e9+7),MAX=(int)(1e5+10);
 static List<int[]>[] edges;

 public static void main(String[] args) throws IOException{

    int n = sc.nextInt();
       int x = sc.nextInt();
       int[] a = new int[n];
       for(int i=0;i<n;++i) a[i] = sc.nextInt();
       int[] dp = new int[x+1];
       dp[0] = 1;
       for(int i=0;i<n;++i){
           for(int j=a[i];j<=x;++j){
               dp[j] = (dp[j] + dp[j-a[i]])%mod;
           }
       }
       out.println(dp[x]);

   out.close();
 }
}