// https://cses.fi/problemset/task/2185
// Prime Multiples
import java.io.*;
import java.util.*;

public class entry_2006152 extends PrintWriter {
 entry_2006152() { super(System.out, true); }
 Scanner sc = new Scanner(System.in);
 public static void main(String[] $) {
  entry_2006152 o = new entry_2006152(); o.main(); o.flush();
 }

 void main() {
  long x = sc.nextLong();
  int n = sc.nextInt();
  long[] aa = new long[n];
  for (int i = 0; i < n; i++)
   aa[i] = sc.nextLong();
  long ans = 0;
out:
  for (int m = 1; m < 1 << n; m++) {
   int p = 0;
   long y = 1;
   for (int i = 0; i < n; i++)
    if ((m & 1 << i) != 0) {
     p ^= 1;
     if (y <= x / aa[i])
      y *= aa[i];
     else
      continue out;
    }
   long k = x / y;
   ans += p == 1 ? k : -k;
  }
  println(ans);
 }
}