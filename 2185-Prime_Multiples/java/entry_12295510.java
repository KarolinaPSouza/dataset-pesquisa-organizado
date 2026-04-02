import java.io.*;

public class entry_12295510 {
    static class FastIO {
        private InputStream in;
        private byte[] buffer = new byte[1 << 16];
        private int pos, bytesRead;

        public FastIO(InputStream in) {
            this.in = in;
        }

        private void fillBuffer() throws IOException {
            bytesRead = in.read(buffer, 0, buffer.length);
            pos = 0;
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (pos >= bytesRead) fillBuffer();
            return buffer[pos++];
        }

        public int nextInt() throws IOException {
            int num = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                num = num * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return neg ? -num : num;
        }

        public long nextLong() throws IOException {
            long num = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                num = num * 10 + (c - '0');
                c = read();
            } while (c >= '0' && c <= '9');
            return neg ? -num : num;
        }

        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = nextInt();
            return arr;
        }
    }

    public static void main(String[] args) throws IOException {
        FastIO in = new FastIO(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        long n = in.nextLong();
        int k = in.nextInt();
        long[] primes = new long[k];
        for(int i=0;i<k;i++) primes[i] = in.nextLong();
        long[] count = new long[k + 1];

        for (int mask = 1; mask < (1 << k); mask++) {
            long temp = n;
            int noOfDivisors = Integer.bitCount(mask);
            for (int i = 0; i < k; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (temp < primes[i]) {
                        temp = 0;
                        break;
                    }
                    temp /= primes[i];
                }
            }
            count[noOfDivisors] += temp;
        }

        long ans = 0;
        for (int i = 1; i <= k; i++) {
            if (i % 2 == 0) ans -= count[i];
            else ans += count[i];
        }
        pw.println(ans);
        pw.flush();
    }
}