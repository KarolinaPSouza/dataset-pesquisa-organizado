import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class entry_12687535 {
 public static int binarySearch(long[][] project, long x) {
  int l = 0;
  int r = project.length;
  while (l < r) {
   int mid = (l + r) / 2;
   if (project[mid][0] >= x) {
    r = mid;
   } else {
    l = mid + 1;
   }
  }
  return l;

 }

 public static void main(String[] args) {
  InputReader in = new InputReader(System.in);
  OutputWriter out = new OutputWriter(System.out);
  int n = in.nextInt();
  long[][] project = new long[n][3];
  for (int i = 0; i < n; i++) {
   project[i][0] = in.nextInt();
   project[i][1] = in.nextInt();
   project[i][2] = in.nextInt();
  }
  Arrays.sort(project, (a, b) -> Long.compare(a[0], b[0]));
  long dp[] = new long[n + 1];
  for (int i = n - 1; i >= 0; i--) {
   int idx = binarySearch(project, project[i][1] + 1);
   dp[i] = Math.max(dp[i + 1], project[i][2] + dp[idx]);
  }
  out.println(dp[0]);

  // Your logic here

  out.writer.close(); // Ensure output is flushed
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

  public int nextInt() {
   return Integer.parseInt(next());
  }

  public double nextDouble() {
   return Double.parseDouble(next());
  }

  public long nextLong() {
   return Long.parseLong(next());
  }
 }

 static class OutputWriter {
  public PrintWriter writer;

  OutputWriter(OutputStream stream) {
   writer = new PrintWriter(stream);
  }

  public void print(Object args) {
   writer.print(args);
  }

  public void println(Object args) {
   writer.println(args);
  }
 }
}