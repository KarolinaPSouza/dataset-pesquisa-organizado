import java.util.*;
import java.io.*;

public class entry_9703593 {
    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);

        int n = io.getInt();
        int m = io.getInt();
        int[] ds = new int[n + 1];
        int[] ds_card = new int[n + 1];
        @SuppressWarnings("unchecked")
        Set<Integer>[] adj = (HashSet<Integer>[]) new HashSet[n + 1];
        for (int i = 1; i <= n; i++) {
            ds[i] = i;
            ds_card[i] = 1;
            adj[i] = new HashSet<>();
        }
        int a = -1; int b = -1;
        for (int i = 1; i <= m; i++) {
            int u = io.getInt(); int v = io.getInt();
            if (a != -1) continue;
            if (a == -1 && find(ds, u) == find(ds, v)) {
                a = u; b = v;
            }
            union(ds, ds_card, u, v);
            if (a == u && b == v) continue;
            adj[u].add(v); adj[v].add(u);
        }
        if (a == -1 && b == -1) {
            io.println("IMPOSSIBLE");
        } else {
            boolean[] visited = new boolean[n + 1];
            visited[a] = true;
            LinkedList<Integer> path = new LinkedList<>(List.of(a));
            dfs(path, adj, visited, b);
            io.println(path.size() + 1);
            for (int v : path) {
                io.print(v); io.print(' ');
            }
            io.print(a);
            io.println();
        }
        io.flush();
        io.close();
    }

    public static boolean dfs(LinkedList<Integer> path, Set<Integer>[] adj, boolean[] visited, int end) {
        int u = path.getLast();
        if (u == end) return true;
        for (int v : adj[u]) {
            if (visited[v]) continue; else visited[v] = true;
            path.addLast(v);
            if (dfs(path, adj, visited, end)) return true;
            path.removeLast();
        }
        return false;
    }

    public static int find(int[] ds, int a) {
        if (ds[a] == a) return a;
        return ds[a] = find(ds, ds[a]);
    }

    public static void union(int[] ds, int[] ds_card, int a, int b) {
        a = find(ds, a);
        b = find(ds, b);
        if (ds_card[a] < ds_card[b]) {
            int temp =a; a = b; b = temp;
        }
        ds[b] = a;
        ds_card[a] += ds_card[b];
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
