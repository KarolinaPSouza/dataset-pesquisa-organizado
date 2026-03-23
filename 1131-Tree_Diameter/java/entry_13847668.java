import java.io.*;
import java.util.*;

public class entry_13847668 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void println(Object object) throws IOException {
            bw.append("" + object).append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static ArrayList<ArrayList<Integer>> adj;

    static int[] bfs(int start) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;
        dist[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    q.add(neighbor);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();

        int n = in.nextInt();
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 1: BFS from node 1
        int[] firstBFS = bfs(1);
        int farthestNode = 1;
        for (int i = 2; i <= n; i++) {
            if (firstBFS[i] > firstBFS[farthestNode]) {
                farthestNode = i;
            }
        }

        // Step 2: BFS from the farthest node
        int[] secondBFS = bfs(farthestNode);
        int diameter = 0;
        for (int i = 1; i <= n; i++) {
            diameter = Math.max(diameter, secondBFS[i]);
        }

        out.println(diameter);
        out.close();
    }
}