import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class entry_4417678 {
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

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int n = r.nextInt();
        int m = r.nextInt();
        ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>(n + 1);
        for (int i = 0; i <= n; i++) {
            x.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = r.nextInt();
            int b = r.nextInt();
            x.get(a).add(b);
            x.get(b).add(a);
        }

        int[] visited = new int[n + 1];
        ArrayList<Integer> u = new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(x, visited, i);
                u.add(i);
            }
        }

        System.out.println(count - 1);
        for (int i = 1; i <= count - 1; i++) {
            System.out.println(u.get(i - 1) + " " + u.get(i));
        }
    }

    private static void dfs(ArrayList<ArrayList<Integer>> x, int[] visited, int i) {
        if (visited[i] == 0) {
            visited[i] = 1;
            for (Integer c : x.get(i)) {
                dfs(x, visited, c);
            }
        }
    }


}