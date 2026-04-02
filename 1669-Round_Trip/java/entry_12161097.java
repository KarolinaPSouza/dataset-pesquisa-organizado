import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class entry_12161097 {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] dimensions = reader.readLine().split(" ");
        final int cities = Integer.parseInt(dimensions[0]);
        final int roads = Integer.parseInt(dimensions[1]);

        final List<List<Integer>> graph = new ArrayList<>();
        for (int index = 0; index < cities; ++index) {
            graph.add(new ArrayList<>());
        }

        for (int index = 0; index < roads; ++index) {
            dimensions = reader.readLine().split(" ");
            final int source = Integer.parseInt(dimensions[0]) - 1;
            final int destination = Integer.parseInt(dimensions[1]) - 1;
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        final List<Integer> cycle = solve(graph);
        if (Objects.isNull(cycle)) {
            writer.write("IMPOSSIBLE");
        } else {
            final StringBuilder answer = new StringBuilder();
            answer.append(cycle.size()).append("\n");

            for (final int element : cycle) {
                answer.append(element + 1).append(" ");
            }

            writer.write(answer.toString());
        }

        reader.close();
        writer.close();
    }

    private static List<Integer> solve(final List<List<Integer>> graph) {
        final int nodes = graph.size();
        final boolean[] visited = new boolean[nodes];
        final int[] parent = new int[nodes];

        for (int node = 0; node < nodes; ++node) {
            if (!visited[node]) {
                final List<Integer> cycle = depthFirstSearch(graph, visited, parent, node);

                if (Objects.nonNull(cycle)) {
                    return cycle;
                }
            }
        }

        return null;
    }

    private static List<Integer> depthFirstSearch(
            final List<List<Integer>> graph,
            final boolean[] visited,
            final int[] parent,
            final int startNode
    ) {
        final Stack<Integer> dfsStack = new Stack<>();
        dfsStack.add(startNode);

        while (!dfsStack.isEmpty()) {
            final int currentNode = dfsStack.pop();
            visited[currentNode] = true;

            for (final int nextNode : graph.get(currentNode)) {
                if (!visited[nextNode]) {
                    parent[nextNode] = currentNode;
                    dfsStack.add(nextNode);
                } else if (nextNode != parent[currentNode]) {
                    return constructCycle(currentNode, nextNode, parent);
                }
            }
        }

        return null;
    }

    private static List<Integer> constructCycle(final int startNode, final int endNode, final int[] parent) {
        final List<Integer> answer = new ArrayList<>();
        for (int node = startNode; node != endNode; node = parent[node]) {
            answer.add(node);
        }
        answer.add(endNode);
        answer.add(startNode);
        return answer;
    }
}