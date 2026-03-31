import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author varunvats32
 */
public class entry_565394 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        RestaurantCustomers solver = new RestaurantCustomers();
        solver.solve(1, in, out);
        out.close();
    }

    static class RestaurantCustomers {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            List<Integer> s = new ArrayList<>(n);
            List<Integer> e = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                s.add(in.nextInt());
                e.add(in.nextInt());
            }

            Collections.sort(s);
            Collections.sort(e);

            int ei = 0, sj = 0, count = 0, mc = Integer.MIN_VALUE;


            while (ei < n && sj < n) {
                if (s.get(sj) < e.get(ei)) {
                    count++;
                    mc = Math.max(mc, count);
                    sj++;
                } else {
                    count--;
                    ei++;
                }
            }

            out.println(mc);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[16384];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}
