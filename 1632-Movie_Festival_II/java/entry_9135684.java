import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class entry_9135684 {
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int testcases = 1;
        outer:
        for (int t = 0; t < testcases; t++) {
            int n = io.nextInt();
            int k = io.nextInt();
            Pair[] a = new Pair[n];
            for (int i = 0; i < n; i++)
                a[i] = new Pair(io.nextInt(), io.nextInt());
            Arrays.sort(a, Comparator.comparingInt(Pair -> Pair.b));
            int count = 0;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                Integer key = map.floorKey(a[i].a);
                if (key != null) {
                    k++;
                    int val = map.get(key);
                    if (val == 1)
                        map.remove(key);
                    else
                        map.put(key, val - 1);
                }
                if (k >= 1) {
                    map.put(a[i].b, map.getOrDefault(a[i].b, 0) + 1);
                    count++;
                    k--;
                }
            }
            io.println(count);
            io.close();
        }
    }

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

                if (numChars == -1) return -1;  // end of file

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

                if (c < '0' || c > '9') throw new InputMismatchException();

                res = 10 * res + c - '0';

                c = nextByte();

            } while (c > ' ');

            return res * sgn;

        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}