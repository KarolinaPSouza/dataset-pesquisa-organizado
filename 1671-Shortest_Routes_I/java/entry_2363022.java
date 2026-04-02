import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ethan55
 */
public class entry_2363022 {
  public static void main(String[] args) {
    TestRunner.run();
  }

  public static class TestCase {
    static final boolean MULTIPLE = false;

    public void solve(InputReader in, OutputWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();
      WeightedGraph<Integer> g = new WeightedGraph<>(true);
      for (int i = 1; i <= n; i++) {
        g.addNode(i);
      }
      for (int i = 0; i < m; i++) {
        g.addEdge(in.nextInt(), in.nextInt(), in.nextLong());
      }
      Map<Integer, Long> result = WeightedGraphTraversal.dijkstra(g, 1);
      for (int i = 1; i <= n; i++) {
        out.println(result.get(i));
      }
    }
  }

  public static class TestRunner {

    public static void run() {
      InputReader in = new InputReader(System.in);
      try (OutputWriter out = new OutputWriter(System.out)) {
        int testCases = TestCase.MULTIPLE ? in.nextInt() : 1;
        for (int i = 1; i <= testCases; i++) {
          new TestCase().solve(in, out);
        }
      }
    }

  }

  public static class WeightedGraph<T> {
    private final boolean isDirected;
    private final Map<T, List<Edge<T>>> nodes = new HashMap<>();

    public WeightedGraph(boolean isDirected) {
      this.isDirected = isDirected;
    }

    public void addNode(T node) {
      nodes.putIfAbsent(node, new LinkedList<>());
    }

    public void addEdge(T from, T to, Long weight) {
      nodes.get(from).add(new Edge<>(to, weight));
      if (!isDirected) {
        nodes.get(to).add(new Edge<>(from, weight));
      }
    }

    public List<Edge<T>> getEdges(T from) {
      return nodes.get(from);
    }
  }

  public static class Edge<T> {
    public T to;
    public Long weight;

    public Edge(T to, Long weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  public static class Node<T> {
    public T value;
    public long cost;

    public Node(T value, long cost) {
      this.value = value;
      this.cost = cost;
    }
  }

  public static class OutputWriter implements AutoCloseable {
    private static final int BUFFER_SIZE = 1 << 13;
    private final byte[] outputBuffer = new byte[BUFFER_SIZE];
    private final OutputStream outputStream;
    private int outputBufferIndex = 0;

    public OutputWriter(OutputStream os) {
      this.outputStream = os;
    }

    public OutputWriter println(Object o) {
      return writeln(Objects.toString(o));
    }

    public void flush() {
      innerFlush();
      try {
        outputStream.flush();
      } catch (IOException e) {
        throw new IllegalStateException("Failed to flush");
      }
    }

    private OutputWriter write(byte b) {
      outputBuffer[outputBufferIndex++] = b;
      if (outputBufferIndex == BUFFER_SIZE) {
        innerFlush();
      }
      return this;
    }

    private OutputWriter write(String s) {
      s.chars()
          .forEach(
              c -> {
                outputBuffer[outputBufferIndex++] = (byte) c;
                if (outputBufferIndex == BUFFER_SIZE) {
                  innerFlush();
                }
              });
      return this;
    }

    private OutputWriter writeln() {
      return write((byte) '\n');
    }

    private OutputWriter writeln(String s) {
      return write(s).writeln();
    }

    private void innerFlush() {
      try {
        outputStream.write(outputBuffer, 0, outputBufferIndex);
        outputBufferIndex = 0;
      } catch (IOException e) {
        throw new IllegalStateException("Failed to inner flush");
      }
    }

    @Override
    public void close() {
      flush();
    }
  }

  public static class InputReader {
    private final InputStream inputStream;
    private final byte[] inputBuffer = new byte[1024];
    private int bytesRead = 0;
    private int inputBufferIndex = 0;

    public InputReader(InputStream inputStream) {
      this.inputStream = inputStream;
    }

    private int readByte() {
      if (bytesRead == -1) {
        throw new InputMismatchException();
      }
      if (inputBufferIndex >= bytesRead) {
        inputBufferIndex = 0;
        try {
          bytesRead = inputStream.read(inputBuffer);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (bytesRead <= 0) {
          return -1;
        }
      }
      return inputBuffer[inputBufferIndex++];
    }

    public int nextInt() {
      return (int) nextLong();
    }

    public long nextLong() {
      long num = 0;
      int b;
      boolean minus = false;
      do {
        b = readByte();
      } while (b != -1 && !((b >= '0' && b <= '9') || b == '-'));
      if (b == '-') {
        minus = true;
        b = readByte();
      }

      while (true) {
        if (b >= '0' && b <= '9') {
          num = num * 10 + (b - '0');
        } else {
          return minus ? -num : num;
        }
        b = readByte();
      }
    }

  }

  public static class WeightedGraphTraversal {
    public static <T> Map<T, Long> dijkstra(WeightedGraph<T> graph, T from) {
      Map<T, Long> costs = new HashMap<>();
      costs.put(from, 0L);
      Queue<Node<T>> queue = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
      queue.add(new Node<>(from, 0L));
      while (!queue.isEmpty()) {
        Node<T> curr = queue.poll();
        if (costs.getOrDefault(curr.value, Long.MAX_VALUE) < curr.cost) {
          continue;
        }
        for (Edge<T> edge : graph.getEdges(curr.value)) {
          long newCost = curr.cost + edge.weight;
          if (newCost < costs.getOrDefault(edge.to, Long.MAX_VALUE)) {
            costs.put(edge.to, newCost);
            queue.add(new Node<>(edge.to, newCost));
          }
        }
      }
      return costs;
    }

  }
}