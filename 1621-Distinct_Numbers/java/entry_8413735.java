import java.io.*;
import java.util.*;

public class entry_8413735 {

  static class InputReader {

    BufferedReader reader;
    StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    String next() { // reads in the next string
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() { // reads in the next int
      return Integer.parseInt(next());
    }

    public long nextLong() { // reads in the next long
      return Long.parseLong(next());
    }

    public double nextDouble() { // reads in the next double
      return Double.parseDouble(next());
    }
  }

  static InputReader r = new InputReader(System.in);
  static PrintWriter pw = new PrintWriter(System.out);

  public static void main(String[] args) {
    int n = 0;
    int trials = r.nextInt();
    HashSet<Integer> hs = new HashSet<Integer>();
    for(int i = 0; i < trials; i++){
        hs.add(r.nextInt());
    }
    for (int element : hs) {
      n += 1;
    }
    pw.print(n);
    pw.close();
  }
}