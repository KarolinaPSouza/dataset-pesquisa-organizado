//package sc.vsu.putinpa;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class entry_10078458 {
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

        List<List<Integer>> cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cities.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;

            cities.get(a).add(b);
            cities.get(b).add(a);
        }

        var visited = new int[n];
        var from = new int[n];
        Arrays.fill(from, -1);
        List<Integer> order = new ArrayList<>();
        for (int i = 0; order.isEmpty() && i < n; i++) {
            if (visited[i] == 0) {
                dfs(cities, i, visited, from, order);
            }
        }

        if (!order.isEmpty()) {
            var result = order.stream().map(i -> String.valueOf(i + 1)).collect(Collectors.joining(" "));
            out.println(order.size());
            out.println(result);
        } else {
            out.println("IMPOSSIBLE");
        }
    }

    public static void dfs(List<List<Integer>> cities, int city, int[] visited, int[] from, List<Integer> order) {
        visited[city] = 1;

        for (int to : cities.get(city)) {
            if (to == from[city]) {
                continue;
            }
            if (visited[to] == 0) {
                from[to] = city;
                dfs(cities, to, visited, from, order);
                if (!order.isEmpty()) {
                    return;
                }
            } else if (visited[to] == 1) {
                from[to] = city;
                makeOrder(to, from, order);
                return;
            }
        }

        visited[city] = 2;
    }

    public static void makeOrder(int lastVertex, int[] from, List<Integer> order) {
        order.add(lastVertex);
        for (int c = from[lastVertex]; c != lastVertex ; c = from[c]) {
            order.add(c);
        }
        order.add(lastVertex);
        Collections.reverse(order);
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