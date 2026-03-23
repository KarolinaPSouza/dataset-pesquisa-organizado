import java.io.*;
import java.util.*;

public class entry_1944265 {

 static long N;
 static long MOD = (long) 1e9 + 7;

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  N = Long.parseLong(br.readLine());

  long ans = 0;
  for (long i = 1, j; i <= N; i = j) 
  {
   long q = N / i; 
   j = N / q + 1;
   // Process terms [i..j-1] of the summation
   // Since they all have the same quotient q
   // Now we add q * sum(i..j-1) to the answer
   long x = j - i, y = i + j - 1; // (x * y)/2 = sum(i..j-1)

   if (x % 2 == 0) 
    x /= 2;
   else 
    y /= 2;

   x %= MOD;
   y %= MOD;
   ans = (ans + ((((q % MOD) * x) % MOD) * y) % MOD) % MOD;
  }

  pw.println(ans);

  pw.close();
  br.close();
 }

}