import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_1927488 {

 static class _Scanner {
  InputStream is;
  _Scanner(InputStream is) {
   this.is = is;
  }
  byte[] bb = new byte[1 << 15];
  int k, l;
  byte getc() throws IOException {
   if (k >= l) {
    k = 0;
    l = is.read(bb); //if (l < 0) return -1;
   }
   return bb[k++];
  }
  byte skip() throws IOException {
   byte b;
   while ((b = getc()) <= 32)
    ;
   return b;
  }
  String next() throws IOException {
   StringBuilder sb = new StringBuilder();
   for (byte b = skip(); b > 32; b = getc())
    sb.append((char) b);
   return sb.toString();
  }
  int nextInt() throws IOException {
   int n = 0;
   for (byte b = skip(); b > 32; b = getc())
    n = n * 10 + b - '0';
   return n;
  }
 }

 private static final int MAX = 1_000_00;
 private static List<int[]>[] adj = new ArrayList[MAX + 1];
 private static long[] dist = new long[MAX + 1];

 public static void shortestPathFromSource(int source, int N) {

  //Dijkstra's Algorithm

  TreeSet<long[]> pq = new TreeSet<>(
          (x, y) -> x[0] == y[0] ? Long.compare(x[1], y[1]) : Long.compare(x[0], y[0]));
    dist[1] = 0;
    pq.add(new long[]{dist[1], 1});
    while (!pq.isEmpty()) {
   int u = (int) pq.pollFirst()[1];
   for (int[] edge : adj[u]) {
     int v = edge[0];
     int w = edge[1];
     if (dist[v] > dist[u] + w) {
    pq.remove(new long[]{dist[v], v});
    dist[v] = dist[u] + w;
    pq.add(new long[]{dist[v], v});
     }
   }
    }

  // StringBuilder sb = new StringBuilder();

  // for(int i = 1; i <= N; i += 1) {
   // sb.append(distanceOf[i] + " ");
  // }
  PrintWriter pw = new PrintWriter(System.out);

  for(int i = 1; i <= N; i += 1) {
   pw.print(dist[i] + " ");
  }

  pw.println();
  pw.close();

  //System.out.println(sb);

 }

 public static void main(String[] args) throws IOException{
  _Scanner sc = new _Scanner(System.in);
  int n = sc.nextInt();
  int m = sc.nextInt();
  for (int i = 1; i <= n; i++) {
   adj[i] = new ArrayList<>();
   dist[i] = Long.MAX_VALUE;
  }
  while (m-- > 0) {
   int i = sc.nextInt();
   int j = sc.nextInt();
   int w = sc.nextInt();
   adj[i].add(new int[]{j, w});
  }


  shortestPathFromSource(1, n);
 }

}