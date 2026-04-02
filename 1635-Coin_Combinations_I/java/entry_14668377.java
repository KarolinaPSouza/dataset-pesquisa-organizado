
import java.io.*;

public class entry_14668377 {
    private static int MOD = (int) 1e9 + 7;
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int x = in.nextInt();
        int[] arr = in.nextIntArray(n);
        int dp[] = new int[x + 1];
        dp[0] = 1;
        for(int i=1;i<=x;i++)
        {
            for (int coin = 0; coin < n; coin++) {
                if (i - arr[coin] >= 0) {
                    dp[i] += dp[i - arr[coin]];
                    if (dp[i] >= MOD) dp[i] -= MOD;
                }
            }
        }
        System.out.println(dp[x]);
    }

    // ---------------- FastReader Class ----------------
    static class FastReader {
        private final int BUFFER_SIZE = 1 << 16; // 64 KB
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        public String next() throws IOException {
            byte c;
            while ((c = read()) <= ' ' && c != -1);
            StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
            } while ((c = read()) > ' ' && c != -1);
            return sb.toString();
        }

        public String readLine() throws IOException {
            StringBuilder sb = new StringBuilder();
            byte c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                if (c == '\r') continue;
                sb.append((char) c);
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c;
            while ((c = read()) <= ' ' && c != -1);
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c;
            while ((c = read()) <= ' ' && c != -1);
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        // array of integers
        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }

        // array of longs
        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) arr[i] = nextLong();
            return arr;
        }

        // array of doubles
        public double[] nextDoubleArray(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) arr[i] = nextDouble();
            return arr;
        }

        // array of strings
        public String[] nextStringArray(int n) throws IOException {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) arr[i] = next();
            return arr;
        }

        // array of integers with custom delimiter
        public int[] nextIntArrayDelimited(int n, char delimiter) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                String token = nextToken(delimiter);
                arr[i] = Integer.parseInt(token);
            }
            return arr;
        }

        // read token until custom delimiter
        public String nextToken(char delimiter) throws IOException {
            StringBuilder sb = new StringBuilder();
            byte c;
            while ((c = read()) <= ' ' && c != -1);
            do {
                if (c == delimiter) break;
                sb.append((char) c);
            } while ((c = read()) != -1);
            return sb.toString();
        }
    }
}