import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class entry_1513398 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PrimeMultiples solver = new PrimeMultiples();
        solver.solve(1, in, out);
        out.close();
    }

    static class PrimeMultiples {
        public void solve(int testNumber, Reader in, PrintWriter out) {
            long n = in.nextLong();
            int k = in.nextInt();
            ArrayList<Long> a = new ArrayList<>();
            HashSet<Long> hs = new HashSet<>();
            long ans = 0;
            for (int i = 0; i < k; i++) {
                long temp = in.nextLong();
                if (!hs.contains(temp)) {
                    hs.add(temp);
                    a.add(temp);
                }
            }

            k = a.size();
            for (int i = 1; i < (1 << k); i++) {
                int c = 0;
                long val = 1;
                long temp;
                boolean exist = true;
                for (int j = 0; j < k; j++) {
                    if ((i & (1 << j)) > 0) {
                        c++;
                        temp = val;
                        if ((temp * a.get(j)) / a.get(j) != temp) {
                            exist = false;
                            break;
                        }
                        val *= a.get(j);
                    }
                }
                if (!exist) continue;
                if (c % 2 == 1) {
                    ans += n / val;
                } else {
                    ans -= n / val;
                }
            }
            out.println(ans);
        }

    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 20;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public Reader(InputStream x) {
            din = new DataInputStream(x);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
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
