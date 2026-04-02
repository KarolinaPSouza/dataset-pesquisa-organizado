import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author dauom
 */
public class entry_1297253 {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Task1639 solver = new Task1639();
    solver.solve(1, in, out);
    out.close();
  }

  static class Task1639 {
    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      char[] source = in.nextCharArray();
      char[] target = in.nextCharArray();

      int[][] dp = new int[source.length + 1][target.length + 1];
      for (int i = 0; i <= target.length; i++) {
        dp[source.length][i] = target.length - i;
      }
      for (int i = 0; i <= source.length; i++) {
        dp[i][target.length] = source.length - i;
      }

      for (int i = source.length - 1; i >= 0; i--) {
        for (int j = target.length - 1; j >= 0; j--) {
          if (source[i] == target[j]) {
            dp[i][j] = dp[i + 1][j + 1];
          } else {
            dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1])) + 1;
          }
        }
      }

      out.println(dp[0][0]);
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

    public final String next() {
      int c;
      while (isSpaceChar(c = this.read())) {}

      StringBuilder result = new StringBuilder();
      result.appendCodePoint(c);

      while (!isSpaceChar(c = this.read())) {
        result.appendCodePoint(c);
      }

      return result.toString();
    }

    private static final boolean isSpaceChar(final int c) {
      return c == 32 || c == 10 || c == 13 || c == 9
          || c == -1; // 32 == ' ', 10 == '\n', 13 == '\r', 9 == '\t'
    }

    public final char[] nextCharArray() {
      return next().toCharArray();
    }
  }
}