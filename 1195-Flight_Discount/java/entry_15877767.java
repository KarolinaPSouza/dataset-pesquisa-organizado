import java.io.*;
import java.util.*;

public class entry_15877767 {
 static class FastScanner {
  private final InputStream stream;
  private final byte[] buffer = new byte[1 << 16];
  private int ptr = 0;
  private int len = 0;

  FastScanner(InputStream stream) {
   this.stream = stream;
  }

  private int readByte() throws IOException {
   if (ptr >= len) {
    len = stream.read(buffer);
    ptr = 0;
    if (len <= 0)
     return -1;
   }
   return buffer[ptr++];
  }

  int nextInt() throws IOException {
   int c, sign = 1, result = 0;
   do {
    c = readByte();
    if (c == -1)
     return -1;
   } while (c <= ' ');
   if (c == '-') {
    sign = -1;
    c = readByte();
   }
   do {
    result = result * 10 + c - '0';
    c = readByte();
   } while (c > ' ');
   return result * sign;
  }

  long nextLong() throws IOException {
   int c, sign = 1;
   long result = 0;
   do {
    c = readByte();
    if (c == -1)
     return -1;
   } while (c <= ' ');
   if (c == '-') {
    sign = -1;
    c = readByte();
   }
   do {
    result = result * 10 + c - '0';
    c = readByte();
   } while (c > ' ');
   return result * sign;
  }
 }

 static class City {
  int id, disCount;
  long cost;

  City(int id, long cost, int disCount) {
   this.id = id;
   this.cost = cost;
   this.disCount = disCount;
  }

 }
 static class Road {
  int sCity, eCity;
  long cost;

  Road(int sCity, int eCity, long cost) {
   this.sCity = sCity;
   this.eCity = eCity;
   this.cost = cost;
  }
 }

 static ArrayList<Road> map[];
 static long minCost[][];
 static PriorityQueue<City> queue;
 static long max = (long) 1e15;
 static int n,m;
 public static void main(String[] args) throws IOException {
  FastScanner fc = new FastScanner(System.in);

  n = fc.nextInt();
  m = fc.nextInt();
  map = new ArrayList[n + 1];
  minCost = new long[2][n + 1];

  for (int i = 0; i <= n; i++) {
   map[i] = new ArrayList<>();
  }

  queue = new PriorityQueue<>((c1,c2)->Long.compare(c1.cost, c2.cost));

  for (int i = 0; i < m; i++) {
   int a = fc.nextInt();
   int b = fc.nextInt();
   long c = fc.nextLong();
   Road r = new Road(a, b, c);
   map[a].add(r);
  }

  for(int i=0;i<=1;i++){
   for(int j=1;j<=n;j++) minCost[i][j] = max;
  }

  City c = new City(1, 0, 0);
  minCost[0][1] = 0;
  queue.add(c);
  while (!queue.isEmpty()) {
   c = queue.poll();
   if (c.cost > minCost[c.disCount][c.id]) {
    continue;
   }
   for (Road r : map[c.id]) {
    // Discount
    if (c.disCount == 0 && c.cost + r.cost / 2 < minCost[c.disCount+1][r.eCity]) {
      minCost[c.disCount+1][r.eCity] = c.cost + r.cost / 2;
      queue.add(new City(r.eCity, c.cost + r.cost / 2, c.disCount+1));
    }
    // Not Discount
    if (c.cost + r.cost < minCost[c.disCount][r.eCity]) {
     minCost[c.disCount][r.eCity] = c.cost + r.cost;
     queue.add(new City(r.eCity, c.cost + r.cost, c.disCount));
    }
   }

  }
  System.out.println(Math.min(minCost[0][n],minCost[1][n]));
 }
}