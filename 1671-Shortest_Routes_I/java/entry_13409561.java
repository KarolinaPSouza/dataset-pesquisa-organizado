import java.io.*;
import java.util.*;

public class entry_13409561 {

    static long[] solve(int[][] graph, int N, int m) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int j = 0; j < graph.length; j++) {
            int u = graph[j][0] - 1;
            int v = graph[j][1] - 1;
            int wt = graph[j][2];
            adj.get(u).add(new int[]{v, wt});
        }

        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        q.add(new long[]{0, 0});

        while (!q.isEmpty()) {
            long[] curr = q.poll();
            int node = (int) curr[0];
            long dis = curr[1];

            if (dis > dist[node]) continue;

            for (int[] arr : adj.get(node)) {
                int adjNode = arr[0];
                int edgeWgt = arr[1];

                if (dis + edgeWgt < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWgt;
                    q.add(new long[]{adjNode, dist[adjNode]});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == Long.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        long[] ans = solve(graph, n, m);

        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + (i == n - 1 ? "\n" : " "));
        }
        bw.flush();
    }
}