import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class entry_15127453 {
    static int[] distances;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("cdf.in"));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1; int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b); adj[b].add(a);
        }

        visited = new boolean[N];
        int f1 = bfs(0, 0)[0];

        visited = new boolean[N];
        pw.println(bfs(f1, 0)[1]);

        br.close();
        pw.close();
    }

    static int[] dfs(int curr, int len) {
        visited[curr] = true;
        int maxDist = len;
        int farthest = curr;

        for (int n : adj[curr]) {
            if (!visited[n]) {
                int[] cand = dfs(n, len + 1);
                if (cand[1] > maxDist) {
                    maxDist = cand[1];
                    farthest = cand[0];
                }
            }
        }

        return new int[]{farthest, maxDist};
    }

    static int[] bfs(int curr, int len) {
        ArrayDeque<Integer[]> dq = new ArrayDeque<>();
        dq.offer(new Integer[]{curr, len});
        int farthest = curr;
        int maxDist = len;

        while (!dq.isEmpty()) {
            Integer[] pair = dq.poll();
            if (visited[pair[0]]) continue;
            visited[pair[0]] = true;
            if (pair[1] > maxDist) {
                maxDist = pair[1];
                farthest = pair[0];
            }

            for (int n : adj[pair[0]]) {
                dq.offer(new Integer[]{n, pair[1] + 1});
            }
        }

        return new int[]{farthest, maxDist};
    }
}
