//package com.denisbogdanov.cses.problemset_2.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class entry_6270816 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
    //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\RogBo\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);

        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        List<Integer> currPath = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            currPath.clear();
            currPath.add(i);

            if (hasCycleDfs(adjList, i, -1, visited, currPath)) {
                int startNode = currPath.get(currPath.size() - 1);
                int indexOfStart = currPath.indexOf(startNode);

                int size = currPath.size() - indexOfStart;
                System.out.println(size);
                System.out.println(currPath.stream().skip(indexOfStart).map(String::valueOf).collect(Collectors.joining(" ")));
                return;
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static boolean hasCycleDfs(List<List<Integer>> adjList, int currNode, int prevNode, boolean[] visited, List<Integer> currPath) {
        for (Integer neighbour : adjList.get(currNode)) {
            if (visited[neighbour]) {
                if (neighbour != prevNode) {
                    currPath.add(neighbour);
                    return true;
                }
            } else {
                visited[neighbour] = true;
                currPath.add(neighbour);
                if (hasCycleDfs(adjList, neighbour, currNode, visited, currPath)) {
                    return true;
                } else {
                    while (!currPath.isEmpty() && currPath.get(currPath.size() - 1) != currNode) {
                        currPath.remove(currPath.size() - 1);
                    }
                }
            }
        }

        return false;
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