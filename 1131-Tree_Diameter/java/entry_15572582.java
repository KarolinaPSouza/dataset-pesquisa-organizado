import java.io.*;
import java.util.*;

public class entry_15572582 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        // BFS from node 1 to find farthest node u
        int u = bfsFarthest(1, adj, n);
        // BFS from u to find diameter distance
        int diameter = bfsDistance(u, adj, n);
        System.out.println(diameter);
    }

    // returns farthest node index from start
    static int bfsFarthest(int start, ArrayList<Integer>[] adj, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;
        int farNode = start;
        while (!q.isEmpty()) {
            int v = q.poll();
            if (dist[v] > dist[farNode]) farNode = v;
            for (int to : adj[v]) {
                if (dist[to] == -1) {
                    dist[to] = dist[v] + 1;
                    q.add(to);
                }
            }
        }
        return farNode;
    }

    // returns maximum distance from start to any node
    static int bfsDistance(int start, ArrayList<Integer>[] adj, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;
        int maxd = 0;
        while (!q.isEmpty()) {
            int v = q.poll();
            maxd = Math.max(maxd, dist[v]);
            for (int to : adj[v]) {
                if (dist[to] == -1) {
                    dist[to] = dist[v] + 1;
                    q.add(to);
                }
            }
        }
        return maxd;
    }
}