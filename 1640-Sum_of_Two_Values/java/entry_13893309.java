import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_13893309 {
 private static void solve(FastScanner fs, PrintWriter pw) {
  int n = fs.nextInt(), target = fs.nextInt();
  int[] a = fs.readIntArray(n);

  Map<Integer, Integer> visited = new HashMap<>();
  for (int i = 0; i < n; i++) {
   if (visited.containsKey(target-a[i])) {
    pw.print(visited.get(target-a[i]));
    pw.print(" ");
    pw.println(i+1);
    return;
   }
   visited.put(a[i], i+1);
  }
  pw.println("IMPOSSIBLE");
 }

 private static void precompute() {

 }

    public static void main(String[] args) {
     FastScanner fs = new FastScanner();
  PrintWriter pw = new PrintWriter(System.out);

  precompute();
  int t = 1;
  // t = fs.nextInt();
  while (t-- > 0) {
   solve(fs, pw);
  }

  pw.flush();
    }

 static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  int[] readIntArray(int n) {
   int[] a = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  long[] readLongArray(int n) {
   long[] a = new long[n];
   for (int i = 0; i < n; i++)
    a[i] = nextLong();
   return a;
  }

  long nextLong() {
   return Long.parseLong(next());
  }
 }
}