//package sc.vsu.putinpa;

import java.io.*;
import java.util.*;

public class entry_10087832 {
    static InputReader in = new InputReader(System.in);
    static PrintStream out = new PrintStream(System.out);

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void init(InputStream inStream, PrintStream outStream) {
        in = new InputReader(inStream);
        out = new PrintStream(outStream);
    }

    public static void solution() {
        int n = in.nextInt();
        int m = in.nextInt();

        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            var a = in.nextInt() - 1;
            var b = in.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        var visited = new int[n];
        List<Integer> cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                cities.add(i);
                var color = cities.size();
                dfs(graph, i, visited, color);
            }
        }

        out.println(cities.size() - 1);
        var sb = new StringBuilder();
        for (int i = 0; i < cities.size() - 1; i++) {
            sb.append(cities.get(i) + 1).append(" ").append(cities.get(i + 1) + 1).append("\n");
        }
        out.println(sb);
    }

    static void dfs(List<List<Integer>> graph, int vertex, int[] visited, int color) {
        visited[vertex] = color;

        for (int v : graph.get(vertex)) {
            if (visited[v] == 0) {
                dfs(graph, v, visited, color);
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}