import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
 int vertex;
 long weight;

 public Pair(int vertex, long weight) {
  this.vertex = vertex;
  this.weight = weight;
 }

 @Override
 public int compareTo(Pair o) {
  return (int) (this.weight - o.weight);
 }
}

public class entry_1691703 {

 static long[] ans = new long[100000+10];
 static void dijkstra(ArrayList<ArrayList<Pair>> adj, int src) {
  PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
  boolean[] visited = new boolean[adj.size() + 1];
  pq.add(new Pair(src, 0));
  while (pq.size() > 0) {
   Pair top_pair = pq.poll();

   if (visited[top_pair.vertex]) {
    continue;
   }
   visited[top_pair.vertex] = true;

//   System.out.println(src + " to " + top_pair.vertex + " is @ " + top_pair.weight);
   ans[top_pair.vertex] = top_pair.weight;
   for (int i = 0; i < adj.get(top_pair.vertex).size(); i++) {
    if (!visited[adj.get(top_pair.vertex).get(i).vertex]) {
     pq.add(new Pair(adj.get(top_pair.vertex).get(i).vertex,
       adj.get(top_pair.vertex).get(i).weight + top_pair.weight));
    }
   }
  }
 }

 public static void main(String[] args) throws IOException {
  StdIn scn = new StdIn();
  int n = scn.nextInt();
  int m = scn.nextInt();
  ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
  for (int i = 0; i < n + 1; i++) {
   adj.add(new ArrayList<Pair>());
  }
  for (int i = 0; i < m; i++) {
   int u = scn.nextInt();
   int v = scn.nextInt();
   int w = scn.nextInt();
   adj.get(u).add(new Pair(v, w));
//   adj.get(v).add(new Pair(u, w));
  }
  dijkstra(adj, 1);
  for (int i = 1; i<=n; i++) {
   System.out.print(ans[i]+" ");
  }
 }

 interface Input {
  public String next();

  public String nextLine();

  public int nextInt();

  public long nextLong();

  public double nextDouble();
 }

 static class StdIn implements Input {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;

  public StdIn() {
   din = new DataInputStream(System.in);
   buffer = new byte[BUFFER_SIZE];
   bufferPointer = bytesRead = 0;
  }

  public StdIn(String filename) {
   try {
    din = new DataInputStream(new FileInputStream(filename));
   } catch (Exception e) {
    throw new RuntimeException();
   }
   buffer = new byte[BUFFER_SIZE];
   bufferPointer = bytesRead = 0;
  }

  public String next() {
   int c;
   while ((c = read()) != -1 && (c == ' ' || c == '\n' || c == '\r'))
    ;
   StringBuilder s = new StringBuilder();
   while (c != -1) {
    if (c == ' ' || c == '\n' || c == '\r')
     break;
    s.append((char) c);
    c = read();
   }
   return s.toString();
  }

  public String nextLine() {
   int c;
   while ((c = read()) != -1 && (c == ' ' || c == '\n' || c == '\r'))
    ;
   StringBuilder s = new StringBuilder();
   while (c != -1) {
    if (c == '\n' || c == '\r')
     break;
    s.append((char) c);
    c = read();
   }
   return s.toString();
  }

  public int nextInt() {
   int ret = 0;
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

  public int[] readIntArray(int n) {
   int[] ar = new int[n];
   for (int i = 0; i < n; ++i)
    ar[i] = nextInt();
   return ar;
  }

  public long nextLong() {
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

  public long[] readLongArray(int n) {
   long[] ar = new long[n];
   for (int i = 0; i < n; ++i)
    ar[i] = nextLong();
   return ar;
  }

  public long gcd(long a, long b) {
   if (b == 0) {
    return a;
   }
   return gcd(b, a % b);
  }

  public void printLongArray(long[] a) {
   for (int i = 0; i < a.length; i++) {
    System.out.print(a[i] + " ");
   }
   System.out.println();
  }

  public void printIntArray(int[] a) {
   for (int i = 0; i < a.length; i++) {
    System.out.print(a[i] + " ");
   }
   System.out.println();
  }

  public double nextDouble() {
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

  private byte read() {
   try {
    if (bufferPointer == bytesRead)
     fillBuffer();
    return buffer[bufferPointer++];
   } catch (IOException e) {
    throw new RuntimeException();
   }
  }

  public void close() throws IOException {
   if (din == null)
    return;
   din.close();
  }
 }
}