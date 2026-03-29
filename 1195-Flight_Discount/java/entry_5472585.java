//package CompetitiveProgramming.CSES.Graph;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class entry_5472585 {
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

  public Reader(String file_name) throws IOException {
   din = new DataInputStream(new FileInputStream(file_name));
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

 static class Pair {
  int x;
  long y;

  public Pair(int x, long y) {
   this.x = x;
   this.y = y;
  }
 }

 static class Triplet {
  int x;
  int y;
  long z;

  public Triplet(int x, int y, long z) {
   this.x = x;
   this.y = y;
   this.z = z;
  }
 }

 static void dij(int source, ArrayList<ArrayList<Pair>> adj, long[] dist) {
  int[] vis = new int[adj.size()];
  q.add(new Pair(source, 0));
  dist[source] = 0;
  // System.out.println(q.peek().x + " " + q.peek().y);
  while (!q.isEmpty()) {
   Pair s = q.poll();
   if (vis[s.x] == 1)
    continue;
   vis[s.x] = 1;
   for (Pair i : adj.get(s.x)) {
    if (dist[s.x] + i.y < dist[i.x]) {
     dist[i.x] = dist[s.x] + i.y;
     q.add(new Pair(i.x, dist[i.x]));
     // System.out.println(q.peek().y);
    }
   }
  }
 }

 static PriorityQueue<Pair> q = new PriorityQueue<>((p1, p2) -> Long.compare(p1.y, p2.y));

 public static void main(String[] args) throws IOException {
  BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
  Reader sc = new Reader();
  int n = sc.nextInt();
  int m = sc.nextInt();
  Triplet[] connections = new Triplet[m];
  ArrayList<ArrayList<Pair>> adj1 = new ArrayList<>();
  ArrayList<ArrayList<Pair>> adj2 = new ArrayList<>();
  for (int i = 0; i < n; i++) {
   adj1.add(new ArrayList<>());
   adj2.add(new ArrayList<>());
  }
  for (int i = 0; i < m; i++) {
   int a = sc.nextInt() - 1;
   int b = sc.nextInt() - 1;
   int c = sc.nextInt();
   adj1.get(a).add(new Pair(b, c));
   adj2.get(b).add(new Pair(a, c));
   connections[i] = new Triplet(a, b, c);
  }
  long[] dist1 = new long[n];
  long[] dist2 = new long[n];
  Arrays.fill(dist1, (long) 2e14);
  Arrays.fill(dist2, (long) 2e14);
  dij(0, adj1, dist1);
  dij(n - 1, adj2, dist2);
  long ans = Long.MAX_VALUE;
  for (Triplet i : connections) {
   ans = Math.min(ans, (dist1[i.x]) + (dist2[i.y]) + (i.z / 2));
  }
  output.write(ans + "\n");
  output.flush();
  sc.close();
 }
}