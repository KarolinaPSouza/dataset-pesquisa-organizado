import java.io.*;
import java.util.*;

public class entry_15245257 {
    static int n;
    static int[][] edges;
    static int[] head, next, to;
    static int idx = 0;

    static void addEdge(int a, int b) {
        to[idx] = b;
        next[idx] = head[a];
        head[a] = idx++;
    }

    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;
        int far = start;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int e = head[u]; e != -1; e = next[e]) {
                int v = to[e];
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                    if (dist[v] > dist[far]) far = v;
                }
            }
        }
        return new int[]{far, dist[far]};
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();

        // adjacency using arrays for max speed
        head = new int[n + 1];
        Arrays.fill(head, -1);
        next = new int[2 * (n - 1)];
        to = new int[2 * (n - 1)];

        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            addEdge(a, b);
            addEdge(b, a);
        }

        int[] first = bfs(1);
        int[] second = bfs(first[0]);

        System.out.println(second[1]);
    }

    // ultra-fast scanner
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}