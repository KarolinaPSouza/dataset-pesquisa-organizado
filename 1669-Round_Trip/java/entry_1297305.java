import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author dauom
 */
public class entry_1297305 {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Task1669 solver = new Task1669();
    solver.solve(1, in, out);
    out.close();
  }

  static class Task1669 {
    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();
      int[][] g = GraphUtils.packUndirectedUnweighted(in.nextIntMatrix(m, 2), n);

      int[] par = new int[n + 1];
      int[] vis = new int[n + 1];
      ArrayList<Integer> ans = new ArrayList<>();
      Task1669.Dfs dfs =
          new Task1669.Dfs() {
            public void go(int u, int p) {
              vis[u] = 1;
              for (int v : g[u]) {
                if (v == p) {
                  continue;
                }

                if (vis[v] == 0) {
                  par[v] = u;
                  go(v, u);
                } else if (vis[v] == 1) {
                  ans.add(v);
                  while (u != v) {
                    ans.add(u);
                    u = par[u];
                  }
                  ans.add(v);
                  Collections.reverse(ans);
                }

                if (!ans.isEmpty()) {
                  return;
                }
              }
              vis[u] = 2;
            }
          };

      for (int i = 1; i <= n && ans.isEmpty(); i++) {
        if (vis[i] == 0) {
          dfs.go(i, 0);
        }
      }

      if (ans.isEmpty()) {
        out.println("IMPOSSIBLE");
        return;
      }

      out.println(ans.size());
      for (int u : ans) {
        out.print(u);
        out.print(" ");
      }
    }

    private interface Dfs {
      void go(int u, int p);
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
    private final byte[] buf = new byte[1 << 16];
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
}