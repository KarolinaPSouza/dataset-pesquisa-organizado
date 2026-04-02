import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_13359710 {
    public static void main(String[] args) throws IOException {
        final IOHandler ioHandler = new IOHandler();
        final int computers = Integer.parseInt(ioHandler.read());
        final int connections = Integer.parseInt(ioHandler.read());
        final List<List<Integer>> graph = new ArrayList<>();
        for (int computer = 0; computer < computers; ++computer) {
            graph.add(new ArrayList<>());
        }
        for (int connection = 0; connection < connections; ++connection) {
            final int source = Integer.parseInt(ioHandler.read()) - 1;
            final int destination = Integer.parseInt(ioHandler.read()) - 1;
            graph.get(source).add(destination);
            graph.get(destination).add(source);
        }

        final List<Integer> path = findShortestPath(graph, 0);
        if (Objects.isNull(path)) {
            ioHandler.write("IMPOSSIBLE\n");
        } else {
            ioHandler.write(path.size() + "\n");
            for (final int element : path) {
                ioHandler.write(element + " ");
            }
            ioHandler.write("\n");
        }
        ioHandler.close();
    }

    private static List<Integer> findShortestPath(final List<List<Integer>> graph, final int source) {
        final Queue<Integer> bfsQueue = new ArrayDeque<>();
        final int[] previousNode = new int[graph.size()];
        final boolean[] visited = new boolean[graph.size()];

        bfsQueue.offer(source);
        visited[source] = true;

        while (!bfsQueue.isEmpty()) {
            final int currentNode = bfsQueue.poll();

            for (final int nextNode : graph.get(currentNode)) {
                if (!visited[nextNode]) {
                    bfsQueue.offer(nextNode);
                    visited[nextNode] = true;
                    previousNode[nextNode] = currentNode;
                }
            }
        }

        if (!visited[graph.size() - 1]) return null;
        final List<Integer> result = new ArrayList<>();
        int currentNode = graph.size() - 1;
        while (currentNode != 0) {
            result.add(currentNode + 1);
            currentNode = previousNode[currentNode];
        }

        result.add(1);
        Collections.reverse(result);
        return result;
    }

    private static final class IOHandler implements Closeable {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        private StringTokenizer tokenizer;

        public String read() throws IOException {
            while (Objects.isNull(tokenizer) || !tokenizer.hasMoreElements()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }

            return tokenizer.nextToken();
        }

        public void write(final String output) throws IOException {
            writer.write(output);
        }

        @Override
        public void close() throws IOException {
            writer.flush();
            writer.close();
            reader.close();
        }
    }
}