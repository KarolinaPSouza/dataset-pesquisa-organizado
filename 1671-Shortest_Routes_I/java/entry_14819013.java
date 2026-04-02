import java.io.*;
import java.util.*;
public class entry_14819013 {

    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt();
        int m = io.nextInt();
        Map<Integer, List<Flight>> adjList = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            long c = io.nextInt();
            if (!adjList.containsKey(a)) {
                adjList.put(a, new ArrayList<>());
            }
            adjList.get(a).add(new Flight(b, c));
        }

        long[] dist = new long[n+1];
        boolean[] processed = new boolean[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(processed, false);
        PriorityQueue<Flight> q = new PriorityQueue<>();
        q.add(new Flight(1, 0));
        while(!q.isEmpty()) {
            Flight cur = q.remove();
            if (processed[cur.node]) {
                continue;
            }
            processed[cur.node] = true;
            dist[cur.node] = cur.length;
            if (!adjList.containsKey(cur.node)) {
                continue;
            }
            for (Flight nei : adjList.get(cur.node)) {
                if (dist[nei.node] > dist[cur.node] + nei.length) {
                    q.add(new Flight(nei.node, dist[cur.node] + nei.length));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            sb.append(dist[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}

class Flight implements Comparable<Flight> {
    int node;
    long length;

    public Flight(int node, long length) {
        this.node = node;
        this.length = length;
    }

    @Override
    public int compareTo (Flight o) {
        if (this.length > o.length) {
            return 1;
        } else if (this.length < o.length) {
            return -1;
        } else {
            return 0;
        }
    }
}

class FastIO extends PrintWriter {

  private InputStream stream;
  private byte[] buf = new byte[1 << 16];
  private int curChar, numChars;

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
   if (numChars == -1) throw new InputMismatchException();
   if (curChar >= numChars) {
    curChar = 0;
    try {
     numChars = stream.read(buf);
    } catch (IOException e) { throw new InputMismatchException(); }
    if (numChars == -1) return -1;  // end of file
   }
   return buf[curChar++];
  }

  // to read in entire lines, replace c <= ' '
  // with a function that checks whether c is a line break
  public String next() {
   int c;
   do { c = nextByte(); } while (c <= ' ');
   StringBuilder res = new StringBuilder();
   do {
    res.appendCodePoint(c);
    c = nextByte();
   } while (c > ' ');
   return res.toString();
  }
  public int nextInt() {  // nextLong() would be implemented similarly
   int c;
   do { c = nextByte(); } while (c <= ' ');
   int sgn = 1;
   if (c == '-') {
    sgn = -1;
    c = nextByte();
   }
   int res = 0;
   do {
    if (c < '0' || c > '9') throw new InputMismatchException();
    res = 10 * res + c - '0';
    c = nextByte();
   } while (c > ' ');
   return res * sgn;
  }
  public double nextDouble() { return Double.parseDouble(next()); }
 }
 // EndCodeSnip

