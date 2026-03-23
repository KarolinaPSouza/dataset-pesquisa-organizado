import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class entry_2034706 {
  public static void main(String[] args) {
    InputReader in = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    Solver solver = new Solver();
    solver.solve(in, out);
    in.close();
    out.close();
  }

  static class Solver {
    public void solve(InputReader in, PrintWriter out) {
      int n = in.nextInt();
      int m = in.nextInt();

      TreeMap<Integer, Integer> prices = new TreeMap<>();
      for (int i = 0; i < n; i++) {
        int curr = in.nextInt();
        prices.put(curr, prices.getOrDefault(curr, 0) + 1);
      }

      for (int i = 0; i < m; i++) {
        int curr = in.nextInt();
        Map.Entry<Integer, Integer> e = prices.floorEntry(curr);
        if (e == null) {
          out.println(-1);
        } else {
          out.println(e.getKey());
          if (e.getValue() == 1) {
            prices.remove(e.getKey());
          } else {
            prices.put(e.getKey(), e.getValue() - 1);
          }
        }
      }
    }
  }

  static class InputReader {
    private final int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer;
    private int bytesRead;

    public InputReader(InputStream inputStream) {
      din = new DataInputStream(inputStream);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String readLine() {
      byte[] buf = new byte[64]; // line length
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == '\n') {
          if (cnt != 0) {
            break;
          } else {
            continue;
          }
        }
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() {
      int ret = 0;
      byte c = read();
      while (c <= ' ') {
        c = read();
      }
      boolean neg = (c == '-');
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (neg) {
        return -ret;
      }
      return ret;
    }

    public long nextLong() {
      long ret = 0;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = (c == '-');
      if (neg) c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg) {
        return -ret;
      }
      return ret;
    }

    public double nextDouble() {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ') c = read();
      boolean neg = (c == '-');
      if (neg) c = read();

      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (c == '.') {
        while ((c = read()) >= '0' && c <= '9') {
          ret += (c - '0') / (div *= 10);
        }
      }

      if (neg) return -ret;
      return ret;
    }

    private void fillBuffer() {
      try {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
      if (bytesRead == -1) buffer[0] = -1;
    }

    private byte read() {
      if (bufferPointer == bytesRead) {
        fillBuffer();
      }
      return buffer[bufferPointer++];
    }

    public void close() {
      try {
        din.close();
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
  }
}