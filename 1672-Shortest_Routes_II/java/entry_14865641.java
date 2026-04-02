import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public class entry_14865641 {
    static int n ;
    static int m ;
    static int q;
    static long[][] dist ;
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();

        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        dist = new long[n+1][n+1];

        for(var it : dist){
            Arrays.fill(it , (long)1e15);
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v =sc.nextInt();
            long w = (long)sc.nextInt();
            dist[u][v] = Math.min(dist[u][v], w);
            dist[v][u] = Math.min(dist[v][u], w);
        }
        for(int i=1;i<=n;i++) dist[i][i] = 0;

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++)
                    dist[i][j] = Math.min( dist[i][j] , dist[i][k]+dist[k][j]);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<q;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(dist[u][v]==(long)1e15) sb.append(-1).append("\n");
            else sb.append(dist[u][v]).append("\n");
        }
        System.out.println(sb);
    }
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }
    }
}