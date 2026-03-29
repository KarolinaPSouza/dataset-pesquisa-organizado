import java.io.*;
import java.util.*;

public class entry_15695693 {

    static class Edge {
        int to;
        long wt;

        Edge(int to, long wt){
            this.to = to;
            this.wt = wt;
        }
    }

    static final long INF = (long) 1e18;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        List<List<Edge>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            long c = fs.nextLong();

            graph.get(a).add(new Edge(b, c));
        }

        long[][] dist = new long[n + 1][2];

        for(int i = 1; i <= n; i++){
            dist[i][0] = INF;
            dist[i][1] = INF;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        dist[1][0] = 0;

        pq.offer(new long[]{0, 1, 0});

        while(!pq.isEmpty()){

            long[] cur = pq.poll();

            long d = cur[0];

            int u = (int) cur[1];

            int used = (int) cur[2];

            if(dist[u][used] < d) continue;

            for(Edge e : graph.get(u)){

                int v = e.to;

                long wt = e.wt;

                if(d + wt < dist[v][used]){

                    dist[v][used] = d + wt;

                    pq.offer(new long[]{dist[v][used], v, used});   

                }

                if(used == 0){

                    long discounted = d + wt / 2;

                    if(discounted < dist[v][1]){

                        dist[v][1] = discounted;

                        pq.offer(new long[]{discounted, v, 1});

                    }

                }

            }

        }

        System.out.println(Math.min(dist[n][0], dist[n][1]));

    }

    // Fast input
    static class FastScanner {
        byte[] buffer = new byte[1 << 16];
        int ptr = 0, len = 0;
        InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do {
                c = read();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}