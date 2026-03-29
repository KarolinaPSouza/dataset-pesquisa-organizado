import java.io.*;
import java.util.*;

class BeingZero {
    public void solve(int n, int m, List<int[]> edges) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, 0);  // Use Long.MAX_VALUE for initialization
        dist[1] = 0;

        int[] par = new int[n + 1];
        Arrays.fill(par, -1);

        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != Long.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[u] + w);
                }
            }
        }

        boolean f = true;

        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != Long.MAX_VALUE) {
                    long z = dist[v];
                    dist[v] = Math.min(dist[v], dist[u] + w);
                    if (dist[v] != z) {
                        f = false;
                        par[v] = u;
                    }
                }
            }
        }

        if (f) {
            System.out.println("NO");
        } else {
            int x = 0;
            for (int i = 1; i <= n; i++) {
                if (par[i] != -1) {
                    x = i;
                    break;
                }
            }

            List<Integer> cycle = new ArrayList<>();
            Set<Integer> stSet = new HashSet<>();
            while (!stSet.contains(x)) {
                cycle.add(x);
                stSet.add(x);
                x = par[x];
            }
            cycle.add(x);
            Collections.reverse(cycle);

            System.out.println("YES");
            Set<Integer> finalSet = new HashSet<>();
            for (int i : cycle) {
                System.out.print(i + " ");
                if (finalSet.contains(i)) {
                    break;
                }
                finalSet.add(i);
            }
        }
    }
}

public class entry_11479590 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new int[]{u, v, w});
        }

        BeingZero solver = new BeingZero();
        solver.solve(n, m, edges);
    }
}