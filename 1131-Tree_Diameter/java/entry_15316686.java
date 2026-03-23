// Save as entry_15316686.java
import java.io.*;
import java.util.*;

public class entry_15316686 {
    static int n;
    static ArrayList<Integer>[] adj;

    static int bfsFarthest(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        dist[start] = 0;
        int far = start;
        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    dq.add(v);
                    if (dist[v] > dist[far]) far = v;
                }
            }
        }
        return far;
    }

    static int bfsDist(int start, int node) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        dist[start] = 0;
        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    dq.add(v);
                }
            }
        }
        return dist[node];
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        n = fs.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        int u = bfsFarthest(1);
        int v = bfsFarthest(u);
        // compute distance between u and v by bfs from u
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(u);
        dist[u] = 0;
        while (!dq.isEmpty()) {
            int cur = dq.poll();
            for (int nei : adj[cur]) {
                if (dist[nei] == -1) {
                    dist[nei] = dist[cur] + 1;
                    dq.add(nei);
                }
            }
        }
        System.out.println(dist[v]);
    }

    // Fast scanner
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        String next() throws IOException {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
    }
}