import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author dauom
 */
public class entry_1305153 {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Task1132 solver = new Task1132();
    solver.solve(1, in, out);
    out.close();
  }

  static class Task1132 {
    private int n;
    private int[][] g;
    private int[] dp1;
    private int[] dp2;
    private int[] mxdp;
    private int[] ans;
    private int[] par;

    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      n = in.nextInt();
      g = GraphUtils.packUndirectedUnweighted(in.nextIntMatrix(n - 1, 2), n);
      dp1 = new int[n + 1];
      dp2 = new int[n + 1];
      mxdp = new int[n + 1];
      par = new int[n + 1];
      ans = new int[n + 1];
      solve();
      for (int u = 1; u <= n; u++) {
        out.print(ans[u]);
        out.print(" ");
      }
    }

    private void solve() {
      int[] queue = new int[n];
      queue[0] = par[1] = 1;
      for (int addPt = 1, pollPt = 0; pollPt < addPt; pollPt++) {
        int u = queue[pollPt];
        for (int v : g[u]) {
          if (par[v] == 0) {
            queue[addPt++] = v;
            par[v] = u;
          }
        }
      }
      ArrayReverser.reverse(queue);
      for (int u : queue) {
        for (int v : g[u]) {
          if (v != par[u]) {
            if (dp1[v] + 1 >= dp1[u]) {
              dp2[u] = dp1[u];
              dp1[u] = dp1[v] + 1;
              mxdp[u] = v;
            } else if (dp1[v] + 1 >= dp2[u]) {
              dp2[u] = dp1[v] + 1;
            }
            ans[u] = Math.max(ans[u], dp1[u]);
          }
        }
      }
      int[][] pqueue = new int[n][2];
      pqueue[0][0] = 1;
      for (int addPt = 1, pollPt = 0; pollPt < addPt; pollPt++) {
        int u = pqueue[pollPt][0];
        int maxd = pqueue[pollPt][1];
        ans[u] = Math.max(ans[u], maxd);
        for (int v : g[u]) {
          if (v != par[u]) {
            if (v == mxdp[u]) {
              pqueue[addPt][1] = Math.max(maxd, dp2[u]) + 1;
            } else {
              pqueue[addPt][1] = Math.max(maxd, dp1[u]) + 1;
            }
            pqueue[addPt++][0] = v;
          }
        }
      }
    }
  }

  static final class GraphUtils {
    private GraphUtils() {
      throw new RuntimeException("DON'T");
    }

    public static final int[][] packUndirectedUnweighted(int[][] edges, int n) {
      int[][] g = new int[n + 1][];
      int[] size = new int[n + 1];
      for (int[] edge : edges) {
        ++size[edge[0]];
        ++size[edge[1]];
      }
      for (int i = 0; i <= n; i++) {
        g[i] = new int[size[i]];
      }
      for (int[] edge : edges) {
        g[edge[0]][--size[edge[0]]] = edge[1];
        g[edge[1]][--size[edge[1]]] = edge[0];
      }
      return g;
    }
  }

  static final class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[1 << 21];
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
      for (c = this.read(); isSpaceChar(c); c = this.read()) {}

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

  static class ArrayReverser {
    private ArrayReverser() {
      throw new RuntimeException("DON'T");
    }

    public static void reverse(int[] arr, int from, int to) {
      while (from < to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
        ++from;
        --to;
      }
    }

    public static void reverse(int[] arr) {
      reverse(arr, 0, arr.length - 1);
    }
  }
}