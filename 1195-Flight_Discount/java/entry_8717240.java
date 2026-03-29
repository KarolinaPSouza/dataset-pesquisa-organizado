import java.io.*;
import java.util.*;

public class entry_8717240 {
    static long INF = (long) 1e14+1; 

    static long solve(int n, int[][] E, int m) {
        var G = new AdjList[2][n];
        Arrays.setAll(G, __ -> AdjList.of(n)); 
        for(var e: E) {
            var u = e[0]; 
            var v = e[1];
            var w = e[2];
            G[0][u].add(new int[] {0, v, w}); 
            G[1][u].add(new int[] {1, v, w}); 
            G[0][u].add(new int[] {1, v, w/2}); 
        }
        var D = new long[2][n];
        Arrays.fill(D[0], INF);
        Arrays.fill(D[1], INF); 
        var pq = new PriorityQueue<long[]>((a,b) -> a[0] < b[0] ? -1 : a[0] > b[0] ? +1 : 0); 
        D[0][0] = 0; 
        pq.offer(new long[] {0, 0, 0}); // state = {distance, # of discounts applied so far [0|1], node}
        while(!pq.isEmpty()) {
            long d = pq.peek()[0]; 
            var y = (int) pq.peek()[1];
            var u = (int) pq.peek()[2]; 
            pq.poll(); 
            if(D[y][u] < d) {
                continue; 
            }
            // if(D[0][n-1] < d || D[1][n-1] < d) {
            //     continue; 
            // }
            for(var vw: G[y][u]) {
                var z = vw[0];
                var v = vw[1]; 
                var w = vw[2]; 
                long alt = d + w; 
                if(alt < D[z][v]) {
                    D[z][v] = alt; 
                    // if(v != n-1 && !G[z][v].isEmpty()) {
                        pq.offer(new long[] {alt, z, v}); 
                    // } 
                }
            }
        }
        return min(D[0][n-1], D[1][n-1]); 
    }
    public static void main(String[] args) throws Exception {
        var io = new FastIO(); 
        var n = io.nextInt(); 
        var m = io.nextInt(); 
        var E = io.nextIntArray(m, 3, new int[] {-1, -1, 0}); 
        var ans = solve(n, E, m); 
        io.println(ans); 
        io.close(); 
    }

    static long min(long a, long b) { return Math.min(a,b); }
    static class AdjList extends ArrayList<int[]> {
        static AdjList[] of(int n) {
            var ans = new AdjList[n]; 
            Arrays.setAll(ans, __ -> new AdjList()); 
            return ans; 
        }
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