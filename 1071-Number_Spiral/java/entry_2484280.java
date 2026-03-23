import java.util.*;
import java.io.*;

public class entry_2484280 {
    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());
        }

        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }
        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
        }
    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = r.nextInt();
        for (int i=0; i<t; i++) {
            valueFinder(r.nextLong(), r.nextLong());
        }
        pw.close();
    }

    private static void valueFinder(long x, long y) {;
        long result = 1;
        if (x > y || x == y) {
            if (x % 2 != 0) {
                result = x*x-((x-1l)*2)+(y-1);
            } else {
                result = x*x-y+1;
            }
        } else {
            if (y % 2 != 0) {
                result = y*y-x+1;
            } else {
                result = y*y-((y-1)*2)+(x-1);
            }
        }
        pw.println(result);
    }
}