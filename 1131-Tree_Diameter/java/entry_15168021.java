import java.io.*;
import java.util.*;

public class entry_15168021 {

    static ArrayList<Integer>[] adj;
    static int n;

    static class Pair {
        int node, dist;
        Pair(int n, int d) { node = n; dist = d; }
    }

    static Pair bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        q.add(start);
        dist[start] = 0;

        int farNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > maxDist) {
                        maxDist = dist[v];
                        farNode = v;
                    }
                }
            }
        }
        return new Pair(farNode, maxDist);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<Integer>();

        for (int i = 0; i < n - 1; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            adj[a].add(b);
            adj[b].add(a);
        }

        Pair p1 = bfs(1);
        Pair p2 = bfs(p1.node);

        System.out.println(p2.dist);
    }
}