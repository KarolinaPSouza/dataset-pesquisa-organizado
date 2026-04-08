import java.io.*;
import java.util.*;

public class entry_6494296 {

    public static void main(String[] args) throws IOException {
//        BufferedReader br;
//        PrintWriter out;
//        StringTokenizer st;
//        try {
//            br = new BufferedReader(new FileReader("rental.in"));
//            out = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
//            st = new StringTokenizer(br.readLine());
//        } catch (Exception e) {
//            br = new BufferedReader(new InputStreamReader(System.in));
//            out = new PrintWriter(System.out);
//            st = new StringTokenizer(br.readLine());
//        }

        FastIO io = new FastIO();
        int N = io.nextInt();
        int K = io.nextInt();

        ArrayList<Movie> movies = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            movies.add(new Movie(io.nextInt(), io.nextInt()));
        }
        movies.sort((Movie one, Movie two) -> one.end - two.end);

//        for(Movie m : movies) {
//            System.out.println(m.start + " " + m.end);
//        }

        TreeMap<Integer, Integer> watching = new TreeMap<>();
        int numAvailable = K;
        int answer = 0;
        for(int i = 0; i < N; i++) {
            int start = movies.get(i).start;
            int end = movies.get(i).end;

            if (watching.lowerKey(start + 1) != null) {
                if(watching.get(watching.lowerKey(start + 1)) == 1) {
                    watching.remove(watching.lowerKey(start + 1));
                } else {
                    watching.put(watching.lowerKey(start + 1), watching.get(watching.lowerKey(start + 1)) - 1);
                }

                if(watching.containsKey(end)) {
                    watching.put(end, watching.get(end) + 1);
                } else {
                    watching.put(end, 1);
                }

                answer++;
            } else if (numAvailable > 0) {
                answer++;
                if (watching.containsKey(end)) {
                    watching.put(end, watching.get(end) + 1);
                } else {
                    watching.put(end, 1);
                }
                numAvailable--;
            }
        }

        io.print(answer);
        io.close();
    }

    static class Movie {
        int start;
        int end;

        public Movie(int s, int e) {
            start = s;
            end = e;
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