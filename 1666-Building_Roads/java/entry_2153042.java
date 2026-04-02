import java.awt.*;
import java.io.*;
import java.util.*;

public class entry_2153042 {

    public static void main(String[] args) throws Exception {
        solve();
        io.close();
    }

    private static void solve() throws Exception {
        int n = io.nextInt();
        int m = io.nextInt();
        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            dsu.union(a - 1, b - 1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(dsu.findParent(i), i);
        }

        int k = dsu.findParent(0);
        io.println(map.size() - 1);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getKey() == k) {
                continue;
            }
            io.println((e.getKey() + 1) + " " + (k + 1));
        }
    }

    static class DSU {
        int[] parents;
        int groups;

        DSU(int n) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            groups = n;
        }

        boolean union(int a, int b) {
            int pa = findParent(a);
            int pb = findParent(b);
            if (pa == pb) return false;
            parents[pa] = pb;
            groups--;
            return true;
        }

        int findParent(int a) {
            if (parents[a] != a) {
                parents[a] = findParent(parents[a]);
            }
            return parents[a];
        }

    }

    static int compare(int[] a, int v0, int v1) {
        if (a[0] == v0) {
            return Integer.compare(a[1], v1);
        }
        return Integer.compare(a[0], v0);
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>(a.length);
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    //-----------PrintWriter for faster output---------------------------------
    public static FastIO io = new FastIO();

    //-----------MyScanner class for faster input----------
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

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
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars == -1) return -1; // end of file
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

        public String nextLine() {
            int c;
            do {
                c = nextByte();
            } while (c < '\n');
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > '\n');
            return res.toString();
        }

        public int nextInt() { // nextLong() would be implemented similarly
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
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
    //--------------------------------------------------------
}