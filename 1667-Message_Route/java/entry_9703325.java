import java.util.*;
import java.io.*;

public class entry_9703325 {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt(); int m = io.getInt();
        @SuppressWarnings("unchecked")
        Set<Integer>[] adj = (HashSet<Integer>[]) new HashSet[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int u = io.getInt(); int v = io.getInt();
            adj[u].add(v); adj[v].add(u);
        }

        int[] prev = dijkstra(1, adj);
        if (prev[n] == n) {
            io.println("IMPOSSIBLE");
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(n);
            while (stack.peek() != 1) {
                stack.push(prev[stack.peek()]);
            }
            io.println(stack.size());
            int u = stack.pop();
            io.print(u);
            while (!stack.isEmpty()) {
                int v = stack.pop();
                io.print(' ');
                io.print(v);
                u = v;
            }
            io.println();
        }

        io.flush();
        io.close();
    }

    public static int[] dijkstra(int start, Set<Integer>[] adj) {
        int[] dist = new int[adj.length];
        int[] prev = new int[adj.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = i;
        }
        dist[start] = 0;
        boolean[] visited = new boolean[adj.length];
        Queue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt((int[] arr) -> arr[1]));
        pq.offer(new int[] { start, 0 });
        while (!pq.isEmpty()) {
            int u = pq.poll()[0];
            if (visited[u]) continue; else visited[u] = true;
            for (int v : adj[u]) {
                if (dist[u] + 1 < dist[v]) {
                    dist[v] = dist[u] + 1;
                    prev[v] = u;
                    pq.offer(new int[] { v, dist[v] });
                }
            }
        }
        return prev;
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) {
            }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
