import java.io.*;
import java.util.*;

public class entry_5105950 {
 public static void main(String[] args) throws IOException {
  FastIO io = new FastIO();

  int n = io.nextInt();
  int k = io.nextInt();
  PriorityQueue<Movie> pq = new PriorityQueue<>();
  for (int i=0; i<n; i++){
   int start = io.nextInt();
   int end = io.nextInt();
   pq.add(new Movie(start, end));
  }
  int ans = 0;
  TreeMap<Integer, Integer> workers = new TreeMap<>();
  int used = 0;
  while (pq.size() > 0){
   Movie m = pq.poll();
   Integer worker = workers.floorKey(m.start);
   if (worker == null && used < k){
    ans++;
    used++;
    workers.put(m.end, workers.getOrDefault(m.end, 0) + 1);
   } else if (worker != null){
    ans++;
    if (workers.get(worker) == 1) workers.remove(worker);
    else workers.put(worker, workers.get(worker) - 1);
    workers.put(m.end, workers.getOrDefault(m.end, 0) + 1);
   }
  }
  io.println(ans);
  io.close();
 }
}
class Movie implements Comparable<Movie> {
 int start, end;
 public Movie (int start, int end){
  this.start = start;
  this.end = end;
 }
 public int compareTo (Movie m){
  if (end == m.end)
   return Integer.compare(start, m.start);
  return Integer.compare(end, m.end);
 }
}
class FastIO extends PrintWriter {
  private InputStream stream;
  private byte[] buf = new byte[1<<16];
  private int curChar, numChars;

  // standard input
  public FastIO() { this(System.in,System.out); }
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
   if (numChars == -1) throw new InputMismatchException();
   if (curChar >= numChars) {
    curChar = 0;
    try {
     numChars = stream.read(buf);
    } catch (IOException e) {
     throw new InputMismatchException();
    }
    if (numChars == -1) return -1; // end of file
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
  public int nextInt() { // nextLong() would be implemented similarly
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
  public double nextDouble() { return Double.parseDouble(next()); }
}
