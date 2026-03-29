import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_12078851 {

    static class Edge {
        int a, b, c;
        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void findNegativeCycle(int n, int m, Edge[] edges) {
        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
        }

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Edge edge = edges[j];
                if (dist[edge.a] + edge.c < dist[edge.b]) {
                    dist[edge.b] = dist[edge.a] + edge.c;
                    parent[edge.b] = edge.a;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            Edge edge = edges[j];
            if (dist[edge.a] != Long.MAX_VALUE && dist[edge.a] + edge.c < dist[edge.b]) {
                parent[edge.b] = edge.a;
                int[] cycle = new int[n + 1];
                boolean[] visited = new boolean[n+1];
                int x = edge.b;

                int cycleStart = x;
                int cycleIndex = 0;
                visited[x] = true;
                cycle[cycleIndex++] = cycleStart;

                int node = parent[cycleStart];
                while (!visited[node]) {
                    cycle[cycleIndex++] = node;
                    visited[node] = true;
                    node = parent[node];
                }

                cycle[cycleIndex--] = node;

                PrintWriter pw = new PrintWriter(System.out);
                pw.println("YES");
                pw.print(node + " ");
                while (cycle[cycleIndex] != node) {
                    pw.print(cycle[cycleIndex--] + " ");
                }
                pw.print(node);
                pw.close();
                return;
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        findNegativeCycle(n, m, edges);
    }
}