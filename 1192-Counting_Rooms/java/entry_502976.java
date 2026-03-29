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
import java.util.ArrayDeque;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author unknown
 */
public class entry_502976 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        CountingRooms solver = new CountingRooms();
        solver.solve(1, in, out);
        out.close();
    }

    static class CountingRooms {
        static int n;
        static int m;
        static int[][] map;
        static boolean[][] vis;
        static int[] dx;
        static int[] dy;
        static int newx;
        static int newy;

        static public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            map = new int[n][m];
            vis = new boolean[n][m];
            dx = new int[]{-1, 0, 1, 0};
            dy = new int[]{0, 1, 0, -1};
            for (int i = 0; i < n; i++) {
                String s = in.readLine();
                for (int j = 0; j < s.length(); j++) {
                    map[i][j] = s.charAt(j) == '#' ? 0 : 1;
                }
            }
            int rooms = 0;
//        debug(map);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1 && !vis[i][j]) {
                        vis[i][j] = true;
                        bfs(i, j);
                        rooms++;
                    }
                }
            }
            out.println(rooms);
        }

        static void bfs(int xx, int yy) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            queue.addLast(xx);
            queue.addLast(yy);
            while (!queue.isEmpty()) {
                int x = queue.removeFirst();
                int y = queue.removeFirst();
                for (int i = 0; i < 4; i++) {
                    newx = x + dx[i];
                    newy = y + dy[i];
                    if (isValid(newx, newy)) {
                        vis[newx][newy] = true;
                        queue.addLast(newx);
                        queue.addLast(newy);
                    }
                }
            }
        }

        static boolean isValid(int x, int y) {
            if (x < 0 || x >= n) {
                return false;
            }
            if (y < 0 || y >= m) {
                return false;
            }
            return map[x][y] == 1 && !vis[x][y];
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

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
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

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

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

        public void println(long i) {
            writer.println(i);
        }

    }
}
