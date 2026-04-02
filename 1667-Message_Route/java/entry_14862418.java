import java.io.*;
import java.util.*;
import java.util.ArrayList;

class Reader {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
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

class BFS {
    public static void bfsTraversal(int start, ArrayList<ArrayList<Integer>> adj, int[] parent, int[] minWays) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        minWays[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int ways = minWays[node] + 1;

            for (int neighbor : adj.get(node)) {
                if (ways < minWays[neighbor]) {
                    minWays[neighbor] = ways;
                    parent[neighbor] = node;
                    queue.add(neighbor);
                }
            }
        }
    }
}

public class entry_14862418 {
    public static void main(String[] args) {
        Reader.FastReader sc = new Reader.FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) edges.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        int[] minWays = new int[n];
        int[] parent = new int[n];
        Arrays.fill(minWays, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        BFS.bfsTraversal(0, edges, parent, minWays);

        if (minWays[n - 1] == Integer.MAX_VALUE) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(minWays[n - 1] + 1);
            List<Integer> path = new ArrayList<>();
            for (int v = n - 1; v != -1; v = parent[v]) {
                path.add(v);
            }
            Collections.reverse(path);
            for (int x : path) System.out.print((x + 1) + " ");
        }
    }
}