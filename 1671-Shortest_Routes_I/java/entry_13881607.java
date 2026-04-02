import java.io.*;
import java.util.*;

public class entry_13881607 {
    static class Pair implements Comparable<Pair> {
        long dist;
        int node;
        Pair(long d, int n) {
            dist = d;
            node = n;
        }

        public int compareTo(Pair other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            graph.get(u).add(new Pair(w, v));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            long d = current.dist;
            int u = current.node;

            if (d > dist[u]) continue;

            for (Pair edge : graph.get(u)) {
                int v = edge.node;
                long newDist = d + edge.dist;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    pq.offer(new Pair(newDist, v));
                }
            }
        }

        for (int i = 1; i <= n; i++) out.print(dist[i] + " ");
        out.println();
        out.flush();
    }
}