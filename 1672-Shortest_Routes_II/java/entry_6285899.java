//package com.denisbogdanov.cses.problemset_2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_6285899 {
    private static final long INF = 1_000_000_000_000_000L;

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\RogBo\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        long[][] distMatrix = new long[n][n];
        for (long[] row : distMatrix) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < n; i++) {
            distMatrix[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int weight = in.nextInt();

            distMatrix[a][b] = distMatrix[b][a] = Math.min(distMatrix[a][b], weight);
        }

        for (int k = 0; k < n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    distMatrix[a][b] = Math.min(distMatrix[a][b], distMatrix[a][k] + distMatrix[k][b]);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;

            sb.append(distMatrix[a][b] == INF ? -1: distMatrix[a][b]).append("\n");
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