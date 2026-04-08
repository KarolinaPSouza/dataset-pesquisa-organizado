import javax.print.DocFlavor;
import java.util.*;
import java.io.*;

import java.io.IOException;

public class entry_11886273 {
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
            FastIO in=new FastIO();
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            int ans = 0;
            Arrays.sort(arr, (a, b) ->a[1]==b[1]?a[0]-b[0]: a[1]- b[1]);
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                Integer t = map.floorKey(arr[i][0]);
                if(t!=null) {
                    ++k;
                    map.put(t, map.get(t)-1);
                    if(map.get(t)==0) {map.remove(t);}
                }
                if(k>0){
                    ++ans;
                    --k;
                    map.put(arr[i][1], map.getOrDefault(arr[i][1], 0)+1);
                }
            }

            in.println(ans);
            in.close();
        } catch (Exception e) {
            return;
        }
    }

    public static boolean check(int[] arr, long m, int k) {
        long sum = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            if(sum>m){
                ++count;
                sum = arr[i];
            }
        }
        ++count;
        return count<=k;
    }
}