import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class entry_941134 {
    static BufferedReader reader;
    static PrintWriter out;

    public static void addEdge(Map<Integer, List<Integer>> graph, int a, int b) {
        if (!graph.containsKey(a)) graph.put(a, new ArrayList<>());
        graph.get(a).add(b);
    }

    public static void solve() throws IOException {
        StringTokenizer line;
        line = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(line.nextToken());
        int m = Integer.parseInt(line.nextToken());
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            line = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());
            addEdge(graph, a, b);
            addEdge(graph, b, a);
        }

        int[] color = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        boolean possible = true;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            color[i] = 1;
            while (!queue.isEmpty()) {
                int x = queue.poll();
                int col = color[x];
                if (visited[x]) continue;
                visited[x] = true;
                if (!graph.containsKey(x)) continue;
                for (int c : graph.get(x)) {
                    if (!visited[c]) {
                        color[c] = 1 - col;
                        queue.add(c);
                    } else {
                        if (color[c] == col) possible = false;
                    }
                }
            }
        }

        if (possible) {
            for (int i = 1; i <= n; i++) out.print((color[i] + 1) + " ");
            out.println();
        } else {
            out.println("IMPOSSIBLE");
        }
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        solve();

        reader.close();
        out.close();
    }
}