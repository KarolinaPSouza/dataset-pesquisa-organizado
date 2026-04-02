import java.io.*;
import java.util.*;

public class entry_12103736 {
    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Edge {
        int to;
        long weight;
        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();

        List<List<Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int c = fr.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(encode(1, 0L));

        while (!pq.isEmpty()) {
            long current = pq.poll();
            long currentDist = current >>> 17;
            int u = (int)(current & 0x1FFFF);

            if (currentDist > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                long newDist = currentDist + edge.weight;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.add(encode(v, newDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append(' ');
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static long encode(int node, long distance) {
        return (distance << 17) | node;
    }
}