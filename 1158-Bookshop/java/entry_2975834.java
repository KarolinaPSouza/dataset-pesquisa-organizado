import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

// entry_2975834 -> CodeForcesProblemSet
public class entry_2975834 {
 static FastReader fr = new FastReader();
 static PrintWriter out = new PrintWriter(System.out);
 static final int gigamod = 1000000007;

 public static void main(String[] args) {
  int n = fr.nextInt(), x = fr.nextInt();
  int[] prices = fr.nextIntArray(n);
  int[] pages = fr.nextIntArray(n);

  // Recurrence relation: 
  // For the 'i'th book, you either buy it or you do not.
  // dp[n][x] = max(dp[n - 1][x], dp[n - 1][x - price[n]] + pages[n]);

  int[][] dp = new int[n + 1][x + 1];

  for (int i = 1; i < n + 1; i++) {
   for (int j = 0; j < x + 1; j++) {
    if (j - prices[i - 1] < 0) {
     dp[i][j] = dp[i - 1][j];
     continue;
    }
    dp[i][j] = Math.max(dp[i - 1][j], (dp[i - 1][j - prices[i - 1]] + pages[i - 1]));
   }
  }

  out.println(dp[n][x]);

  out.close();
 }

 static int factorial(int n) {
  if (n <= 1)
   return 1;
  return n * factorial(n - 1);
 }

 static long factorialInDivision(long a, long b) {
  if (a == b)
   return 1;
  return a * factorialInDivision(a - 1, b);
 }

 static BigInteger factorialInDivision(BigInteger a, BigInteger b) {
  if (a.equals(b))
   return BigInteger.ONE;
  return a.multiply(factorialInDivision(a.subtract(BigInteger.ONE), b));
 }

 // Sieve of Eratosthenes: 
 static boolean[] primeGenerator(int upto) {
  boolean[] isPrime = new boolean[upto + 1];
  Arrays.fill(isPrime, true);
  isPrime[1] = isPrime[0] = false;

  for (long i = 2; i * i < upto + 1; i++)
   if (isPrime[(int) i])
    // Mark all the multiples greater than or equal
    // to the square of i to be false.
    for (long j = i; j * i < upto + 1; j++)
     isPrime[(int) j * (int) i] = false;
  return isPrime;
 }

 static int gcd(int a, int b) {
  if (b == 0) {
   return a;
  } else {
   return gcd(b, a % b);
  }
 }

 static void shuffleArray(long[] arr, int startPos, int endPos) {
  Random rnd = new Random();
  for (int i = startPos; i < endPos; ++i) {
   long tmp = arr[i];
   int randomPos = i + rnd.nextInt(endPos - i);
   arr[i] = arr[randomPos];
   arr[randomPos] = tmp;
  }
 }

 static void shuffleArray(int[] arr, int startPos, int endPos) {
  Random rnd = new Random();
  for (int i = startPos; i < endPos; ++i) {
   int tmp = arr[i];
   int randomPos = i + rnd.nextInt(endPos - i);
   arr[i] = arr[randomPos];
   arr[randomPos] = tmp;
  }
 }

 static void shuffleArray(double[] arr, int startPos, int endPos) {
  Random rnd = new Random();
  for (int i = startPos; i < endPos; ++i) {
   double tmp = arr[i];
   int randomPos = i + rnd.nextInt(endPos - i);
   arr[i] = arr[randomPos];
   arr[randomPos] = tmp;
  }
 }

 static class Tuple implements Comparable<Tuple> {
  long a;
  int b;
  int c;

  Tuple() {
   a = b = 0;
  }

  Tuple(long a, int b, int c) {
   this.a = a;
   this.b = b;
   this.c = c;
  }

  @Override
  public int compareTo(Tuple o) {
   if (this.a > o.a)
    return -1;
   if (this.a < o.a)
    return 1;
   return 0;
  }
 }

 static class customTupleComparator implements Comparator<Tuple> {
  @Override
  public int compare(Tuple o1, Tuple o2) {
   if (o1.b > o2.b)
    return 1;
   if (o1.b < o2.b)
    return -1;
   return 0;
  }
 }

 // Time Complexity: O(sqrt(n))
 static boolean isPrime(int n) {
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

 static int hash(String s, int arrayLen) {
  return (s.hashCode() & 0x7fffffff) % arrayLen;
 }

 static class FastReader {
  // The input stream is read and stored into a buffer which can be used to
  // retrieve
  // data whenever required. This reduces the # of IO operations thus ensuring
  // fast input.

  // BufferedReader for input buffering and StringTokenizer for splitting the
  // input
  // line by line into string tokens which can be parsed manually for the desired
  // data.
  private BufferedReader bfr;
  private StringTokenizer st;

  public FastReader() {
   // Passing an InputStreamReader to the BufferedReader constructor (using the
   // console
   // input stream).
   bfr = new BufferedReader(new InputStreamReader(System.in));
  }

  // Method to return the next String token which can be parsed further.
  String next() {
   // Initializing (if required)/Resetting by creating tokens from the
   // next line.
   // If there are no more elements from the current line:
   if (st == null || !st.hasMoreElements()) {
    try {
     // Creating tokenizer using the next line.
     st = new StringTokenizer(bfr.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }

  // Parsing the next token to an Integer.
  int nextInt() {
   return Integer.parseInt(next());
  }

  // Parsing the next token to a Long.
  long nextLong() {
   return Long.parseLong(next());
  }

  // Parsing the next token to a Double.
  double nextDouble() {
   return Double.parseDouble(next());
  }

  // Parsing the next token to a Character.
  char nextChar() {
   return next().toCharArray()[0];
  }

  // Reading a whole string.
  String nextString() {
   return next();
  }

  // Parsing the input tokens to an integer array of
  // the specified size.
  int[] nextIntArray(int n) {
   int[] arr = new int[n];
   for (int i = 0; i < n; i++)
    arr[i] = nextInt();
   return arr;
  }

  // Parsing the input token to a double array of
  // the specified size.
  double[] nextDoubleArray(int n) {
   double[] arr = new double[n];
   for (int i = 0; i < arr.length; i++)
    arr[i] = nextDouble();
   return arr;
  }

  long[] nextLongArray(int n) {
   long[] arr = new long[n];
   for (int i = 0; i < n; i++)
    arr[i] = nextLong();
   return arr;
  }

  public char[] nextCharArray(int n) {
   char[] chars = new char[n];
   for (int i = 0; i < n; i++)
    chars[i] = fr.nextChar();
   return chars;
  }
 }
}