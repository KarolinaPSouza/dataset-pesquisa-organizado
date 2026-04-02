import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class FastInput {
  private final InputStream in;
  private final byte[] buffer = new byte[1 << 26]; // 64 KB buffer
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
  private final byte[] buffer = new byte[1 << 26]; // 64 KB buffer
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


public class entry_14355296 {

  public static void main(String[] args) throws IOException {
    FastInput in = new FastInput(System.in);

    int n = in.nextInt();

    List<Integer> vals = new ArrayList<>();

    for(int i=0; i<n-1; i++){
      vals.add(in.nextInt());
    }

    entry_14355296 solution3 = new entry_14355296();
    solution3.numSubordinates(n, vals);
  }

  void numSubordinates(int n, List<Integer> managers) throws IOException {
    FastOutput out = new FastOutput(System.out);
    Map<Integer, Integer> map = new HashMap<>();
    LinkedHashMap<Integer, Integer> mapCount = new LinkedHashMap<>();
    int[] indegree = new int[n+1];
    map.put(1, 0);
    for(int i=0; i<n-1; i++){
      indegree[managers.get(i)]++;
      map.put(i+2, managers.get(i));
    }

    LinkedList<Integer> queue = new LinkedList<>();
    for(int i=1; i<=n; i++){
      if(indegree[i] == 0){
        queue.add(i);
      }
    }

    while (!queue.isEmpty()){
      int emp = queue.poll();
      if(emp == 1){
        continue;
      }
      int manager = managers.get(emp-2);
      indegree[manager]--;
      mapCount.put(manager, mapCount.getOrDefault(manager, 0) + 1 + mapCount.getOrDefault(emp, 0));
      if(indegree[managers.get(emp-2)] == 0){
        queue.add(managers.get(emp-2));
      }
    }

    for(int i=1; i<=n; i++){
      out.print(mapCount.getOrDefault(i, 0));
      out.print(" ");
    }
    out.flush();
  }
}