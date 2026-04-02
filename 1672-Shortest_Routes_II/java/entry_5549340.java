import java.io.*;
import java.util.*;
public class entry_5549340 {
    public static void main(String[] args) throws Exception {
        final long MAX = Long.MAX_VALUE/2;
        Reader reader = new Reader();
        int N = reader.nextInt();
        int M = reader.nextInt();
        int Q = reader.nextInt();
        long[][] roads = new long[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(roads[i], MAX);
            roads[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            int c1 = reader.nextInt();
            int c2 = reader.nextInt();
            int distance = reader.nextInt();
            // If there are multiple routes between two cities, pick smaller one
            roads[c1][c2] = roads[c2][c1] = Math.min(roads[c1][c2],distance);
        }
        for (int m = 1; m <= N; m++) {
            for (int c1 = 1; c1 <= N; c1++) {
                for (int c2 = c1+1; c2 <= N; c2++) {
                    if (roads[c1][m]+roads[m][c2] < roads[c1][c2]) {
                        roads[c1][c2] = roads[c2][c1] = roads[c1][m] + roads[m][c2];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (Q-->0) {
            int c1 = reader.nextInt();
            int c2 = reader.nextInt();
            if (roads[c1][c2] != MAX) {
                sb.append(roads[c1][c2]).append('\n');
            } else {
                sb.append(-1).append('\n');
            }
        }
        reader.print(sb);
        reader.closeAll();
    }
    static class Reader extends PrintWriter {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        StringBuilder sb = new StringBuilder();
        public Reader() {
            super(System.out);
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public Reader(String fileName) throws IOException {
            super(new File(fileName+".out"));
            din = new DataInputStream(new FileInputStream(fileName+".in"));
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
        public String readLine() throws IOException {
            sb.setLength(0);
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n' || c == '\r') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                sb.append((char)c);
                cnt++;
            }
            return sb.toString();
        }
        public String nextToken() throws IOException {
            sb.setLength(0);
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == ' ' || c == '\n' || c == '\r') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                cnt++;
                sb.append((char)c);
            }
            return sb.toString();
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) return -ret;
            return ret;
        }
        public void closeAll() throws Exception {
            super.close();
            din.close();
        }
    }    
}