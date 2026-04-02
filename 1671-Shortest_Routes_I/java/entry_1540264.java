import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_1540264 {
    static class FastIO {
        InputStream dis;
        byte[] buffer = new byte[1 << 17];
        int pointer = 0;
        public FastIO(String fileName) throws Exception {
            dis = new FileInputStream(fileName);
        }
        public FastIO(InputStream is) throws Exception {
            dis = is;
        }
        int nextInt() throws Exception {
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
        long nextLong() throws Exception {
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
        byte nextByte() throws Exception {
            if (pointer == buffer.length) {
                dis.read(buffer, 0, buffer.length);
                pointer = 0;
            }
            return buffer[pointer++];
        }
        String next() throws Exception {
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
    }
    static class Edge {
        public int dest, weight;
        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
    static class Pair implements Comparable<Pair>{
        public int index;
        public long distance;
        public Pair(int index, long distance) {
            this.index = index;
            this.distance = distance;
        }
        public int compareTo(Pair p) {
            return Long.compare(distance, p.distance);
        }
    }
    public static void main(String[] args) throws Exception {
        FastIO sc = new FastIO(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        long inf = Long.MAX_VALUE/2;
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Edge>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            adj[sc.nextInt()-1].add(new Edge(sc.nextInt()-1, sc.nextInt()));
        }
        int s = 0;
        long[] dist = new long[n];
        Arrays.fill(dist, inf);
        dist[s] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(s, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.distance != dist[cur.index]) {
                continue;
            }
            for (Edge e : adj[cur.index]) {
                if (dist[e.dest] > dist[cur.index] + e.weight) {
                    dist[e.dest] = dist[cur.index] + e.weight;
                    pq.add(new Pair(e.dest, dist[e.dest]));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (long i : dist) {
            ans.append(i).append(" ");
        }
        pw.write(String.valueOf(ans));
        pw.close();
    }
}