import java.util.*;
import java.io.*;

/**
 * Made by egor https://github.com/chermehdi/egor.
 * 
 * @author Azuz
 * 
 */
public class entry_1119242 {

    void solve(InputReader in, PrintWriter out) {
      int n = in.nextInt();
      long target = in.nextInt();
      Pair[] arr = new Pair[n];
      for (int i = 0; i < n; ++i) {
        arr[i] = new Pair(i+1, in.nextLong());
      } Arrays.sort(arr);

      int x = 0, y = 0, z = 0, t = 0;
      for (int i = 0; i < n && x <= 0; ++i)
      for (int j = i + 1; j < n && x <= 0; ++j) {
        int l = j + 1;
        int r = n - 1;

        while (l < r) {

          long sum = arr[l].value + arr[r].value + arr[i].value + arr[j].value;
          if (sum == target) {
            x = arr[i].idx;
            y = arr[j].idx;
            z = arr[l].idx; 
            t = arr[r].idx;

            break;
          } else if (sum < target) {
            ++l;
          } else {
            --r;
          }
        }
      }

      if (x <= 0) {
        out.println("IMPOSSIBLE");
      } else {
        out.println(x + " " + y + " " + z + " " +t) ;
      }

    }

    public static void main(String[] args) {
      InputReader in = new InputReader(System.in);
      PrintWriter out = new PrintWriter(System.out);
      new entry_1119242().solve(in, out);
      out.close();
    }

    static class Pair implements Comparable<Pair> {
      int idx; long value;

      public Pair(int idx, long value) {
        this.value = value;
        this.idx = idx;
      }

      @Override
      public int compareTo(Pair p) {
        return Long.compare(this.value, p.value);
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

    public long nextLong() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {
      }

      byte sgn = 1;
      if (c == 45) {
        sgn = -1;
        c = this.read();
      }

      long res = 0;

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