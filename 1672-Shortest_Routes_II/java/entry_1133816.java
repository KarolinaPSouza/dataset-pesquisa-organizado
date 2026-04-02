import java.util.*;
import java.io.*;

/**
 * Made by egor https://github.com/chermehdi/egor.
 * 
 * @author Azuz
 * 
 */
public class entry_1133816 {

    void solve(InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();
      int q = in.nextInt();
      long[][] dist = new long[n + 1][n + 1];
      for (int i = 1; i < n; ++i) {
        for (int j = i + 1; j <= n; ++j) {
          dist[i][j] = dist[j][i] = Long.MAX_VALUE;
        }
      }

      for (int i = 0; i < m; ++i) {
        int u = in.nextInt();
        int v = in.nextInt();
        int c = in.nextInt();

        dist[u][v] = dist[v][u] = Math.min(dist[u][v], c);
      }

      for (int k = 1; k <= n; ++k) {
        for (int i = 1; i <= n; ++i) if (dist[i][k] != Long.MAX_VALUE){
          for (int j = 1; j <= n; ++j) if (dist[k][j] != Long.MAX_VALUE) {
            dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
          }
        }
      }

      for (int i = 0; i < q; ++i) {
        int u = in.nextInt();
        int v = in.nextInt();
        out.println(dist[u][v] == Long.MAX_VALUE ? -1 : dist[u][v]);
      }

    }

    public static void main(String[] args) {
      InputReader in = new InputReader(System.in);
      PrintWriter out = new PrintWriter(System.out);
      new entry_1133816().solve(in, out);
      out.close();
    }


  static class InputReader {

    private InputStream stream;
    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
    private static final int EOF = -1;
    private byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    public int read() {
      if (this.numChars == EOF) {
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
            return EOF;
          }
        }

        return this.buf[this.curChar++];
      }
    }

    public int nextInt() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) {
        sgn = -1;
        c = this.read();
      }

      int res = 0;

      while (c >= 48 && c <= 57) {
        res *= 10;
        res += c - 48;
        c = this.read();
        if (isSpaceChar(c)) {
          return res * sgn;
        }
      }

      throw new InputMismatchException();
    }

    public static boolean isSpaceChar(int c) {
      return c == 32 || c == 10 || c == 13 || c == 9 || c == EOF;
    }

  }
}