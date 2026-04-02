//package practice;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_2059015 implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public entry_2059015() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    long[] x = new long[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.nl();
    }
    long minSum = 0, prefix = 0, max = x[0];
    for (int i = 0; i < n; i++) {
      prefix += x[i];
      max = Math.max(max, prefix - minSum);
      minSum = Math.min(minSum, prefix);
    }
    out.println(max);
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int ni() {
      return Integer.parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (entry_2059015 instance = new entry_2059015()) {
      instance.solve();
    }
  }
}