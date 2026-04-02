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
public class entry_1449727 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ShortestRoutesII solver = new ShortestRoutesII();
        solver.solve(1, in, out);
        out.close();
    }

    static class ShortestRoutesII {
        static final long INF = 0x3f3f3f3f3f3f3f3fL;

        public void solve(int testNumber, Reader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            long ans[][] = new long[n][n];
            for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (i != j) ans[i][j] = INF;

            for (int i = 0; i < m; i++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                int c = in.nextInt();
                if (c < ans[a][b]) {
                    ans[a][b] = ans[b][a] = c;
                }
            }
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        long temp = ans[i][k] + ans[k][j];
                        if (ans[i][j] > temp) {
                            ans[i][j] = temp;
                        }
                    }
                }
            }
            while (q-- > 0) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                long temp = ans[a][b];
                out.println(temp == INF ? -1 : temp);
            }
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
