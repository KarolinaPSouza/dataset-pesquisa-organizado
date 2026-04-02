import java.io.*;
import java.util.*;

public class entry_8749282 {
    public static void main(String[] args) throws Exception {
        final FastIO io = new FastIO(); 
        final long n = io.nextLong(); 
        final int m = io.nextInt(); 
        final long[] A = io.nextLongArray(m); 
        var end = 1 << m; 
        long ans = 0; 
        for(var mask = 1; mask < end; mask++) {
            long acc = 1;
            var k = 0;
            for(var i = 0; i < m; i++) {
                if(((mask >> i) & 1) == 1) {
                    if(n / acc < A[i]) {
                        acc = 0;
                        break; 
                    }
                    acc *= A[i]; 
                    k++; 
                }
            }
            ans += acc == 0 ? 0 : (k % 2 == 1 ? +1 : -1) * n / acc;
        }
        io.println(ans); 
        io.close(); 
    }

    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public FastIO() { // standard input
            this(System.in, System.out); 
        }
        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }
        public FastIO(String i, String o) throws IOException { // file input
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }
        private int nextByte() { // throws InputMismatchException() if previously detected end of file
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
        public long nextLong() throws IOException {
            long ret = 0;
            int c = nextByte();
            while (c <= ' ') {
                c = nextByte();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = nextByte();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = nextByte()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
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
        public long[] nextLongArray(int n) throws IOException {
            var ans = new long[n]; 
            for(var i = 0; i < n; i++) {
                ans[i] = nextLong(); 
            }
            return ans;
        }
        public double nextDouble() { 
            return Double.parseDouble(nextString()); 
        }
        public void println(int[] A, char separator) {
            println(A, 0, separator); 
        }
        public void println(int[] A, int offset, char separator) {
            var sb = new StringBuffer(); 
            for(var a: A) {
                sb.append( a+offset ).append(separator); 
            }
            println(sb); 
        }
        public void println(long[] A, char separator) {
            println(A, 0, separator); 
        }
        public void println(long[] A, long offset, char separator) {
            var sb = new StringBuffer(); 
            for(var a: A) {
                sb.append( a+offset ).append(separator);
            }
            println(sb); 
        }
    }
}