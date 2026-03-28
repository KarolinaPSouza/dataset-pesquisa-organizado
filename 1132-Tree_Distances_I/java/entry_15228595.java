import java.io.*;
import java.util.*;

public class entry_15228595 {
    static int n;
    static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int[] dist1 = bfs(1);
        int u = 1;
        for (int i = 1; i <= n; i++) {
            if (dist1[i] > dist1[u]) u = i;
        }

        int[] distU = bfs(u);
        int v = u;
        for (int i = 1; i <= n; i++) {
            if (distU[i] > distU[v]) v = i;
        }

        int[] distV = bfs(v);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distU[i], distV[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : tree.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }
}