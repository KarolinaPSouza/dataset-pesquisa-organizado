import java.io.*;
import java.util.*;

public class entry_6966037 {
 public static int mod = 1000000007;
 public static int inv = 500000004;
 public static void main(String[] args) {
  Scanner s = new Scanner(System.in);
  long n = s.nextLong();
  long ans = 0;
  long cur = 1;
  while(cur <= n) {
   long need = n/cur;
   long last = n/need;
   ans += need * sum(cur, last);
   ans %= mod;
   cur = last + 1;
  }
  System.out.println(ans);
 }

 public static long sum(long start, long end) {
  return ((((end - start + 1) % mod) * ((start + end) % mod) % mod) *
          inv % mod);
 }

}