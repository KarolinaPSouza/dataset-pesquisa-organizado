import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class entry_5705123 {

    static long INF = Long.MAX_VALUE / 2;
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int cities = sc.nextInt();
        int totalConnections = sc.nextInt();
        int totalQueries = sc.nextInt();
        long[][] dp = new long[cities + 1][cities + 1];
        for(int i = 0; i <= cities; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }
        for(int i = 0; i < totalConnections; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            dp[source][dest] = dp[dest][source] = Math.min(dp[source][dest],weight);
        }

        for(int k = 1; k <= cities; k++) {
            for(int i = 1; i <= cities; i++) {
                for(int j = 1; j <= cities; j++) {
                    if(dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < totalQueries; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            if(dp[source][dest] == INF) {
                dp[source][dest] = -1;
            }
            sb.append(dp[source][dest] + "\n");
        }
        System.out.println(sb.toString());
        /* V^2 + EVLogV
        Reader sc = new Reader();
        int cities = sc.nextInt();
        int totalConnections = sc.nextInt();
        int totolQueries = sc.nextInt();
        Graph g = new Graph(cities);
        for(int i = 0; i < totalConnections; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            g.addVertices(source, dest, weight);
        }
        List<long[]> list = new ArrayList<>();
        for(int i = 1; i <= cities; i++) {
            list.add(g.findSolution(i));
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < totolQueries; i++) {
            int source = sc.nextInt();
            int dest = sc.nextInt();
            long[] res = list.get(source - 1);
            if(res[dest] == Long.MAX_VALUE) {
                sb.append(-1);
            } else {
                sb.append(res[dest]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
         */
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
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

        public long nextLong() throws IOException
        {
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

        public double nextDouble() throws IOException
        {
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

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}