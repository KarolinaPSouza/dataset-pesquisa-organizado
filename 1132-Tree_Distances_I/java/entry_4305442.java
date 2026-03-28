//package CompetitiveProgramming.CSES.TreeAlgorithms;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Vector;
import java.util.Queue;
import java.util.ArrayDeque;

public class entry_4305442 {
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

 static void dfs(int s, int n, Vector<Vector<Integer>> adj, int[] dist) {
  Queue<Integer> q = new ArrayDeque<Integer>();
  q.add(s);
  int[] vis = new int[n];
  vis[s] = 1;
  while (!q.isEmpty()) {
   int u = q.poll();
   for (int i : adj.get(u)) {
    if (vis[i] == 1)
     continue;
    vis[i] = 1;
    dist[i] += 1 + dist[u];
    q.add(i);
   }
  }
 }

 public static void main(String[] args) throws IOException {
  BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
  Reader sc = new Reader();
  int n = sc.nextInt();
  Vector<Vector<Integer>> adj = new Vector<>();
  for (int i = 0; i < n; i++) {
   adj.add(new Vector<>());
  }
  for (int i = 1; i < n; i++) {
   int a = sc.nextInt();
   int b = sc.nextInt();
   adj.get(a - 1).add(b - 1);
   adj.get(b - 1).add(a - 1);
  }
  int[] distend1 = new int[n];
  int[] distend2 = new int[n];
  dfs(0, n, adj, distend1);
  int max = 0;
  int maxsource = 0;
  for (int i = 0; i < n; i++) {
   if (max < distend1[i]) {
    maxsource = i;
    max = distend1[i];
   }
  }
  Arrays.fill(distend1, 0);
  max = 0;
  dfs(maxsource, n, adj, distend1);
  for (int i = 0; i < n; i++) {
   if (max < distend1[i]) {
    maxsource = i;
    max = distend1[i];
   }
  }
  dfs(maxsource, n, adj, distend2);
  for (int i = 0; i < n; i++) {
   output.write(Math.max(distend1[i], distend2[i]) + " ");
  }
  output.flush();
  output.close();
 }
}