//package com.denisbogdanov.cses.problemset_3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class entry_8153341 {
    private static final long INF = 1_000_000_000_000_000L;

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\bogda\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        int m = in.nextInt();

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int weight = in.nextInt();

            edges[i] = new Edge(from, to, weight);
        }

        long[] distances = new long[n + 1];
        Arrays.fill(distances, INF);
        distances[1] = 0;

        int[] prev = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distances[edge.to] > distances[edge.from] + edge.weight) {
                    distances[edge.to] = distances[edge.from] + edge.weight;
                    prev[edge.to] = edge.from;
                }
            }
        }

        int start = -1;
        for (Edge edge : edges) {
            if (distances[edge.to] > distances[edge.from] + edge.weight) {
                if (distances[edge.to] > distances[edge.from] + edge.weight) {
                    start = edge.to;
                    distances[edge.to] = distances[edge.from] + edge.weight;
                    prev[edge.to] = edge.from;
                }
            }
        }

        if (start == -1) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < n; i++) {
            start = prev[start];
        }

        List<Integer> result = new ArrayList<>();
        int currNode = start;
        while (true) {
            result.add(currNode);
            if (start == currNode && result.size() > 1) {
                break;
            }

            currNode = prev[currNode];
        }

        Collections.reverse(result);
        System.out.println("YES");
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static class Edge {
        final int from;
        final int to;
        final int weight;

        private Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
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