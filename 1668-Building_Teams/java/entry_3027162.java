import java.io.*;
import java.util.*;

public class entry_3027162 {
    private static int N;
    private static int M;
    private static Map<Integer, List<Integer>> graph;
    private static boolean[] color;
    private static boolean[] visited;
    private static boolean isTwoColor;

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, false);
            }
            if (!isTwoColor) {
                break;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (!isTwoColor) {
            bw.write("IMPOSSIBLE");
            bw.flush();
            return;
        }
        for (int i = 1; i < color.length; i++) {
            if (i > 1) {
                bw.write(" ");
            }
            if (color[i]) {
                bw.write(Integer.toString(1));
            } else {
                bw.write(Integer.toString(2));
            }
        }
        bw.flush();
    }

    private static void dfs(int vertex, boolean colour) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        color[vertex] = colour;
        if (!graph.containsKey(vertex)) {
            return;
        }
        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(neighbor, !colour);
            } else if (color[vertex] == color[neighbor]) {
                isTwoColor = false;
                return;
            }
        }
    }

    private static void init() {
        graph = new HashMap<>();
        FastReader reader = new FastReader();
        N = reader.nextInt();
        color = new boolean[N + 1];
        visited = new boolean[N + 1];
        M = reader.nextInt();
        for (int i = 0; i < M; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            if (graph.containsKey(a)) {
                graph.get(a).add(b);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                graph.put(a, list);
            }
            if (graph.containsKey(b)) {
                graph.get(b).add(a);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                graph.put(b, list);
            }
        }
        isTwoColor = true;
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}