import java.util.HashSet;
import java.util.Scanner;

public class entry_15926425 {
 public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  long n = in.nextLong();
  in.close();

  long result = 0;
  System.err.println((long) Math.sqrt(n));
  long M = 1000000007;

  // first, do large floor(n/k) particularly ones where a >= sqrt(n)
  for (long k = 1; k <= Math.sqrt(n); k++) {
   long add = n/k;
   add *= k;
   result += add; 
   result %= M;
  }

  // long chains of floor(n/k) eventually happen where a < sqrt(n) and k > sqrt(n)
  for (long a = 1; a < Math.sqrt(n); a++) {
   // n/(a+1) < k <= n/a
   // also, k > sqrt
   long lbi = Math.max(n/(a+1) + 1, (long) Math.sqrt(n) + 1);
   long ubi = n/a;
   // a(lowerBoundInc + ... + upperBoundInc)
//   long add = 0;
//   if (ubi % 2 == 0) add += ((ubi%M)/2)*(ubi%M+1);
//   else add += (ubi%M)*((ubi%M+1)/2);
//   add %= M;
//   if (lbi % 2 == 0) add -= ((lbi%M)/2)*(lbi%M-1);
//   else add -= (lbi%M)*((lbi%M-1)/2);
//   
//   add %= M;
//   add += M;
//   add %= M;
   long add = (ubi%M)*(ubi%M+1)-(lbi%M)*(lbi%M-1);
   add %= M;
   add += M;
   add %= M;
   if (add % 2 == 1) add += M;
   add /= 2;

   add *= a;
   result += add;
   result %= M;
  }

  System.out.println(result);
 }

}