import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class entry_6269834 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int numNodes = Integer.parseInt(line[0]);
        int numEdges = Integer.parseInt(line[1]);
        List<Integer>[] adjacencyList = createAdjacencyList(numNodes);
        addEdgesToAdjacencyList(reader, numEdges, adjacencyList);
        findShortestPath(numNodes, adjacencyList);
    }

    private static List<Integer>[] createAdjacencyList(int numNodes) {
        List<Integer>[] adjacencyList = new ArrayList[numNodes];
        for (int i = 0; i < numNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        return adjacencyList;
    }

    private static void addEdgesToAdjacencyList(BufferedReader reader, int numEdges, List<Integer>[] adjacencyList) throws IOException {
        for (int i = 0; i < numEdges; i++) {
            String[] line = reader.readLine().split(" ");
            int nodeA = Integer.parseInt(line[0]) - 1;
            int nodeB = Integer.parseInt(line[1]) - 1;
            adjacencyList[nodeA].add(nodeB);
            adjacencyList[nodeB].add(nodeA);
        }
    }

    private static void findShortestPath(int numNodes, List<Integer>[] adjacencyList) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        boolean[] visited = new boolean[numNodes];
        visited[0] = true;
        int[] previousNode = new int[numNodes];
        for (int i = 0; i < previousNode.length; i++) {
            previousNode[i] = -1;
        }
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : adjacencyList[currentNode]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    previousNode[neighbor] = currentNode;
                    queue.add(neighbor);
                }
            }
        }
        printShortestPath(numNodes, visited, previousNode);
    }

    private static void printShortestPath(int numNodes, boolean[] visited, int[] previousNode) {
        if (!visited[numNodes - 1]) {
            System.out.println("IMPOSSIBLE");
        } else {
            List<Integer> path = new ArrayList<>();
            for (int i = numNodes - 1; i != -1; i = previousNode[i]) {
                path.add(i);
            }
            System.out.println(path.size());
            for (int i = path.size() - 1; i >= 0; i--) {
                System.out.print((path.get(i) + 1) + " ");
            }
            System.out.println();
        }
    }
}