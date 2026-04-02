import java.io.*;
import java.util.*;

public class entry_8564911 {
 static int ans[];
 static ArrayList<Integer> adj[];
 public static void main(String[] args) {
  FastIO io = new FastIO();
  int n=io.nextInt();
  ans = new int[n+1];
  adj = new ArrayList[n+1];
  for (int i=0;i<n+1;i++) adj[i] = new ArrayList<>();
  for (int i=2;i<n+1;i++) {
   int boss=io.nextInt();
   adj[boss].add(i);
  }
  Queue<Integer> q = new LinkedList<>();
  ArrayList<Integer> order = new ArrayList<>();
  q.add(1);order.add(1);
  while (!q.isEmpty()) {
   int c = q.remove();
   for (int nb : adj[c]) {
    q.add(nb);
    order.add(nb);
   }
  }
  for (int i=n-1;i>=0;i--)
   dfs(order.get(i));
  for (int i=1;i<n+1;i++)
   io.print(ans[i]+" ");
  io.println();
  io.close();
 }
 static int dfs(int node) {
  if (ans[node]!=0)
   return ans[node];
  for (int nb:adj[node])
   ans[node]+=dfs(nb)+1;
  return ans[node];
 }
}

class FastIO extends PrintWriter {
 private InputStream stream;
 private byte[] buf = new byte[1 << 16];
 private int curChar;
 private int numChars;
 // standard input
 public FastIO() { this(System.in, System.out); }
 public FastIO(InputStream i, OutputStream o) {
  super(o);
  stream = i;
 }
 // file input
 public FastIO(String i, String o) throws IOException {
  super(new FileWriter(o));
  stream = new FileInputStream(i);
 }
 // throws InputMismatchException() if previously detected end of file
 private int nextByte() {
  if (numChars == -1) { throw new InputMismatchException(); }
  if (curChar >= numChars) {
   curChar = 0;
   try {
    numChars = stream.read(buf);
   } catch (IOException e) { throw new InputMismatchException(); }
   if (numChars == -1) {
    return -1;  // end of file
   }
  }
  return buf[curChar++];
 }
 // to read in entire lines, replace c <= ' '
 // with a function that checks whether c is a line break
 public String next() {
        int c; do { c = nextByte(); } while (c <= ' ');
        StringBuilder res = new StringBuilder();
        do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
        return res.toString();
 }
 public int nextInt() {
        int c; do { c = nextByte(); } while (c <= ' ');
        int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10*res+c-'0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
 }
 public long nextLong() {
        int c; do { c = nextByte(); } while (c <= ' ');
        int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10*res+c-'0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
 }
 public double nextDouble() { return Double.parseDouble(next()); }
}