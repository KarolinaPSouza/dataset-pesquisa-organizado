import java.util.*;
import java.io.*;

public class entry_7785708 {
    static class FastIO extends PrintWriter {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar, numChars;

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
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) { throw new InputMismatchException(); }
                if (numChars == -1) return -1;  // end of file
            }
            return buf[curChar++];
        }

        // to read in entire lines, replace c <= ' '
        // with a function that checks whether c is a line break
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

        public int nextInt() {  // nextLong() would be implemented similarly
            int c;
            do { c = nextByte(); } while (c <= ' ');
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = nextByte();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = 10 * res + c - '0';
                c = nextByte();
            } while (c > ' ');
            return res * sgn;
        }
        public double nextDouble() { return Double.parseDouble(next()); }
    }

    public static void main(String[] args) {
        new entry_7785708().run();
    }

    public class Movie implements Comparable<Movie> {
        long start, end;

        public Movie (long start, long end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo (Movie o) {
            if (end == o.end)
                return Long.compare(start, o.start);
            return Long.compare(end, o.end);
        }

        public String toString () {
            return start + " -> " + end;
        }
    }


    TreeMap<Long, Integer> watching;

    public void run () {
        FastIO f = new FastIO();

        int n = f.nextInt(), k = f.nextInt();
        PriorityQueue<Movie> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(new Movie((long)f.nextInt(), (long)f.nextInt()));
        }

        watching = new TreeMap<Long, Integer>();
        watching.put(0L, k);  // initialize all members at time 0

        int ans = 0, size = k;

        while (!pq.isEmpty()) {
            Movie cur = pq.poll();

            if (size < k) {
                add(cur.end);
                ans++;
                size++;
            } else if (cur.start >= watching.firstKey()) {
                long fl = watching.floorKey(cur.start);
                remove(fl);
                add(cur.end);
                ans++;
            }

//            System.out.println(cur + " " + watching);
        }

        f.println(ans);

        f.close();
    }

    public void add (long x) {
     if (watching.containsKey(x)) {
            watching.put(x, watching.get(x) + 1);
     } else {
            watching.put(x, 1);
     }
    }

    public void remove (long x) {
        watching.put(x, watching.get(x) - 1);
     if (watching.get(x) == 0) { watching.remove(x); }
    }

}