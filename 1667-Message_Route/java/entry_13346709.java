import java.util.*;
import java.io.*;

public class entry_13346709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;
        int[] prev = new int[n + 1];


        while (!q.isEmpty()) {
            int node = q.poll();


            if (node == n) break;

            for (int nei : adj.get(node)) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    prev[nei] = node;
                    q.add(nei);
                }
            }
        }

        if (!vis[n]) {
            System.out.println("IMPOSSIBLE");
            return;
        }


        List<Integer> path = new ArrayList<>();
        int cur = n;
        while (cur != 0) {
            path.add(cur);
            cur = prev[cur];
        }
        Collections.reverse(path);

        System.out.println(path.size());
        StringBuilder sb = new StringBuilder();
        for (int node : path) {
            sb.append(node).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}