import java.io.*;
import java.util.*;

public class entry_15199290 {

    static List<Integer>[] adjList;

    // Helper class to store BFS results
    static class BFSData {
        int farNode;
        int maxDist;
        int[] distArr;
        BFSData(int farNode, int maxDist, int[] distArr) {
            this.farNode = farNode;
            this.maxDist = maxDist;
            this.distArr = distArr;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader(System.in);
        int nodes = fr.nextInt();

        adjList = new ArrayList[nodes + 1];
        for (int i = 1; i <= nodes; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < nodes - 1; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }

        // Step 1: find one end of the diameter (X)
        BFSData firstPass = bfs(1, nodes);
        int nodeX = firstPass.farNode;

        // Step 2: find the opposite end (Y)
        BFSData secondPass = bfs(nodeX, nodes);
        int nodeY = secondPass.farNode;
        int[] distFromX = secondPass.distArr;

        // Step 3: compute distances from Y
        BFSData thirdPass = bfs(nodeY, nodes);
        int[] distFromY = thirdPass.distArr;

        // Step 4: for each node, print max distance from X or Y
        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= nodes; i++) {
            output.append(Math.max(distFromX[i], distFromY[i])).append(" ");
        }
        System.out.println(output.toString().trim());
    }

    // BFS that returns the farthest node, distance, and all distances
    static BFSData bfs(int startNode, int totalNodes) {
        int[] distance = new int[totalNodes + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startNode);
        distance[startNode] = 0;

        int farthest = startNode;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adjList[current]) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[current] + 1;
                    queue.add(neighbor);
                    if (distance[neighbor] > distance[farthest]) {
                        farthest = neighbor;
                    }
                }
            }
        }

        return new BFSData(farthest, distance[farthest], distance);
    }

    // Fast input for large datasets
    static class FastReader {
        private final byte[] buf = new byte[1 << 16];
        private int idx = 0, size = 0;
        private final InputStream stream;
        FastReader(InputStream stream) { this.stream = stream; }

        private int read() throws IOException {
            if (idx >= size) {
                size = stream.read(buf);
                idx = 0;
                if (size <= 0) return -1;
            }
            return buf[idx++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do c = read(); while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            for (; c > ' '; c = read()) val = val * 10 + (c - '0');
            return val * sign;
        }
    }
}