/*
 * entry_15171852
 *
 * There are n projects you can attend. For each project, you know its starting
 * and ending days and the amount of money you would get as reward. You can
 * only attend one project during a day.
 * What is the maximum amount of money you can earn?
 *
 * Input:
 * The first input line contains an integer n: the number of projects.
 * After this, there are n lines. Each such line has three integers a_i, b_i,
 * and p_i: the starting day, the ending day, and the reward.
 *
 * Output:
 * Print one integer: the maximum amount of money you can earn.
 *
 * Constraints: 1 ≤ n ≤ 2·10^5, 1 ≤ a_i ≤ b_i ≤ 10^9, 1 ≤ p_i ≤ 10^9
 *
 * Example:
 * Input:
 * 4
 * 2 4 4
 * 3 6 6
 * 6 8 2
 * 5 7 3
 *
 * Output:
 * 7
 */

import java.io.*;
import java.util.*;

/**
 * @author hdchen
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class entry_15171852 {
 static FastIO io = new FastIO();

 public static void main(String[] args) throws IOException {
  // Weighted interval scheduling: sort by end time + DP with binary search
  // Key insight: for each project, find latest non-overlapping project using binary search
  // dp[i] = maximum profit considering projects 0 to i
  // Time: O(n log n), Space: O(n)

  int numProjects = io.nextInt();

  // Use ArrayList with initial capacity + Collections.sort to avoid Arrays.sort O(n²) worst case
  List<int[]> projects = new ArrayList<>(numProjects);

  for (int i = 0; i < numProjects; ++i) {
   int startDay = io.nextInt();
   int endDay = io.nextInt();
   int reward = io.nextInt();
   projects.add(new int[]{startDay, endDay, reward});
  }

  // Sort projects by end day (greedy: process in chronological order)
  Collections.sort(projects, (a, b) -> a[1] - b[1]);

  // dp[i] = maximum profit achievable using projects 0 to i
  long[] maxProfitUpTo = new long[numProjects];

  for (int currentProject = 0; currentProject < numProjects; ++currentProject) {
   int[] current = projects.get(currentProject);
   int currentStartDay = current[0];
   int currentReward = current[2];

   // Binary search: find latest project that ends before current project starts
   // This is the rightmost project with endDay < currentStartDay
   int searchLeft = 0, searchRight = currentProject;

   while (searchLeft < searchRight) {
    int searchMid = searchLeft + ((searchRight - searchLeft) >> 1);

    if (projects.get(searchMid)[1] < currentStartDay) {
     // This project ends before current starts, search right for later projects
     searchLeft = searchMid + 1;
    } else {
     // This project overlaps, search left for earlier projects
     searchRight = searchMid;
    }
   }

   // Calculate profit: current reward + best profit from non-overlapping projects
   long profitWithCurrent = currentReward + (searchLeft == 0 ? 0 : maxProfitUpTo[searchLeft - 1]);

   // DP transition: take current project or skip it
   maxProfitUpTo[currentProject] = profitWithCurrent;

   // Propagate best result so far (monotonic property)
   if (currentProject > 0 && maxProfitUpTo[currentProject - 1] > maxProfitUpTo[currentProject]) {
    maxProfitUpTo[currentProject] = maxProfitUpTo[currentProject - 1];
   }
  }

  io.println(maxProfitUpTo[numProjects - 1]);
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