import java.io.*;
import java.util.*;

public class entry_14791199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, w});
        }

        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, 0);  // multi-source BF

        int x = -1;

        for (int i = 0; i < n; i++) {
            x = -1;
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                    x = v;
                }
            }
        }

        if (x == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 0; i < n; i++) x = parent[x]; // move inside cycle

            List<Integer> cycle = new ArrayList<>();
            int start = x;
            do {
                cycle.add(x);
                x = parent[x];
            } while (x != start);
            cycle.add(start);

            Collections.reverse(cycle);
            for (int node : cycle) {
                System.out.print(node + " ");
            }
        }
    }
}