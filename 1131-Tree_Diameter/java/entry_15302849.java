import java.io.*;
import java.util.*;

public class entry_15302849 {
    static int n;
    static ArrayList<ArrayList<Integer>> g;

    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        int farNode = start;

        while (!q.isEmpty()) {
            int u = q.poll();
            farNode = u;

            for (int v : g.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return new int[]{farNode, dist[farNode]};
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        g = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        int A = bfs(1)[0];
        int diameter = bfs(A)[1];

        System.out.println(diameter);
    }
}