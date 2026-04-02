import java.io.*;
import java.util.*;

public class entry_14481444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        int[] parent = new int[n + 1];
        int[] childCount = new int[n + 1];
        int[] subordinates = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            parent[i] = boss;
            adj[boss].add(i);
            childCount[boss]++;
        }

        // Queue for bottom-up BFS
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (adj[i].isEmpty()) q.add(i); // leaf employees
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == 1) continue; // root has no parent
            int boss = parent[u];

            subordinates[boss] += (1 + subordinates[u]);

            childCount[boss]--;
            if (childCount[boss] == 0) q.add(boss);
        }

        // Fast output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subordinates[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}