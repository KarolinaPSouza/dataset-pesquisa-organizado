import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class entry_6135370 {
 static FastIO io;
 static final int MOD = 1000000007;
 static int[] bestUp = new int[10];
 static int[] maxDist = new int[10];

 public static void main(String[] args) throws IOException {
  String fileName = "";
  if (fileName.equals("") == false) {
   io = new FastIO(fileName);
  } else {
   io = new FastIO();
  }
  int size = io.nextInt();
  if (size == 1) {
   io.println(0);
   io.close();
   return;
  }
  Node[] nodes = new Node[size];
  bestUp = new int[size];
  maxDist = new int[size];
  for (int i = 0; i < size; i++) {
   nodes[i] = new Node(i);
  }
  for (int i = 1; i < size; i++) {
   int a = io.nextInt() - 1;
   int b = io.nextInt() - 1;
   nodes[a].children.add(nodes[b]);
   nodes[b].children.add(nodes[a]);
  }
  ArrayDeque<State> stack = new ArrayDeque<>();
  stack.add(new State(nodes[0], null));
  while (stack.isEmpty() == false) {
   State state = stack.removeLast();
   Node node = state.node;
   Node parent = state.parent;
   s: switch (state.dfsState) {
   case 0:
    state.iterator = node.children.iterator();
    while (state.iterator.hasNext()) {
     Node child = state.iterator.next();
     if (child != parent) {
      state.dfsState = 1;
      stack.add(state);
      stack.add(new State(child, node));
      break s;
     }
    }
    if (stack.isEmpty() == false) {
     stack.peekLast().returnVal = node.maxDepth1 + 1;
    }
    break;
   case 1:
    int depth = state.returnVal;
    if (depth > node.maxDepth1) {
     node.maxDepth2 = node.maxDepth1;
     node.maxDepth1 = depth;
    } else if (depth > node.maxDepth2) {
     node.maxDepth2 = depth;
    }
    while (state.iterator.hasNext()) {
     Node child = state.iterator.next();
     if (child != parent) {
      stack.add(state);
      stack.add(new State(child, node));
      break s;
     }
    }
    if (stack.isEmpty() == false) {
     stack.peekLast().returnVal = node.maxDepth1 + 1;
    }
    break;
   }
  }
  stack.add(new State(nodes[0], null));
  while (stack.isEmpty() == false) {
   State state = stack.remove();
   Node node = state.node;
   Node parent = state.parent;
   if (parent != null) {
    if (parent.maxDepth2 != 0) {
     int parDepth = node.maxDepth1 + 1 == parent.maxDepth1 ? parent.maxDepth2 : parent.maxDepth1;
     bestUp[node.self] = Math.max(parDepth, bestUp[parent.self]) + 1;
    } else {
     bestUp[node.self] = bestUp[parent.self] + 1;
    }
   }
   maxDist[node.self] = Math.max(bestUp[node.self], node.maxDepth1);
   for (Node child : node.children) {
    if (child != parent) {
     stack.add(new State(child, node));
    }
   }
  }

  for (int num : maxDist) {
   io.print(num + " ");
  }
  io.close();
 }

 static class State {
  Node node;
  Node parent;
  int returnVal;
  int dfsState;
  Iterator<Node> iterator;

  public State(entry_6135370.Node node, entry_6135370.Node parent) {
   this.node = node;
   this.parent = parent;
  }

 }

 static class Node {
  // Node parent;
  ArrayList<Node> children = new ArrayList<>();
  int self;
  int maxDepth1;
  int maxDepth2;

  public Node(int self) {
   this.self = self;
  }

  @Override
  public String toString() {
   return "" + (self + 1);
  }
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

  public String readLine() {
   byte[] buf = new byte[64]; // line length
   int cnt = 0, c;
   try {
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
   } catch (IOException e) {
    throw new RuntimeException(e);
   }
   return new String(buf, 0, cnt);
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