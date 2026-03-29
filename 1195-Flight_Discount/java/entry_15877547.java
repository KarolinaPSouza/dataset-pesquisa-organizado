//package onpro;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class entry_15877547 {
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
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, result = 0;
            do {
                c = readByte();
                if (c == -1) return -1;
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
                if (c == -1) return -1;
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
 static class Road{
  int end; 
  long cost;
  public Road(int end, long cost) {
   this.end = end;
   this.cost = cost;
  }
 }
 static class City{
  int end; 
  long cost; 
  int dc;
  public City(int end, long cost, int dc) {
   this.end = end;
   this.cost = cost;
   this.dc = dc;
  }
 }
 static long max = (long) 1e15;
 static int n, m;
 static ArrayList<Road> roads[];
 static PriorityQueue<City> cities;
 static long visited[][];
 @SuppressWarnings("unchecked")
 public static void main(String[] args) throws IOException {
  //System.setIn(new java.io.FileInputStream("sample_input.txt"));
  @SuppressWarnings("resource")
  FastScanner sc = new FastScanner(System.in);
  n = sc.nextInt();
  m = sc.nextInt();
  roads = new ArrayList[n+1];
  for(int i=1;i<=n;i++){
   roads[i] = new ArrayList<>();
  }
  visited = new long[n+1][2];
  for(int i=1;i<=m;i++){
    int st = sc.nextInt();
    int end = sc.nextInt();
    long cost = sc.nextInt();
    Road road = new Road(end, cost);
    roads[st].add(road);
  }
  System.out.println(Dijkstra(1, n));
 }

 public static long Dijkstra(int a, int b) {
  for(int i=0;i<=n;i++){
   for(int j=0;j<=1;j++) visited[i][j] = max;
  }
  cities = new PriorityQueue<>((c1,c2)->Long.compare(c1.cost, c2.cost));
  cities.add(new City(a, 0, 0));
  visited[a][0] = 0;
  while(!cities.isEmpty()){
   City tmp = cities.poll();
   if(tmp.cost>visited[tmp.end][tmp.dc]) continue;
   for(Road r:roads[tmp.end]){
    if(tmp.cost+r.cost<visited[r.end][tmp.dc]){
     visited[r.end][tmp.dc] = tmp.cost+r.cost;
     cities.add(new City(r.end, tmp.cost+r.cost, tmp.dc));
    }
    if(tmp.dc<1&&tmp.cost+r.cost/2<visited[r.end][tmp.dc+1]){
     visited[r.end][tmp.dc+1] = tmp.cost+r.cost/2;
     cities.add(new City(r.end, tmp.cost+r.cost/2, tmp.dc+1));
    }
   }
  }
  return Math.min(visited[b][0], visited[b][1]);
 }
}