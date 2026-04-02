//package Problems.Graph;

import java.util.*;
import java.io.DataInputStream;
import java.io.IOException;

public class entry_12658254 {

    // Custom fast input reader class
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        // Fast method to read next integer
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read(); // Skip whitespace
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        // Fast method to read next long
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        // Read one byte from the buffer
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                bytesRead = din.read(buffer, 0, BUFFER_SIZE);
                bufferPointer = 0;
                if (bytesRead == -1) return -1;
            }
            return buffer[bufferPointer++];
        }

        // Read next word
        public String next() throws IOException {
            byte c = read();
            while (c <= ' ') c = read();
            StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
                c = read();
            } while (c > ' ');
            return sb.toString();
        }
    }

    // Graph variables
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;
    static int cycleStart = -1, cycleEnd = -1;

    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();

        int n = sc.nextInt(); // number of cities (nodes)
        int m = sc.nextInt(); // number of roads (edges)

        // Initialize graph with n+1 nodes (1-indexed)
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];
        parent = new int[n + 1];

        // Read and build the undirected graph
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Perform DFS on each unvisited node
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) break; // Stop if cycle is found
            }
        }

        if (cycleStart == -1) {
            // No cycle found
            System.out.println("IMPOSSIBLE");
        } else {
            // Reconstruct the cycle path using parent array
            List<Integer> path = new ArrayList<>();
            path.add(cycleStart);
            for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
                path.add(v);
            }
            path.add(cycleStart); // Close the cycle
            Collections.reverse(path);

            // Output the cycle path
            System.out.println(path.size());
            for (int city : path) {
                System.out.print(city + " ");
            }
        }
    }

    // DFS to detect cycle in undirected graph
    static boolean dfs(int u, int par) {
        visited[u] = true;
        parent[u] = par;

        for (int v : graph.get(u)) {
            if (v == par) continue; // Skip edge to parent

            if (visited[v]) {
                // Cycle found
                cycleStart = v;
                cycleEnd = u;
                return true;
            }

            if (dfs(v, u)) {
                return true;
            }
        }

        return false;
    }
}