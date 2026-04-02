// Jan. 3, 2025
// Trial 5
// Approach: implement FastIO to run within time constraint

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class entry_11655994 {
    public static ArrayList<Integer>[] adj;
    public static byte[] visited;

    // Ignore the warning, it's fine
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // FastIO for faster input, you can use BufferedReader instead (Should still work [Hopefully])
        FastIO fio = new FastIO();
        final int N = fio.nextInt();
        final int M = fio.nextInt();
        adj = new ArrayList[N];
        visited = new byte[N];

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = fio.nextInt() - 1;
            int b = fio.nextInt() - 1;
            adj[a].add(b);
            adj[b].add(a);
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                colour(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(visited[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void colour(int node) {
        byte colour = visited[node] == 1 ? (byte) 2 : (byte) 1;
        for (int i = 0; i < adj[node].size(); i++) {
            int next = adj[node].get(i);
            if (visited[next] == 0) {
                visited[next] = colour;
                colour(next);
            } else if (visited[next] != colour) {
                System.out.println("IMPOSSIBLE");
                System.exit(0);
            }
        }
    }


    //https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
    static class FastIO {
        final private int BUFFER_SIZE = 1 << 17;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastIO() {
            din = new DataInputStream(System.in);
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
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg ? -ret : ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}