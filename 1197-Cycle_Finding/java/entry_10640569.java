// package W3.CSES;

import java.util.*;

public class entry_10640569 {
    static class GraphEdge {
        int from, to, cost;

        GraphEdge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long MAX_VALUE = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nodeCount = scanner.nextInt(); // number of nodes
        int edgeCount = scanner.nextInt(); // number of edges

        List<GraphEdge> graphEdges = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int weight = scanner.nextInt();
            graphEdges.add(new GraphEdge(u, v, weight));
        }

        long[] distances = new long[nodeCount + 1];
        Arrays.fill(distances, MAX_VALUE);
        int[] predecessors = new int[nodeCount + 1];
        Arrays.fill(predecessors, -1);

        int lastUpdatedNode = -1;

        // Bellman-Ford Algorithm
        for (int startNode = 1; startNode <= nodeCount; startNode++) {
            distances[startNode] = 0;

            for (int iteration = 0; iteration < nodeCount; iteration++) {
                boolean updated = false;
                lastUpdatedNode = -1;

                for (GraphEdge edge : graphEdges) {
                    if (distances[edge.from] != MAX_VALUE && distances[edge.from] + edge.cost < distances[edge.to]) {
                        distances[edge.to] = distances[edge.from] + edge.cost;
                        predecessors[edge.to] = edge.from;
                        lastUpdatedNode = edge.to;
                        updated = true;
                    }
                }
                if (!updated) break; // No updates mean no negative cycle
            }

            if (lastUpdatedNode != -1) break; // Found a node that was updated
        }

        if (lastUpdatedNode == -1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            int cycleStartNode = lastUpdatedNode;
            for (int i = 0; i < nodeCount; i++) {
                cycleStartNode = predecessors[cycleStartNode]; // Backtrack to find cycle start
            }

            List<Integer> cycleNodes = new ArrayList<>();
            for (int currentNode = cycleStartNode; ; currentNode = predecessors[currentNode]) {
                cycleNodes.add(currentNode);
                if (currentNode == cycleStartNode && cycleNodes.size() > 1) break; // Cycle is complete
            }
            Collections.reverse(cycleNodes); // Reverse to print in the correct order
            for (int node : cycleNodes) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}