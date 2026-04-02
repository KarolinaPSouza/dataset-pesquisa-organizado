import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Edit_Distance {
    public long solve(String source, String target) {
        // return recurse(source, 0, source.length(), target, 0, target.length());
        return iterative(source, target);
    }

    // (i, j) = min moves to convert (i...n) -> (j...m)
    private long recurse(String source, int i, int n, String target, int j, int m) {
        if (i == n && j == m) {
            return 0;
        }
        if (i == n) {
            // min moves to convert "" to target[j....m]. add all chars
            return (m - j);
        }
        if (j == m) {
            // min moves to convert source[I....n] to "". remove all chars
            return (n - i);
        }

        // if char already same then dont do anything
        if (source.charAt(i) == target.charAt(j)) {
            return recurse(source, i + 1, n, target, j + 1, m);
        }
        //replace, remove, add at current index
        return 1 + Math.min(
            recurse(source, i + 1, n, target, j + 1, m), 
            Math.min(recurse(source, i + 1, n, target, j, m), recurse(source, i, n, target, j + 1, m))
        );
    }

    private long iterative(String source, String target) {
        int n = source.length(), m = target.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int c = 0; c <= m; ++c) {
            dp[n][c] = (m - c);
        }
        for (int r = 0; r <= n; ++r) {
            dp[r][m] = (n - r);
        }
        dp[n][m] = 0;
        for (int r = n - 1; r >= 0; --r) {
            for (int c = m - 1; c >= 0; --c) {
                if (source.charAt(r) == target.charAt(c)) {
                    dp[r][c] = dp[r + 1][c + 1];
                } else {
                    dp[r][c] = 1 + Math.min(
                        dp[r + 1][c + 1],
                        Math.min(dp[r + 1][c], dp[r][c + 1])
                    );
                }
            }
        }
        return dp[0][0];
    }
}

public class entry_10554599 {

    public static void main(final String[] args) throws IOException {
        final InputReader reader = new InputReader(System.in);
        System.out.println(new Edit_Distance().solve(reader.readString(), reader.readString()));
    }

    // Helper Methods
    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];

        private int curChar;

        private int numChars;

        // we see System.in as input stream for this object
        public InputReader(final InputStream stream) {
            this.stream = stream;
        }

        public char readChar() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        // returns a single character
        public int read() {
            if (numChars == -1)
                throw new RuntimeException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (final IOException e) {
                    throw new RuntimeException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String readString() {
            final StringBuilder stringBuilder = new StringBuilder();
            int c = read();
            while (isSpaceChar(c))
                c = read();
            do {
                stringBuilder.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return stringBuilder.toString();
        }

        public int[] readIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = readInt();
            }
            return arr;
        }

        public int readInt() {
            int c = read();
            // if space character then ignore it. we can define what is space character is
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(final int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}