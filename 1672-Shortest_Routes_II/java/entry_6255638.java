import java.io.*;
import java.util.*;

public class entry_6255638 {
    // We can't use Long.MAX_VALUE because of overflow
    private static final long BIG = (long)1e18;

    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int m = io.nextInt();
        int q = io.nextInt();

        long[][] minDist = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], BIG);
        }
  for (int i = 0; i < m; i++) {
   int u = io.nextInt() - 1;
   int v = io.nextInt() - 1;
   int w = io.nextInt();
   if (w < minDist[u][v]) {
    minDist[u][v] = minDist[v][u] = w;
   }
  }

  for (int k = 0; k < n; k++) {
   for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
     long newDist = minDist[i][k] + minDist[k][j];
     if (newDist < minDist[i][j]) {
      minDist[i][j] = minDist[j][i] = newDist;
     }
    }
   }
  }

  for (int i = 0; i < q; i++) {
   int u = io.nextInt() - 1;
   int v = io.nextInt() - 1;

   // Handle some special cases
   if (u == v) {
    minDist[u][v] = 0;
   } else if (minDist[u][v] == BIG) {
    minDist[u][v] = -1;
   }

   io.println(minDist[u][v]);
  }

  io.close();
    }

    static class Kattio extends PrintWriter {
 private BufferedReader r;
 private StringTokenizer st;
 // standard input
 public Kattio() { this(System.in, System.out); }
 public Kattio(InputStream i, OutputStream o) {
  super(o);
  r = new BufferedReader(new InputStreamReader(i));
 }
 // USACO-style file input
 public Kattio(String problemName) throws IOException {
  super(problemName + ".out");
  r = new BufferedReader(new FileReader(problemName + ".in"));
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
}