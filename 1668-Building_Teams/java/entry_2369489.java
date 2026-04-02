//package com.cses.graphalgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_2369489 {

    static PrintWriter out = new PrintWriter(System.out);

    static class FastScanner {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static List<Integer>[] adjList;
    static int[] color;
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        adjList = new List[n + 1];
        color = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (adjList[a] == null) {
                adjList[a] = new ArrayList<>();
            }
            if (adjList[b] == null) {
                adjList[b] = new ArrayList<>();
            }
            adjList[a].add(b);
            adjList[b].add(a);
        }
        boolean isPossible = true;
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                if (!bfs(i)) {
                    isPossible = false;
                    break;
                }
            }
        }
        if (isPossible) {
            for (int i = 1; i < n + 1; i++) {
                out.print(color[i] + " ");
            }
            out.println();
        } else {
            out.println("IMPOSSIBLE");
        }
        out.close();
    }

    private static boolean bfs(int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currNode = queue.poll();
                if (Objects.nonNull(adjList[currNode])) {
                    for (int neighbor : adjList[currNode]) {
                        if (color[neighbor] == 0) {
                            color[neighbor] = color[currNode] == 1 ? 2 : 1;
                            queue.add(neighbor);
                        } else {
                            if (color[neighbor] == color[currNode]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}