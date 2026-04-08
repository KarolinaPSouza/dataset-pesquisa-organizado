import java.util.*;
import java.io.*;

public class entry_11908460 {
    public static void main(String[] args) throws IOException {
        FastIO io = new FastIO();
        int n = io.nextInt();
        int k = io.nextInt();

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            movies.add(new Movie(io.nextInt(), io.nextInt()));
        }

        Collections.sort(movies);

        TreeMap<Integer, Integer> endTimes = new TreeMap<>();
        endTimes.put(0, k);
        int ct = 0;
        for (Movie m : movies){
            Integer lower = endTimes.floorKey(m.getStart());
            if (lower != null){
                ct++;
                int lowVal = endTimes.get(lower);
                if (lowVal==1) endTimes.remove(lower);
                else endTimes.put(lower, lowVal-1);
                endTimes.put(m.getFinish(), endTimes.getOrDefault(m.getFinish(), 0)+1);
            }
        }
        io.println(ct);
        io.close();
    }

    static class Movie implements Comparable<Movie> {
        private int start;
        private int finish;

        public Movie(int s, int f) {
            start = s;
            finish = f;
        }

        public int getStart() {
            return start;
        }

        public int getFinish() {
            return finish;
        }

        public String toString(){
            return start+", "+finish;
        }

        @Override
        public int compareTo(Movie o) {
            if (finish == o.getFinish()) return start - o.getStart();
            return finish - o.getFinish();
        }
    }

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
}
