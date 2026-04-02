import java.io.*;
import java.util.*;

public class entry_4002025 {
    public static Reader reader = new Reader();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = reader.nextInt();
        Node[] nodes = new Node[N];
        int[] childCount = new int[N];
        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < N; i++) {
            int parent = reader.nextInt() - 1;
            nodes[i].parent = nodes[parent];
            childCount[parent]++;
        }
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (childCount[i] == 0)
                q.add(nodes[i]);
        }
        while(!q.isEmpty()) {
            Node n = q.poll();
            if (n.parent == null)
                continue;
            n.parent.subOrdinates += 1;
            n.parent.subOrdinates += n.subOrdinates;
            childCount[n.parent.i]--;
            if (childCount[n.parent.i] == 0)
                q.add(n.parent);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                sb.append(nodes[i].subOrdinates);
                // print(nodes[i].subOrdinates);
            } else {
                sb.append(" " + nodes[i].subOrdinates);
                // print(" " + nodes[i].subOrdinates);
            }
        }
        // sb.append("\n");
        println(sb.toString());
        // println("");
        bw.flush();
        bw.close();
    }


    static class Node {
        int i;
        Node parent;
        int subOrdinates;

        public Node(int i) {
            this.i = i;
        }

        @Override
        public int hashCode() {
            return this.i;
        }

        @Override
        public boolean equals(Object o) {
            Node other = (Node) o;
            return this.i == other.i;
        }
    }

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

    public static void print(int a) throws IOException {
        bw.write("" + a);
    }

    public static void print(String a) throws IOException {
        bw.write(a);
    }

    public static void printSp(String a) throws IOException {
        bw.write(a + " ");
    }

    public static void println(String a) throws IOException {
        bw.write(a + "\n");
    }

    public static void println(int a) throws IOException {
        bw.write(a + "\n");
    }

    public static void println(long a) throws IOException {
        bw.write(a + "\n");
    }
}