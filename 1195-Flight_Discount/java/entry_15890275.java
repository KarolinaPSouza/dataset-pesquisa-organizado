//package flight_discount;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class entry_15890275 {
 static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
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

 public static void main(String[] args) throws IOException{
//  long begin = System.currentTimeMillis();
//        System.setIn(new java.io.FileInputStream("C:\\Users\\haiduong.ng\\eclipse-workspace\\luyen_thi_pro\\src\\flight_discount\\input.txt"));
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a-1).add(new Edge(b, c));
        }

        long[][] dist = new long[n+1][2];
        for (int i = 1; i <= n; ++i) {
         Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        dist[1][0] = 0;

        PriorityQueue<long[]> pQueue = new PriorityQueue<long[]>(Comparator.comparing(a -> a[0]));
        pQueue.add(new long[] {0,1,0});


        while(!pQueue.isEmpty()) {
         long[] cur = pQueue.poll();
         long cost = cur[0];
         long city = cur[1]; 
         long couponUsed = cur[2];


         if (cost != dist[(int) city][(int) couponUsed]) continue;

         if (city == n) {
          System.out.println(cost);
//                System.out.println(System.currentTimeMillis()-begin + "ms");
          return;
         }

         for (Edge edge: graph.get((int) (city-1))) {
          int nextCity = edge.to;
          long newCost = cost + edge.cost;
          if (newCost < dist[nextCity][(int) couponUsed]) {
           dist[nextCity][(int) couponUsed] = newCost;
           pQueue.add(new long[] {newCost,nextCity,(long) couponUsed});
          }

          if (couponUsed == 0) {
           long newCostWithCoupon = cost + edge.cost/2;
           if (newCostWithCoupon < dist[nextCity][1]) {
            dist[nextCity][1] = newCostWithCoupon;
            pQueue.add(new long[] { newCostWithCoupon,nextCity,1});
           }
          }
         }
        }
    }
}