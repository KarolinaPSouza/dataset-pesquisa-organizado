import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author varunvats32
 */
public class entry_1681965 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ShortestRoutesII solver = new ShortestRoutesII();
        solver.solve(1, in, out);
        out.close();
    }

    static class ShortestRoutesII {
        static long[][] dist;
        static int n;
        static int m;
        static int q;
        static long INF = (long) 1e13;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            q = in.nextInt();
            dist = new long[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                a--;
                b--;
                dist[a][b] = Math.min(dist[a][b], c);
                dist[b][a] = Math.min(dist[a][b], c);
            }

            // pre-process
            for (int i = 0; i < n; i++) {
                // Relax the node i;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (j == k) continue;
                        if (ifGreater(dist[j][k], dist[j][i], dist[i][k])) {
                            dist[j][k] = dist[j][i] + dist[i][k];
                        }
                    }
                }
            }

            for (int i = 0; i < q; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                x--;
                y--;
                long ans = dist[x][y];
                out.println(ans == INF ? -1 : ans);
            }
        }

        private boolean ifGreater(long c, long a, long b) {
            if (a == INF || b == INF)
                return false;
            return c > a + b;
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
