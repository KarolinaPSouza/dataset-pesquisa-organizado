import java.util.*;
import java.io.*;

@SuppressWarnings("unchecked")
public class entry_6683898 {
    public static void main(String[] args) throws IOException{
        FastIO io = new FastIO();
        StringBuilder sb = new StringBuilder();
        int n = io.nextInt(); int m = io.nextInt();

        ArrayList<int[]>[] connections = new ArrayList[n];
        long[] dist = new long[n]; Arrays.fill(dist, Long.MAX_VALUE); dist[0] = 0;
        PriorityQueue<long[]> cur = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        for (int i = 0; i < n; i++) {
            connections[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = io.nextInt() - 1; 
            int b = io.nextInt() - 1;
            int c = io.nextInt();
            connections[a].add(new int[]{b, c});
        }
        cur.add(new long[]{0, 0});
        while(!cur.isEmpty()){
            long[] x = cur.poll();
            int node = (int)x[0];
            long d = x[1];
            if(dist[node] < d){
                continue;
            }
            for(int[] e : connections[node]){
                if(dist[node] + e[1] < dist[e[0]]){
                    dist[e[0]] = dist[node] + e[1];
                    cur.add(new long[]{e[0], dist[e[0]]});
                }
            }
        }
        for(long e : dist){
            sb.append(e).append(" ");
        }
        io.println(sb);
        io.close();
    }
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

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