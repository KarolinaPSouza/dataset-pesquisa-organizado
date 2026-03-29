import java.io.*;
import java.util.*;

public class entry_13896370 {

    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0; byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-'); if (neg) c = read();
            do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0; byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-'); if (neg) c = read();
            do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
    }

    static int lowerBound(long[][] arr, long key, int high) {
        int low = 0, ans = -1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (arr[mid][1] < key) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int n = in.nextInt();
        long[][] jobs = new long[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = in.nextLong(); // start
            jobs[i][1] = in.nextLong(); // end
            jobs[i][2] = in.nextLong(); // value
        }

        Arrays.sort(jobs, Comparator.comparingLong(a -> a[1]));
        long[] dp = new long[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            long val = jobs[i][2];
            int prev = lowerBound(jobs, jobs[i][0], i - 1);
            if (prev != -1) val += dp[prev];
            dp[i] = Math.max(dp[i - 1], val);
        }

        System.out.println(dp[n - 1]);
    }
}