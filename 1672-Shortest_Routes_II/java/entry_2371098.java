import java.io.*;

public class entry_2371098 {
    static class FastScanner {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public FastScanner(boolean usingFile) throws IOException {
            if (usingFile) din=new DataInputStream(new FileInputStream("C:\\Users\\skwek\\IdeaProjects\\HelloWorld\\src\\testing.in"));
            else din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do ret = ret * 10 + c - '0';
            while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)  buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException
        {
            if (din == null) return;
            din.close();
        }
    }
    public static void main(String[] args) throws IOException {
        final long t = System.currentTimeMillis();
        FastScanner input = new FastScanner(false);
        int N = input.nextInt();
        int M = input.nextInt();
        int Q = input.nextInt();
        long[][] graph = new long[N+1][N+1];
        for (int i = 1; i<=N; i++) {
            for (int j = 1; j<=N; j++) {
                graph[i][j]=Long.MAX_VALUE/2;
            }
            graph[i][i]=0;
        }
        for (int i = 0; i<M; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            int z = input.nextInt();
            graph[x][y]=Math.min(graph[x][y],z);
            graph[y][x]=Math.min(graph[y][x],z);
        }
        for (int k = 1; k<=N; k++) {
            for (int i = 1; i<=N; i++) {
                for (int j = i+1; j<=N; j++) {
                    long a = graph[i][k]+graph[k][j];
                    if (a<graph[i][j]) graph[i][j]=graph[j][i]=a;
                }
            }
        }
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i<Q; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            long res = graph[a][b];
            if (res==Long.MAX_VALUE/2) out.println(-1);
            else out.println(graph[a][b]);
        }
        out.close();
    }
}