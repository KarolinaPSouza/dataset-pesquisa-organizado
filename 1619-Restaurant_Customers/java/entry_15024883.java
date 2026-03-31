/*
 * Restaurant Customers
 *
 * You are given the arrival and leaving times of n customers in a restaurant.
 * What was the maximum number of customers in the restaurant at any time?
 *
 * Input:
 * The first input line has an integer n: the number of customers.
 * After this, there are n lines that describe the customers. Each line has two
 * integers a and b: the arrival and leaving times of a customer.
 * You may assume that all arrival and leaving times are distinct.
 *
 * Output:
 * Print one integer: the maximum number of customers.
 *
 * Constraints: 1 ≤ n ≤ 2·10^5, 1 ≤ a < b ≤ 10^9
 *
 * Example:
 * Input:
 * 3
 * 5 8
 * 2 4
 * 3 9
 *
 * Output:
 * 2
 */

import java.io.*;
import java.util.*;

/**
 * @author hdchen
 */
public class entry_15024883 {
 static FastIO io = new FastIO();

 public static void main(String[] args) throws IOException {
  int n = io.nextInt();

  // Use ArrayList with initial capacity for better performance
  ArrayList<int[]> events = new ArrayList<>(n << 1);

  for (int i = 0; i < n; i++) {
   int arrival = io.nextInt();
   int departure = io.nextInt();

   // Add arrival event: time and +1 (customer enters)
   events.add(new int[]{arrival, 1});

   // Add departure event: time and -1 (customer leaves)
   events.add(new int[]{departure, -1});
  }

  // Sort events by time, with departures before arrivals at same time
  Collections.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

  int maxCustomers = 0;
  int currentCustomers = 0;

  // Process events in chronological order
  for (int[] event : events) {
   currentCustomers += event[1];  // +1 for arrival, -1 for departure
   maxCustomers = Math.max(maxCustomers, currentCustomers);
  }

  io.println(maxCustomers);
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