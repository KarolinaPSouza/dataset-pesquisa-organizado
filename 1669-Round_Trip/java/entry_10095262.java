import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class entry_10095262 {
    static final int N = 100010;
    static List<Integer>[] g = new ArrayList[N];
    static boolean[] vis = new boolean[N];
    static int[] par = new int[N];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException  {
        //System.setIn(new java.io.FileInputStream("9.in"));
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer line = new StringTokenizer(br.readLine(), " ");

        //long t1 = System.currentTimeMillis();

        int n = Integer.parseInt(line.nextToken());
        int m = Integer.parseInt(line.nextToken());

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
            vis[i] = false;
            par[i] = -1;
        }

        for (int i = 0; i < m; i++) {
         line = new StringTokenizer(br.readLine(), " ");        
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, -1);
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static void dfs(int node, int p) {
        par[node] = p;
        vis[node] = true;

        for (int x : g[node]) {
            if (!vis[x]) {
                dfs(x, node);
            } else if (x != p) {
                List<Integer> cyc = new ArrayList<>();
                int cur = node;

                cyc.add(node);
                while (par[cur] != x) {
                    cur = par[cur];
                    cyc.add(cur);
                }
                cyc.add(x);
                cyc.add(node);

                sb.append(cyc.size() + "\n");
                for (int y : cyc) {
                 sb.append(y + " ");
                }

                System.out.print(sb);

                System.exit(0);
            }
        }
    }
}