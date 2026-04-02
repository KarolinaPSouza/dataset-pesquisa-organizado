// ioput
import java.util.*;
import java.io.*;

public class entry_7084268 {

 private static final long INF = (long) 1e18;

 public static void main(String[] args) {
  FastIO io = new FastIO();

  int n = io.nextInt();
  int m = io.nextInt();
  int q = io.nextInt();

  long dist[][] = new long[n][n];
  for (int i = 0; i < n; ++i) {
   Arrays.fill(dist[i], INF);
  }

  for (int i = 0; i < m; ++i) {
   int a = io.nextInt() - 1;
   int b = io.nextInt() - 1;
   int c = io.nextInt();
   if (c < dist[a][b]) {
    dist[a][b] = dist[b][a] = c;
   }
  }

  for (int k = 0; k < n; ++k) {
   for (int i = 0; i < n; ++i) {
    for (int j = i + 1; j < n; ++j) {
     long newDist = dist[i][k] + dist[k][j];
     if (newDist < dist[i][j]) {
      dist[i][j] = dist[j][i] = newDist;
     }
    }
   }
  }

  for (int i = 0; i < q; ++i) {
   int a = io.nextInt() - 1;
   int b = io.nextInt() - 1;
   if (a == b) {
    dist[a][b] = 0;
   } else if (dist[a][b] == INF) {
    dist[a][b] = -1;
   }

   io.println(dist[a][b]); 
  }
  io.close();
 }
}

// Faster input
class FastIO extends PrintWriter {
 private StringTokenizer st;
 private BufferedReader br;

 public FastIO() {
  super(System.out);
  br = new BufferedReader(new InputStreamReader(System.in));
 }

 public String nextToken() {
  while (st == null || !st.hasMoreElements()) {
   try {
    st = new StringTokenizer(br.readLine());
   } catch (IOException e) {
    System.out.println("Error trying to get next token.");
    e.printStackTrace();
   }
  }
  return st.nextToken();
 }

 public int nextInt() {
  return Integer.parseInt(nextToken());
 }
}
