// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

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
    public long nextLong() {  // nextLong() would be implemented similarly
  long c;
  do { c = nextByte(); } while (c <= ' ');

  long sgn = 1;
  if (c == '-') {
   sgn = -1;
   c = nextByte();
  }

  long res = 0;
  do {
   if (c < '0' || c > '9') { throw new InputMismatchException(); }
   res = 10 * res + c - '0';
   c = nextByte();
  } while (c > ' ');
  return res * sgn;
 }

 public double nextDouble() { return Double.parseDouble(next()); }
}

public class entry_15957973 {
 public static void main(String[] args) {
        FastIO io = new FastIO();

        int n =io.nextInt(), m = io.nextInt();
        TreeMap<Integer, Integer> prices = new TreeMap<>();
        ArrayList<Integer> max_prices = new ArrayList<>(m);

        for (int i = 0; i < n; ++i) {
            int price = io.nextInt();
            Integer freq = prices.get(price);
            if (freq == null)
                freq = 0;
            prices.put(price, freq + 1);
        }

        for (int i = 0; i < m; ++i)
            max_prices.add(io.nextInt());

        for (int price : max_prices) {
            Integer result = prices.floorKey(price);
            // ticket doesn't exist
            if (result == null) {
                io.println(-1);
                continue;
            }

            int freq = prices.get(result);
            if (freq - 1 == 0) 
                prices.remove(result);
            else
                prices.put(result, freq - 1);



            io.println(result);
        }
        io.close();
    }

}