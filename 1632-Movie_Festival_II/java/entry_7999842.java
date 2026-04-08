import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.TreeMap;


public class entry_7999842 {
 public static void main(String[] args) {
  FastIO sc = new FastIO();
  int n = sc.nextInt();
  int k = sc.nextInt();
  TreeMap<Long, Integer>m =  new TreeMap<Long, Integer>();
  long [][] movies = new long [n][2];
  for(int i =0;i<n;i++) {
   movies[i][0]=sc.nextInt();
   movies[i][1]=sc.nextInt();
  }
  Arrays.sort(movies, (long [] e1, long []e2) -> Long.compare(e1[1],e2[1]));
  int count=0;
  m.put((long)-1,k);
  //you can watch if the start is less or equal to cur val (end val), pick the greatest one because its bad
  for(int i =0;i<n;i++) {
   long start = movies[i][0];
   long end = movies[i][1];
   Long val = m.lowerKey(start+1);
   if(val!=null) {
    count++;
    //remove one lower keyu from m
    m.put(val,m.get(val)-1);
    if(m.get(val)==0) {
     m.remove(val);
    }
    m.put(end, m.getOrDefault(end, 0)+1);
   }
  }
  System.out.println(count);
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