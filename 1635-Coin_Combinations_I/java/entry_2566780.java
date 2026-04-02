//package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class entry_2566780 {
    public static int[] dp = new int[0];
    public static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        int[] in1 = arrayInput();
        int n = in1[0];
        int target = in1[1];
        int[] coins = arrayInput();
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i = 1; i <= target; i++){
            for(int c: coins){
                if(c <= i){
                    int x = dp[i] + dp[i-c];
                    if(x >= mod){
                        x -= mod;
                    }
                    dp[i] = x;
                }
            }
        }

        bw.write(dp[target] + "\n");
        bw.flush();
        bw.close();
    }

    public static int[] arrayInput() {
        String[] x = io.nextLine().split(" ");
        int arr[] = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            arr[i] = Integer.parseInt(x[i]);
        }
        return arr;
    }

    public static int fastMod(int a, int b){
        return a & (b-1);
    }


    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static FastIO io = new FastIO();

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


}