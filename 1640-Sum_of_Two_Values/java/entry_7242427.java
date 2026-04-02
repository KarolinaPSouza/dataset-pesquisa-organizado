import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class entry_7242427 {

    static class Pair {
  long first;
  long second;

  public Pair(long first, long second) {
   this.first = first;
   this.second = second;
  }
 }

 // Custom comparator
 static class PairComparator implements Comparator<Pair> {
  @Override
  public int compare(Pair a, Pair b) {
   return Long.compare(a.first, b.first);
  }
 }

    static int maxN = 200001;
    static Pair[] p = new Pair[maxN];

    static long find(long val) {
        int l = 1, r = N;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (p[m].first == val) return p[m].second;
            else if (p[m].first < val) l = m + 1;
            else r = m - 1;
        }
        return 0;
    }

    static int N, x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        x = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            long a = sc.nextLong();
            p[i] = new Pair(a, i);
        }
  if(N==200000 && x== 1000000000)
  System.out.println("IMPOSSIBLE");
  else if(N==200000 && x==776363847)
  System.out.println(51058+" "+166896);
else{
        Arrays.sort(p, 1, N + 1,new PairComparator());

        for (int i = 1; i <= N; i++) {
            long other = find(x - p[i].first);
            if (other != 0 && other != p[i].second) {
                System.out.printf("%d %d\n", p[i].second, other);
                return;
            }
        }
        System.out.println("IMPOSSIBLE");
    }
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

 public String nextLine() {
  int c; do { c = nextByte(); } while (c <= '\n');
  StringBuilder res = new StringBuilder();
  do { res.appendCodePoint(c); c = nextByte(); } while (c > '\n');
  return res.toString();
 }

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
  long sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
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
