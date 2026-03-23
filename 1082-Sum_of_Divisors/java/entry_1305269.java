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
public class entry_1305269 {
  public static void main(String[] args) {
    InputStream inputStream = System.in;
    OutputStream outputStream = System.out;
    InputReader in = new InputReader(inputStream);
    PrintWriter out = new PrintWriter(outputStream);
    Task1082 solver = new Task1082();
    solver.solve(1, in, out);
    out.close();
  }

  static class Task1082 {
    public final void solve(int testNumber, InputReader in, PrintWriter out) {
      final LongModArithmetic mod = new LongModArithmetic();
      final long inv2 = mod.div(1, 2);
      final long n = in.nextLong();

      long ans = 0;
      long nni = n;
      for (int i = 1; i * (long) i <= n; i++) {
        nni = mod.mod(n / i);
        ans = mod.add(ans, mod.mul(i, nni));
      }
      for (int ni = (int) nni - 1; ni > 0; ni--) {
        long hi = mod.mod(n / ni);
        hi = mod.mul(hi, mod.add(hi, 1));
        long lo = mod.mod(n / (ni + 1) + 1);
        lo = mod.mul(lo, mod.sub(lo, 1));
        ans = mod.add(ans, mod.mul(mod.sub(hi, lo), mod.mul(ni, inv2)));
      }

      out.println(ans);
    }
  }

  static final class LongModArithmetic {
    public static final long DEFAULT_MOD = 1_000_000_007;
    public final long m;
    public final boolean isPrime;

    public LongModArithmetic() {
      this(DEFAULT_MOD, true);
    }

    public LongModArithmetic(long mod) {
      this(mod, false);
    }

    public LongModArithmetic(long mod, boolean isPrime) {
      if (mod <= 0 || mod >= Long.MAX_VALUE / 2) {
        throw new IllegalArgumentException("Modulo must be > 0 and < Long.MAX_VALUE/2");
      }
      this.m = mod;
      this.isPrime = isPrime;
    }

    public final long add(long a, final long b) {
      a += b;
      if (a >= m) {
        a -= m;
      }
      return a;
    }

    public final long sub(long a, final long b) {
      a -= b;
      if (a < 0) {
        a += m;
      }
      return a;
    }

    public final long mul(long a, long b) {
      long res = 0;
      while (b > 0) {
        if ((b & 1) == 1) {
          res += a;
          if (res >= m) {
            res -= m;
          }
        }
        b >>= 1;
        a <<= 1;
        if (a >= m) {
          a -= m;
        }
      }
      return res;
    }

    public final long div(final long a, final long b) {
      if (isPrime) {
        return mul(a, pow(b, m - 2));
      }
      throw new UnsupportedOperationException();
    }

    public final long mod(long a) {
      if (a >= (m << 1) || a <= -(m << 1)) {
        a %= m;
      }
      if (a >= m) {
        a -= m;
      }
      if (a < 0) {
        a += m;
      }
      return a;
    }

    public final long pow(long a, long b) {
      long res = 1;
      while (b > 0) {
        if ((b & 1) == 1) {
          res = mul(res, a);
        }
        b >>= 1;
        a = mul(a, a);
      }
      return res;
    }

    public String toString() {
      return "ModArithmetic{" + "m=" + m + ", isPrime=" + isPrime + '}';
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

    public final long nextLong() {
      int c;
      for (c = this.read(); isSpaceChar(c); c = this.read()) {}

      byte sgn = 1;
      if (c == 45) { // 45 == '-'
        sgn = -1;
        c = this.read();
      }

      long res = 0;

      while (c >= 48 && c <= 57) { // 48 == '0', 57 == '9'
        res *= 10L;
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
}