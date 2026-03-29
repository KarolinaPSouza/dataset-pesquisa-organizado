import java.io.*;
import java.util.*;
import java.util.function.Predicate; 

public class entry_8708889 {
    static long solve(int[][] A, int n) {
        Arrays.sort(A, Comparator.comparing((int[] a) -> a[0]));
        var dp = new long[n+1]; 
        for(var i = n-1; i >= 0; i--) {
            var _i = i; 
            var j = bisect(i+1, n, (_j) -> A[_j][0] < A[_i][1]); 
            dp[i] = max(dp[i+1], A[i][2] + dp[j]); 
        }
        return dp[0]; 
    }
    public static void main(String[] args) throws Exception {
        var io = new FastIO(); 
        var n = io.nextInt(); 
        var A = io.nextIntArray(n, 3, new int[] {-1,0,0}); 
        var ans = solve(A, n); 
        io.println(ans); 
        io.close(); 
    }

    static long max(long a, long b) { return Math.max(a,b); }
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
    static class FastIO extends PrintWriter {
        // private static char SPACE = 0x20; 
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
        public String nextString() {
            int c;
            do { 
                c = nextByte(); 
            } while (c <= ' ');
            var res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }
        public String nextLine() {
            int c;
            do { 
                c = nextByte(); 
            } while (c <= '\n');
            var res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > '\n');
            return res.toString();
        }
        public int nextInt() {  // nextLong() would be implemented similarly
            int c;
            do { 
                c = nextByte(); 
            } while (c <= ' ');
            var sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            var res = 0;
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
        public int[][] nextIntArray(int n, int m, int[] offset) {
            var ans = new int[n][m]; 
            for(var i = 0; i < n; i++) {
                for(var j = 0; j < m; j++) {
                    ans[i][j] = nextInt() + offset[j]; 
                }
            }
            return ans;
        }
        public double nextDouble() { 
            return Double.parseDouble(nextString()); 
        }
        public void println(int[] A, char separator) {
            var sb = new StringBuffer(); 
            for(var a: A) {
                sb.append(a).append(separator); 
            }
            println(sb); 
        }
        public void println(long[] A, char separator) {
            var sb = new StringBuffer(); 
            for(var a: A) {
                sb.append(a).append(separator);
            }
            println(sb); 
        }
    }
}