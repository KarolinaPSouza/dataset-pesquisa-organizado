import java.io.*;
import java.util.*;

public class entry_15304491 {

    static int n;
    static ArrayList<Integer>[] adj;

    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            String[] parts = br.readLine().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            adj[a].add(b);
            adj[b].add(a);
        }
        int[] first = bfs(1);
        int A = 1;
        for (int i = 1; i <= n; i++) {
            if (first[i] > first[A]) A = i;
        }

        int[] distA = bfs(A);
        int B = A;
        for (int i = 1; i <= n; i++) {
            if (distA[i] > distA[B]) B = i;
        }

        int[] distB = bfs(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(" ");
        }
        System.out.println(sb.toString());
    }
}