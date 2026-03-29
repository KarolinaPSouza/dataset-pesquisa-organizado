import java.util.*;

public class entry_11978680 {

    static final long INF = 0x3f3f3f3f3f3f3f3fL;
    static final int MAXN = 2501;
    static final int MAXM = 5001;
    static int N, M, ptr;
    static int[] p = new int[MAXN];
    static long[] dp = new long[MAXN];
    static Edge[] edges = new Edge[MAXM];

    static class Edge {
        int a, b;
        long c;
        Edge(int a, int b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        // Reading the edges
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();
            edges[i] = new Edge(a, b, c);
        }

        // Initialize dp array
        ptr = -1;
        Arrays.fill(dp, INF);
        Arrays.fill(p, -1);
        dp[2] = 0;  // Starting from node 2

        // Bellman-Ford algorithm
        for (int iter = 0; iter < N && ptr != 0; iter++) {
            ptr = 0;
            for (int i = 0; i < M; i++) {
                int u = edges[i].a;
                int v = edges[i].b;
                long w = edges[i].c;

                if (dp[v] > dp[u] + w) {
                    dp[v] = dp[u] + w;
                    p[v] = u;
                    ptr = v;
                }
            }
        }

        if (ptr == 0) {
            System.out.println("NO");
            return;
        }

        // Trace the cycle
        for (int i = 0; i < N; i++) {
            ptr = p[ptr];
        }

        List<Integer> cycle = new ArrayList<>();
        for (int v = ptr; ; v = p[v]) {
            cycle.add(v);
            if (v == ptr && cycle.size() > 1) break;
        }

        Collections.reverse(cycle);

        System.out.println("YES");
        for (int i = 0; i < cycle.size(); i++) {
            System.out.print(cycle.get(i) + (i == cycle.size() - 1 ? "\n" : " "));
        }
    }
}