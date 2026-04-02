import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// https://cses.fi/problemset/task/1636
class Coin_Combinations_2 {
    private static final long MOD = (long) (Math.pow(10, 9)+7);
    /*
        dp[x][i] = total ways to get x as sum such that we only consider [i...n] coins (for ordering purposes)
         dp[x][i] = 
            pick coins[i] -> dp[x-coins[i]][i]
            dont pick -> dp[x][i + 1] (considers only i+1...n coins -> for ordering)
    */
    public long solve(int n, int[] coins, int sum) {
        long[][] dp = new long[sum + 1][n];
        for (int i = 0; i < n; ++i) {
            dp[0][i] = 1;
        }
        for (int s = 1; s <= sum; ++s) {
            for (int i = n - 1; i >= 0; --i) {
                if (coins[i] <= s) {
                    dp[s][i] += dp[s - coins[i]][i];
                }
                if (i + 1 < n) {
                    dp[s][i] += dp[s][i + 1];
                }
                dp[s][i] %= MOD;
            }
        }
        return dp[sum][0];
    }

    // at any point (s, i) we need (s - x, i) and (s, i + 1)
    // if we start from loop from s=1 to sum
    // we are storing dp[s][0] in dp[s] at the end. so we are losing information of (s-x, i)
    // so thats why iterate from i instead. dp[s][i] -> dp[s] and we can always get dp[s-x][i] from dp[s-x]
    public long solve_optimized(int n, int[] coins, int sum) {
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int s = 1; s <= sum; ++s) {
                long nextResult = dp[s];
                dp[s] = 0;
                if (coins[i] <= s) {
                    dp[s] += dp[s - coins[i]];
                }
                if (i + 1 < n) {
                    dp[s] += nextResult;
                }
                dp[s] %= MOD;
            }
        }
        return dp[sum];
    }
}

public class entry_10549472 {
    public static void main(final String[] args) throws IOException {
        final InputReader reader = new InputReader(System.in);
        int n = reader.readInt(), x = reader.readInt();
        System.out.println(new Coin_Combinations_2().solve_optimized(n, reader.readIntArray(n), x));
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