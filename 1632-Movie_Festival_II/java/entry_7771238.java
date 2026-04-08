import java.util.*;
import java.io.*;

public class entry_7771238 {
    static class Movie implements Comparable<Movie> {
        int start, end;
        public Movie(int start, int end){
            this.start=  start;
            this.end = end;
        }

        public int compareTo(Movie other) {
            if (Integer.compare(end, other.end) != 0) {
                return Integer.compare(end, other.end);
            }
            return Integer.compare(start, other.start);
        }
    }

    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO(System.in, System.out);

        int n = io.nextInt();
        int k = io.nextInt(); // number of club members
        Movie[] movies = new Movie[n];
        for (int i = 0; i < n; i++) {
            movies[i] = new Movie(io.nextInt(), io.nextInt());
        }
        Arrays.sort(movies);

        TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();
        int count = 0;
        multiset.put(0, k);
        for (int i = 0; i < n; i++) {
            Integer lower = multiset.lowerKey(movies[i].start + 1); // find the greatest end time that is less than or equal to the start time of this movie
            if (lower != null) {
                int lowerValue = multiset.get(lower);
    // remove the original time in which member finishes movie
    if (lowerValue - 1 == 0) {
     multiset.remove(lower);
    } else {
     multiset.put(lower, lowerValue - 1);
    }
    // member now finishes watching at time movie.end
    multiset.put(movies[i].end, multiset.getOrDefault(movies[i].end, 0) + 1);
                count++;
            }
        }

        io.println(count);

        io.close();
    }

    // public static void add(TreeMap<Integer, Integer> multiset, int x) {
    //     if (multiset.containsKey(x)) {
    //         multiset.put(x, multiset.get(x) + 1);
    //     }
    //     else {
    //         multiset.put(x, 1);
    //     }
    // }

    // public static void remove(TreeMap<Integer, Integer> multiset, int x) {
    //     multiset.put(x, multiset.get(x) - 1);
    //     if (multiset.get(x) == 0) {
    //         multiset.remove(x);
    //     }
    // }

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
   if (c < '0' || c > '9') { throw new InputMismatchException(); }
   res = 10 * res + c - '0';
   c = nextByte();
  } while (c > ' ');
  return res * sgn;
 }

 public double nextDouble() { return Double.parseDouble(next()); }
}