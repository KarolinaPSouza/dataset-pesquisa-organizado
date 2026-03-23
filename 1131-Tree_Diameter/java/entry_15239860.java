import java.io.*;
import java.util.*;

public class entry_15239860 {
    static List<Integer>[] adj;
    static int n;

    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static Pair bfs(int start) {
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(start, 0));
        visited[start] = true;

        Pair farthest = new Pair(start, 0);

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            if (curr.dist > farthest.dist)
                farthest = curr;

            for (int nei : adj[curr.node]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(new Pair(nei, curr.dist + 1));
                }
            }
        }
        return farthest;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Pair x = bfs(1);
        Pair y = bfs(x.node);

        System.out.println(y.dist);
    }
}