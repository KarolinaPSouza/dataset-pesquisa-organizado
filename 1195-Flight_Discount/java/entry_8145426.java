//package com.denisbogdanov.cses.problemset_3.graph;

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

public class entry_8145426 {
    private static final long INF = 1_000_000_000_000_000L;

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
    //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\bogda\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Route>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int cost = in.nextInt();

            adjList.get(a).add(new Route(b, cost, false));
        }

        long[] fullCosts = new long[n];
        long[] discountedCosts = new long[n];

        Arrays.fill(fullCosts, INF);
        Arrays.fill(discountedCosts, INF);

        fullCosts[0] = 0;
        discountedCosts[0] = 0;

        Queue<Route> q = new PriorityQueue<>(Comparator.comparingLong(r -> r.cost));
        q.offer(new Route(0, 0, false));

        while (!q.isEmpty()) {
            Route polled = q.poll();

            if (polled.usedDiscount) {
                if (polled.cost > discountedCosts[polled.to]) continue;

                int newStart = polled.to;

                for (Route route : adjList.get(newStart)) {
                    int nextCity = route.to;
                    if (discountedCosts[nextCity] > discountedCosts[newStart] + route.cost) {
                        discountedCosts[nextCity] = discountedCosts[newStart] + route.cost;
                        q.offer(new Route(nextCity, discountedCosts[nextCity], true));
                    }
                }
            } else {
                if (polled.cost > fullCosts[polled.to]) continue;

                int newStart = polled.to;

                for (Route route : adjList.get(newStart)) {
                    int nextCity = route.to;
                    if (fullCosts[nextCity] > fullCosts[newStart] + route.cost) {
                        fullCosts[nextCity] = fullCosts[newStart] + route.cost;
                        q.offer(new Route(nextCity, fullCosts[nextCity], false));
                    }
                }

                for (Route route : adjList.get(newStart)) {
                    int nextCity = route.to;
                    if (discountedCosts[nextCity] > fullCosts[newStart] + route.cost / 2) {
                        discountedCosts[nextCity] = fullCosts[newStart] + route.cost / 2;
                        q.offer(new Route(nextCity, discountedCosts[nextCity], true));
                    }
                }
            }
        }

        System.out.println(discountedCosts[n - 1]);
    }

    private static class Route {
        final int to;
        final long cost;
        final boolean usedDiscount;

        public Route(int to, long cost, boolean usedDiscount) {
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