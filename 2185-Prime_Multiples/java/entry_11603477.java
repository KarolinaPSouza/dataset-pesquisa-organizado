import java.io.*;
import java.util.*;

public class entry_11603477 {

    static int[] bit;
    static long[] arr;
    static long N;
    static long answer;

    public static void main(String[] args) throws IOException {
//        BufferedReader br;
//        PrintWriter out;
//        StringTokenizer st;
//        try {
//            br = new BufferedReader(new FileReader("mootube.in"));
//            out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
//            st = new StringTokenizer(br.readLine());
//        } catch (Exception e) {
//            br = new BufferedReader(new InputStreamReader(System.in));
//            out = new PrintWriter(System.out);
//            st = new StringTokenizer(br.readLine());
//        }
//
//        out.close();

        FastIO in = new FastIO();
        N = Long.parseLong(in.next());
        int K = in.nextInt();
        arr = new long[K];
        answer = 0;
        for(int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(in.next());
        }

        bit = new int[K];
        bitRun(0);

        in.print(answer);
        in.close();
    }

    static void bitRun(int index) {
        if(index + 1 < bit.length) {
            bit[index] = 0;
            bitRun(index + 1);
            bit[index] = 1;
            bitRun(index + 1);
        } else {
            bit[index] = 0;
            int count = 0;
            long multiply = 1;
            for(int i = 0; i <= index; i++) {
                if(bit[i] == 1) {
                    if(N / multiply < arr[i]) {
                        multiply = 0;
                        break;
                    }
                    multiply *= arr[i];
                    count++;
                }
            }
            if(multiply != 0 && count > 0) {
                if(count % 2 == 0) {
                    answer -= (N / multiply);
                } else {
                    answer += (N / multiply);
                }
            }

            bit[index] = 1;
            count = 0;
            multiply = 1;
            for(int i = 0; i <= index; i++) {
                if(bit[i] == 1) {
                    if(N / multiply < arr[i]) {
                        multiply = 0;
                        break;
                    }
                    multiply *= arr[i];
                    count++;
                }
            }
            if(multiply != 0 && count > 0) {
                if(count % 2 == 0) {
                    answer -= (N / multiply);
                } else {
                    answer += (N / multiply);
                }
            }
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