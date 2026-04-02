import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.TreeSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author NMouad21
 */
public class entry_225302 {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Task1671 solver = new Task1671();
    solver.solve(1, in, out);
    out.close();
  }

  static class Task1671 {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();
      int[][][] g = GraphUtils.packDirectedWeighted(in.nextIntMatrix(m, 3), n);

      long[] dist = new long[n + 1];
      Arrays.fill(dist, Constants.INF64);
      dist[1] = 0;

      TreeSet<long[]> pq = new TreeSet<>(
          (x, y) -> x[0] == y[0] ? Long.compare(x[1], y[1]) : Long.compare(x[0], y[0]));
      pq.add(new long[]{dist[1], 1});
      while (!pq.isEmpty()) {
        int u = (int) pq.pollFirst()[1];
        for (int[] edge : g[u]) {
          int v = edge[0];
          int w = edge[1];
          if (dist[v] > dist[u] + w) {
            if (dist[v] < Constants.INF64) {
              pq.remove(new long[]{dist[v], v});
            }
            dist[v] = dist[u] + w;
            pq.add(new long[]{dist[v], v});
          }
        }
      }

      for (int i = 1; i <= n; i++) {
        out.print(dist[i]);
        out.print(' ');
      }
    }

  }

  static final class InputReader {

    private final InputStream stream;
    private final byte[] buf = new byte[1 << 20];
    private int curChar;
    private int numChars;

    public InputReader() {
      this.stream = System.in;
    }

    public InputReader(final InputStream stream) {
      this.stream = stream;
    }

    private final int read() {
      if (this.numChars == -1) {
        throw new UnknownError();
      } else {
        if (this.curChar >= this.numChars) {
          this.curChar = 0;

          try {
            this.numChars = this.stream.read(this.buf);
          } catch (IOException ex) {
            throw new InputMismatchException();
          }

          if (this.numChars <= 0) {
            return -1;
          }
        }

        return this.buf[this.curChar++];
      }
    }

    public final int nextInt() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) { // 45 == '-'
        sgn = -1;
        c = this.read();
      }

      int res = 0;

      while (c >= 48 && c <= 57) { // 48 == '0', 57 == '9'
        res *= 10;
        res += c - 48; // 48 == '0'
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }

      throw new InputMismatchException();
    }

    private static final boolean isSpaceChar(final int c) {
      return c == 32 || c == 10 || c == 13 || c == 9
          || c == -1; // 32 == ' ', 10 == '\n', 13 == '\r', 9 == '\t'
    }

    public final int[][] nextIntMatrix(final int n, final int m) {
      int[][] arr = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          arr[i][j] = nextInt();
        }
      }
      return arr;
    }

  }

  static final class GraphUtils {

    private GraphUtils() {
      throw new RuntimeException("DON'T");
    }

    public static int[][][] packDirectedWeighted(int[][] edges, int n) {
      int[][][] g = new int[n + 1][][];
      int[] size = new int[n + 1];
      for (int[] edge : edges) {
        ++size[edge[0]];
      }
      for (int i = 0; i <= n; i++) {
        g[i] = new int[size[i]][];
      }
      int[] other;
      for (int[] edge : edges) {
        other = new int[edge.length - 1];
        System.arraycopy(edge, 1, other, 0, other.length);
        g[edge[0]][--size[edge[0]]] = other;
      }
      return g;
    }

  }

  static class Constants {

    public static final long INF64 = 0x3f3f3f3f3f3f3f3fL;

  }
}
