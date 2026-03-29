import java.io.*;
import java.util.*;

public class entry_13782067 {
    private static final long INF = Long.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            long weight = Long.parseLong(tokenizer.nextToken());
            edges.add(new Edge(from, to, weight));
        }

        long[] distances = new long[n + 1];
        Arrays.fill(distances, INF);
        distances[1] = 0;

        int[] parents = new int[n + 1];
        Arrays.fill(parents, -1);

        int cycleStart = -1;
        for (int i = 1; i <= n; i++) {
            cycleStart = -1;
            for (Edge edge : edges) {
                if (distances[edge.u] + edge.w < distances[edge.v]) {
                    distances[edge.v] = distances[edge.u] + edge.w;
                    parents[edge.v] = edge.u;
                    if (i == n) {
                        cycleStart = edge.v;
                    }
                }
            }
        }

        if (cycleStart == -1) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < n; i++) {
                cycleStart = parents[cycleStart];
            }

            List<Integer> cycle = new ArrayList<>();
            int current = cycleStart;
            do {
                cycle.add(current);
                current = parents[current];
            } while (current != cycleStart);
            cycle.add(cycleStart);
            Collections.reverse(cycle);

            System.out.println("YES");
            for (int node : cycle) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    private static class Edge {
        int u, v;
        long w;

        Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}