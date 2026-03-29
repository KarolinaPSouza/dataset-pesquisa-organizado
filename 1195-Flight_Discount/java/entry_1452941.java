import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class entry_1452941 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FlightDiscount solver = new FlightDiscount();
        solver.solve(1, in, out);
        out.close();
    }

    static class FlightDiscount {
        public void solve(int testNumber, Reader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<int[]> g[] = new ArrayList[2 * n];
            for (int i = 0; i < 2 * n; i++) g[i] = new ArrayList<>();
            PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[1], y[1]));
            pq.add(new long[]{0, 0});
            for (int i = 0; i < m; i++) {
                int a = in.nextInt() - 1;
                int b = in.nextInt() - 1;
                int c = in.nextInt();
                g[a * 2].add(new int[]{b * 2, c});
                g[a * 2].add(new int[]{b * 2 + 1, c / 2});
                g[a * 2 + 1].add(new int[]{b * 2 + 1, c});
            }
            long ans[] = new long[2 * n];
            Arrays.fill(ans, -1);
            while (pq.size() > 0) {
                long x[] = pq.poll();
                if (ans[(int) x[0]] != -1) continue;
//            System.out.println((x[0]) + " " + x[1]);
                ans[(int) x[0]] = x[1];
                for (int xx[] : g[(int) x[0]]) {
                    pq.add(new long[]{xx[0], x[1] + xx[1]});
                }
            }

            out.println(ans[(n - 1) * 2 + 1]);

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
