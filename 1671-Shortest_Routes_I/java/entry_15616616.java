import java.io.*;
import java.util.*;

public class entry_15616616 {

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = readByte();
            } while (c <= ' ');

            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = readByte();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return neg ? -val : val;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }

    static class Edge {
        int to;
        long w;

        Edge(int to, long weight) {
            this.to = to;
            this.w = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            long w = fs.nextLong();
            graph[u].add(new Edge(v, w));
        }

        long[] dist = new long[n + 1];

  for( int i = 1;i <= n;i++){
    dist[i] = Long.MAX_VALUE;
  }

  dist[1] = 0;

  PriorityQueue<long[]> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1[1], e2[1]));
  pq.add(new long[]{1, 0});

  while(!pq.isEmpty()){

    long[] curr = pq.poll();
    if(dist[(int)curr[0]] < curr[1]){
     continue;
    }

    for(Edge e : graph[(int)curr[0]]){
     if(dist[e.to] > dist[(int)curr[0]] + e.w){
      dist[e.to] = dist[(int)curr[0]] + e.w;
      pq.add(new long[]{e.to, dist[e.to]});
     }
    }
  }

  for(int i = 1;i <= n;i++){
   System.out.print(dist[i] + " ");
  }

}}