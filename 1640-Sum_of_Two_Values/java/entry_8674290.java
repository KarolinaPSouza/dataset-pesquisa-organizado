import java.io.*;
import java.util.*;

public class entry_8674290 {
    static int[] solve(int[] A, int n, int target) {
        var seen = new HashMap<Integer, Integer>(); 
        for(var j = 0; j < n; j++) {
            var key = target-A[j]; 
            if(seen.containsKey(key)) {
                var i = seen.get(key); 
                return new int[] {i, j};
            }
            seen.put(A[j], j); 
        }
        return null; 
    }
    public static void main(String[] args) throws Exception {
        var io = new FastIO(); 
        var n = io.nextInt(); 
        var x = io.nextInt(); 
        var A = io.nextIntArray(n); 
        var ans = solve(A, n, x); 
        if(ans == null) {
            io.println("IMPOSSIBLE"); 
        } else {
            io.printf("%d %d", ans[0]+1, ans[1]+1); 
        }
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