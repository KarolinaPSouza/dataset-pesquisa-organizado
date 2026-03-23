import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class entry_1434923 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        SumOfDivisors solver = new SumOfDivisors();
        solver.solve(1, in, out);
        out.close();
    }

    static class SumOfDivisors {
        long m = 1_000_000_007;

        public long sum(long n) {
            long ans = 1;
            if (n % 2 == 0) {
                ans = n / 2;
                ans %= m;
                ans *= (n + 1) % m;
                ans %= m;
            } else {
                ans = (n + 1) / 2;
                ans %= m;
                ans *= (n) % m;
                ans %= m;
            }
            return ans;
        }

        public void solve(int testNumber, Reader in, PrintWriter out) {
            long n = in.nextLong();
            long i = 0;
            long ans = 0;
            long l = 1;
            while (l <= n) {
                long k = n / l;
                long r = n / k;
                k %= m;
                ans += ((sum(r) - sum(l - 1) + m) % m) * k;
                ans %= m;
                l = r + 1;
            }
            out.println(ans);
        }

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public Reader(InputStream x) {
            din = new DataInputStream(x);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public long nextLong() {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1)
                    buffer[0] = -1;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private byte read() {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

    }
}
