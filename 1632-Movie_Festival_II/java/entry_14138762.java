import java.io.*;
import java.util.*;

public class entry_14138762 {
 public static void main(String[] args) {
  FastIO io = new FastIO();
  int n = io.nextInt();
  int k = io.nextInt();

            ArrayList<Pair> al=new ArrayList<>();
            for(int i=0;i<n;i++) {
                al.add(new Pair(io.nextInt(), io.nextInt()));
            }
            Collections.sort(al);
            TreeMap<Integer, Integer> tm=new TreeMap<>();
            tm.put(0, k);
            int ans=0;
            for(var v:al){
                var key=tm.floorKey(v.first);
                if(key!=null){
                    ++ans;
                    int value=tm.get(key);
                    if(value==1) tm.remove(key);
                    else
                        tm.put(key, value-1);

                    tm.put(v.second, tm.getOrDefault(v.second, 0)+1);                    
                } 
            }
            io.println(ans);
  io.close();
 }

    static class Pair implements Comparable<Pair>{
//    static class Pair{
        int first;
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }

        @Override
        public String toString() {
            return "first: " + first + " second: " + second;
        }

        @Override
        public int compareTo(Pair p){
            if(this.second==p.second)
                return this.first-p.first;
            return this.second-p.second;
        }

    }


 static class Interval {
  int start, end;

  Interval(int start, int end) {
   this.start = start;
   this.end = end;
  }
 }

 // BeginCodeSnip{FastIO}
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
 // EndCodeSnip{FastIO}
}