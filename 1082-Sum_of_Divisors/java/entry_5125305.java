import java.util.*;
import java.io.*;

public class entry_5125305 {

 static long mod = (long)1e9 + 7;

 public static long fastMod(String N, long mod) {
  long r=0;
  String s = N+"";
  for (int i = 0; i < N.length(); i++) {
   r *= 10;
   r += N.charAt(i)-'0';
   r %= mod;
  }
  r %= mod;
  return r;
 }

 static long sumOfDiv(long n) {
  long ans = 0;
  for(int i = 1; i<=Math.sqrt(n); i++) {
   long s = (n/(i+1)) + 1;
   long e = n/i;
   ans += e*i;
   ans = ans - (ans/mod)*mod;
   if(i==e) break;
   long sum = ((s+e)&1)==0 ? (s+e)/2:(s+e);
   long num = ((e-s+1)&1)==0 ? (e-s+1)/2:(e-s+1) ;
   num *= i;
   num = num - (num/mod)*mod;
   sum = sum - (sum/mod)*mod;
   sum *= num;
   ans += sum;
   sum = sum - (sum/mod)*mod;
  }
  ans = ans - (ans/mod)*mod;
  return ans ;
 }





 public static void main(String[] args) throws Exception {
  Scanner sc = new Scanner(System.in);
  long t = sc.nextLong();
  long ans = sumOfDiv(t); 
  System.out.println(ans);

 }



 static class Scanner {
  StringTokenizer st;
  BufferedReader br;

  public Scanner(InputStream s) {
   br = new BufferedReader(new InputStreamReader(s));
  }

  public String next() throws IOException {
   while (st == null || !st.hasMoreTokens())
    st = new StringTokenizer(br.readLine());
   return st.nextToken();
  }

  public int nextInt() throws IOException {
   return Integer.parseInt(next());
  }

  public long nextLong() throws IOException {
   return Long.parseLong(next());
  }

  public String nextLine() throws IOException {
   return br.readLine();
  }

  public double nextDouble() throws IOException {
   String x = next();
   StringBuilder sb = new StringBuilder("0");
   double res = 0, f = 1;
   boolean dec = false, neg = false;
   int start = 0;
   if (x.charAt(0) == '-') {
    neg = true;
    start++;
   }
   for (int i = start; i < x.length(); i++)
    if (x.charAt(i) == '.') {
     res = Long.parseLong(sb.toString());
     sb = new StringBuilder("0");
     dec = true;
    } else {
     sb.append(x.charAt(i));
     if (dec)
      f *= 10;
    }
   res += Long.parseLong(sb.toString()) / f;
   return res * (neg ? -1 : 1);
  }

  public boolean ready() throws IOException {
   return br.ready();
  }

  long[] readArray(int n) throws IOException {
   long[] a = new long[n];
   for (int i = 0; i < n; i++)
    a[i] = nextLong();
   return a;
  }
 }

}
