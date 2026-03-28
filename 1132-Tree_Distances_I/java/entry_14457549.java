import java.io.*;
import java.util.*;

public class entry_14457549 {
    static int N = 200001;
    static ArrayList<Integer>[] adj = new ArrayList[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] d1 = bfs(1, n);
        int far = 1;
        for (int i = 1; i <= n; i++) if (d1[i] > d1[far]) far = i;

        int[] d2 = bfs(far, n);
        far = 1;
        for (int i = 1; i <= n; i++) if (d2[i] > d2[far]) far = i;

        int[] d3 = bfs(far, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(d2[i], d3[i])).append(" ");
        }
        System.out.println(sb);
    }

    static int[] bfs(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
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
}