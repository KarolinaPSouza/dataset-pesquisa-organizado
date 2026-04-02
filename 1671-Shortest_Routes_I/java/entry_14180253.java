import java.io.*;
import java.util.*;

public class entry_14180253 {
    static int n, m;
    static String ans;
    static List<int[]>[] adj;
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        n = fr.nextInt();
        m = fr.nextInt();
        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            int w = fr.nextInt();
            adj[u].add(new int[]{v,w});
        }
        long[] dist = new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
        pq.offer(new long[]{1,0});
        dist[1] = 0;
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int)curr[0];
            long weight = curr[1];
            if (weight != dist[node]) continue;
            for (int[] neigh: adj[node]) {
                int nextNode = neigh[0];
                int len = neigh[1];
                if (dist[nextNode] > weight + len) {
                    dist[nextNode] = weight + len;
                    pq.offer(new long[]{nextNode,dist[nextNode]});
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= n; i++) res.append(dist[i] + " ");
        out.println(res.toString());
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}