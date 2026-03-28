import java.io.*;
import java.util.*;

public class entry_13308989 {
    static ArrayList<Integer>[] tree;
    static int[] distance;

    public static int findFarthest(int start, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int farthest = start;
        while (!q.isEmpty()) {
            int curr = q.poll();
            farthest = curr;
            for (int nei : tree[curr]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        return farthest;
    }

    public static int[] bfs(int start, int n) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nei : tree[curr]) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    dist[nei] = dist[curr] + 1;
                    q.add(nei);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        int x = findFarthest(1, n);
        int y = findFarthest(x, n);
        int[] dx = bfs(x, n);
        int[] dy = bfs(y, n);

        for (int i = 1; i <= n; i++) {
            out.print(Math.max(dx[i], dy[i]) + " ");
        }
        out.println();
        out.flush();
    }
}