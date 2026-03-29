import java.io.*;
import java.util.*;

public class entry_15389323 {

    static FastReader fr = new FastReader();

    public static void main(String[] z) throws IOException {

        int n = fr.nextInt();

        int[] start, end;
        long[] val;

        Integer[] indices;
        start = new int[n];
        end = new int[n];
        val = new long[n];
        indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            int brr[] = fr.nextIntArray(3);
            start[i] = brr[0];
            end[i]   = brr[1];
            val[i]   = brr[2];
            indices[i] = i;
        }

        Arrays.sort(indices, (o1, o2) -> end[o1] - end[o2]);

        long dp[][] = new long[2][n];
        // dp[0][i] -> excluding ith element
        // dp[1][i] -> including ith element

        dp[0][0] = 0;
        dp[1][0] = val[indices[0]];

        for (int i = 1; i < n; i++) {
            if (end[indices[i - 1]] < start[indices[i]]) {
                // no overlap
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
                dp[1][i] = val[indices[i]] + dp[0][i];
            } else {
                // overlap
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
                int index = getIndex(indices, end, start[indices[i]]);
                if (index == -1)
                    dp[1][i] = val[indices[i]];
                else
                    dp[1][i] = val[indices[i]] + Math.max(dp[0][index], dp[1][index]);
            }
        }

        System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
    }

    static int getIndex(Integer indices[], int[] arr, int val) {

        return bSearch(0, indices.length - 1, val, arr, indices);
    }

    static int bSearch(int l, int r, int val, int arr[], Integer indices[]) {

        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int indexMid = indices[mid];

            if (arr[indexMid] < val) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }

        return ans;
    }

    // --- Optimized FastReader ---
    static class FastReader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din = new DataInputStream(System.in);
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                bytesRead = din.read(buffer, 0, BUFFER_SIZE);
                bufferPointer = 0;
                if (bytesRead == -1) return -1;
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read(); // skip whitespace
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public char[][] next2DCharArray(int n, int m) throws IOException {
            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                int j = 0;
                byte c;
                while (j < m && (c = read()) != -1) {
                    if (c == '\n' || c == '\r') continue;
                    arr[i][j++] = (char) c;
                }
            }
            return arr;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }

        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = nextLong();
            return arr;
        }
    }

}