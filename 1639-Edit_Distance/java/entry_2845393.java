import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Manav
 */
public class entry_2845393 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        EditDistance solver = new EditDistance();
        solver.solve(1, in, out);
        out.close();
    }

    static class EditDistance {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            String x = in.next(), y = in.next();
            int n = x.length(), m = y.length();
            int[][] cache = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                cache[i][0] = i;
            }
            for (int i = 0; i <= m; i++) {
                cache[0][i] = i;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (x.charAt(i - 1) == y.charAt(j - 1)) {
                        cache[i][j] = cache[i - 1][j - 1];
                    } else {
                        cache[i][j] = 1 + Math.min(Math.min(cache[i - 1][j], cache[i][j - 1]), cache[i - 1][j - 1]);
                    }
                }
            }
            out.println(cache[n][m]);
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
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

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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

        public String next() {
            return nextString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}
