//package com.denisbogdanov.cses.problemset_2.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class entry_6778123 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\RogBo\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();

        int[] result = new int[n];

        int[] bosses = new int[n];
        bosses[0] = -1;

        int[] directSubordinates = new int[n];

        for (int i = 1; i < n; i++) {
            int boss = in.nextInt() - 1;
            directSubordinates[boss]++;
            bosses[i] = boss;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (directSubordinates[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer polled = q.poll();
            int boss = bosses[polled];

            if (boss == -1) continue;

            result[boss] += result[polled] + 1;
            directSubordinates[boss]--;
            if (directSubordinates[boss] == 0) {
                q.offer(boss);
            }
        }

        System.out.println(Arrays.stream(result).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
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