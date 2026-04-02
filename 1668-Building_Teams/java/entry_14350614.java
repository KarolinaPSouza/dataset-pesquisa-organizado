import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Pair{
  int val;
  Pair parent;

  public Pair(int val, Pair parent){
    this.val = val;
    this.parent = parent;
  }
}

class FastInput {
  private final InputStream in;
  private final byte[] buffer = new byte[1 << 20]; // 64 KB buffer
  private int ptr = 0, len = 0;

  FastInput(InputStream in) {
    this.in = in;
  }

  private int readByte() throws IOException {
    if (ptr >= len) {
      len = in.read(buffer);
      ptr = 0;
      if (len <= 0) return -1;
    }
    return buffer[ptr++];
  }

  int nextInt() throws IOException {
    int c, sign = 1, x = 0;
    do {
      c = readByte();
    } while (c <= ' ' && c != -1); // skip spaces/newlines
    if (c == '-') {
      sign = -1;
      c = readByte();
    }
    while (c > ' ') {
      x = x * 10 + (c - '0');
      c = readByte();
    }
    return x * sign;
  }

  long nextLong() throws IOException {
    int c, sign = 1;
    long x = 0;
    do {
      c = readByte();
    } while (c <= ' ' && c != -1);
    if (c == '-') {
      sign = -1;
      c = readByte();
    }
    while (c > ' ') {
      x = x * 10 + (c - '0');
      c = readByte();
    }
    return x * sign;
  }

  String next() throws IOException {
    int c;
    StringBuilder sb = new StringBuilder();
    do {
      c = readByte();
    } while (c <= ' ' && c != -1);
    while (c > ' ') {
      sb.append((char) c);
      c = readByte();
    }
    return sb.toString();
  }
}

// 🔹 Ultra-Fast Output Writer
class FastOutput {
  private final byte[] buffer = new byte[1 << 20]; // 64 KB buffer
  private int ptr = 0;
  private final OutputStream out;

  FastOutput(OutputStream out) {
    this.out = out;
  }

  private void flushBuffer() throws IOException {
    out.write(buffer, 0, ptr);
    ptr = 0;
  }

  private void write(int b) throws IOException {
    if (ptr == buffer.length) flushBuffer();
    buffer[ptr++] = (byte) b;
  }

  private void reverse(int l, int r) {
    while (l < r) {
      byte tmp = buffer[l];
      buffer[l] = buffer[r];
      buffer[r] = tmp;
      l++;
      r--;
    }
  }

  public void print(int x) throws IOException {
    if (x == 0) {
      write('0');
      return;
    }
    if (x < 0) {
      write('-');
      x = -x;
    }
    int start = ptr;
    while (x > 0) {
      buffer[ptr++] = (byte) ('0' + (x % 10));
      x /= 10;
    }
    reverse(start, ptr - 1);
  }

  public void print(long x) throws IOException {
    if (x == 0) {
      write('0');
      return;
    }
    if (x < 0) {
      write('-');
      x = -x;
    }
    int start = ptr;
    while (x > 0) {
      buffer[ptr++] = (byte) ('0' + (x % 10));
      x /= 10;
    }
    reverse(start, ptr - 1);
  }

  public void print(String s) throws IOException {
    for (int i = 0; i < s.length(); i++) {
      write(s.charAt(i));
    }
  }

  public void println(int x) throws IOException {
    print(x);
    write('\n');
  }

  public void println(long x) throws IOException {
    print(x);
    write('\n');
  }

  public void println(String s) throws IOException {
    print(s);
    write('\n');
  }

  public void flush() throws IOException {
    flushBuffer();
    out.flush();
  }
}

// 🔹 Example Usage


public class entry_14350614 {

  public static void main(String[] args) throws IOException {
    FastInput in = new FastInput(System.in);
    FastOutput out = new FastOutput(System.out);

    int n = in.nextInt();
    int m = in.nextInt();

    List<List<Integer>> vals = new ArrayList<>();

    for(int i=0; i<m; i++){
      vals.add(Arrays.asList(in.nextInt(), in.nextInt()));
    }

    entry_14350614 solution3 = new entry_14350614();
    solution3.bipartite(n, vals);
  }

  void bipartite(int n, List<List<Integer>> edges) throws IOException {
    List<List<Integer>> graph = buildGraph(n, edges);
    FastOutput out = new FastOutput(System.out);

    int[] color = new int[n+1];
    Arrays.fill(color, -1);

    for(int i=0; i<n; i++){
      if(color[i] == -1){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(i);
        color[i] = 0;

        while(!queue.isEmpty()){
          int node = queue.poll();
          for(int neighbor: graph.get(node)){
            if(color[neighbor] == -1){
              color[neighbor] = 1 - color[node];
              queue.add(neighbor);
            } else if(color[neighbor] == color[node]){
              out.println("IMPOSSIBLE");
              out.flush();
              return;
            }
          }
        }
      }
    }

    for(int i=1; i<=n; i++){
      out.print(color[i]+1);
      out.print(" ");
    }
    out.flush();
  }

  List<List<Integer>> buildGraph(int n, List<List<Integer>> edges){
    List<List<Integer>> graph = new ArrayList<>();
    for(int i=0; i<=n; i++){
      graph.add(new ArrayList<>());
    }

    for(List<Integer> edge: edges){
      int u = edge.get(0);
      int v = edge.get(1);
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    return graph;
  }

}