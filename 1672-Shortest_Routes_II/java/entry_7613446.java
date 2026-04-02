import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class entry_7613446 {
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

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
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

        public long nextLong() throws IOException {
            long ret = 0;
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

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
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
    }

    static class Graph {
        int n;
        long matrix[][];

        public Graph(int n, int m, int edges[][]) {
            this.n = n;
            this.matrix = new long[n][n];

            for (int i = 0; i < n; i++)
                Arrays.fill(matrix[i], Long.MAX_VALUE);

            for (int i = 0; i < n; i++)
                matrix[i][i] = 0l;

            buildMatrix(m, edges);
        }

        private void buildMatrix(int m, int edges[][]) {
            for (int edge[] : edges) {
                matrix[edge[0]][edge[1]] = Math.min(matrix[edge[0]][edge[1]], edge[2]);
                matrix[edge[1]][edge[0]] = Math.min(matrix[edge[1]][edge[0]], edge[2]);
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {

                        if (matrix[i][k] != Long.MAX_VALUE && matrix[k][j] != Long.MAX_VALUE
                                && matrix[i][k] + matrix[k][j] < matrix[i][j])
                            matrix[i][j] = matrix[i][k] + matrix[k][j];

                    }
                }
            }
        }

        public long shortestPath(int a, int b) {
            return matrix[a][b] == Long.MAX_VALUE ? -1l : matrix[a][b];
        }
    }

    public static void main(String args[]) throws IOException {
        Reader s = new Reader();
        PrintWriter out = new PrintWriter(System.out);

        int n = s.nextInt();
        int m = s.nextInt();
        int q = s.nextInt();

        int edges[][] = new int[m][3];

        for (int i = 0; i < m; i++) {
            edges[i][0] = s.nextInt() - 1;
            edges[i][1] = s.nextInt() - 1;
            edges[i][2] = s.nextInt();
        }

        Graph graph = new Graph(n, m, edges);

        for (int i = 0; i < q; i++) {
            int a = s.nextInt() - 1;
            int b = s.nextInt() - 1;

            out.println(graph.shortestPath(a, b));
        }

        out.flush();
        s.close();
    }
}