import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

public class entry_12068016 {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        final String[] dimensions = reader.readLine().split(" ");
        final int pupils = Integer.parseInt(dimensions[0]), friendships = Integer.parseInt(dimensions[1]);

        final List<List<Integer>> graph = new ArrayList<>();
        for (int index = 0; index < pupils; ++index) {
            graph.add(new ArrayList<>());
        }

        for (int index = 0; index < friendships; ++index) {
            final String[] connection = reader.readLine().split(" ");
            final int source = Integer.parseInt(connection[0]) - 1;
            final int destination = Integer.parseInt(connection[1]) - 1;
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        final List<Integer> colors = solve(graph, pupils);
        if (Objects.isNull(colors)) {
            writer.write("IMPOSSIBLE");
        } else {
            final StringBuilder answer = new StringBuilder();

            for (final int color : colors) {
                answer.append(color).append(" ");
            }

            writer.write(answer.toString());
        }

        reader.close();
        writer.close();
    }

    private static List<Integer> solve(final List<List<Integer>> graph, final int nodes) {
        final int[] colors = new int[nodes];
        for (int node = 0; node < nodes; ++node) {
            if (colors[node] == 0) {
                final Queue<List<Integer>> bfsQueue = new ArrayDeque<>();
                bfsQueue.add(List.of(node, 1));
                colors[node] = 1;

                while (!bfsQueue.isEmpty()) {
                    final int currentNode = bfsQueue.peek().get(0);
                    final int currentColor = bfsQueue.peek().get(1);
                    bfsQueue.poll();

                    for (final int nextNode : graph.get(currentNode)) {
                        if (colors[nextNode] == currentColor) {
                            return null;
                        } else if (colors[nextNode] == 0) {
                            colors[nextNode] = currentColor == 1 ? 2 : 1;
                            bfsQueue.add(List.of(nextNode, colors[nextNode]));
                        }
                    }
                }
            }
        }

        return Arrays.stream(colors).boxed().collect(Collectors.toList());
    }
}