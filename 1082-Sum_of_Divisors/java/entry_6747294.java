import java.util.*;
import java.io.*;

public class entry_6747294 {

 public static long expo(long a, long b, long MOD) {
  long ans = 1;
  while (b > 0) {
   if ((b & 1) > 0)
    ans = ans * a % MOD;
   a = a * a % MOD;
   b >>= 1;
  }
  return ans;
 }

 public static long sum(long n, long MOD) {
  return (((n % MOD) * ((n + 1) % MOD) % MOD) * inverse(2, MOD)) % MOD;
 }

 public static long range(long a, long b, long MOD) {
  return (sum(b, MOD) - sum(a - 1, MOD) + MOD) % MOD;
 }

 public static long inverse(long i, long MOD) {
  if(i==1) return 1;
  return (MOD - ((MOD/i)*inverse(MOD%i, MOD))%MOD+MOD)%MOD;
 }

 public static void main(String args[]) throws IOException {
  FastScanner in = new FastScanner(System.in);
  PrintWriter out = new PrintWriter(System.out);

  long MOD = 1000000007;
  long n = in.nextLong();

  long ans = 0;

  for (long i = 1; i * i < n; i++) {
   ans = (ans + ((n / i) * i) % MOD) % MOD ; 
  }

  long left = (long)Math.ceil(Math.sqrt(n));

  for (long i = (long)Math.sqrt(n); i >= 1; i--) {
   long right = n / i;
   ans = (ans + ((i * range(left, right, MOD)) % MOD) + MOD) % MOD;
   left = right + 1;
  }

  out.println(ans);

  out.close();
 }

 static class FastScanner {
  BufferedReader br;
  StringTokenizer st;

  public FastScanner(InputStream i) {
   br = new BufferedReader(new InputStreamReader(i));
   st = new StringTokenizer("");
  }

  public String next() throws IOException {
   if (st.hasMoreTokens())
    return st.nextToken();
   else
    st = new StringTokenizer(br.readLine());
   return next();
  }

  public int nextInt() throws IOException {
   return Integer.parseInt(next());
  }

  public long nextLong() throws IOException {
   return Long.parseLong(next());
  }

  public double nextDouble() throws IOException {
   return Double.parseDouble(next());
  }
 }
}