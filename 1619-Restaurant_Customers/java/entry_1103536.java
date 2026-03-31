import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Objects;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author MaxHeap
 */
public class entry_1103536 {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    RestaurantCustomers solver = new RestaurantCustomers();
    solver.solve(1, in, out);
    out.close();
  }

  static class RestaurantCustomers {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int pt = 0;
      IntPair[] ev = new IntPair[n << 1];

      for (int i = 0; i < n; ++i) {
        ev[pt++] = new IntPair(in.nextInt(), 0);
        ev[pt++] = new IntPair(in.nextInt(), 1);
      }
      Arrays.sort(ev);
      int ans = 1;
      int cur = 0;
      for (int i = 0; i < pt; ++i) {
        if (ev[i].y == 0) {
          ++cur;
        } else {
          --cur;
        }
        ans = Math.max(cur, ans);
      }
      out.println(ans);
    }

  }

  static class IntPair implements Comparable<IntPair> {

    public int x;
    public int y;

    public IntPair(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public IntPair(IntPair that) {
      this.x = that.x;
      this.y = that.y;
    }

    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      IntPair intPair = (IntPair) o;
      return x == intPair.x &&
          y == intPair.y;
    }

    public int hashCode() {
      return Objects.hash(x, y);
    }

    public String toString() {
      return "IntPair{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }

    public int compareTo(IntPair o) {
      int c = Integer.compare(x, o.x);
      if (c == 0) {
        return Integer.compare(y, o.y);
      }
      return c;
    }

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
