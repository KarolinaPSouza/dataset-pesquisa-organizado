import java.io.*;
import java.util.*;

public class entry_13892216 {
    static final long INF = (long) 1e15;

    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();

        long[][] grid = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], INF);
            grid[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int w = in.nextInt();
            grid[u][v] = Math.min(grid[u][v], w);
            grid[v][u] = Math.min(grid[v][u], w);
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                if (grid[i][k] == INF) continue;
                for (int j = 0; j < n; ++j) {
                    if (grid[k][j] != INF) {
                        grid[i][j] = Math.min(grid[i][j], grid[i][k] + grid[k][j]);
                    }
                }
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; ++i) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            out.append(grid[u][v] == INF ? -1 : grid[u][v]).append('\n');
        }

        System.out.print(out);
    }

    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferPointer = 0, bytesRead = 0;
        private final DataInputStream din;

        public FastReader() {
            din = new DataInputStream(System.in);
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, 0, BUFFER_SIZE);
            bufferPointer = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do {
                ret = ret * 10 + (c - '0');
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }
    }
}