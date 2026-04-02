import java.io.*;
import java.util.*;

public class entry_8774910 {
    static int[][] solve(int n, int[][] E, int m) {
        var dsu = new DSU(n); 
        var i = 0; 
        for( ; i < m; i++) {
            var e = E[i]; 
            var u = e[0]; 
            var v = e[1]; 
            if(dsu.connected(u, v)) {
                // System.out.printf("u=%d\tv=%d%n", u+1, v+1);
                break;
            }
            dsu.union(u, v); 
        }
        if(i == m) {
            return null; 
        }
        List<Integer>[] G = new ArrayList[n]; 
        Arrays.setAll(G, __ -> new ArrayList<>()); 
        for(var j = 0; j < i; j++) {
            var e = E[j]; 
            var u = e[0]; 
            var v = e[1]; 
            if(dsu.connected(u, E[i][0])) {
                G[u].add(v); 
                G[v].add(u); 
            }
        }
        var P = new int[n]; 
        Arrays.fill(P, -1); 
        var q = new ArrayDeque<Integer>(); 
        var seen = new boolean[n]; 
        seen[ E[i][0] ] = true; 
        q.offer(E[i][0]); 
        while(!q.isEmpty()) {
            var u = q.peek(); 
            q.poll(); 
            if(u == E[i][1]) {
                break; 
            }
            for(var v: G[u]) {
                if(!seen[v]) {
                    seen[v] = true; 
                    P[v] = u; 
                    q.offer(v); 
                }
            }
        }
        var ans = new LinkedList<Integer>(); 
        ans.addFirst(E[i][0]);
        for(var v = E[i][1]; v != -1; v = P[v]) {
            ans.addFirst(v); 
        }
        return new int[][] {{ans.size()}, ans.stream().mapToInt(Integer::intValue).toArray()}; 
    }
    public static void main(String[] args) throws Exception {
        var io = new FastIO(); 
        var n = io.nextInt(); 
        var m = io.nextInt();
        var E = io.nextIntArray(m, 2, new int[] {-1,-1}); 
        var ans = solve(n, E, m); 
        if(ans == null) {
            io.println("IMPOSSIBLE");
        } else {
            io.println(ans[0][0]);
            io.println(ans[1], +1, (char) 0x20);
        }
        io.close(); 
    }

    static class DSU {
        int n, root[], size[]; 

        DSU(int n) {
            this.n = n; 
            this.root = new int[n]; 
            this.size = new int[n]; 
            Arrays.setAll(root, u -> u); 
            Arrays.fill(size, 1); 
        }
        int find(int u) {
            if(root[u] != u) {
                root[u] = find( root[u] ); 
            }
            return root[u]; 
        }
        void union(int u, int v) {
            u = find(u); 
            v = find(v); 
            if(u != v) {
                if(size[u] >= size[v]) {
                    root[v] = u; 
                    size[u] += size[v]; 
                } else {
                    root[u] = v; 
                    size[v] += size[u]; 
                }
            }
        }
        boolean connected(int u, int v) {
            u = find(u);
            v = find(v); 
            return u == v; 
        }
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