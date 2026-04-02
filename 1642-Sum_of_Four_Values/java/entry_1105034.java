import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author MaxHeap
 */
public class entry_1105034 {

  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    SumOfFourValues solver = new SumOfFourValues();
    solver.solve(1, in, out);
    out.close();
  }

  static class SumOfFourValues {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
      int n = in.nextInt(), k = in.nextInt();
      int[] a = in.nextIntArray(n);
      SumOfFourValues.Tuple[] sums = new SumOfFourValues.Tuple[(n * (n - 1)) >> 1];
      int pt = 0;
      for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
          int sum = a[i] + a[j];
          sums[pt++] = new SumOfFourValues.Tuple(i + 1, j + 1, sum);
        }
      }
      HashMap<Integer, List<Integer>> m = new HashMap<>();
      for (int i = 0; i < sums.length; ++i) {
        SumOfFourValues.Tuple was = sums[i];
        int need = k - was.z;
        List<Integer> values = m.computeIfAbsent(need, v -> new ArrayList<>());
        for (int v : values) {
          if (isCompatible(sums[v], was)) {
            out.println(sums[v].x + " " + sums[v].y + " " + was.x + " " + was.y);
            return;
          }
        }
        List<Integer> that = m.computeIfAbsent(was.z, v -> new ArrayList<>());
        that.add(i);
      }
      out.println("IMPOSSIBLE");
    }

    private boolean isCompatible(SumOfFourValues.Tuple b, SumOfFourValues.Tuple a) {
      if (a.x == b.x || a.x == b.y) {
        return false;
      }
      if (a.y == b.x || a.y == b.y) {
        return false;
      }
      return true;
    }

    static class Tuple {

      int x;
      int y;
      int z;

      public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
      }

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

    public int[] nextIntArray(int n) {
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = nextInt();
      }
      return arr;
    }

  }
}
