import java.io.*;
import java.util.*;

public class entry_13305138 {
    static int[] subtreeSz;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer("");
        int edgesRead = 0;
        while (edgesRead < n - 1) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int b = Integer.parseInt(st.nextToken());
            adj.get(b).add(edgesRead + 2);
            adj.get(edgesRead + 2).add(b);
            edgesRead++;
        }

        subtreeSz = new int[n + 1];
        parent = new int[n + 1];


        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        q.add(1);
        parent[1] = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int nbr : adj.get(node)) {
                if (nbr != parent[node]) {
                    parent[nbr] = node;
                    q.add(nbr);
                }
            }
        }


        Collections.reverse(order);
        for (int node : order) {
            subtreeSz[node] = 1;
            for (int nbr : adj.get(node)) {
                if (nbr != parent[node]) {
                    subtreeSz[node] += subtreeSz[nbr];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subtreeSz[i] - 1).append(" ");
        }
        System.out.println(sb);
    }
}