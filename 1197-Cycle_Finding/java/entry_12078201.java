/*
Time limit: 1.00 s
Memory limit: 512 MB
   You are given a directed graph, and your task is to find out if it contains a negative cycle, and also give an example of such a cycle.
Input
The first input line has two integers n and m: the number of nodes and edges. The nodes are numbered 1,2,\ldots,n.
After this, the input has m lines describing the edges. Each line has three integers a, b, and c: there is an edge from node a to node b whose length is c.
Output
If the graph contains a negative cycle, print first "YES", and then the nodes in the cycle in their correct order. If there are several negative cycles, you can print any of them. If there are no negative cycles, print "NO".
*/

import java.util.*;

public class entry_12078201 {
    static class Edge {
        int u, v;
        long w;

        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            long w = sc.nextLong();
            edges[i] = new Edge(u, v, w);
        }

        // Initialize distances and paths
        long[] dist = new long[n + 1];
        int[] parent = new int[n + 1];
        // Track num relaxations per vertex
        int[] relaxCount = new int[n + 1];

        Arrays.fill(dist, 0);
        Arrays.fill(parent, -1);
        Arrays.fill(relaxCount, 0);

        // Store the vertex where we found a cycle
        int cycleVertex = -1;

        // Run Bellman-Ford
        for (int i = 1; i <= n; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] + edge.w < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.w;
                    parent[edge.v] = edge.u; // fin relaxation
                    relaxCount[edge.v]++;

                    // If relaxed n times, must be negative cycle
                    if (relaxCount[edge.v] >= n) {
                        cycleVertex = edge.v;
                        break;
                    }
                }
            }
            if (cycleVertex != -1) break;
        }

        if (cycleVertex == -1) {
            System.out.println("NO");

        } else {
            int current = cycleVertex;

            // Walk n steps to ensure cycle
            for (int i = 0; i < n; i++) {
                current = parent[current];
            }

            // Collect the cycle in reverse
            List<Integer> cycle = new ArrayList<>();
            int start = current;
            do {
                cycle.add(current);
                current = parent[current];
            } while (current != start);

            // Reverse cycle for correct order
            Collections.reverse(cycle);

            // Find position of 1 or minimum vertex
            int startPos = -1;
            int minPos = 0;
            for (int i = 0; i < cycle.size(); i++) {
                if (cycle.get(i) == 1) {
                    startPos = i;
                    break;
                }
                if (cycle.get(i) < cycle.get(minPos)) {
                    minPos = i;
                }
            }

            if (startPos == -1) {
                startPos = minPos;
            }

            // Print the cycle
            System.out.println("YES");
            int size = cycle.size();

            for (int i = 0; i < size; i++) {
                int idx = (startPos + i) % size;
                System.out.print(cycle.get(idx));

                if (i < size - 1) System.out.print(" ");
            }
            System.out.println(" " + cycle.get(startPos));
        }

        sc.close();
    }
}