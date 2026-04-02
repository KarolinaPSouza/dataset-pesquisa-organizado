import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.*;

public class entry_14741196 {
 private static int n, m, q;
 private static List<List<Integer>> edgeList = new ArrayList<>();
 private static long[][] dist;

 private static void floyd_warshall() {
  for (int k = 0; k < n; k++) {
   for (int i = 0; i < n; i++) {
    if (dist[i][k] == Long.MAX_VALUE) continue;
    for (int j = 0; j < i; j++) {
     if (dist[k][j] != Long.MAX_VALUE) {
      dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
      dist[j][i] = Math.min(dist[i][j], dist[j][i]);
     }
    }
   }
  }
 }

 private static void solve(FastScanner fs, PrintWriter pw) {
  n = fs.nextInt();
  m = fs.nextInt();
  q = fs.nextInt();

  dist = new long[n][n];
  for (int i = 0; i < n; i++) {
   Arrays.fill(dist[i], Long.MAX_VALUE);
   dist[i][i] = 0;
  }

  for (int i = 0; i < m; i++) {
   int a = fs.nextInt()-1, b = fs.nextInt()-1, w = fs.nextInt();

   dist[a][b] = Math.min(w, dist[a][b]);
   dist[b][a] = Math.min(w, dist[b][a]);
  }

  floyd_warshall();

  for (int i = 0; i < q; i++) {
   int a = fs.nextInt()-1, b = fs.nextInt()-1;
   if (dist[a][b] != Long.MAX_VALUE) pw.println(dist[a][b]);
   else pw.println(-1);
  }
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