import java.io.*;
import java.util.*;

class Reader {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        int nextInt() { return Integer.parseInt(next()); }
    }
}

public class entry_14961313 {
    static class Edge {
        int u, v;
        long w;
        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Reader.FastReader sc = new Reader.FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextInt();
            edges.add(new Edge(a - 1, b - 1, c));
        }

        long[] dist = new long[n];
        int[] par = new int[n];
        Arrays.fill(dist, 0);      // start from 0 so we can detect cycles in any component
        Arrays.fill(par, -1);

        int x = -1;
        for (int i = 0; i < n; i++) {
            x = -1;
            for (Edge e : edges) {
                if (dist[e.v] > dist[e.u] + e.w) {
                    dist[e.v] = dist[e.u] + e.w;
                    par[e.v] = e.u;
                    x = e.v;
                }
            }
        }

        if (x == -1) {
            System.out.println("NO");
        } else {
            // Move n times to ensure we are inside the negative cycle
            int y = x;
            for (int i = 0; i < n; i++) {
                y = par[y];
            }

            // Robust cycle reconstruction
            List<Integer> cycle = new ArrayList<>();
            cycle.add(y);
            int v = par[y];
            while (v != y) {
                cycle.add(v);
                v = par[v];
            }
            cycle.add(y); // close the cycle

            Collections.reverse(cycle);

            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            for (int node : cycle) {
                sb.append(node + 1).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}