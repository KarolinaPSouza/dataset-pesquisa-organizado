import javax.swing.*;
import java.io.*;
import java.util.*;

public class entry_14264975 {
  static class Reader {
    static InputStream is;
    static byte[] inbuf = new byte[1 << 22];
    static int lenbuf = 0, ptrbuf = 0;
    public Reader() {
      is = System.in;
    }

    int readByte() {
      if (lenbuf == -1)
        throw new InputMismatchException();
      if (ptrbuf >= lenbuf) {
        ptrbuf = 0;
        try {
          lenbuf = is.read(inbuf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (lenbuf <= 0)
          return -1;
      }
      return inbuf[ptrbuf++];
    }

    public int nextInt() {
      int num = 0;
      boolean isNegative = false;

      // Skip non-digit characters
      int b = readByte();
      while (b != -1 && (b < '0' || b > '9') && b != '-') {
        b = readByte();
      }

      // Check for negative sign
      if (b == '-') {
        isNegative = true;
        b = readByte();
      }

      // Read the number
      while (b >= '0' && b <= '9') {
        num = num * 10 + (b - '0');
        b = readByte();
      }

      return isNegative ? -num : num;
    }

    boolean isSpaceChar(int c) {
      return !(c >= 33 && c <= 126);
    }

    int skip() {
      int b = readByte();
      while (b != -1 && isSpaceChar(b)) {
        b = readByte();
      }
      return b;
    }

    public String nextString() {
      int b = skip();
      StringBuilder sb = new StringBuilder();
      while (!(isSpaceChar(b))) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      long num = 0;
      boolean isNegative = false;
      int b = readByte();

      // Skip non-digit characters
      while (b != -1 && b != '-' && (b < '0' || b > '9')) {
        b = readByte();
      }

      // Check for negative sign
      if (b == '-') {
        isNegative = true;
        b = readByte();
      }

      // Read the number
      while (b >= '0' && b <= '9') {
        num = num * 10 + (b - '0');
        b = readByte();
      }

      return isNegative ? -num : num;
    }

    public double nextDouble() {
      return Double.parseDouble(nextString());
    }

    public char nextChar() {
      return (char) skip();
    }

  }

  public static PrintWriter writer = new PrintWriter(System.out);

  public static final int MOD = (int) (1e9+7);

  static void solve() {
    // Your code goes here
    Reader reader = new Reader();
    int n = reader.nextInt();
    int k = reader.nextInt();
    List<int[]> movies = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      movies.add(new int[]{reader.nextInt(), reader.nextInt()});
    }

    TreeMap<Integer,Integer> pq = new TreeMap<>();
    movies.sort((a,b) -> a[1] - b[1]);
    pq.put(0, k);
    int ans = 0;
    for (int [] movie : movies) {
      int s = movie[0], e = movie[1];
      Integer l = pq.floorKey(s);
      if (l != null) {
        int count = pq.get(l);
        if (count == 1) pq.remove(l);
        else pq.put(l, count-1);
        pq.put(e, pq.getOrDefault(e, 0) + 1);
        ans++;
      }
    }
    writer.println(ans);
  }

  public static void main(String[] args) {
    solve();
    writer.flush();
  }
}