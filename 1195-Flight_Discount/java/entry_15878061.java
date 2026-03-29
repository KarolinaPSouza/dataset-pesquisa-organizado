import java.io.*;
import java.util.*;

public class entry_15878061 {
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

 static class City implements Comparable<City> {
  int id, disCount;
  long cost;

  City(int id, long cost, int disCount) {this.id = id;
   this.cost = cost;
   this.disCount = disCount;
  }

  @Override
  public int compareTo(City o) {
   return Long.compare(this.cost, o.cost);
  }

  @Override
  public String toString() {
   return this.id + "|" + this.cost + "|" + this.disCount;
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
 static Queue<City> queue = new PriorityQueue<>();
 static long max = (long) 1e15;

 public static void main(String[] args) throws IOException {
  //System.setIn(newjava.io.FileInputStream("src/sample_input.txt"));
  FastScanner scanner = new FastScanner(System.in);

  int n = scanner.nextInt();
  int m = scanner.nextInt();
  map = new ArrayList[n + 1];
  minCost = new long[2][n + 1];
  // System.out.println("" + n + " " + m + "");
  for (int i = 0; i <= n; i++) {
   map[i] = new ArrayList<>();
  }
  queue.clear();

  for (int i = 0; i < m; i++) {
   int a = scanner.nextInt();
   int b = scanner.nextInt();
   long c = scanner.nextLong();
   Road r = new Road(a, b, c);
   map[a].add(r);
  }

  Arrays.fill(minCost[0], max);
  Arrays.fill(minCost[1], max);
  City c = new City(1, 0, 0);
  minCost[0][1] = 0;
  minCost[1][1] = 0;
  queue.add(c);
  while (!queue.isEmpty()) {
   c = queue.poll();
   if (c.cost > minCost[c.disCount][c.id]) {
    continue;
   }

   for (Road r : map[c.id]) {
    // Discount
    if (c.disCount == 0) {
     long newCost = c.cost + r.cost / 2;
     if (newCost < minCost[c.disCount+1][r.eCity]) {
      minCost[c.disCount+1][r.eCity] = newCost;
      queue.add(new City(r.eCity, newCost, c.disCount+1));
     }
    }
    // Not Discount
    long newCost = c.cost + r.cost;
    if (newCost < minCost[c.disCount][r.eCity]) {
     minCost[c.disCount][r.eCity] = newCost;
     queue.add(new City(r.eCity, newCost, c.disCount));
    }
   }

  }
  System.out.print(Math.min(minCost[0][n],minCost[1][n]));
 }
}