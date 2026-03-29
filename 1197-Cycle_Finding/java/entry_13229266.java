import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class entry_13229266 {

    private static final String NO_ANSWER = "NO";
    private static final String YES_ANSWER = "YES";

    public static void main(String[] args) throws Exception {
        final CycleFinding algorithm = createAlgorithm();
        final int[] path = algorithm.execute();

        final String outputResult = createOutputResult(path);
        System.out.println(outputResult);
    }

    private static String createOutputResult(final int[] path) {
        if (path.length == 0) {
            return NO_ANSWER;
        }

        final StringBuilder sb = new StringBuilder(path.length * 5);
        sb.append(YES_ANSWER).append(System.lineSeparator());
        for (int i = path.length - 1; i >= 0; i--) {
            if (path[i] == 0) {
                continue;
            }
            sb.append(path[i]).append(' ');
        }

        return sb.toString();
    }

    private static CycleFinding createAlgorithm() throws Exception {
        try (Reader reader = new Reader()) {
            final int nodesCount = reader.nextInt();
            final int edgesCount = reader.nextInt();

            final CycleFinding.Edge[] edges = new CycleFinding.Edge[edgesCount];
            for (int i = 0; i < edgesCount; i++) {
                edges[i] = new CycleFinding.Edge(reader.nextInt(), reader.nextInt(), reader.nextInt());
            }

            return new CycleFinding(nodesCount, edges);
        }
    }

    private static class CycleFinding {

        private final int nodesCount;
        private final Edge[] edges;

        CycleFinding(int nodesCount, Edge[] edges) {
            this.nodesCount = nodesCount;
            this.edges = edges;
        }

        int[] execute() {

            final long[] distances = new long[this.nodesCount + 1];

            final int[] paths = new int[this.nodesCount + 1];
            Arrays.fill(paths, -1);

            int lastRelaxedNode = -1;
            for (int i = 0; i < this.nodesCount; i++) {

                lastRelaxedNode = -1;
                for (final Edge edge : this.edges) {

                    final long currentWeight = distances[edge.from] + edge.weight;
                    if (distances[edge.to] > currentWeight) {
                        distances[edge.to] = currentWeight;
                        paths[edge.to] = edge.from;
                        lastRelaxedNode = edge.to;
                    }
                }
            }

            if (lastRelaxedNode == -1) {
                return new int[0];
            }

            int startCycleNode = lastRelaxedNode;
            for (int i = 1; i <= this.nodesCount; i++) {
                startCycleNode = paths[startCycleNode];
            }

            final int[] cycle = new int[this.nodesCount + 1];
            int i = 0;
            int cycleNode = startCycleNode;
            do {
                cycle[i] = cycleNode;
                cycleNode = paths[cycleNode];
            } while (++i < cycle.length && cycleNode != startCycleNode);
            cycle[i] = startCycleNode;

            return cycle;
        }

        private static class Edge {

            private final int from;
            private final int to;
            private final int weight;

            private Edge(int from, int to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }
        }
    }

    private static class Reader implements AutoCloseable {

        private static final int BUFFER_SIZE = 1 << 16;

        private final DataInputStream din;
        private final byte[] buffer;

        private int bufferPointer;
        private int bytesRead;

        Reader() {
            this.din = new DataInputStream(System.in);
            this.buffer = new byte[BUFFER_SIZE];
        }

        int nextInt() throws IOException {

            byte c = read();
            while (c <= ' ') {
                c = read();
            }

            final boolean negate = (c == '-');
            if (negate) {
                c = read();
            }

            int result = 0;
            do {
                result = result * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return negate ? -result : result;
        }

        private void fillBuffer() throws IOException {
            this.bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (this.bytesRead == -1) {
                this.buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (this.bufferPointer == this.bytesRead) {
                fillBuffer();
            }

            return this.buffer[this.bufferPointer++];
        }

        @Override
        public void close() throws IOException {
            this.din.close();
        }
    }
}