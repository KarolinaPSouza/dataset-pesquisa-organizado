//package com.example.DSA.graph;

import java.io.*;
import java.util.*;

public class entry_15939745 {

    // Fast input reader
    static class FastScanner {
        private final BufferedInputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static int n, m;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        readInput(fs);

        if (!bfs()) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        printPath();
    }

    static void readInput(FastScanner fs) throws Exception {
        n = fs.nextInt();
        m = fs.nextInt();

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];
    }

    static boolean bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = true;
        parent[1] = -1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == n) {
                return true;
            }

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = node;
                    queue.add(next);
                }
            }
        }
        return false;
    }

    static void printPath() {
        List<Integer> path = new ArrayList<>();
        int curr = n;

        while (curr != -1) {
            path.add(curr);
            curr = parent[curr];
        }

        Collections.reverse(path);

        System.out.println(path.size());
        for (int node : path) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}