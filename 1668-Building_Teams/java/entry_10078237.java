//package sc.vsu.putinpa;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class entry_10078237 {
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

        List<List<Integer>> friendship = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            friendship.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;

            friendship.get(a).add(b);
            friendship.get(b).add(a);
        }

        int[] visited = new int[n];
        var result = true;
        for (int i = 0; result && i < n; i++) {
            if (visited[i] == 0) {
                result &= canDivide(friendship, i, visited, 1);
            }
        }
        if (result) {
            var output = Arrays.stream(visited).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            out.println(output);
        } else {
            out.println("IMPOSSIBLE");
        }
    }

    public static boolean canDivide(List<List<Integer>> friendship, int pupil, int[] visited, int color) {
        visited[pupil] = color;

        for (int to : friendship.get(pupil)) {
            if (visited[to] == 0) {
                if (!canDivide(friendship, to, visited, 3 - color)) {
                    return false;
                }
            } else if (color == visited[to]) {
                return false;
            }
        }

        return true;
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