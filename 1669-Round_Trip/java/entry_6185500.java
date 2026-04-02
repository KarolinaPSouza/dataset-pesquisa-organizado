import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class entry_6185500 {
 static FastIO io;
 static final int MOD = 1000000007;
 static int[] prev;
 static int[] depth;
 static int cycle2 = -1;

 public static void main(String[] args) throws IOException {
  String fileName = "";
  if (fileName.equals("") == false) {
   io = new FastIO(fileName);
  } else {
   io = new FastIO();
  }
  nodeNum = io.nextInt();
  edgeNum = io.nextInt();
  createGraph();
  for (int i = 0; i < edgeNum; i++) {
   addEdge(io.nextInt() - 1, io.nextInt() - 1);
  }
  prev = new int[nodeNum];
  depth = new int[nodeNum];
  Arrays.fill(prev, -1);
  for (int i = 0; i < nodeNum; i++) {
   if (prev[i] == -1) {
    prev[i] = i;
    depth[i] = 0;
    int cycle1 = dfs(i, -1);
    if (cycle1 != -1) {
     ArrayDeque<Integer> path = new ArrayDeque<>();
     path.add(cycle1);
     path.add(cycle2);
     while (depth[cycle2] > depth[cycle1]) {
      cycle2 = prev[cycle2];
      path.add(cycle2);
     }
     while (depth[cycle1] > depth[cycle2]) {
      cycle1 = prev[cycle1];
      path.addFirst(cycle1);
     }
     while (cycle1 != cycle2) {
      cycle1 = prev[cycle1];
      cycle2 = prev[cycle2];
      path.add(cycle2);
      path.addFirst(cycle1);
     }
     io.println(path.size());
     for (int node : path) {
      io.print((node + 1) + " ");
     }
     io.close();
     return;
    }
   }
  }
  io.println("IMPOSSIBLE");
  io.close();
 }

 static int dfs(int node, int parent) {
  for (int adj : graph[node]) {
   if (adj != parent) {
    if (prev[adj] != -1) {
     cycle2 = node;
     return adj;
    } else {
     prev[adj] = node;
     depth[adj] = depth[node] + 1;
     int cycle = dfs(adj, node);
     if (cycle != -1) {
      return cycle;
     }
    }
   }
  }
  return -1;
 }

 static int nodeNum;
 static int edgeNum;
 static HashSet<Integer>[] graph;

 @SuppressWarnings("unchecked")
 static void createGraph() {
  graph = new HashSet[nodeNum];
  for (int i = 0; i < nodeNum; i++) {
   graph[i] = new HashSet<>();
  }
 }

 static void addEdge(int from, int to) {
  graph[from].add(to);
  graph[to].add(from);
 }

 static void deleteEdge(int from, int to) {
  graph[from].remove(to);
  graph[to].remove(from);
 }

 static void replaceEdge(int from, int to) {
  deleteEdge(from, to);
  addEdge(from, to);
 }

 static boolean hasEdge(int from, int to) {
  return graph[from].contains(to);
 }

 static void readIntArray(int[] nums) {
  for (int i = 0; i < nums.length; i++) {
   nums[i] = io.nextInt();
  }
 }

 static void readLongArray(long[] nums) {
  for (int i = 0; i < nums.length; i++) {
   nums[i] = io.nextLong();
  }
 }

 static void sortArray(int[] arr) {
  shuffleArray(arr);
  Arrays.sort(arr);
 }

 static void shuffleArray(int[] arr) {
  Random rnd = ThreadLocalRandom.current();
  for (int i = arr.length - 1; i > 0; i--) {
   int index = rnd.nextInt(i + 1);
   int a = arr[index];
   arr[index] = arr[i];
   arr[i] = a;
  }
 }

 static void sortLongArray(long[] arr) {
  shuffleLongArray(arr);
  Arrays.sort(arr);
 }

 static void shuffleLongArray(long[] arr) {
  Random rnd = ThreadLocalRandom.current();
  for (int i = arr.length - 1; i > 0; i--) {
   int index = rnd.nextInt(i + 1);
   long a = arr[index];
   arr[index] = arr[i];
   arr[i] = a;
  }
 }

 static class FastIO extends PrintWriter {
  final private int BUFFER_SIZE = 1 << 16;
  private DataInputStream din;
  private byte[] buffer;
  private int bufferPointer, bytesRead;
  private StringBuilder sb;

  public FastIO() {
   this(System.in, System.out);
  }

  public FastIO(String file_name) throws IOException {
   this(new FileInputStream(file_name + ".in"), new FileOutputStream(file_name + ".out"));
  }

  public FastIO(InputStream i, OutputStream o) {
   super(o);
   din = new DataInputStream(i);
   buffer = new byte[BUFFER_SIZE];
   bufferPointer = bytesRead = 0;
   sb = new StringBuilder();
  }

  public String nextLine(int lineLength) {
   byte[] buf = new byte[lineLength]; // line length
   int cnt = 0, c;
   try {
    while (cnt != lineLength && (c = read()) != -1) {
     if (c == '\n') {
      return new String(buf, 0, cnt);
     }
     buf[cnt++] = (byte) c;
    }
    while ((c = read()) != -1) {
     if (c == '\n') {
      return new String(buf, 0, cnt);
     }
    }
    return new String(buf, 0, cnt);
   } catch (IOException e) {
    throw new RuntimeException(e);
   }
  }

  public int nextInt() {
   int ret = 0;
   try {
    byte c = read();
    while (c <= ' ') {
     c = read();
    }
    boolean neg = (c == '-');
    if (neg)
     c = read();
    do {
     ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    if (neg)
     return -ret;
    return ret;
   } catch (IOException e) {
    throw new RuntimeException(e);
   }

  }

  public long nextLong() {
   long ret = 0;
   try {
    byte c = read();
    while (c <= ' ')
     c = read();
    boolean neg = (c == '-');
    if (neg)
     c = read();
    do {
     ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');
    if (neg)
     return -ret;
    return ret;
   } catch (IOException e) {
    throw new RuntimeException(e);
   }
  }

  public double nextDouble() throws IOException {
   double ret = 0, div = 1;
   byte c = read();
   while (c <= ' ')
    c = read();
   boolean neg = (c == '-');
   if (neg)
    c = read();

   do {
    ret = ret * 10 + c - '0';
   } while ((c = read()) >= '0' && c <= '9');

   if (c == '.') {
    while ((c = read()) >= '0' && c <= '9') {
     ret += (c - '0') / (div *= 10);
    }
   }

   if (neg)
    return -ret;
   return ret;
  }

  private void fillBuffer() throws IOException {
   bytesRead = din.read(buffer, bufferPointer = 0,
     BUFFER_SIZE);
   if (bytesRead == -1)
    buffer[0] = -1;
  }

  private byte read() throws IOException {
   if (bufferPointer == bytesRead)
    fillBuffer();
   return buffer[bufferPointer++];
  }

  @Override
  public void println() {
   sb.append("\n");
  }

  @Override
  public void println(Object x) {
   sb.append(x.toString()).append("\n");
  }

  @Override
  public void println(String x) {
   sb.append(x).append("\n");
  }

  @Override
  public void println(boolean x) {
   sb.append(x).append("\n");
  }

  @Override
  public void println(char x) {
   sb.append(x).append("\n");
  }

  @Override
  public void println(char[] x) {
   sb.append(x).append("\n");
  }

  @Override
  public void println(double x) {
   sb.append(x).append("\n");
  }

  @Override
  public void println(float x) {
   sb.append(x).append("\n");
  }

  @Override
  public void println(int x) {
   sb.append(x).append("\n");
  }

  @Override
  public void println(long x) {
   sb.append(x).append("\n");
  }

  @Override
  public void print(Object x) {
   sb.append(x.toString());
  }

  @Override
  public void print(String x) {
   sb.append(x);
  }

  @Override
  public void print(boolean x) {
   sb.append(x);
  }

  @Override
  public void print(char x) {
   sb.append(x);
  }

  @Override
  public void print(char[] x) {
   sb.append(x);
  }

  @Override
  public void print(double x) {
   sb.append(x);
  }

  @Override
  public void print(float x) {
   sb.append(x);
  }

  @Override
  public void print(int x) {
   sb.append(x);
  }

  @Override
  public void print(long x) {
   sb.append(x);
  }

  @Override
  public PrintWriter printf(String format, Object... args) {
   sb.append(String.format(format, args));
   return null;
  }

  public void close() {
   if (din != null) {
    try {
     din.close();
    } catch (IOException e) {
    }
   }
   super.print(sb);
   super.close();
  }
 }
}