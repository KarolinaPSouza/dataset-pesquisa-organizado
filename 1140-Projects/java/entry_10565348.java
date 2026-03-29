import java.io.*;
import java.math.BigInteger;
import java.util.*;

// https://cses.fi/problemset/task/1140
class Projects {
    public long solve(int n, int[][] arr) {
        return iterative_most_optimized(n, arr);
    }

    private long iterative(int n, int[][] arr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0][2];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });

        long[] dp = new long[arr[n - 1][0] + 1];
        //dp[i] = max amount of money if start time is 'i'

        dp[arr[n - 1][0]] = arr[n - 1][1];
        for (int i = arr[n - 1][0] - 1; i >= arr[0][0]; --i) {
            for (int k = 0; k < n; ++k) {
                if (i <= arr[k][0]) {
                    dp[i] = Math.max(dp[i], arr[k][2] + (arr[k][1] + 1 < dp.length ? dp[arr[k][1] + 1] : 0));
                }
            }
        }

        return dp[arr[0][0]];
    }

    // start time can go till 10^9 storing long values ~ 8GB memory.. so too much
    // so instead try to use dp[n] since its till 10^5
    private long iterative_optimized(int n, int[][] arr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0][2];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });

        long[] dp = new long[n];
        //dp[i] = max amount of money in [0..i] projects and ending with ith project

        dp[0] = arr[0][2];
        long result = arr[0][2];
        for (int i = 1; i < n; ++i) {
            dp[i] = arr[i][2];
            for (int j = 0; j < i; ++j) {
                if (arr[j][1] < arr[i][0]) {
                    dp[i] = Math.max(arr[i][2] + dp[j], dp[i]);
                }
            }
            result = Math.max(dp[i], result);
        }

        return result;
    }
    /*
    IMPPPPPPP
      we cant convert inner loop into binary search because projects are sorted by start time.. 
     if lets say for some index j = 0 to i
        if overlapping, I don't know for certain whether all next index projects overlaps also because their end time could be different
         so if we sort by end time then we could be sure
        if not overlapping, then all previous wont overlap because previous end < not overlapping project wala end
         even after this it won't work because of way we defined our subproblem. this is one problem in LIS implementation. we have defined dp[i] as ending at ith not the most optimal
         instead consider
            dp[i] = max money from [0..i] projects (doesnt matter includes i or not)
                so at ith project -> we have choice to include which means search for just the previous non-overlapping project and get its dp becaue thats guarenteed to be max till that index
                                    other choice is to exclude which means dp[i - 1]
     */
    private long iterative_most_optimized(int n, int[][] arr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0][2];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            } else if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[2], b[2]);
            }
        });

        long[] dp = new long[n];
        //dp[i] = max amount of money in [0..i] projects

        dp[0] = arr[0][2];
        for (int i = 1; i < n; ++i) {
            // include | exclude
            int previousNonOverlappingIndex = getPreviousNonOverlappingIndexForIthProject(i, arr[i][0], arr);
            dp[i] = Math.max(arr[i][2] + (previousNonOverlappingIndex != -1 ? dp[previousNonOverlappingIndex] : 0), dp[i - 1]);
        }

        return dp[n - 1];
    }

    /*
        f(mid) = if non-overlapping then true
         TTTTTFFFFF -> get last T
     */
    private int getPreviousNonOverlappingIndexForIthProject(int i, int startTime, int[][] arr) {
        int low = 0, high = i - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid][1] < startTime) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}

public class entry_10565348 {
    public static void main(final String[] args) throws IOException {
        final InputReader reader = new InputReader(System.in);
        int n = reader.readInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; ++i) {
            arr[i][0] = reader.readInt();
            arr[i][1] = reader.readInt();
            arr[i][2] = reader.readInt();
        }
        System.out.println(new Projects().solve(n, arr));
    }

    public static void solve (int n, int m, int[][] matrix) {
        int[][][] dp = new int[n][m][5000];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int j = 0; j < m; ++j) {
            dp[n - 1][j][matrix[n - 1][j]] = j;
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < m; ++j) {
                // consider matrix[i][j], try to find some xor with some other value
                int nextRow = i + 1;
                for (int k = 0; k <= 2500; ++k) {
                    for (int nextRowCol = 0; nextRowCol < m; ++nextRowCol) {
                        if (dp[nextRow][nextRowCol][k] != -1 || k == matrix[i][j]) {
                            continue;
                        }
                        int xor = matrix[i][j] ^ k;
                        if (xor > 0) {
                            dp[i][j][xor] = nextRowCol;
                        }
                    }
                }
            }
        }

        for (int j = 0; j < m; ++j) {
            for (int k = 1; k <= 1024; ++k) {
                if (dp[0][j][k] != -1) {
                    // found answer
                    System.out.println("TAK");
                    int row = 0, col = j, xor = k;
                    while (row < n) {
                        System.out.print((col + 1) + " ");
                        col = dp[row][col][k];
                        row++;
                    }
                    return;
                }
            }
        }

        System.out.println("NIE");
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