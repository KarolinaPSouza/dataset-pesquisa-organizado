// package Tree;

import java.io.*;
import java.util.*;

public class entry_15289783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            adj.get(boss).add(i);
        }

        int[] subOrdinates = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> order = new ArrayList<>();

        q.add(1);
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int child : adj.get(node)) {
                q.add(child);
            }
        }

        for (int i = order.size() - 1; i >= 0; i--) {
            int node = order.get(i);
            for (int child : adj.get(node)) {
                subOrdinates[node] += subOrdinates[child] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subOrdinates[i]).append(" ");
        }
        System.out.print(sb);
    }
}