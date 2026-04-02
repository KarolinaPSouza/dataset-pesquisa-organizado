import java.io.*;
import java.util.*;

public class entry_1088729 extends PrintWriter {

    private void solve()  {
        int n = sc.nextInt();
        long x = sc.nextInt();
        long[] a = new long[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        HashMap<Long, int[]> map = new HashMap<>(); 
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                long sum = a[i]+a[j];
                if(map.containsKey(x-sum)) {
                    int[] others = map.get(x-sum);
                    println((i+1) + " " + (j+1) + " " + others[0] + " " + others[1]);
                    return;
                }
            }
            for(int j = 0; j < i; j++) {
                map.put(a[i]+a[j], new int[] {i+1, j+1});
            }
        }
        println("IMPOSSIBLE");
    }

//    entry_1088729() throws FileNotFoundException { super(new File("output.txt")); }
//    InputReader sc = new InputReader(new FileInputStream("test_input.txt"));
    entry_1088729() { super(System.out); }
    InputReader sc = new InputReader(System.in);
    static class InputReader {
        InputReader(InputStream in) { this.in = in; } InputStream in;

        private byte[] buf = new byte[16384];
        private int    curChar;
        private int    numChars;


        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }


    public static void main(String[] $) {
        new Thread(null, new Runnable() {
            public void run() {
                long start = System.nanoTime();
                try {entry_1088729 solution = new entry_1088729(); solution.solve(); solution.flush();} 
                catch (Exception e) {e.printStackTrace(); System.exit(1);}
                System.err.println((System.nanoTime()-start)/1E9);
            }
        }, "1", 1 << 27).start();

    }



}