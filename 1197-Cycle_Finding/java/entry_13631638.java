import java.util.*;
import java.io.*;

class Main {
    static class Edge {
    int from, to;
    long cost;
    Edge(int from, int to, long cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            edges.add(new Edge(a, b, c));
        }

        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, 0); 
        Arrays.fill(parent, -1);

        int x = -1;

        for (int i = 1; i <= n; i++) {
            x = -1;
            for (Edge e : edges) {
                if (dist[e.to] > dist[e.from] + e.cost) {
                    dist[e.to] = dist[e.from] + e.cost;
                    parent[e.to] = e.from;
                    x = e.to;
                }
            }
        }
        if (x == -1){
            System.out.println("NO");
        } else {
            int y = x;
            for (int i = 0; i < n; i++) {
                y = parent[y];
            }

            List<Integer> cycle = new ArrayList<>();
            int cur = y;

            do {
                cycle.add(cur);
                cur = parent[cur];
            } while (cur != y || cycle.size() == 0);
            cycle.add(y);

            Collections.reverse(cycle);

            System.out.println("YES");
            for (int v : cycle) {
                System.out.print(v + " ");
            }
        }
    }
}