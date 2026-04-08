import java.io.*;
import java.util.*;
import java.util.function.*;

public class entry_8679662 {
    static int solve(int[][] A, int n, int k) {
        Arrays.sort(A, (a,b) -> a[1] - b[1]); 
        var sl = new TreeMap<Integer, Integer>(); 
        sl.put(0, k); 
        var ans = 0; 
        for(var a: A) {
            var ql = a[0]; 
            var qr = a[1];
            var floor = sl.floorKey(ql); 
            if(floor != null) {
                sl.merge(floor, -1, Integer::sum); 
                sl.remove(floor, 0); 
                sl.merge(qr, +1, Integer::sum);  
                ans++; 
            }
        }
        return ans; 
    }

    static int bisect(int lo, int hi, Predicate<Integer> predicate) {
  while(lo < hi) {
   var mi = (lo+hi) >>> 1;
   if(predicate.test(mi)) {
    lo = mi+1;
   } else {
    hi = mi;
   }
  }
  return lo;
 }
    public static void main(String[] args) throws Exception {
        var io = new FastIO(); 
        var n = io.nextInt(); 
        var k = io.nextInt(); 
        var A = new int[n][2]; 
        for(var i = 0; i < n; i++) {
            A[i][0] = io.nextInt()-1;
            A[i][1] = io.nextInt()-1;
        }
        var ans = solve(A, n, k); 
        io.println(ans);
        io.close(); 
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        // standard input
        public FastIO() { 
            this(System.in, System.out); 
        }
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
        public int[] nextIntArray(int n) {
            var ans = new int[n]; 
            for(var i = 0; i < n; i++) {
                ans[i] = nextInt(); 
            }
            return ans;
        }
        public double nextDouble() { 
            return Double.parseDouble(next()); 
        }
    }
}