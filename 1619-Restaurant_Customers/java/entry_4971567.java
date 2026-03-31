import java.io.*;
import java.util.InputMismatchException;
import java.util.TreeMap;

public class entry_4971567 {

     public static void main(String[] args) {
             FastScanner sc = new FastScanner();
             int n = sc.nextInt();
         TreeMap<Integer,Integer>hs = new TreeMap<>();
         while(n-->0){
             int x = sc.nextInt();
             int y = sc.nextInt();
             hs.put(x,1);
             hs.put(y,-1);
         }
         int sum =0;
         int max =0;
         for(int x:hs.keySet()){
             sum+=hs.get(x);
             max = Math.max(max,sum);
         }
         sc.println(max);
             sc.close();
         }

        static class FastScanner extends PrintWriter {
             private InputStream stream;
             private byte[] buf = new byte[1 << 16];
             private int curChar;
             private int numChars;

             // standard input
             public FastScanner() { this(System.in, System.out); }

             public FastScanner(InputStream i, OutputStream o) {
                 super(o);
                 stream = i;
             }

             // file input
             public FastScanner(String i, String o) throws IOException {
                 super(new FileWriter(o));
                 stream = new FileInputStream(i);
             }

             // throws InputMismatchException() if previously detected end of file
             private int nextByte() {
                 if (numChars == -1) {
                     throw new InputMismatchException();
                 }
                 if (curChar >= numChars) {
                     curChar = 0;
                     try {
                         numChars = stream.read(buf);
                     } catch (IOException e) {
                         throw new InputMismatchException();
                     }
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
                 do {
                     c = nextByte();
                 } while (c <= ' ');

                 StringBuilder res = new StringBuilder();
                 do {
                     res.appendCodePoint(c);
                     c = nextByte();
                 } while (c > ' ');
                 return res.toString();
             }

             public int nextInt() {  // nextLong() would be implemented similarly
                 int c;
                 do {
                     c = nextByte();
                 } while (c <= ' ');

                 int sgn = 1;
                 if (c == '-') {
                     sgn = -1;
                     c = nextByte();
                 }

                 int res = 0;
                 do {
                     if (c < '0' || c > '9') {
                         throw new InputMismatchException();
                     }
                     res = 10 * res + c - '0';
                     c = nextByte();
                 } while (c > ' ');
                 return res * sgn;
             }

             public double nextDouble() { return Double.parseDouble(next()); }
         }
}