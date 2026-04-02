import java.util.*;
import java.io.*;

public class entry_3349708 {
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

    static int[] coins;
    static int[] arr;
    static int m = (int) Math.pow(10, 9) + 7;
    static int n, x; //n is number of coins, x is desired sum

    public static void main(String[] args){
//        final long startTime = System.currentTimeMillis();
        FastIO io = new FastIO();
        n = io.nextInt(); x = io.nextInt();
        arr = new int[x+1]; coins = new int[n];

        for(int i = 0; i < n; i++){
            coins[i] = io.nextInt();
        }
        Arrays.sort(coins);

        arr[0] = 1;
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= x; i++){
                if(i-coins[j] >= 0){
                    arr[i] += arr[i-coins[j]];
                    arr[i] %= m;
                }
            }
//            for(int i = 1; i <= x; i++){
//                int k = i;
//                while(k >= 0){
//                    arr[j][i] += arr[j-1][k];
//                    arr[j][i] %= m;
//                    k -= coins[j];
//                }
//            }
        }

        io.println(arr[x]);
//        final long endTime = System.currentTimeMillis();
//        io.println(endTime - startTime);
        io.close();
    }

}