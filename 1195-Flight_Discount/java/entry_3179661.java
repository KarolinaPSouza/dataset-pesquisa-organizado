import java.io.*;
import java.util.*;

public class entry_3179661 {

 public static int n, m;
 public static LinkedList<Pair>[] to;
 public static LinkedList<Pair>[] from;
 public static long[] minDist;
 public static long[] minDist2;

 public static void main(String[] args) throws IOException {
  FastIO in = new FastIO(System.in);

  n = in.nextInt();
  m = in.nextInt();
  to = new LinkedList[n];
  from = new LinkedList[n];
  minDist = new long[n];
  minDist2 = new long[n];

  for (int i = 0; i < n; i++) {
   to[i] = new LinkedList<>();
   from[i] = new LinkedList<>();
  }
  for (int i = 0; i < m; i++) {
   int a = in.nextInt() - 1;
   int b = in.nextInt() - 1;
   long c = in.nextInt();
   to[a].add(new Pair(b, c));
   from[b].add(new Pair(a, c));
  }
  dijkstra(0, to, minDist);
  dijkstra(n-1, from, minDist2);

  long min = (long) 1e18;
  for (int i = 0; i < n; i++) {
   for (Pair p : to[i]) {
    min = Math.min(min, minDist[i] + minDist2[p.x] + p.y / 2);
   }
  }

  System.out.println(min);

  in.close();
 }

 public static void dijkstra(int source, LinkedList<Pair>[] adj, long[] minDist) {
  Arrays.fill(minDist, (long) 1e18);
  minDist[source] = 0;

  PriorityQueue<Pair> pq = new PriorityQueue<>();
  pq.add(new Pair(source, 0));
  while (!pq.isEmpty()) {
   Pair p = pq.poll();
   if (p.y != minDist[p.x]) continue;
   for (Pair i : adj[p.x]) {
    if (p.y + i.y < minDist[i.x]) {
     minDist[i.x] = p.y + i.y;
     pq.add(new Pair(i.x, minDist[i.x]));
    }
   }
  }
 }

 public static class Pair implements Comparable<Pair> {
  int x;
  long y;

  public Pair(int x, long y) {
   this.x = x;
   this.y = y;
  }

  @Override
  public int compareTo(Pair o) {
   return (int) (y == o.y ? x - o.x : y - o.y);
  }
 }

 public static class FastIO {
  private InputStream dis;
  private byte[] buffer = new byte[1 << 17];
  private int pointer = 0;

  public FastIO(String fileName) throws IOException {
   dis = new FileInputStream(fileName);
  }

  public FastIO(InputStream is) throws IOException {
   dis = is;
  }

  public int nextInt() throws IOException {
   int ret = 0;
   byte b;

   do {
    b = nextByte();
   } while (b <= ' ');

   boolean negative = false;
   if (b == '-') {
    negative = true;
    b = nextByte();
   }

   while (b >= '0' && b <= '9') {
    ret = 10 * ret + b - '0';
    b = nextByte();
   }

   return (negative) ? -ret : ret;
  }

  public long nextLong() throws IOException {
   long ret = 0;
   byte b;

   do {
    b = nextByte();
   } while (b <= ' ');

   boolean negative = false;
   if (b == '-') {
    negative = true;
    b = nextByte();
   }

   while (b >= '0' && b <= '9') {
    ret = 10 * ret + b - '0';
    b = nextByte();
   }

   return (negative) ? -ret : ret;
  }

  public byte nextByte() throws IOException {
   if (pointer == buffer.length) {
    dis.read(buffer, 0, buffer.length);
    pointer = 0;
   }
   return buffer[pointer++];
  }

  public String next() throws IOException {
   StringBuffer ret = new StringBuffer();
   byte b;

   do {
    b = nextByte();
   } while (b <= ' ');

   while (b > ' ') {
    ret.appendCodePoint(b);
    b = nextByte();
   }

   return ret.toString();
  }

  public void close() throws IOException {
   dis.close();
  }
 }
}