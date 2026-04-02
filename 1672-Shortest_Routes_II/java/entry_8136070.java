//package com.denisbogdanov.cses.problemset_3.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_8136070 {
    private static final long INF = 1_000_000_000_000_000L;

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
    //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\bogda\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        long[][] distances = new long[n][n];
        for (long[] row : distances) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < n; i++) {
            distances[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;
            int dist = in.nextInt();

            distances[from][to] = distances[to][from] = Math.min(distances[from][to], dist);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[j][i] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int from = in.nextInt() - 1;
            int to = in.nextInt() - 1;

            long dist = distances[from][to];
            sb.append(dist == INF ? -1 : dist).append('\n');
        }

        System.out.println(sb);
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