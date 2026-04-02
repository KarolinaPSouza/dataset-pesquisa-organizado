import java.io.*;
import java.util.*;

public class entry_9191015 {
 static class Edge {
  int v;
  long w;

  Edge(int v, long w) {
   this.v = v;
   this.w = w;
  }
 }

 static class Node implements Comparable<Node> {
  int id;
  long dist;

  Node(int id, long dist) {
   this.id = id;
   this.dist = dist;
  }

  public int compareTo(Node other) {
   return Long.compare(this.dist, other.dist);
  }
 }

 static class Reader {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;

  public Reader() {
   din = new DataInputStream(System.in);
   buffer = new byte[BUFFER_SIZE];
   bufferPointer = bytesRead = 0;
  }

  public String readLine() throws IOException {
   byte[] buf = new byte[64]; // line length
   int cnt = 0, c;
   while ((c = read()) != -1) {
    if (c == '\n') {
     if (cnt != 0) {
      break;
     } else {
      continue;
     }
    }
    buf[cnt++] = (byte) c;
   }
   return new String(buf, 0, cnt);
  }

  public int nextInt() throws IOException {
   int ret = 0;
   byte c = read();
   while (c <= ' ') {
    c = read();
   }
   boolean neg = (c == '-');
   if (neg)
    c = read();
   do {
    ret = ret * 10 + c - '0';
   } while ((c = read()) >= '0' && c <= '9');

   if (neg)
    return -ret;
   return ret;
  }

  public long nextLong() throws IOException {
   long ret = 0;
   byte c = read();
   while (c <= ' ')
    c = read();
   boolean neg = (c == '-');
   if (neg)
    c = read();
   do {
    ret = ret * 10 + c - '0';
   } while ((c = read()) >= '0' && c <= '9');
   if (neg)
    return -ret;
   return ret;
  }

  public double nextDouble() throws IOException {
   double ret = 0, div = 1;
   byte c = read();
   while (c <= ' ')
    c = read();
   boolean neg = (c == '-');
   if (neg)
    c = read();

   do {
    ret = ret * 10 + c - '0';
   } while ((c = read()) >= '0' && c <= '9');

   if (c == '.') {
    while ((c = read()) >= '0' && c <= '9') {
     ret += (c - '0') / (div *= 10);
    }
   }

   if (neg)
    return -ret;
   return ret;
  }

  private void fillBuffer() throws IOException {
   bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
   if (bytesRead == -1)
    buffer[0] = -1;
  }

  private byte read() throws IOException {
   if (bufferPointer == bytesRead)
    fillBuffer();
   return buffer[bufferPointer++];
  }

  public void close() throws IOException {
   if (din == null)
    return;
   din.close();
  }
 }

 public static void main(String[] args) throws IOException {
  Reader sc = new Reader();
  PrintWriter out = new PrintWriter(System.out);

  int maxN = 100005;
  int N = sc.nextInt();
  int M = sc.nextInt();
  int a, b;
  long c;
  ArrayList<Edge>[] G = new ArrayList[maxN + 1];
  for (int i = 1; i <= maxN; i++) {
   G[i] = new ArrayList<>();
  }

  for (int i = 0; i < M; i++) {
   a = sc.nextInt();
   b = sc.nextInt();
   c = sc.nextLong();
   G[a].add(new Edge(b, c));
  }

  long[] dist = new long[maxN + 1];
  Arrays.fill(dist, Long.MAX_VALUE);
  dist[1] = 0;
  PriorityQueue<Node> Q = new PriorityQueue<>();
  Q.add(new Node(1, 0));

  while (!Q.isEmpty()) {
   Node node = Q.poll();
   long d = node.dist;
   int u = node.id;

   if (d > dist[u])
    continue;

   for (Edge e : G[u]) {
    if (dist[e.v] > d + e.w) {
     dist[e.v] = d + e.w;
     Q.add(new Node(e.v, dist[e.v]));
    }
   }
  }

  for (int i = 1; i <= N; i++) {
   out.print(dist[i] + " ");
  }
  out.flush();
 }
}