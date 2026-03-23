import java.io.*;
import java.util.*;

public class entry_12936405 {
    static List<Integer>[] g;

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            g[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        int[] res1 = bfs(1, n); // first BFS to get farthest node from node 1
        int[] res2 = bfs(res1[0], n); // second BFS from that farthest node

        System.out.println(res2[1]); // res2[1] = diameter
    }

    // returns {farthestNode, distance}
    static int[] bfs(int start, int n) {
        boolean[] vis = new boolean[n + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { start, 0 });
        vis[start] = true;
        int maxNode = start;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], dist = cur[1];
            if (dist > maxDist) {
                maxDist = dist;
                maxNode = node;
            }
            for (int nei : g[node]) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    q.add(new int[] { nei, dist + 1 });
                }
            }
        }

        return new int[] { maxNode, maxDist };
    }

    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}