import java.util.*;
import java.io.*;

public class entry_7829711 {
    class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public FastIO() { this(System.in, System.out); }

        public FastIO(InputStream i, OutputStream o) {
            super(o);
            stream = i;
        }

        public FastIO(String i, String o) throws IOException {
            super(new FileWriter(o));
            stream = new FileInputStream(i);
        }

        private int nextByte() {
            if (numChars == -1) { throw new InputMismatchException(); }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) { throw new InputMismatchException(); }
                if (numChars == -1) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String next() {
            int c;
            do { c = nextByte(); } while (c <= ' ');

            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = nextByte();
            } while (c > ' ');
            return res.toString();
        }

        public int nextInt() {
            int c;
            do { c = nextByte(); } while (c <= ' ');

            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9') { throw new InputMismatchException(); }
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }

        public long nextLong() {
            long c;
            do { c = nextByte(); } while (c <= ' ');

            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }

            long res = 0;
            do {
                if (c < '0' || c > '9') { throw new InputMismatchException(); }
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }


        public double nextDouble() { return Double.parseDouble(next()); }
    }

    public static void main(String[] args) {
        new entry_7829711().run();
    }

    public void run () {
        FastIO f = new FastIO();

        int N = f.nextInt();
        ArrayList<Integer>[] g = new ArrayList[N];

        for (int i = 0; i < N; i++)
            g[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            int a = f.nextInt()-1, b = f.nextInt()-1;
            g[a].add(b); g[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0); q.add(-1);

        int farthest = -1;

        while (!q.isEmpty()) {
            int c = q.poll(), p = q.poll();
            farthest = c;
            for (int e : g[c]) {
                if (e != p) {
                    q.add(e); q.add(c);
                }
            }
        }

        int k = 0;
        q = new LinkedList<>();
        q.add(farthest); q.add(-1); q.add(0);

        while (!q.isEmpty()) {
            int c = q.poll(), p = q.poll(), l = q.poll();

            k = Math.max(k, l);
            for (int e : g[c]) {
                if (e != p) {
                    q.add(e); q.add(c); q.add(l+1);
                }
            }
        }

        f.println(k);
        f.close();
    }
}