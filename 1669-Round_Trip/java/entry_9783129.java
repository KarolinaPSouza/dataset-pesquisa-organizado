/*import java.io.*;
import java.util.*;
 public class entry_9783129 {
    private static boolean dfs(int node, int[] vis, int[] parent, ArrayList<ArrayList<Integer>> adj, List<Integer> cycle){
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                parent[it] = node;
                if (dfs(it, vis, parent, adj, cycle)) {
                    return true;
                }
            } else if (it != parent[node]) {
                // Cycle detected
                int cur = node;
                while (cur != it) {
                    cycle.add(cur);
                    cur = parent[cur];
                }
                cycle.add(it);
                cycle.add(node); // Add starting node again to close the cycle
                return true;
            }
        }
        return false;
    }
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
         // Read edges
        for (int i = 0; i < m; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
                int[] vis = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        List<Integer> cycle = new ArrayList<>();
                // Find a cycle using DFS
        boolean cycleFound = false;
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, parent, adj, cycle)) {
                    cycleFound = true;
                    break;
                }
            }
        }
        if (cycleFound) {
            System.out.println(cycle.size());
            for (Integer num : cycle) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}*/
import java.io.*;
import java.util.*;

public class entry_9783129 {
    static ArrayList<Integer>[] g;
    static boolean[] vis;
    static int[] par;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // Number of nodes
        int m = Integer.parseInt(st.nextToken()); // Number of edges

        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }

        vis = new boolean[n + 1];
        par = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            vis[i] = false;
            par[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (dfs(i, -1)) {
                    return; // Exit after finding and printing the cycle
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static boolean dfs(int node, int p) {
        par[node] = p;
        vis[node] = true;

        for (int x : g[node]) {
            if (!vis[x]) {
                if (dfs(x, node)) {
                    return true;
                }
            } else if (x != p) {
                ArrayList<Integer> cyc = new ArrayList<>();

                int cur = node;
                cyc.add(node);

                while (par[cur] != x) {
                    cur = par[cur];
                    cyc.add(cur);
                }

                cyc.add(x);
                cyc.add(node);

                System.out.println(cyc.size());

                for (int num : cyc) {
                    System.out.print(num + " ");
                }
                System.out.println();

                return true;
            }
        }

        return false;
    }
}