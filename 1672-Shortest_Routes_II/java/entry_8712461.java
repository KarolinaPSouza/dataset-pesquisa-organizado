import java.io.*;
import java.util.*;

public class entry_8712461 {
    static long INF = (long) 5e11+1;

    static long[] solve(int n, int[][] E, int m, int[][] Q, int o) {
        var D = new long[n][n]; 
        for(var u = 0; u < n; u++) {
            Arrays.fill(D[u], INF); 
            D[u][u] = 0; 
        }
        for(var e: E) {
            var u = e[0]; 
            var v = e[1];
            var w = e[2]; 
            D[u][v] = D[v][u] = min(D[u][v], w); 
        }
        for(var w = 0; w < n; w++) {
            for(var u = 0; u < n; u++) {
                for(var v = 0; v < n; v++) {
                    D[u][v] = min(D[u][v], D[u][w] + D[w][v]); 
                }
            }
        }
        var ans = new long[o];
        for(var k = 0; k < o; k++)  {
            var q = Q[k]; 
            var u = q[0]; 
            var v = q[1]; 
            ans[k] = D[u][v] == INF ? -1 : D[u][v];
        }
        return ans; 
    }
    public static void main(String[] args) throws Exception {
        var io = new FastIO(); 
        var n = io.nextInt(); 
        var m = io.nextInt(); 
        var o = io.nextInt(); 
        var E = io.nextIntArray(m, 3, new int[] {-1,-1, 0}); 
        var Q = io.nextIntArray(o, 2, new int[] {-1,-1});
        var ans = solve(n, E, m, Q, o);
        io.println(ans, '\n'); 
        io.close(); 
    }

    static long min(long a, long b) { return Math.min(a,b); }
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