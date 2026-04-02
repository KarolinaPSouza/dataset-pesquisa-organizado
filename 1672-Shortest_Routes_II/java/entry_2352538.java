import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ethan55
 */
public class entry_2352538 {
  public static void main(String[] args) {
    TestRunner.run();
  }

  public static class TestCase {
    static final boolean MULTIPLE = false;

    public void solve(InputReader in, OutputWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();
      int q = in.nextInt();
      WeightedGraph<Integer> g = new WeightedGraph<>(false);
      for (int i = 1; i <= n; i++) {
        g.addNode(i);
      }
      for (int i = 0; i < m; i++) {
        g.addEdge(in.nextInt(), in.nextInt(), in.nextLong());
      }
      long[][] times = WeightedGraphTraversal.floydWarshall(g, n);
      for (int i = 0; i < q; i++) {
        int from = in.nextInt();
        int to = in.nextInt();
        long result = times[from][to];
        if (result == Long.MAX_VALUE / 2) {
          out.println(-1);
        } else {
          out.println(result);
        }
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

  public static class OutputWriter implements AutoCloseable {
    private static final int BUFFER_SIZE = 1 << 13;
    private final byte[] outputBuffer = new byte[BUFFER_SIZE];
    private final OutputStream outputStream;
    private int outputBufferIndex = 0;

    public OutputWriter(OutputStream os) {
      this.outputStream = os;
    }

    public OutputWriter println(int x) {
      return writeln(x);
    }

    public OutputWriter println(long x) {
      return writeln(x);
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

    private OutputWriter write(int x) {
      if (x == Integer.MIN_VALUE) {
        return write((long) x);
      }
      if (outputBufferIndex + 12 >= BUFFER_SIZE) {
        innerFlush();
      }
      if (x < 0) {
        write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = outputBufferIndex + d - 1; i >= outputBufferIndex; i--) {
        outputBuffer[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      outputBufferIndex += d;
      return this;
    }

    private static int countDigits(long l) {
      if (l >= 1000000000000000000L) {
        return 19;
      }
      if (l >= 100000000000000000L) {
        return 18;
      }
      if (l >= 10000000000000000L) {
        return 17;
      }
      if (l >= 1000000000000000L) {
        return 16;
      }
      if (l >= 100000000000000L) {
        return 15;
      }
      if (l >= 10000000000000L) {
        return 14;
      }
      if (l >= 1000000000000L) {
        return 13;
      }
      if (l >= 100000000000L) {
        return 12;
      }
      if (l >= 10000000000L) {
        return 11;
      }
      if (l >= 1000000000L) {
        return 10;
      }
      if (l >= 100000000L) {
        return 9;
      }
      if (l >= 10000000L) {
        return 8;
      }
      if (l >= 1000000L) {
        return 7;
      }
      if (l >= 100000L) {
        return 6;
      }
      if (l >= 10000L) {
        return 5;
      }
      if (l >= 1000L) {
        return 4;
      }
      if (l >= 100L) {
        return 3;
      }
      if (l >= 10L) {
        return 2;
      }
      return 1;
    }

    private OutputWriter write(long x) {
      if (x == Long.MIN_VALUE) {
        return write("" + x);
      }
      if (outputBufferIndex + 21 >= BUFFER_SIZE) {
        innerFlush();
      }
      if (x < 0) {
        write((byte) '-');
        x = -x;
      }
      int d = countDigits(x);
      for (int i = outputBufferIndex + d - 1; i >= outputBufferIndex; i--) {
        outputBuffer[i] = (byte) ('0' + x % 10);
        x /= 10;
      }
      outputBufferIndex += d;
      return this;
    }

    private OutputWriter writeln(int x) {
      return write(x).writeln();
    }

    private OutputWriter writeln(long x) {
      return write(x).writeln();
    }

    private OutputWriter writeln() {
      return write((byte) '\n');
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

  public static class Edge<T> {
    T to;
    Long weight;

    public Edge(T to, Long weight) {
      this.to = to;
      this.weight = weight;
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

    public static long[][] floydWarshall(WeightedGraph<Integer> g, int n) {
      long[][] dist = new long[n + 1][n + 1];
      for (long[] d : dist) {
        Arrays.fill(d, Long.MAX_VALUE / 2);
      }
      for (int i = 1; i <= n; i++) {
        for (Edge<Integer> e : g.getEdges(i)) {
          dist[i][e.to] = Math.min(dist[i][e.to], e.weight);
        }
        dist[i][i] = 0;
      }
      for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= n; j++) {
            if (dist[i][j] > dist[i][k] + dist[k][j]) {
              dist[i][j] = dist[i][k] + dist[k][j];
            }
          }
        }
      }
      return dist;
    }
  }
}