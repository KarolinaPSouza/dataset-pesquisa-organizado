import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Roy
 */
public class entry_4290163 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        BookShop solver = new BookShop();
        solver.solve(1, in, out);
        out.close();
    }

    static class BookShop {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInteger();
            int x = in.readInteger();

            List<KnapsackItem> itemList = new ArrayList<>();
            List<Integer> prices = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int p = in.readInteger();
                prices.add(p);
            }
            List<Integer> pages = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int p = in.readInteger();
                pages.add(p);
            }
            int[][] dp = new int[n + 1][x + 1];
            for (int i = 1; i <= n; i++) {
                int price = prices.get(i - 1), page = pages.get(i - 1);
                for (int a = 1; a <= x; a++) {
                    dp[i][a] = (price <= a)
                            ? Math.max(page + dp[i - 1][a - price], dp[i - 1][a])
                            : dp[i - 1][a];
                }
            }
            out.printLine(dp[n][x]);
        }

    }

    static class KnapsackItem {
        public final int weight;
        public final int value;

        private KnapsackItem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

    }

    static class InputReader {
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;
        private final InputStream stream;
        private final byte[] buf = new byte[1024];

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private long readWholeNumber(int c) {
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res;
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

        public int readInteger() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = (int) readWholeNumber(c);
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);

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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            this.print(objects);
            writer.println();
        }

        public void close() {
            writer.flush();
            writer.close();
        }

    }
}
