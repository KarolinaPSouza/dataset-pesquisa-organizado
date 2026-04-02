import java.io.*;
import java.util.*;

public class entry_14780384 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();

        ArrayList<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int c = fr.nextInt();
            adj[a].add(new int[]{b, c});
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{1, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;

            for (int[] p : adj[node]) {
                int neighbor = p[0];
                int w = p[1];
                if (dist[node] + w < dist[neighbor]) {
                    dist[neighbor] = dist[node] + w;
                    pq.add(new long[]{neighbor, dist[neighbor]});
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            bw.write(dist[i] + " ");
        }
        bw.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}