import java.io.*;
import java.util.*;

public class entry_15341651 {
 static List<Integer>[] g;
 static int n;

 public static void main(String[] args) throws Exception {
  FastScanner fs = new FastScanner(System.in);

  n = fs.nextInt();
  g = new ArrayList[n+1];
  for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

  for (int i = 0; i < n - 1; i++) {
   int a = fs.nextInt();
   int b = fs.nextInt();
   g[a].add(b);
   g[b].add(a);
  }

  int[] distA = new int[n+1];
  int[] distB = new int[n+1];

  int endA = bfsFarthest(1, distA);
  int endB = bfsFarthest(endA, distA);
  bfsFarthest(endB, distB);

  StringBuilder sb = new StringBuilder();
  for (int i = 1; i <= n; i++)
   sb.append(Math.max(distA[i], distB[i])).append(' ');

  System.out.println(sb);
 }

 static int bfsFarthest(int start, int[] dist) {
  Arrays.fill(dist, -1);
  Queue<Integer> q = new ArrayDeque<>();
  q.add(start);
  dist[start] = 0;

  int farthest = start;

  while (!q.isEmpty()) {
   int u = q.poll();
   if (dist[u] > dist[farthest]) farthest = u;

   for (int v : g[u])
    if (dist[v] == -1) {
     dist[v] = dist[u] + 1;
     q.add(v);
    }
  }

  return farthest;
 }

 // ⬇︎ Add your FastScanner here
 static class FastScanner {
  private final InputStream in;
  private final byte[] buffer = new byte[1 << 16];
  private int ptr = 0, len = 0;

  FastScanner(InputStream is) { in = is; }

  private int read() throws IOException {
   if (ptr >= len) {
    len = in.read(buffer);
    ptr = 0;
    if (len <= 0) return -1;
   }
   return buffer[ptr++];
  }

  int nextInt() throws IOException {
   int c;
   while ((c = read()) <= ' ') if (c == -1) return -1;
   int sign = 1;
   if (c == '-') { sign = -1; c = read(); }
   int val = c - '0';
   while ((c = read()) > ' ') val = val * 10 + (c - '0');
   return val * sign;
  }
 }
}