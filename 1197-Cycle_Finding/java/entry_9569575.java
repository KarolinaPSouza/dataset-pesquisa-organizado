import java.util.*;

public class entry_9569575 {
    static int[] parent;
    static boolean[] visited;
    static long INF = (long)Math.pow(10,18);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();

        }
        visited = new boolean[n + 1];
        int negEdge = -1;
        negEdge = CycDetect(1, edges, n, m);

        if (negEdge == -1)
            System.out.println("NO");
        else {
            System.out.println("YES");
            int v = negEdge;
            ArrayList<Integer> l = new ArrayList<>();

            for(int i = 0; i < n; i++){
                v = parent[v];
            }

            l.add(v);
            int u = parent[v];
            while (u != v) {
                l.add(u);
                u = parent[u];
            }
            l.add(v);

            for (int i = l.size() - 1; i >= 0; i--) {
                System.out.print(l.get(i) + " ");
            }

        }

    }

    public static int CycDetect(int k, int[][] edges, int n, int m) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        visited[k] = true;
        parent = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int src = edges[j][0];
                int dest = edges[j][1];
                int weight = edges[j][2];
                if (((dist[src] + weight) < dist[dest])) {
                    dist[dest] = dist[src] + weight;
                    parent[dest] = src;
                    visited[dest] = true;
                }
            }
        }
        int negEdge = -1;
        for (int j = 0; j < m; j++) {
            int src = edges[j][0];
            int dest = edges[j][1];
            int weight = edges[j][2];
            if (((dist[src] + weight) < dist[dest])) {
                parent[dest] = src;
                negEdge = dest;
                break;
            }
        }
        return negEdge;
    }

}