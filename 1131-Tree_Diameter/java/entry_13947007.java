import java.io.*;
import java.util.*;

public class entry_13947007 {
    static int n;
    static List<Integer>[] tree;
    static int[] distance;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            sb.append(0);
            pw.println(sb.toString().trim());
            pw.close();
            br.close();
            return;
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        distance = new int[n + 1];
        bfs(1);

        int max = 0;
        int node = 0;

        for (int i = 1; i <= n; i++) {
            if (distance[i] > max) {
                max = distance[i];
                node = i;
            }
        }

        bfs(node);

        max = 0;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distance[i]);
        }

        sb.append(max);

        pw.println(sb.toString().trim());
        pw.close();
        br.close();
    }

    public static void bfs(int start) {
        Arrays.fill(distance, -1);
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        distance[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : tree[u]) {
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 1;
                    q.add(v);
                }
            }
        }
    }
}