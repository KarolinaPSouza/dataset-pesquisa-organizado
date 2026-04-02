import java.io.*;
import java.util.*;

public class entry_10640597 {
    static final long INF = Long.MAX_VALUE / 2; // To prevent overflow

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int m = fr.nextInt();
        int q = fr.nextInt();

        // Initialize distance matrix as a 1D array for better cache performance
        long[] dist = new long[(n + 1) * (n + 1)];
        Arrays.fill(dist, INF);

        // Distance from a node to itself is zero
        for (int i = 1; i <= n; i++) {
            dist[i * (n + 1) + i] = 0;
        }

        // Process roads and update distance matrix with the smallest road length
        for (int i = 0; i < m; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            long c = fr.nextLong();

            int indexAB = a * (n + 1) + b;
            if (c < dist[indexAB]) {
                dist[indexAB] = c;
                dist[b * (n + 1) + a] = c; // Since roads are two-way
            }
        }

        // Apply Floyd-Warshall algorithm
        for (int k = 1; k <= n; k++) {
            int kIndex = k * (n + 1);
            for (int i = 1; i <= n; i++) {
                int iIndex = i * (n + 1);
                long dik = dist[iIndex + k];
                if (dik == INF) continue; // Skip if k is unreachable from i
                for (int j = 1; j <= n; j++) {
                    long dkj = dist[kIndex + j];
                    if (dkj == INF) continue; // Skip if j is unreachable from k
                    if (dik + dkj < dist[iIndex + j]) {
                        dist[iIndex + j] = dik + dkj;
                    }
                }
            }
        }

        // Prepare output using StringBuilder for efficiency
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            long distance = dist[a * (n + 1) + b];
            if (distance < INF) {
                sb.append(distance).append('\n');
            } else {
                sb.append("-1\n");
            }
        }

        // Output all results at once
        System.out.print(sb);
    }

    // Custom FastReader for efficient input handling
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 20; // 1MB buffer
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        // Reads the next integer
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = skipToDigit();
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            do {
                ret = ret * 10 + (c - '0');
                c = read();
            } while (isDigit(c));
            return neg ? -ret : ret;
        }

        // Reads the next long
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = skipToDigit();
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            do {
                ret = ret * 10 + (c - '0');
                c = read();
            } while (isDigit(c));
            return neg ? -ret : ret;
        }

        // Skips non-digit characters and returns the next digit or '-'
        private byte skipToDigit() throws IOException {
            byte c;
            while ((c = read()) != -1) {
                if (c == '-' || isDigit(c)) {
                    return c;
                }
            }
            return -1;
        }

        // Reads the next byte
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            if (bytesRead == -1) return -1;
            return bufferPointer < bytesRead ? buffer[bufferPointer++] : -1;
        }

        // Checks if the byte is a digit
        private boolean isDigit(byte c) {
            return c >= '0' && c <= '9';
        }

        // Fills the buffer with new bytes
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, 0, BUFFER_SIZE);
            bufferPointer = 0;
        }
    }
}