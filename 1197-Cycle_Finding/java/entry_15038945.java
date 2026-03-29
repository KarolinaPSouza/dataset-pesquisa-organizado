import java.util.*;

public class entry_15038945 {
    static class Edge {
        long u, v, w;
        Edge(long u, long v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long w = sc.nextLong();
            edges.add(new Edge(x, y, w));
        }

        long[] dist = new long[(int) (n + 1)];
        Arrays.fill(dist, (long) 1e15);
        dist[1] = 0;

        long[] par = new long[(int) (n + 1)];
        Arrays.fill(par, -1);

        // Relax edges n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (dist[(int) edge.u] + edge.w < dist[(int) edge.v]) {
                    dist[(int) edge.v] = dist[(int) edge.u] + edge.w;
                    par[(int) edge.v] = edge.u;
                }
            }
        }

        // Check for negative weight cycle
        long x = -1;
        for (Edge edge : edges) {
            if (dist[(int) edge.u] + edge.w < dist[(int) edge.v]) {
                par[(int) edge.v] = edge.u;
                x = edge.v;
                break;
            }
        }

        if (x == -1) {
            System.out.println("NO");
        } else {
            // find cycle
            for (int i = 0; i < n; i++) {
                x = par[(int) x];
            }

            List<Long> cycle = new ArrayList<>();
            Set<Long> seen = new HashSet<>();

            while (!seen.contains(x)) {
                cycle.add(x);
                seen.add(x);
                x = par[(int) x];
            }
            cycle.add(x);

            Collections.reverse(cycle);

            System.out.println("YES");
            Set<Long> printed = new HashSet<>();
            for (long node : cycle) {
                System.out.print(node + " ");
                if (printed.contains(node)) break;
                printed.add(node);
            }
            System.out.println();
        }
    }
}