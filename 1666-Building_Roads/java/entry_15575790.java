import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_15575790 {

    static void bfs(List < List < Integer >> adj, boolean[] vis, int u) {
        Queue < Integer > q = new ArrayDeque < > ();
        q.offer(u);
        vis[u] = true;

        while (!q.isEmpty()) {

            u = q.poll();


            for (int v: adj.get(u)) {
                if (!vis[v]) {
                    q.offer(v);
                    vis[v] = true;

                }
            }
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List < List < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj.get(u - 1).add(v - 1);
            adj.get(v - 1).add(u - 1);
        }



        boolean[] vis = new boolean[n];



        List < Integer > connections = new ArrayList < > ();




        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(adj, vis, i);
                connections.add(i + 1);

            }
        }


        System.out.println(connections.size()-1);


        for (int i = 0; i < connections.size() - 1; i++) {
            int u = connections.get(i);
            int v = connections.get(i + 1);

            System.out.println(u + " " + v);

        }




    }
}