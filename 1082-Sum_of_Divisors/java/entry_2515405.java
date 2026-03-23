import java.util.*;
import java.io.*;

public class entry_2515405 {

 public static void main(String args[]) throws Exception {

  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

  PrintWriter out = new PrintWriter(System.out);

  long n = Long.parseLong(in.readLine());

  long l = 1;
        long ans = 0;
        long mod = 1000_000_007;

        while (l <= n) {
            long k = n / l;
            long r = n / k + 1;
            long x = r - l;
            long y = l + r - 1;

            if (x % 2 == 0) x /= 2;
            else y /= 2;

            x %= mod;
            y %= mod;
            ans = (ans + k % mod * x % mod * y % mod) % mod;
            l = r;
        }

        ans %= mod;

        out.println(ans);

  out.close();
  in.close();
 }   
}