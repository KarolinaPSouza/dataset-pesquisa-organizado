import java.io.*;
import java.util.*;

public class entry_13412498 {
    static class Pair implements Comparable<Pair> {
        long dist;
        int node;

        Pair(long dist, int node) {
            this.dist = dist;
            this.node = node;
        }

        public int compareTo(Pair other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();

        List<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            long w = fr.nextLong();
            graph[u].add(new Pair(w, v));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (cur.dist > dist[cur.node]) continue;

            for (Pair edge : graph[cur.node]) {
                if (dist[edge.node] > cur.dist + edge.dist) {
                    dist[edge.node] = cur.dist + edge.dist;
                    pq.add(new Pair(dist[edge.node], edge.node));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb);
    }
}