/*
 * Coin Combinations II
 *
 * Consider a money system consisting of n coins. Each coin has a positive
 * integer value. Your task is to calculate the number of distinct ordered
 * ways you can produce a money sum x using the available coins.
 * For example, if the coins are {2,3,5} and the desired sum is 9, there are 3 ways:
 *
 * 2+2+5
 * 3+3+3
 * 2+2+2+3
 *
 * Input:
 * The first input line has two integers n and x: the number of coins and the
 * desired sum of money.
 * The second line has n distinct integers c_1,c_2,...,c_n: the value of each coin.
 *
 * Output:
 * Print one integer: the number of ways modulo 10^9+7.
 *
 * Constraints: 1 ≤ n ≤ 100, 1 ≤ x ≤ 10^6, 1 ≤ c_i ≤ 10^6
 *
 * Example:
 * Input:
 * 3 9
 * 2 3 5
 *
 * Output:
 * 3
 */

import java.io.*;
import java.util.*;

/**
 * @author hdchen
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class entry_15112123 {
 static FastIO io = new FastIO();
 static int MOD = (int) 1e9 + 7;

 public static void main(String[] args) throws IOException {
  // Coin combinations DP: count unordered ways to make target sum
  // Key difference from I: order doesn't matter (2+3+5 = 3+2+5)
  // Process coins one by one to avoid counting same combination multiple times
  // dp[i] = number of ways to make sum i using coins processed so far
  // Time: O(n * x), Space: O(x)

  int numCoins = io.nextInt(), targetSum = io.nextInt();

  // dp[i] represents number of ways to make sum i
  int[] waysToMakeSum = new int[targetSum + 1];

  // Base case: one way to make sum 0 (use no coins)
  waysToMakeSum[0] = 1;

  // Process each coin type one by one
  for (int coinIndex = 0; coinIndex < numCoins; ++coinIndex) {
   int coinValue = io.nextInt();

   // Update all sums that can use this coin type
   // Process from coinValue to targetSum to avoid using same coin multiple times
   for (int currentSum = coinValue; currentSum <= targetSum; ++currentSum) {
    // Add ways using this coin: ways[currentSum - coinValue]
    waysToMakeSum[currentSum] = (waysToMakeSum[currentSum] + waysToMakeSum[currentSum - coinValue]) % MOD;
   }
  }

  io.println(waysToMakeSum[targetSum]);
  io.close();
 }

 // Fast sort to avoid Arrays.sort() O(n²) worst case
 static void sort(int[] a) {
  ArrayList<Integer> l = new ArrayList<>(a.length);
  for (int i : a) l.add(i);
  Collections.sort(l);
  for (int i = 0; i < a.length; i++) a[i] = l.get(i);
 }

 static class FastIO extends PrintWriter {
  private InputStream stream;
  private byte[] buf = new byte[1 << 16];
  private int curChar, numChars;

  public FastIO() {
   super(System.out);
   stream = System.in;
  }

  public FastIO(String inputFile, String outputFile) throws IOException {
   super(new FileWriter(outputFile));
   stream = new FileInputStream(inputFile);
  }

  private int nextByte() {
   if (numChars == -1) throw new InputMismatchException();
   if (curChar >= numChars) {
    curChar = 0;
    try {
     numChars = stream.read(buf);
    } catch (IOException e) {
     throw new InputMismatchException();
    }
    if (numChars == -1) return -1;
   }
   return buf[curChar++];
  }

  // Input methods
  public String next() {
   int c;
   do { c = nextByte(); } while (c <= ' ');
   StringBuilder res = new StringBuilder();
   do {
    res.appendCodePoint(c);
    c = nextByte();
   } while (c > ' ');
   return res.toString();
  }

  public String nextLine() {
   int c = nextByte();
   while (c == '\r' || c == '\n') {
    c = nextByte();
   }
   StringBuilder res = new StringBuilder();
   do {
    res.appendCodePoint(c);
    c = nextByte();
   } while (c != '\n' && c != '\r' && c != -1);
   return res.toString();
  }

  public int nextInt() {
   int c;
   do { c = nextByte(); } while (c <= ' ');
   int sgn = 1;
   if (c == '-') {
    sgn = -1;
    c = nextByte();
   }
   int res = 0;
   do {
    if (c < '0' || c > '9') throw new InputMismatchException();
    res = 10 * res + c - '0';
    c = nextByte();
   } while (c > ' ');
   return res * sgn;
  }

  public long nextLong() {
   int c;
   do { c = nextByte(); } while (c <= ' ');
   int sgn = 1;
   if (c == '-') {
    sgn = -1;
    c = nextByte();
   }
   long res = 0;
   do {
    if (c < '0' || c > '9') throw new InputMismatchException();
    res = 10 * res + c - '0';
    c = nextByte();
   } while (c > ' ');
   return res * sgn;
  }

  public double nextDouble() {
   return Double.parseDouble(next());
  }

  public int[] nextIntArray(int n) {
   int[] arr = new int[n];
   for (int i = 0; i < n; i++) arr[i] = nextInt();
   return arr;
  }

  public long[] nextLongArray(int n) {
   long[] arr = new long[n];
   for (int i = 0; i < n; i++) arr[i] = nextLong();
   return arr;
  }

  // Output methods inherited from PrintWriter:
  // print(Object), println(Object), printf(String, Object...)
  // print(int), println(int), print(long), println(long)
  // print(String), println(String), println()
 }
}