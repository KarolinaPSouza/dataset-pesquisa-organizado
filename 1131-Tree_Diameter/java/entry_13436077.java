
import java.io.*;
import java.util.*;

public class entry_13436077 {
    static int n;
    static List<List<Integer>> adj;

    // BFS from src; returns farthest node and fills distances
    static int bfs(int src, int[] dist) {
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        dist[src] = 0;

        int far = src;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                    if (dist[v] > dist[far]) far = v;
                }
            }
        }
        return far;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] dist = new int[n + 1];
        int A = bfs(1, dist);         // 1: arbitrary start
        int B = bfs(A, dist);         // from A we find furthest node
        System.out.println(dist[B]);  // dist[B] is the diameter
    }
}