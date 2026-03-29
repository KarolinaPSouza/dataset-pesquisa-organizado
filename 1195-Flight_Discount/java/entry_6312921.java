//package com.denisbogdanov.cses.problemset_2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_6312921 {
    private static final long INF = 1_000_000_000_000_000L;

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\RogBo\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        int m = in.nextInt();

        long[] costsWithoutDiscount = new long[n];
        long[] costsWithOneDiscount = new long[n];

        Arrays.fill(costsWithoutDiscount, INF);
        Arrays.fill(costsWithOneDiscount, INF);

        costsWithoutDiscount[0] = 0;
        costsWithOneDiscount[0] = 0;

        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int c = in.nextInt();

            adjList.get(a).add(new Edge(b, c));
        }

        Queue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingLong(e -> e.cost));
        minHeap.offer(new Edge(0, 0));
        boolean[] processedWithoutDiscount = new boolean[n];
        boolean[] processedWitOneDiscount = new boolean[n];

        while (!minHeap.isEmpty()) {
            Edge polled = minHeap.poll();

            if (polled.usedDiscount) {
                if (processedWitOneDiscount[polled.to]) continue;
                processedWitOneDiscount[polled.to] = true;
            } else {
                if (processedWithoutDiscount[polled.to]) continue;
                processedWithoutDiscount[polled.to] = true;
            }

            for (Edge edge : adjList.get(polled.to)) {
                if (polled.usedDiscount) {
                    if (polled.cost + edge.cost < costsWithOneDiscount[edge.to]) {
                        costsWithOneDiscount[edge.to] = polled.cost + edge.cost;
                        minHeap.offer(new Edge(edge.to, costsWithOneDiscount[edge.to], true));
                    }
                } else {
                    if (polled.cost + edge.cost < costsWithoutDiscount[edge.to]) {
                        costsWithoutDiscount[edge.to] = polled.cost + edge.cost;
                        minHeap.offer(new Edge(edge.to, costsWithoutDiscount[edge.to]));
                    }

                    if (polled.cost + edge.cost / 2 < costsWithOneDiscount[edge.to]) {
                        costsWithOneDiscount[edge.to] = polled.cost + edge.cost / 2;
                        minHeap.offer(new Edge(edge.to, costsWithOneDiscount[edge.to], true));
                    }
                }
            }
        }

        System.out.println(costsWithOneDiscount[n - 1]);
    }

    private static class Edge {
        final int to;
        final long cost;
        boolean usedDiscount = false;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        public Edge(int to, long cost, boolean usedDiscount) {
            this.to = to;
            this.cost = cost;
            this.usedDiscount = usedDiscount;
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