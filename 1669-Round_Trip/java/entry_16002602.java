import java.io.*;
import java.util.*;

public class entry_16002602 {

    static int sn = -1;
    static int en = -1;
    static boolean[] vis;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> adj;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read n and m
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        v++; // 1-based indexing

        vis = new boolean[v];
        parent = new int[v];
        adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // read edges
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 1; i < v; i++) {
            if (!vis[i]) {
                parent[i] = -1;
                vis[i] = true;
                if (dfs(i, -1)) {
                    ans.add(sn);
                    for (int f = en; f != sn; f = parent[f]) {
                        ans.add(f);
                    }
                    ans.add(sn);

                    System.out.println(ans.size());
                    for (int x : ans) {
                        System.out.print(x + " ");
                    }
                    return;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    static boolean dfs(int i, int p) {
        for (int k : adj.get(i)) {
            if (k == p) continue;

            if (!vis[k]) {
                vis[k] = true;
                parent[k] = i;
                if (dfs(k, i)) return true;
            } else {
                sn = k;
                en = i;
                return true;
            }
        }
        return false;
    }
}