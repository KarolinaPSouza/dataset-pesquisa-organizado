import java.util.*;

public class entry_7163815 {

    static class Triplet {
        long first;
        long second;
        long third;
    }

    static long n, m;
    static List<Triplet> edges = new ArrayList<>();
    static long[] dist;
    static long[] relaxant;

    public static void bellmanFord() {
        long x = -1;
        for (long i = 1; i <= n; ++i) {
            x = -1;
            for (Triplet e : edges) {
                long u = e.first;
                long v = e.second;
                long d = e.third;
                if (dist[(int)u] + d < dist[(int)v]) {
                    dist[(int)v] = d + dist[(int)u];
                    relaxant[(int)v] = u;
                    x = v;
                }
            }
        }

        if (x == -1) {
            System.out.println("NO");
        } else {
            for (long i = 1; i <= n; ++i) {
                x = relaxant[(int)x];
            }

            List<Long> cycle = new ArrayList<>();

            for (long v = x; ; v = relaxant[(int)v]) {
                cycle.add(v);
                if (v == x && cycle.size() > 1) {
                    break;
                }
            }

            Collections.reverse(cycle);

            System.out.println("YES");
            for (long v : cycle) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        m = sc.nextLong();

        dist = new long[(int)n + 1];
        relaxant = new long[(int)n + 1];

        for (long i = 0; i < m; ++i) {
            Triplet inp = new Triplet();
            inp.first = sc.nextLong();
            inp.second = sc.nextLong();
            inp.third = sc.nextLong();
            edges.add(inp);
        }

        Arrays.fill(relaxant, -1);

        bellmanFord();
    }
}