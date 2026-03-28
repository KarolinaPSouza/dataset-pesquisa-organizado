import java.io.*;
import java.util.*;
public class entry_5675722 {
    private static int N;
    private static int[] toLeaf;
    private static ArrayList<Integer>[] adj;
    public static void main(String[] args) throws Exception {
        Reader io = new Reader();
        N = io.nextInt();
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            int a = io.nextInt();
            int b = io.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }
        toLeaf = new int[N+1];
        int diameterEnd1 = bfs(1);
        int diameterEnd2 = bfs(diameterEnd1);
        bfs(diameterEnd2);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(toLeaf[i]).append(' ');
        }
        sb.setLength(sb.length()-1);
        io.println(sb);
        io.closeAll();
    }
    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int[] depth = new int[N+1];
        Arrays.fill(depth, -1);
        depth[node] = 0;
        while (!queue.isEmpty()) {
            node = queue.remove();
            for (int child: adj[node]) {
                if (depth[child] == -1) {
                    queue.add(child);
                    depth[child] = depth[node] + 1;
                    toLeaf[child] = Math.max(toLeaf[child], depth[child]);
                }
            }
        }
        return node;
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