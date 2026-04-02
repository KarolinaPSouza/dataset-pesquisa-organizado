import java.io.*;
import java.util.*;

public class entry_12884337 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        FastReader() {
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
        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = fr.nextInt();
        int m = fr.nextInt();

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int c = fr.nextInt();
            graph[a].add(new int[]{b, c});
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{1, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int cost = edge[1];
                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                    pq.add(new long[]{v, dist[v]});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            bw.write(dist[i] + " ");
        }
        bw.newLine();
        bw.flush();
    }
}