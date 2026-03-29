import java.util.*;

public class entry_13692844 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        ArrayList<int[]> edges = new ArrayList<>();
        long[] dis = new long[V + 1];
        Arrays.fill(dis, 0); // 0 works even for disconnected nodes
        int[] par = new int[V + 1];

        int updatedNode = -1;

        for (int i = 0; i < E; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int d = s.nextInt();
            edges.add(new int[]{a, b, d});
        }

        for (int i = 0; i < V; i++) {
            updatedNode = -1;
            for (int[] e : edges) {
                int u = e[0], v = e[1], w = e[2];
                if (dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                    par[v] = u;
                    updatedNode = v;
                }
            }
        }

        if (updatedNode == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            // Move V steps to enter the cycle
            for (int i = 0; i < V; i++) {
                updatedNode = par[updatedNode];
            }

            List<Integer> cycle = new ArrayList<>();
            int cur = updatedNode;
            do {
                cycle.add(cur);
                cur = par[cur];
            } while (cur != updatedNode);
            cycle.add(updatedNode);
            Collections.reverse(cycle);

            for (int x : cycle) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}