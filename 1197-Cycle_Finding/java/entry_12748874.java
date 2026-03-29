import java.io.*;
import java.util.*;

class BeingZero {
    public List<Integer> detectNegativeCycle(int n, int m, int[] u, int[] v, int[] w) {
        List<Integer> ans = new ArrayList<>();
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // Initialize distances
        dist[1] = 0;

        int[] par = new int[n + 1];
        Arrays.fill(par, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u1 = u[j];
                int v1 = v[j];
                int w1 = w[j];

                dist[v1] = Math.min(dist[v1], dist[u1] + w1);

            }
        }
        // System.out.println("Distances ");
        // for(long ele : dist)
        // System.out.print(ele + " ");
        // System.out.println();

        boolean f = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int u1 = u[j];
                int v1 = v[j];
                int w1 = w[j];

                long z = dist[v1];
                dist[v1] = Math.min(dist[v1], dist[u1] + w1);
                if (dist[v1] != z) {
                    f = false;
                    par[v1] = u1;
                }

            }
        }

        if (f) {
            return new ArrayList<>();
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

            Set<Integer> finalSet = new HashSet<>();
            for (int i : cycle) {
                ans.add(i);
                if (finalSet.contains(i)) {
                    break;
                }
                finalSet.add(i);
            }
            return ans;
        }
    }
}

public class entry_12748874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        int N = sc.nextInt(); // Number of nodes
        int E = sc.nextInt(); // Number of edges

        int[] u = new int[E];
        int[] v = new int[E];
        int[] w = new int[E];

        for (int i = 0; i < E; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }

        BeingZero bz = new BeingZero();
        List<Integer> cycle = bz.detectNegativeCycle(N, E, u, v, w);

        if (cycle.isEmpty()) {
            output.append("NO\n");
        } else {
            output.append("YES\n");
            for (int node : cycle) {
                output.append(node).append(" ");
            }
            output.append("\n");
        }

        System.out.print(output.toString());
        sc.close();
    }

}