import java.io.*;
import java.util.*;

class FastIO extends PrintWriter {
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
                return -1; // end of file
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

/**
 * Test
 */
public class entry_8146639 {

    public static void main(String[] args) throws IOException {
        // FastIO io = new FastIO("time.in", "time.out");
        FastIO io = new FastIO();
        int n = io.nextInt();
        int m = io.nextInt();
        int q = io.nextInt();

        long[][] dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j)
                    dp[i][j] = -1;
            }
        }

        for (; m > 0; m--) {
            int a = io.nextInt();
            int b = io.nextInt();
            long c = io.nextInt();
            a--;
            b--;
            dp[a][b] = dp[a][b] != -1 ? Math.min(dp[a][b], c) : c;
            dp[b][a] = dp[a][b];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] != -1 && dp[k][j] != -1 && (dp[i][j] > dp[i][k] + dp[k][j] || dp[i][j] == -1)) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        for (; q > 0; q--) {
            int a = io.nextInt();
            int b = io.nextInt();
            io.println(dp[--a][--b]);
        }
        io.close();

    }
}