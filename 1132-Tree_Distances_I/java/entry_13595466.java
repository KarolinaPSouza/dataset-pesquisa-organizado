// package com.example.songanalytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_13595466 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node_u = Integer.parseInt(st.nextToken()) - 1;
            int node_v = Integer.parseInt(st.nextToken()) - 1;
            list.get(node_u).add(node_v);
            list.get(node_v).add(node_u);
        }

        // First BFS to find the farthest node from any starting point (let's use node 0)
        int[] dist1 = bfs(list, 0, n);

        // Find the node with maximum distance
        int farthestNode = 0;
        for (int i = 0; i < n; i++) {
            if (dist1[i] > dist1[farthestNode]) {
                farthestNode = i;
            }
        }

        // Second BFS from the farthest node found in the first BFS
        int[] distFromA = bfs(list, farthestNode, n);

        // Find the farthest node from node A (call it B)
        int nodeB = 0;
        for (int i = 0; i < n; i++) {
            if (distFromA[i] > distFromA[nodeB]) {
                nodeB = i;
            }
        }

        // Third BFS from node B
        int[] distFromB = bfs(list, nodeB, n);

        // Calculate the maximum distance for each node
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(Math.max(distFromA[i], distFromB[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    // BFS function to calculate distance from a source node to all other nodes
    private static int[] bfs(List<List<Integer>> graph, int source, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        dist[source] = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int neighbor : graph.get(curr)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    queue.offer(neighbor);
                }
            }
        }

        return dist;
    }
}