import java.util.*;
import java.io.*;

public class entry_9651697 {
    private static final long LARGE = (long) 1e18;

    public static void main(String[] args) throws IOException {
        Reader io = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = io.nextInt();
        int m = io.nextInt();
        int q = io.nextInt();

        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], LARGE);
        for (int i = 0; i < m; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            int c = io.nextInt();
            if (c < dist[a][b])
                dist[a][b] = dist[b][a] = c;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    long temp = dist[i][k] + dist[k][j];
                    if (temp < dist[i][j])
                        dist[i][j] = dist[j][i] = temp;
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int a = io.nextInt() - 1;
            int b = io.nextInt() - 1;
            if (a == b)
                dist[a][b] = 0;
            else if (dist[a][b] == LARGE)
                dist[a][b] = -1;
            pw.println(dist[a][b]);
        }
        pw.close();
        io.close();
    }

    static class Reader {

        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;

        private byte[] buffer;

        private int bufferPointer, bytesRead;

        public Reader() {

            din = new DataInputStream(System.in);

            buffer = new byte[BUFFER_SIZE];

            bufferPointer = bytesRead = 0;

        }

        private void fillBuffer() throws IOException {

            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);

            if (bytesRead == -1)
                buffer[0] = -1;

        }

        private byte read() throws IOException {

            if (bufferPointer == bytesRead)
                fillBuffer();

            return buffer[bufferPointer++];

        }

        public void close() throws IOException {

            if (din == null)
                return;

            din.close();

        }

        public int nextInt() throws IOException {

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

    }
}