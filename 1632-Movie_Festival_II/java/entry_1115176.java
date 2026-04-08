import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author dauom
 */
public class entry_1115176 {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Task1632 solver = new Task1632();
    solver.solve(1, in, out);
    out.close();
  }

  static class Task1632 {
    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int k = in.nextInt();
      int[][] m = new int[n][];
      for (int i = 0; i < n; i++) {
        m[i] = new int[] {in.nextInt(), in.nextInt(), i};
      }
      Arrays.sort(m, Comparators.singletonIntArr1);
      TreeSet<int[]> ms = new TreeSet<>(Comparators.pairIntArr);
      int ans = 0, e, i;
      int[] floorX = new int[] {0, 0};
      for (int[] movie : m) {
        floorX[0] = movie[0];
        e = movie[1];
        i = movie[2];
        int[] rem = ms.floor(floorX);
        if (rem != null) {
          ms.remove(rem);
        }
        if (ms.size() < k) {
          ms.add(new int[] {e, i});
          ++ans;
        }
      }

      out.println(ans);
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
  }

  static final class Comparators {
    public static final Comparator<int[]> singletonIntArr1 = (x, y) -> compare(x[1], y[1]);
    public static final Comparator<int[]> pairIntArr =
        (x, y) -> x[0] == y[0] ? compare(x[1], y[1]) : compare(x[0], y[0]);

    private static final int compare(final int x, final int y) {
      return x < y ? -1 : (x == y ? 0 : 1);
    }
  }
}