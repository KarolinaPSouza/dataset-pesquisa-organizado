import java.io.*;
import java.util.*;

public class entry_11236104 {
 public static void main(String[] args) throws IOException {
  FastIO io = new FastIO();
  int n = io.nextInt();
  int k = io.nextInt();

  int[][] movies = new int[n][2];
  for (int i = 0; i<n; i++) {
   movies[i][0] = io.nextInt();
   movies[i][1] = io.nextInt();
  }

  Arrays.sort(movies, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });

  TreeMap<Integer, Integer> set = new TreeMap<Integer, Integer>();
  set.put(0,k);
  int count = 0;
  for (int i = 0; i<n; i++) {
   if (set.floorKey(movies[i][0]) != null) {
    count++;
    if (set.get(set.floorKey(movies[i][0])) == 1) {
     set.remove(set.floorKey(movies[i][0]));
    }
    else {
     set.put(set.floorKey(movies[i][0]), set.get(set.floorKey(movies[i][0]))-1);
    }
    set.put(movies[i][1], set.getOrDefault(movies[i][1],0)+1);
   }
  }
  io.println(count);
  io.close();
 }
 static class FastIO extends PrintWriter {
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
}
