import java.io.*;

import java.util.*;


public class entry_2658416 {
 // CodeSnip{Kattio}
 private static class Kattio extends PrintWriter {
  private BufferedReader r;
  private StringTokenizer st;
  // standard input

  public Kattio() { this(System.in,System.out); }
  public Kattio(InputStream i, OutputStream o) {
   super(o);
   r = new BufferedReader(new InputStreamReader(i));
  }

  // USACO-style file input
  public Kattio(String problemName) throws IOException {
   super(new FileWriter(problemName+".out"));
   r = new BufferedReader(new FileReader(problemName+".in"));
  }
  // returns null if no more input

  public String next() {
   try {
    while (st == null || !st.hasMoreTokens())
     st = new StringTokenizer(r.readLine());
    return st.nextToken();
   } catch (Exception e) {}
   return null;
  }
  public int nextInt() { return Integer.parseInt(next()); }
  public double nextDouble() { return Double.parseDouble(next()); }
  public long nextLong() { return Long.parseLong(next()); }
 }
 public static void main(String[] args) {
  Kattio io = new Kattio();

  int n = io.nextInt(), m = io.nextInt(), q = io.nextInt();

  long[][] mat = new long[n][n];
  long INF = (long)1e18;

  for(long[] row : mat) {
   Arrays.fill(row, INF);
  }

  for (int i = 0; i < m; i++) {
   int u = io.nextInt(), v = io.nextInt(), w = io.nextInt();
   u--; v--;
   if (w < mat[u][v]) mat[u][v] = mat[v][u] = w;
  }

  for (int k = 0; k < n; k++)
   for (int i = 0; i < n; i++)
    for (int j = i + 1; j < n; j++)
     if (mat[i][k] + mat[k][j] < mat[i][j])
      mat[i][j] = mat[j][i] = mat[i][k] + mat[k][j];

  while (q-- > 0) {
   int u = io.nextInt(), v = io.nextInt();
   u--; v--;
   if (u == v) mat[u][v] = 0;
   if (mat[u][v] == INF) mat[u][v] = -1;
   io.println(mat[u][v]);
  }

  io.close();
 }
}