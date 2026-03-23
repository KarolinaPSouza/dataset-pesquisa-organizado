//package com.denisbogdanov.cses.problemset_2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_6788689 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
    //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\RogBo\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        int furthestNode = -1;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!q.isEmpty()) {
            Integer polled = q.poll();
            furthestNode = polled;

            for (Integer neighbour : adjList.get(polled)) {
                if (visited[neighbour]) continue;

                visited[neighbour] = true;
                q.offer(neighbour);
            }
        }

        int distance = -1;
        q.offer(furthestNode);

        Arrays.fill(visited, false);
        visited[furthestNode] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer polled = q.poll();

                for (Integer neighbour : adjList.get(polled)) {
                    if (visited[neighbour]) continue;

                    visited[neighbour] = true;
                    q.offer(neighbour);
                }
            }

            distance++;
        }

        System.out.println(distance);
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