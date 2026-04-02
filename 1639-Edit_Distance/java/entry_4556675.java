import java.util.Arrays;
import java.util.Scanner;
import javax.print.attribute.standard.NumberUpSupported;

/* ********* 1e9 ********* */
public class entry_4556675 {
 int mod = (int) 1e9;
 static int mod7 = ((int) 1e9) + 7;

 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  String pString = sc.next();
  String qString = sc.next();
  int dp[][] = new int[pString.length()][qString.length()];
//  for (int i[] : dp)
//   Arrays.fill(i, -1);
  System.out.println(minDistanceHelper(pString.toCharArray(), qString.toCharArray(), 0, 0, dp));
 }

 public static int minDistanceHelper(char[] w1, char[] w2, int w1Index, int w2Index, int[][] memo) {
     if(w1Index == w1.length) return w2.length - w2Index;
     if(w2Index == w2.length) return w1.length - w1Index;

     if(memo[w1Index][w2Index] != 0) return memo[w1Index][w2Index];

     if(w1[w1Index] == w2[w2Index]) {
         memo[w1Index][w2Index] = minDistanceHelper(w1, w2, w1Index+1, w2Index+1, memo);
     } else {
         int opt1 = minDistanceHelper(w1, w2, w1Index+1, w2Index, memo);
         int opt2 = minDistanceHelper(w1, w2, w1Index, w2Index+1, memo);
         int opt3 = minDistanceHelper(w1, w2, w1Index+1, w2Index+1, memo);
         memo[w1Index][w2Index] = Math.min(opt1, Math.min(opt2, opt3)) + 1;
     }
     return memo[w1Index][w2Index];
 }

 /* ********* 1e9 ********* */
 public int lcm(int a, int b) {
  return a / gcd(a, b) * b;
 }

 public int gcd(int a, int b) {
  while (b != 0) {
   a %= b;
   int temp = a;
   a = b;
   b = temp;

  }
  return a;
 }

 public static boolean isPrime(int n) {
  if (n <= 1)
   return false;
  if (n <= 3)
   return true;
  if (n % 2 == 0 || n % 3 == 0)
   return false;
  for (int i = 5; i * i <= n; i = i + 6)
   if (n % i == 0 || n % (i + 2) == 0)

    return false;
  return true;
 }

 static int divCount(int n) {
  boolean hash[] = new boolean[n + 1];
  Arrays.fill(hash, true);
  for (int p = 2; p * p < n; p++)
   if (hash[p] == true)
    for (int i = p * 2; i < n; i += p)
     hash[i] = false;
  int total = 1;
  for (int p = 2; p <= n; p++) {
   if (hash[p]) {
    int count = 0;
    if (n % p == 0) {
     while (n % p == 0) {
      n = n / p;
      count++;
     }
     total = total * (count + 1);
    }
   }
  }
  return total;
 }

 static int nCr(int n, int r) {
  return fact(n) / (fact(r) * fact(n - r));
 }

 static int fact(int n) {
  if (n == 0)
   return 1;
  int res = 1;
  for (int i = 2; i <= n; i++)
   res = res * i;
  return res;
 }
}