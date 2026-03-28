import java.io.*;
import java.util.*;

public class entry_13180605 {
    static final int MAXN = 200005;
    static int[] head = new int[MAXN];
    static int[] to = new int[2 * MAXN];
    static int[] next = new int[2 * MAXN];
    static int[] distU = new int[MAXN], distV = new int[MAXN];
    static int idx = 0;

    static void addEdge(int u, int v) {
        to[idx] = v;
        next[idx] = head[u];
        head[u] = idx++;
    }

    static void bfs(int start, int[] dist, int n) {
        Arrays.fill(dist, 1, n + 1, -1);
        Deque<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = head[u]; i != -1; i = next[i]) {
                int v = to[i];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = Integer.parseInt(br.readLine());
        Arrays.fill(head, 0, n + 1, -1);
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            addEdge(a, b);
            addEdge(b, a);
        }

        bfs(1, distU, n);
        int u = 1;
        for (int i = 2; i <= n; i++) if (distU[i] > distU[u]) u = i;
        bfs(u, distU, n);
        int v = 1;
        for (int i = 2; i <= n; i++) if (distU[i] > distU[v]) v = i;
        bfs(v, distV, n);

        for (int i = 1; i <= n; i++) out.print(Math.max(distU[i], distV[i]) + " ");
        out.println();
        out.flush();
    }
}