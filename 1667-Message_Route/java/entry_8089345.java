//package com.denisbogdanov.cses.problemset_3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class entry_8089345 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
    //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\bogda\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        int[] prevComputers = new int[n + 1];
        prevComputers[1] = -1;

        while (!q.isEmpty()) {
            Integer polled = q.poll();

            for (Integer neighbour : adjList.get(polled)) {
                if (prevComputers[neighbour] != 0) continue;

                prevComputers[neighbour] = polled;
                q.offer(neighbour);

                if (neighbour == n) {
                    printPath(1, n, prevComputers);
                    return;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static void printPath(int start, int end, int[] prevComputers) {
        int curr = end;
        List<Integer> path = new ArrayList<>();

        while (curr != start) {
            path.add(curr);
            curr = prevComputers[curr];
        }

        path.add(start);
        System.out.println(path.size());
        Collections.reverse(path);
        System.out.println(path.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int[] readIntArray(int n) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = nextInt();
            }

            return result;
        }

        public long[] readLongArray(int n) {
            long[] result = new long[n];
            for (int i = 0; i < n; i++) {
                result[i] = nextLong();
            }

            return result;
        }

        public char[][] readCharGrid(int rows, int columns) {
            char[][] result = new char[rows][columns];
            for (int r = 0; r < rows; r++) {
                String row = next();
                result[r] = row.toCharArray();
            }

            return result;
        }
    }
}