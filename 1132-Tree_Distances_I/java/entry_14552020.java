//package com.problems.tree ;
import java.io.*;
import java.util.*;

public class entry_14552020 {
    private static List<List<Integer>> adj;

    private static int[] bfs(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] d1 = bfs(1, n);
        int A = 1;
        for (int i = 1; i <= n; i++) {
            if (d1[i] > d1[A]) A = i;
        }
        int[] distA = bfs(A, n);
        int B = A;
        for (int i = 1; i <= n; i++) {
            if (distA[i] > distA[B]) B = i;
        }
        int[] distB = bfs(B, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i], distB[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}