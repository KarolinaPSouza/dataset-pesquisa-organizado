import javax.print.DocFlavor;
import java.util.*;
import java.io.*;

import java.io.IOException;

public class entry_12026972 {
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


        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    public static void main(String[] args) {
        try {
            FastIO in = new FastIO();
            int n = in.nextInt();
            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
                arr[i][2] = in.nextInt();
            }
            TreeMap<Integer, Long> map = new TreeMap<>();
            map.put(0, 0L);
            Arrays.sort(arr, (a, b) -> a[1] - b[1]);
            for (int i = 0; i < n; i++) {
                Integer k = map.lowerKey(arr[i][0]);
                map.put(arr[i][1], Math.max(arr[i][2] + map.get(k), map.lastEntry().getValue()));
            }
            in.println(map.lastEntry().getValue());
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    public static int helper(int[][] arr, int n, int prev, int[][] dp) {
        if(n<0) return 0;

        if(dp[n][prev]!=-1) return dp[n][prev];

        int a = arr[n][0]>arr[prev][1]?helper(arr, n-1, n, dp)+arr[n][2]: 0;
        int b = helper(arr, n-1, prev, dp);

        return dp[n][prev] = Math.max(a, b);
    }
}